package layout;


import android.app.Dialog;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;

import jp.ac.fjb.x15g020.emotionjudgmentapp_ver2.R;

import static jp.ac.fjb.x15g020.emotionjudgmentapp_ver2.R.drawable.bowl_moku;
import static junit.runner.BaseTestRunner.getPreference;

/**
 * A simple {@link Fragment} subclass.
 */
public class ResultOkFragment extends Fragment implements View.OnClickListener{
	private ImageButton btn1;
	private ImageButton btn2;
	private String path;
	private File file;
	private int i1;
	private int i2;
	private int i3;
	private int i4;
	private int i5;
	private int i6;
	private int i7;
	private int i8;
	public MediaPlayer mediaPlayer;
	private Animation animation;


	public ResultOkFragment() {
		// Required empty public constructor
	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_result_ok, container, false);

		//カメラで撮影した写真の一時保存データを取得  (よくわからんけどフィールドにしてある)
		path = getContext().getCacheDir() + "/emotionjudgment.jpg";
		//一時保存データのパスをFileにセット　（Uriで指定できるようにするため？）
		file = new File(path);

		return view;
	}


//	@Override
//	public void onProgress(Long sizeTotal, Long sizeCurrent) {
//		System.out.format("%d/%d\n",sizeCurrent,sizeTotal);
//	}


	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);


		//IDからオブジェクトを取得
		btn1 = (ImageButton) view.findViewById(R.id.btnStageSelect);
		btn2 = (ImageButton) view.findViewById(R.id.b1);
		//ボタンをリスナーに登録
		btn1.setOnClickListener(this);
		btn2.setOnClickListener(this);


		TextView ResultOdai = getView().findViewById(R.id.ResultOdai);
		ImageView imageResultMonster = getView().findViewById(R.id.imageResultMonster);
		ImageView imageResultText = getView().findViewById(R.id.imageResultText);
		ImageView btnStageSelect = getView().findViewById(R.id.btnStageSelect);

		Bundle bundle = getArguments();
		if (bundle.getInt("惑星") == 1) {
			//水星
			ResultOdai.setText("驚き達成度　　:" + bundle.getInt("結果1") + "%");
			if (bundle.getInt("結果1") >= 0){
				// プリファレンスの準備 //
				SharedPreferences pref = getContext().getSharedPreferences( "pref", getContext().MODE_PRIVATE );
				// プリファレンスに書き込むためのEditorオブジェクト取得
				SharedPreferences.Editor editor = pref.edit();
				//表情ボールパスをセット
				editor.putString("bowlsui","クリア");
				editor.commit();

				//ボール
				//	画像セット
				ImageView imageBowl = new ImageView(getContext());
				imageBowl.setImageResource(R.drawable.m_sui4);
				imageBowl.startAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.anime));

				// ダイアログ作成
				Dialog dialog = new Dialog(getContext());
				dialog.getWindow().setGravity(Gravity.BOTTOM);
				//背景透明
				dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
				// ダイアログ表示
				dialog.setContentView(imageBowl);
				dialog.show();

				//宇宙人
				imageResultMonster.setImageResource(R.drawable.m_sui_result);
				//判定結果
				imageResultText.setImageResource(R.drawable.result_ok);
				//写真を表示
				ImageView picView = (ImageView) getView().findViewById(R.id.imageResultPicture);
				picView.setImageURI(Uri.fromFile(file));
				mediaPlayer = MediaPlayer.create(getContext(), R.raw.bgm_ok);
				mediaPlayer.start();
			}
			else {
				imageResultMonster.setImageResource(R.drawable.m_sui1);
				imageResultText.setImageResource(R.drawable.image_ng);
				//写真を表示
				ImageView picView = (ImageView) getView().findViewById(R.id.imageResultPicture);
				picView.setImageURI(Uri.fromFile(file));
			}
		} else if (bundle.getInt("惑星") == 2) {
			//金星
			ResultOdai.setText("軽蔑達成度　　:" + bundle.getInt("結果2") + "%");
			if (bundle.getInt("結果2") >= 0){
				// プリファレンスの準備 //
				SharedPreferences pref = getContext().getSharedPreferences( "pref", getContext().MODE_PRIVATE );
				// プリファレンスに書き込むためのEditorオブジェクト取得
				SharedPreferences.Editor editor = pref.edit();
				//表情ボールパスをセット
				editor.putString("bowlkin","クリア");
				editor.commit();

				//ボール
				//	画像セット
				ImageView imageBowl = new ImageView(getContext());
				imageBowl.setImageResource(R.drawable.m_kin4);
				imageBowl.startAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.anime));

				// ダイアログ作成
				Dialog dialog = new Dialog(getContext());
				dialog.getWindow().setGravity(Gravity.BOTTOM);
				//背景透明
				dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
				// ダイアログ表示
				dialog.setContentView(imageBowl);
				dialog.show();

				//宇宙人
				imageResultMonster.setImageResource(R.drawable.m_kin_result);
				//判定結果
				imageResultText.setImageResource(R.drawable.result_ok);
				//写真を表示
				ImageView picView = (ImageView) getView().findViewById(R.id.imageResultPicture);
				picView.setImageURI(Uri.fromFile(file));
				mediaPlayer = MediaPlayer.create(getContext(), R.raw.bgm_ok);
				mediaPlayer.start();
			}
			else {
				imageResultMonster.setImageResource(R.drawable.m_kin1);
				imageResultText.setImageResource(R.drawable.image_ng);
				//写真を表示
				ImageView picView = (ImageView) getView().findViewById(R.id.imageResultPicture);
				picView.setImageURI(Uri.fromFile(file));
			}
		} else if (bundle.getInt("惑星") == 3) {
			//地球
			ResultOdai.setText("真顔達成度　　:" + bundle.getInt("結果3") + "%");
			if (bundle.getInt("結果3") >= 0){
				// プリファレンスの準備 //
				SharedPreferences pref = getContext().getSharedPreferences( "pref", getContext().MODE_PRIVATE );
				// プリファレンスに書き込むためのEditorオブジェクト取得
				SharedPreferences.Editor editor = pref.edit();
				//表情ボールパスをセット
				editor.putString("bowlti","クリア");
				editor.commit();

				//表情ボールを渡すシーン
				imageResultMonster.setImageResource(R.drawable.m_ti1);
				//判定結果
				imageResultText.setImageResource(R.drawable.result_ok);
				//写真を表示
				ImageView picView = (ImageView) getView().findViewById(R.id.imageResultPicture);
				picView.setImageURI(Uri.fromFile(file));
				mediaPlayer = MediaPlayer.create(getContext(), R.raw.bgm_ok);
				mediaPlayer.start();
			}
			else if (bundle.getInt("結果3") >= 80) {
				imageResultMonster.setImageResource(R.drawable.m_ti2);
				imageResultText.setImageResource(R.drawable.result_ok);
				//写真を表示
				ImageView picView = (ImageView) getView().findViewById(R.id.imageResultPicture);
				picView.setImageURI(Uri.fromFile(file));
				mediaPlayer = MediaPlayer.create(getContext(), R.raw.bgm_ok);
				mediaPlayer.start();
			} else {
				imageResultMonster.setImageResource(R.drawable.m_ti1);
				imageResultText.setImageResource(R.drawable.image_ng);
				//写真を表示
				ImageView picView = (ImageView) getView().findViewById(R.id.imageResultPicture);
				picView.setImageURI(Uri.fromFile(file));
			}
		} else if (bundle.getInt("惑星") == 4) {
			//火星
			ResultOdai.setText("怒り達成度　　:" + bundle.getInt("結果4") + "%");
			if (bundle.getInt("結果4") >= 0){
				// プリファレンスの準備 //
				SharedPreferences pref = getContext().getSharedPreferences( "pref", getContext().MODE_PRIVATE );
				// プリファレンスに書き込むためのEditorオブジェクト取得
				SharedPreferences.Editor editor = pref.edit();
				//表情ボールパスをセット
				editor.putString("bowlka","クリア");
				editor.commit();

				//ボール
				//	画像セット
				ImageView imageBowl = new ImageView(getContext());
				imageBowl.setImageResource(R.drawable.m_ka4);
				imageBowl.startAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.anime));

				// ダイアログ作成
				Dialog dialog = new Dialog(getContext());
				dialog.getWindow().setGravity(Gravity.BOTTOM);
				//背景透明
				dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
				// ダイアログ表示
				dialog.setContentView(imageBowl);
				dialog.show();

				//宇宙人
				imageResultMonster.setImageResource(R.drawable.m_ka_result);
				//判定結果
				imageResultText.setImageResource(R.drawable.result_ok);
				//写真を表示
				ImageView picView = (ImageView) getView().findViewById(R.id.imageResultPicture);
				picView.setImageURI(Uri.fromFile(file));
				mediaPlayer = MediaPlayer.create(getContext(), R.raw.bgm_ok);
				mediaPlayer.start();
			}
			else {
				imageResultMonster.setImageResource(R.drawable.m_ka1);
				imageResultText.setImageResource(R.drawable.image_ng);
				//写真を表示
				ImageView picView = (ImageView) getView().findViewById(R.id.imageResultPicture);
				picView.setImageURI(Uri.fromFile(file));
			}
		} else if (bundle.getInt("惑星") == 5) {
			//木星
			ResultOdai.setText("笑顔達成度 :" + bundle.getInt("結果5") + "%");
			if (bundle.getInt("結果5") >= 80 ){
				// プリファレンスの準備 //
				SharedPreferences pref = getContext().getSharedPreferences( "pref", getContext().MODE_PRIVATE );
				// プリファレンスに書き込むためのEditorオブジェクト取得
				SharedPreferences.Editor editor = pref.edit();
				//表情ボールパスをセット
				editor.putString("bowlmoku","クリア");
				editor.commit();

				//ボール
				//	画像セット
				ImageView imageBowl = new ImageView(getContext());
				imageBowl.setImageResource(R.drawable.m_moku4);
				imageBowl.startAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.anime));

				// ダイアログ作成
				Dialog dialog = new Dialog(getContext());
				dialog.getWindow().setGravity(Gravity.BOTTOM);
				//背景透明
				dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
				// ダイアログ表示
				dialog.setContentView(imageBowl);
				dialog.show();

				//宇宙人
				imageResultMonster.setImageResource(R.drawable.m_moku_result);
				//判定結果
				imageResultText.setImageResource(R.drawable.result_ok);
				//写真
				ImageView picView = (ImageView) getView().findViewById(R.id.imageResultPicture);
				picView.setImageURI(Uri.fromFile(file));
				mediaPlayer = MediaPlayer.create(getContext(), R.raw.bgm_ok);
				mediaPlayer.start();
			}
			else {
				imageResultMonster.setImageResource(R.drawable.m_ka_result);
				imageResultText.setImageResource(R.drawable.image_ng);
				//写真を表示
				ImageView picView = (ImageView) getView().findViewById(R.id.imageResultPicture);
				picView.setImageURI(Uri.fromFile(file));
			}
		} else if (bundle.getInt("惑星") == 6) {
			//土星
			ResultOdai.setText("悲しみ達成度　　:" + bundle.getInt("結果6") + "%");
			if (bundle.getInt("結果6") >= 0){
				// プリファレンスの準備 //
				SharedPreferences pref = getContext().getSharedPreferences( "pref", getContext().MODE_PRIVATE );
				// プリファレンスに書き込むためのEditorオブジェクト取得
				SharedPreferences.Editor editor = pref.edit();
				//表情ボールパスをセット
				editor.putString("bowldo","クリア");
				editor.commit();

				//ボール
				//	画像セット
				ImageView imageBowl = new ImageView(getContext());
				imageBowl.setImageResource(R.drawable.m_do4);
				imageBowl.startAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.anime));

				// ダイアログ作成
				Dialog dialog = new Dialog(getContext());
				dialog.getWindow().setGravity(Gravity.BOTTOM);
				//背景透明
				dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
				// ダイアログ表示
				dialog.setContentView(imageBowl);
				dialog.show();

				//宇宙人
				imageResultMonster.setImageResource(R.drawable.m_do_result);
				//判定結果
				imageResultText.setImageResource(R.drawable.result_ok);
				//写真を表示
				ImageView picView = (ImageView) getView().findViewById(R.id.imageResultPicture);
				picView.setImageURI(Uri.fromFile(file));
				mediaPlayer = MediaPlayer.create(getContext(), R.raw.bgm_ok);
				mediaPlayer.start();
			}
			else {
				imageResultMonster.setImageResource(R.drawable.m_do1);
				imageResultText.setImageResource(R.drawable.image_ng);
				//写真を表示
				ImageView picView = (ImageView) getView().findViewById(R.id.imageResultPicture);
				picView.setImageURI(Uri.fromFile(file));
			}
		} else if (bundle.getInt("惑星") == 7) {
			//天王星
			ResultOdai.setText("恐怖達成度　　:" + bundle.getInt("結果7") + "%");
			if (bundle.getInt("結果7") >= 0){
				// プリファレンスの準備 //
				SharedPreferences pref = getContext().getSharedPreferences( "pref", getContext().MODE_PRIVATE );
				// プリファレンスに書き込むためのEditorオブジェクト取得
				SharedPreferences.Editor editor = pref.edit();
				//表情ボールパスをセット
				editor.putString("bowlten","クリア");
				editor.commit();

				//ボール
				//	画像セット
				ImageView imageBowl = new ImageView(getContext());
				imageBowl.setImageResource(R.drawable.m_ten4);
				imageBowl.startAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.anime));

				// ダイアログ作成
				Dialog dialog = new Dialog(getContext());
				dialog.getWindow().setGravity(Gravity.BOTTOM);
				//背景透明
				dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
				// ダイアログ表示
				dialog.setContentView(imageBowl);
				dialog.show();

				//宇宙人
				imageResultMonster.setImageResource(R.drawable.m_ten_result);
				//判定結果
				imageResultText.setImageResource(R.drawable.result_ok);
				//写真を表示
				ImageView picView = (ImageView) getView().findViewById(R.id.imageResultPicture);
				picView.setImageURI(Uri.fromFile(file));
				mediaPlayer = MediaPlayer.create(getContext(), R.raw.bgm_ok);
				mediaPlayer.start();
			}
			else {
				imageResultMonster.setImageResource(R.drawable.m_ten1);
				imageResultText.setImageResource(R.drawable.image_ng);
				//写真を表示
				ImageView picView = (ImageView) getView().findViewById(R.id.imageResultPicture);
				picView.setImageURI(Uri.fromFile(file));
			}
		} else if (bundle.getInt("惑星") == 8) {
			//海王星
			ResultOdai.setText("嫌悪達成度　　:" + bundle.getInt("結果8") + "%");
			if (bundle.getInt("結果8") >= 0){
				// プリファレンスの準備 //
				SharedPreferences pref = getContext().getSharedPreferences( "pref", getContext().MODE_PRIVATE );
				// プリファレンスに書き込むためのEditorオブジェクト取得
				SharedPreferences.Editor editor = pref.edit();
				//表情ボールパスをセット
				editor.putString("bowlkai","クリア");
				editor.commit();

				//ボール
				//	画像セット
				ImageView imageBowl = new ImageView(getContext());
				imageBowl.setImageResource(R.drawable.m_kai4);
				imageBowl.startAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.anime));

				// ダイアログ作成
				Dialog dialog = new Dialog(getContext());
				dialog.getWindow().setGravity(Gravity.BOTTOM);
				//背景透明
				dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
				// ダイアログ表示
				dialog.setContentView(imageBowl);
				dialog.show();

				//宇宙人
				imageResultMonster.setImageResource(R.drawable.m_kai_result);
				//判定結果
				imageResultText.setImageResource(R.drawable.result_ok);
				//写真を表示
				ImageView picView = (ImageView) getView().findViewById(R.id.imageResultPicture);
				picView.setImageURI(Uri.fromFile(file));
				mediaPlayer = MediaPlayer.create(getContext(), R.raw.bgm_ok);
				mediaPlayer.start();
			}
			else {
				imageResultMonster.setImageResource(R.drawable.m_kai1);
				imageResultText.setImageResource(R.drawable.image_ng);
				//写真を表示
				ImageView picView = (ImageView) getView().findViewById(R.id.imageResultPicture);
				picView.setImageURI(Uri.fromFile(file));
			}
		}

	}

	@Override
	public void onClick(View view) {
		if (view.getId() == R.id.btnStageSelect) {
			//マップ  押下時
			FragmentTransaction ft = getFragmentManager().beginTransaction();
			ft.replace(R.id.layout_main, new MapFragment());
			ft.commit();
		} else if(view.getId() == R.id.b1){
			//もう一度  押下時
			FragmentTransaction ft2 = getFragmentManager().beginTransaction();
			ft2.replace(R.id.layout_main, new EmotionBowlFragment());
			ft2.commit();
		}
	}
}


