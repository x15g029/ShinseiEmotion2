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
				Bundle bundle = getArguments();
				if(bundle.getInt("惑星") == 1 ){
					bundle.putInt("惑星",1);
					FragmentTransaction ft = getFragmentManager().beginTransaction();
					Fragment f = new PictureCheckFragment();
					f.setArguments(bundle);
					ft.replace(R.id.layout_main,f);
					ft.commit();

				}else if(bundle.getInt("惑星") == 2 ){
					bundle.putInt("惑星",2);
					FragmentTransaction ft = getFragmentManager().beginTransaction();
					Fragment f = new PictureCheckFragment();
					f.setArguments(bundle);
					ft.replace(R.id.layout_main,f);
					ft.commit();

				}else if(bundle.getInt("惑星") == 3 ){
					bundle.putInt("惑星",3);
					FragmentTransaction ft = getFragmentManager().beginTransaction();
					Fragment f = new PictureCheckFragment();
					f.setArguments(bundle);
					ft.replace(R.id.layout_main,f);
					ft.commit();

				}else if(bundle.getInt("惑星") == 4 ){
					bundle.putInt("惑星",4);
					FragmentTransaction ft = getFragmentManager().beginTransaction();
					Fragment f = new PictureCheckFragment();
					f.setArguments(bundle);
					ft.replace(R.id.layout_main,f);
					ft.commit();

				}else if(bundle.getInt("惑星") == 5 ){
					bundle.putInt("惑星",5);
					FragmentTransaction ft = getFragmentManager().beginTransaction();
					Fragment f = new PictureCheckFragment();
					f.setArguments(bundle);
					ft.replace(R.id.layout_main,f);
					ft.commit();

				}else if(bundle.getInt("惑星") == 6 ){
					bundle.putInt("惑星",6);
					FragmentTransaction ft = getFragmentManager().beginTransaction();
					Fragment f = new PictureCheckFragment();
					f.setArguments(bundle);
					ft.replace(R.id.layout_main,f);
					ft.commit();

				}else if(bundle.getInt("惑星") == 7 ){
					bundle.putInt("惑星",7);
					FragmentTransaction ft = getFragmentManager().beginTransaction();
					Fragment f = new PictureCheckFragment();
					f.setArguments(bundle);
					ft.replace(R.id.layout_main,f);
					ft.commit();

				}else if(bundle.getInt("惑星") == 8 ){
					bundle.putInt("惑星",8);
					FragmentTransaction ft = getFragmentManager().beginTransaction();
					Fragment f = new PictureCheckFragment();
					f.setArguments(bundle);
					ft.replace(R.id.layout_main,f);
					ft.commit();

				}
			}
		});
		//写真撮影
		mCamera.save(path);

		//エモーションエンジンの呼び出し
		EmotionEngine.getEmotion(path,this);


		return false;



	}

	@Override
	public void onEmotion(EmotionEngine.EmotionParam[] params) {
		if(getContext()==null)
			return;
		if(params == null)
			Toast.makeText(getContext(), "接続エラー", Toast.LENGTH_SHORT).show();
		else{
			if(params.length==0)
				Toast.makeText(getContext(), "顔検出エラー", Toast.LENGTH_SHORT).show();
			else{
				EmotionEngine.EmotionParam p = params[0];
				TextView text = getView().findViewById(R.id.textStatus);
				String msg = String.format("怒り　:%f\n軽蔑　:%f\nムカ　:%f\n恐れ　:%f\n喜び　:%f\n無表情:%f\n悲しみ:%f\n驚き　:%f\n",
					p.anger,params[0].contempt,p.disgust,p.fear,p.happiness,p.neutral,p.sadness,p.surprise);
				text.setText(msg);
			}

		}
	}

	@Override
	public void onProgress(Long sizeTotal, Long sizeCurrent) {
		System.out.format("%d/%d\n",sizeCurrent,sizeTotal);
	}


}
