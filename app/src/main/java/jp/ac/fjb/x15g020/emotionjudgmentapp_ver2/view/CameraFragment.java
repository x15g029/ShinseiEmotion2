package jp.ac.fjb.x15g020.emotionjudgmentapp_ver2.view;


import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import jp.ac.fjb.x15g020.emotionjudgmentapp_ver2.R;
import jp.ac.fjb.x15g020.emotionjudgmentapp_ver2.model.CameraPreview;
import jp.ac.fjb.x15g020.emotionjudgmentapp_ver2.model.EmotionEngine;
import layout.PictureCheckFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class CameraFragment extends Fragment implements View.OnTouchListener ,EmotionEngine.EmotionListener{
	CameraPreview mCamera;
	private String path;

	public CameraFragment() {
		// Required empty public constructor
	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		return inflater.inflate(R.layout.fragment_camera, container, false);
	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);

		//インスタンスの取得
		TextureView textureView = (TextureView) getView().findViewById(R.id.textureCamera);
		//カメラプレビュー用クラスの作成
		mCamera = new CameraPreview();
		mCamera.setTextureView(textureView);

		getView().setOnTouchListener(this);


//		//IDからオブジェクトを取得
//		Button button  = (Button)view.findViewById(R.id.button);
//		//リスナーを登録
//		button.setOnClickListener(new View.OnClickListener() {
//			@Override
//			public void onClick(View v) {
//				FragmentTransaction ft = getFragmentManager().beginTransaction();
//				ft.replace(R.id.layout_main,new PictureCheckFragment());
//				ft.commit();



//			}
//		});


	}




	@Override
	public void onResume() {
		super.onResume();
		mCamera.open(1);
		mCamera.startPreview();

	}

	@Override
	public void onPause() {
		mCamera.close();
		super.onPause();

	}

	@Override
	public boolean onTouch(View view, MotionEvent motionEvent) {
		TextView text = getView().findViewById(R.id.textStatus);
		text.setText("測定中");
		Toast.makeText(getContext(), "写真保存", Toast.LENGTH_SHORT).show();

		//保存パスの設定
		path = getContext().getCacheDir()+"/emotionjudgment.jpg";
		//保存が完了したら実行する処理
		mCamera.setSaveListener(new CameraPreview.SaveListener() {
			@Override
			public void onSave(Bitmap bitmap) {
				FragmentTransaction ft2 = getFragmentManager().beginTransaction();
				ft2.replace(R.id.layout_main,new PictureCheckFragment());
				ft2.commit();
			}
		});
		//写真撮影
		mCamera.save(path);

		//エモーションエンジンの呼び出し
		EmotionEngine.getEmotion(path,this);


		return false;



	}

	@Override
	public void onEmotion(JSONArray json) {
		if(getContext()==null)
			return;
		if(json == null)
			Toast.makeText(getContext(), "接続エラー", Toast.LENGTH_SHORT).show();

		else{
			if(json.length() == 0)
				Toast.makeText(getContext(), "顔検出エラー", Toast.LENGTH_SHORT).show();
			else{
				try{
					JSONObject jsonObject = (JSONObject)json.get(0);
					JSONObject scores = (JSONObject)jsonObject.get("scores");
					double anger = scores.getDouble("anger");
					double contempt = scores.getDouble("contempt");
					double disgust = scores.getDouble("disgust");
					double fear = scores.getDouble("fear");
					double happiness = scores.getDouble("happiness");
					double neutral = scores.getDouble("neutral");
					double sadness = scores.getDouble("sadness");
					double surprise = scores.getDouble("surprise");

					TextView text = getView().findViewById(R.id.textStatus);
					String msg = String.format("怒り　:%f\n軽蔑　:%f\nムカ　:%f\n恐れ　:%f\n喜び　:%f\n無表情:%f\n悲しみ:%f\n驚き　:%f\n",
							anger,contempt,disgust,fear,happiness,neutral,sadness,surprise);
					text.setText(msg);
				}catch (Exception e){
					Toast.makeText(getContext(), "データエラー", Toast.LENGTH_SHORT).show();
				}
			}
		}
	}



}
