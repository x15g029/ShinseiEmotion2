package jp.ac.fjb.x15g020.emotionjudgmentapp_ver2.model;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by oikawa on 2017/11/22.
 */

public class EmotionEngine {
	final static String EmotionURL = "https://westus.api.cognitive.microsoft.com/emotion/v1.0/recognize";
	final static String EmotuionKey1 = "0a284af59c244f9e9d5c1cca8c35e322";
	final static String EmotuionKey2 = "5ec452cd6bec42daa2f0bc00142297fa";
	public static class EmotionParam implements Serializable{
		public double anger;
		public double contempt;
		public double disgust;
		public double fear;
		public double happiness;
		public double neutral;
		public double sadness;
		public double surprise;
	}
	public interface EmotionListener{
		public void onEmotion(EmotionParam[] params);
		public void onProgress(Long sizeTotal,Long sizeCurrent);
	}

	public static void getEmotion(final String path, final EmotionListener listener){
		new AsyncTask<Integer, Long, JSONArray>(){
			@Override
			protected void onPostExecute(JSONArray json) {
				super.onPostExecute(json);
				if(json != null){
					try {
						EmotionParam[] params = new EmotionParam[json.length()];
						for(int i=0;i<json.length();i++){
							JSONObject jsonObject = (JSONObject)json.get(0);
							JSONObject scores = (JSONObject)jsonObject.get("scores");
							EmotionParam param = new EmotionParam();
							param.anger = scores.getDouble("anger");
							param.contempt = scores.getDouble("contempt");
							param.disgust = scores.getDouble("disgust");
							param.fear = scores.getDouble("fear");
							param.happiness = scores.getDouble("happiness");
							param.neutral = scores.getDouble("neutral");
							param.sadness = scores.getDouble("sadness");
							param.surprise = scores.getDouble("surprise");
							params[i] = param;
						}

						listener.onEmotion(params);
					} catch (JSONException e) {
						listener.onEmotion(null);
					}
				}



			}

			@Override
			protected void onProgressUpdate(Long... values) {
				super.onProgressUpdate(values);
				listener.onProgress(values[0],values[1]);
			}

			@Override
			protected JSONArray doInBackground(Integer... integers) {
				JSONArray json = null;
				try {
					File file = new File(path);
					if(file == null)
						return null;

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

					// APIに接続
					con.connect();

					long sizeTotal = file.length();
					FileInputStream input = new FileInputStream(file);
					DataOutputStream os = new DataOutputStream(con.getOutputStream());
					byte buf[]=new byte[1024];
					int len;
					long sizeCur = 0;
					while((len=input.read(buf))!=-1){
						os.write(buf,0,len);
						sizeCur += len;
						publishProgress(sizeTotal,sizeCur);
					}



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
