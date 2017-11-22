package jp.ac.fjb.x15g020.emotionjudgmentapp_ver2.view;


import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import org.json.JSONObject;

import jp.ac.fjb.x15g020.emotionjudgmentapp_ver2.R;
import jp.ac.fjb.x15g020.emotionjudgmentapp_ver2.model.CameraPreview;
import jp.ac.fjb.x15g020.emotionjudgmentapp_ver2.model.EmotionEngine;

/**
 * A simple {@link Fragment} subclass.
 */
public class CameraFragment extends Fragment implements View.OnTouchListener, EmotionEngine.EmotionListener {
	CameraPreview mCamera;

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
	}

	@Override
	public void onResume() {
		super.onResume();
		mCamera.open(0);
		mCamera.startPreview();

	}

	@Override
	public void onPause() {
		mCamera.close();
		super.onPause();
	}

	@Override
	public boolean onTouch(View view, MotionEvent motionEvent) {
		Toast.makeText(getContext(), "写真保存", Toast.LENGTH_SHORT);
		String path = Environment.getExternalStorageDirectory()+"/emotionjudgment.jpg";
		mCamera.save(path);

		//エモーションエンジンの呼び出し
		EmotionEngine.getEmotion(path,this);
		return false;
	}

	@Override
	public void onEmotion(JSONObject json) {

	}
}
