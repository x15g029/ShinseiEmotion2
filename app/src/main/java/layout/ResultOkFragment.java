package layout;


import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.prefs.Preferences;

import jp.ac.fjb.x15g020.emotionjudgmentapp_ver2.R;
import jp.ac.fjb.x15g020.emotionjudgmentapp_ver2.model.EmotionEngine;
import jp.ac.fjb.x15g020.emotionjudgmentapp_ver2.view.CameraFragment;

import static junit.runner.BaseTestRunner.getPreference;

/**
 * A simple {@link Fragment} subclass.
 */
public class ResultOkFragment extends Fragment implements View.OnClickListener, EmotionEngine.EmotionListener {
	private ImageButton btn1;
	private Button btn2;
	private String path;
	private File file;

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
//        //写真を表示
//        ImageView picView = (ImageView)view.findViewById(R.id.imageResultPicture);
//        picView.setImageURI(Uri.fromFile(file));

		//エモーションエンジンの呼び出し
		EmotionEngine.getEmotion(path, this);
		return view;
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
			else {
				EmotionEngine.EmotionParam p = params[0];
				double anger = p.anger * 100;
				double contempt = p.contempt * 100;
				double disgust = p.disgust * 100;
				double fear = p.fear * 100;
				double happiness = p.happiness * 100;
				double neutral = p.neutral * 100;
				double sadness = p.sadness * 100;
				double surprise = p.surprise * 100;

				int i1 = (int) surprise;
				int i2 = (int) contempt;
				int i3 = (int) neutral;
				int i4 = (int) anger;
				int i5 = (int) happiness;
				int i6 = (int) sadness;
				int i7 = (int) fear;
				int i8 = (int) disgust;


				TextView ResultOdai = getView().findViewById(R.id.ResultOdai);
				ImageView imageResultMonster = getView().findViewById(R.id.imageResultMonster);
				ImageView imageResultText = getView().findViewById(R.id.imageResultText);
				ImageView btnStageSelect = getView().findViewById(R.id.btnStageSelect);


				Bundle bundle = getArguments();
				if (bundle.getInt("惑星") == 1) {
					//水星
					ResultOdai.setText("驚き達成度　　:" + i1 + "%");
					if (i1 >= 80) {
						imageResultMonster.setImageResource(R.drawable.m_sui2);
						imageResultText.setImageResource(R.drawable.result_ok);
						//写真を表示
						ImageView picView = (ImageView) getView().findViewById(R.id.imageResultPicture);
						picView.setImageURI(Uri.fromFile(file));
						btnStageSelect.setImageResource(R.drawable.map_back);
					} else {
						imageResultMonster.setImageResource(R.drawable.image_chac);
						imageResultText.setImageResource(R.drawable.image_ng);
						//写真を表示
						ImageView picView = (ImageView) getView().findViewById(R.id.imageResultPicture);
						picView.setImageURI(Uri.fromFile(file));
						btnStageSelect.setImageResource(R.drawable.image_revenge);
					}
				} else if (bundle.getInt("惑星") == 2) {
					//金星
					ResultOdai.setText("軽蔑達成度　　:" + i2 + "%");
					if (i2 >= 80) {
						imageResultMonster.setImageResource(R.drawable.m_kin2);
						imageResultText.setImageResource(R.drawable.result_ok);
						//写真を表示
						ImageView picView = (ImageView) getView().findViewById(R.id.imageResultPicture);
						picView.setImageURI(Uri.fromFile(file));
						btnStageSelect.setImageResource(R.drawable.map_back);
					} else {
						imageResultMonster.setImageResource(R.drawable.image_kani);
						imageResultText.setImageResource(R.drawable.image_ng);
						//写真を表示
						ImageView picView = (ImageView) getView().findViewById(R.id.imageResultPicture);
						picView.setImageURI(Uri.fromFile(file));
						btnStageSelect.setImageResource(R.drawable.image_revenge);
					}
				} else if (bundle.getInt("惑星") == 3) {
					//地球
					ResultOdai.setText("真顔達成度　　:" + i3 + "%");
					//表情ボールを渡すとこを今日から試行錯誤していきます
					//とりあえず、表情ボール一覧のフラグメント作ったから
					//ここの結果で、初めて９０％を出した時にのみ、表情ボールを渡すっていう文を書きたい
					if (i3 >= 90){
						//表情ボール一覧に表示する画像のソースをプリファレンスに保存
						// プリファレンスの準備 //
						SharedPreferences pref = getContext().getSharedPreferences( "pref", getContext().MODE_PRIVATE );
						// プリファレンスに書き込むためのEditorオブジェクト取得
						SharedPreferences.Editor editor = pref.edit();
						//表情ボールパスをセット
						editor.putString("bowl","クリア");
						editor.commit();

						//新しいImegeViewを生成して、表情ボールを渡すシーン
						ImageView bowlageru = (ImageView)getView().findViewById(R.id.bowlageru);
						bowlageru.setImageResource(R.drawable.bowl1);
					}
					if (i3 >= 80) {
						imageResultMonster.setImageResource(R.drawable.m_ti2);
						imageResultText.setImageResource(R.drawable.result_ok);
						//写真を表示
						ImageView picView = (ImageView) getView().findViewById(R.id.imageResultPicture);
						picView.setImageURI(Uri.fromFile(file));
						btnStageSelect.setImageResource(R.drawable.map_back);
					} else {
						imageResultMonster.setImageResource(R.drawable.m_ti1);
						imageResultText.setImageResource(R.drawable.image_ng);
						//写真を表示
						ImageView picView = (ImageView) getView().findViewById(R.id.imageResultPicture);
						picView.setImageURI(Uri.fromFile(file));
						btnStageSelect.setImageResource(R.drawable.image_revenge);
					}
				} else if (bundle.getInt("惑星") == 4) {
					//火星
					ResultOdai.setText("怒り達成度　　:" + i4 + "%");
					if (i4 >= 80) {
						imageResultMonster.setImageResource(R.drawable.m_ka2);
						imageResultText.setImageResource(R.drawable.result_ok);
						//写真を表示
						ImageView picView = (ImageView) getView().findViewById(R.id.imageResultPicture);
						picView.setImageURI(Uri.fromFile(file));
						btnStageSelect.setImageResource(R.drawable.map_back);
					} else {
						imageResultMonster.setImageResource(R.drawable.image_tako);
						imageResultText.setImageResource(R.drawable.image_ng);
						//写真を表示
						ImageView picView = (ImageView) getView().findViewById(R.id.imageResultPicture);
						picView.setImageURI(Uri.fromFile(file));
						btnStageSelect.setImageResource(R.drawable.image_revenge);
					}
				} else if (bundle.getInt("惑星") == 5) {
					//木星
					ResultOdai.setText("笑顔達成度　　:" + i5 + "%");
					if (i5 >= 80) {
						imageResultMonster.setImageResource(R.drawable.m_moku2);
						imageResultText.setImageResource(R.drawable.result_ok);
						//写真を表示
						ImageView picView = (ImageView) getView().findViewById(R.id.imageResultPicture);
						picView.setImageURI(Uri.fromFile(file));
						btnStageSelect.setImageResource(R.drawable.map_back);
					} else {
						imageResultMonster.setImageResource(R.drawable.image_upup);
						imageResultText.setImageResource(R.drawable.image_ng);
						//写真を表示
						ImageView picView = (ImageView) getView().findViewById(R.id.imageResultPicture);
						picView.setImageURI(Uri.fromFile(file));
						btnStageSelect.setImageResource(R.drawable.image_revenge);
					}
				} else if (bundle.getInt("惑星") == 6) {
					//土星
					ResultOdai.setText("悲しみ達成度　　:" + i6 + "%");
					if (i6 >= 80) {
						imageResultMonster.setImageResource(R.drawable.m_do2);
						imageResultText.setImageResource(R.drawable.result_ok);
						//写真を表示
						ImageView picView = (ImageView) getView().findViewById(R.id.imageResultPicture);
						picView.setImageURI(Uri.fromFile(file));
						btnStageSelect.setImageResource(R.drawable.map_back);
					} else {
						imageResultMonster.setImageResource(R.drawable.m_do1);
						imageResultText.setImageResource(R.drawable.image_ng);
						//写真を表示
						ImageView picView = (ImageView) getView().findViewById(R.id.imageResultPicture);
						picView.setImageURI(Uri.fromFile(file));
						btnStageSelect.setImageResource(R.drawable.image_revenge);
					}
				} else if (bundle.getInt("惑星") == 7) {
					//天王星
					ResultOdai.setText("恐怖達成度　　:" + i7 + "%");
					if (i7 >= 80) {
						imageResultMonster.setImageResource(R.drawable.m_ten2);
						imageResultText.setImageResource(R.drawable.result_ok);
						//写真を表示
						ImageView picView = (ImageView) getView().findViewById(R.id.imageResultPicture);
						picView.setImageURI(Uri.fromFile(file));
						btnStageSelect.setImageResource(R.drawable.map_back);
					} else {
						imageResultMonster.setImageResource(R.drawable.image_tensi);
						imageResultText.setImageResource(R.drawable.image_ng);
						//写真を表示
						ImageView picView = (ImageView) getView().findViewById(R.id.imageResultPicture);
						picView.setImageURI(Uri.fromFile(file));
						btnStageSelect.setImageResource(R.drawable.image_revenge);
					}
				} else if (bundle.getInt("惑星") == 8) {
					//海王星
					ResultOdai.setText("嫌悪達成度　　:" + i8 + "%");
					if (i8 >= 80) {
						imageResultMonster.setImageResource(R.drawable.m_kai2);
						imageResultText.setImageResource(R.drawable.result_ok);
						//写真を表示
						ImageView picView = (ImageView) getView().findViewById(R.id.imageResultPicture);
						picView.setImageURI(Uri.fromFile(file));
						btnStageSelect.setImageResource(R.drawable.map_back);
					} else {
						imageResultMonster.setImageResource(R.drawable.image_dh);
						imageResultText.setImageResource(R.drawable.image_ng);
						//写真を表示
						ImageView picView = (ImageView) getView().findViewById(R.id.imageResultPicture);
						picView.setImageURI(Uri.fromFile(file));
						btnStageSelect.setImageResource(R.drawable.image_revenge);
					}
				}

			}
		}
	}

	@Override
	public void onProgress(Long sizeTotal, Long sizeCurrent) {
		System.out.format("%d/%d\n",sizeCurrent,sizeTotal);
	}


	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);


		//IDからオブジェクトを取得
		btn1 = (ImageButton) view.findViewById(R.id.btnStageSelect);
		btn2 = (Button) view.findViewById(R.id.b1);

		//ボタンをリスナーに登録
		btn1.setOnClickListener(this);
		btn2.setOnClickListener(this);
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


