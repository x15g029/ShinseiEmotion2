package jp.ac.fjb.x15g020.emotionjudgmentapp_ver2.model;

import android.os.AsyncTask;

import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by oikawa on 2017/11/22.
 */

public class EmotionEngine {
	final static String EmotionURL = "https://westus.api.cognitive.microsoft.com/emotion/v1.0/recognize";
	final static String EmotuionKey1 = "ba0940707fd04b14a8dad57ab46e2142";
	final static String EmotuionKey2 = "5cd4f94f06ba4e548859b0840a58b156";
	public interface EmotionListener{
		public void onEmotion(JSONArray json);
	}

	public static void getEmotion(final String path, final EmotionListener listener){
		new AsyncTask<Integer, Integer, JSONArray>(){
			@Override
			protected void onPostExecute(JSONArray json) {
				super.onPostExecute(json);
				listener.onEmotion(json);
			}

			@Override
			protected JSONArray doInBackground(Integer... integers) {
				JSONArray json = null;
				try {

					URL url = new URL(EmotionURL);
					HttpURLConnection con = (HttpURLConnection) url.openConnection();
					con.setReadTimeout(10000);
					con.setConnectTimeout(20000);
					con.setRequestMethod("POST");
					con.setDoInput(true);
					con.setDoOutput(true);
					//リクエストヘッダーの設定
					con.setRequestProperty("Content-Type", "application/octet-stream");
					con.setRequestProperty("Ocp-Apim-Subscription-Key", EmotuionKey1);


					FileInputStream input = new FileInputStream(path);
					DataOutputStream os = new DataOutputStream(con.getOutputStream());
					byte buf[]=new byte[1024];
					int len;
					while((len=input.read(buf))!=-1){
						os.write(buf,0,len);
					}


					// APIに接続
					con.connect();
					os.close();

					int status = con.getResponseCode();

					switch (status) {
						case HttpURLConnection.HTTP_OK:
							InputStream in = con.getInputStream();
							BufferedReader reader = new BufferedReader(new InputStreamReader(in));
							String line;
							StringBuilder sb = new StringBuilder();

							while (null != (line = reader.readLine())){
								sb.append(line);
							}
							in.close();
							System.out.println(sb.toString());
							json = new JSONArray(sb.toString());
							break;
						case HttpURLConnection.HTTP_UNAUTHORIZED:
							break;
						default:
							break;
					}

				} catch (Exception e){
					e.printStackTrace();
				}

				return json;
			}
		}.execute();



	}
}
