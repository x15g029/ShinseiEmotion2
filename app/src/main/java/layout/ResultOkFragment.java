package layout;


import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.math.BigDecimal;

import jp.ac.fjb.x15g020.emotionjudgmentapp_ver2.R;
import jp.ac.fjb.x15g020.emotionjudgmentapp_ver2.model.CameraPreview;
import jp.ac.fjb.x15g020.emotionjudgmentapp_ver2.model.EmotionEngine;
import jp.ac.fjb.x15g020.emotionjudgmentapp_ver2.view.CameraFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class ResultOkFragment extends Fragment implements View.OnClickListener ,EmotionEngine.EmotionListener{
    private ImageButton btn1;
    private ImageButton btn2;
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
        path = getContext().getCacheDir()+"/emotionjudgment.jpg";
        //一時保存データのパスをFileにセット　（Uriで指定できるようにするため？）
        file = new File(path);
//        //写真を表示
//        ImageView picView = (ImageView)view.findViewById(R.id.imageResultPicture);
//        picView.setImageURI(Uri.fromFile(file));

        //エモーションエンジンの呼び出し
        EmotionEngine.getEmotion(path,this);
        return view;
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
                    double anger = scores.getDouble("anger");//怒り
                    double contempt = scores.getDouble("contempt");//軽蔑
                    double disgust = scores.getDouble("disgust");//嫌悪
                    double fear = scores.getDouble("fear");//恐怖
                    double happiness = scores.getDouble("happiness");//笑顔
                    double neutral = scores.getDouble("neutral");//真顔
                    double sadness = scores.getDouble("sadness");//悲しみ
                    double surprise = scores.getDouble("surprise");//驚き


                    anger = anger * 100;
                    contempt = contempt * 100;
                    disgust = disgust * 100;
                    fear = fear * 100;
                    happiness = happiness * 100;
                    neutral = neutral * 100;
                    sadness = sadness * 100;
                    surprise = surprise * 100;

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
                    if(bundle.getInt("惑星") == 1 ){
                        //水星
                        ResultOdai.setText("驚き達成度　　:" + i1 +"%");
                            if(i1 >= 80){
                                imageResultMonster.setImageResource(R.drawable.m_sui2);
                                imageResultText.setImageResource(R.drawable.result_ok);
                                //写真を表示
                                ImageView picView = (ImageView)getView().findViewById(R.id.imageResultPicture);
                                picView.setImageURI(Uri.fromFile(file));
                                btnStageSelect.setImageResource(R.drawable.map_back);
                            }else{
                                imageResultMonster.setImageResource(R.drawable.image_chac);
                                imageResultText.setImageResource(R.drawable.image_ng);
                                //写真を表示
                                ImageView picView = (ImageView)getView().findViewById(R.id.imageResultPicture);
                                picView.setImageURI(Uri.fromFile(file));
                                btnStageSelect.setImageResource(R.drawable.image_revenge);
                            }
                    }else if(bundle.getInt("惑星") == 2 ){
                        //金星
                        ResultOdai.setText("軽蔑達成度　　:" + i2 +"%");
                            if(i2 >= 80){
                                imageResultMonster.setImageResource(R.drawable.m_kin2);
                                imageResultText.setImageResource(R.drawable.result_ok);
                                //写真を表示
                                ImageView picView = (ImageView)getView().findViewById(R.id.imageResultPicture);
                                picView.setImageURI(Uri.fromFile(file));
                                btnStageSelect.setImageResource(R.drawable.map_back);
                            }else{
                                imageResultMonster.setImageResource(R.drawable.image_kani);
                                imageResultText.setImageResource(R.drawable.image_ng);
                                //写真を表示
                                ImageView picView = (ImageView)getView().findViewById(R.id.imageResultPicture);
                                picView.setImageURI(Uri.fromFile(file));
                                btnStageSelect.setImageResource(R.drawable.image_revenge);
                            }
                    }else if(bundle.getInt("惑星") == 3 ){
                        //地球
                        ResultOdai.setText("真顔達成度　　:" + i3 +"%");
                            if(i3 >= 80){
                                imageResultMonster.setImageResource(R.drawable.m_ti2);
                                imageResultText.setImageResource(R.drawable.result_ok);
                                //写真を表示
                                ImageView picView = (ImageView)getView().findViewById(R.id.imageResultPicture);
                                picView.setImageURI(Uri.fromFile(file));
                                btnStageSelect.setImageResource(R.drawable.map_back);
                            }else{
                                imageResultMonster.setImageResource(R.drawable.m_ti1);
                                imageResultText.setImageResource(R.drawable.image_ng);
                                //写真を表示
                                ImageView picView = (ImageView)getView().findViewById(R.id.imageResultPicture);
                                picView.setImageURI(Uri.fromFile(file));
                                btnStageSelect.setImageResource(R.drawable.image_revenge);
                            }
                    }else if(bundle.getInt("惑星") == 4 ){
                        //火星
                        ResultOdai.setText("怒り達成度　　:" + i4 +"%");
                            if(i4 >= 80){
                                imageResultMonster.setImageResource(R.drawable.m_ka2);
                                imageResultText.setImageResource(R.drawable.result_ok);
                                //写真を表示
                                ImageView picView = (ImageView)getView().findViewById(R.id.imageResultPicture);
                                picView.setImageURI(Uri.fromFile(file));
                                btnStageSelect.setImageResource(R.drawable.map_back);
                            }else{
                                imageResultMonster.setImageResource(R.drawable.image_tako);
                                imageResultText.setImageResource(R.drawable.image_ng);
                                //写真を表示
                                ImageView picView = (ImageView)getView().findViewById(R.id.imageResultPicture);
                                picView.setImageURI(Uri.fromFile(file));
                                btnStageSelect.setImageResource(R.drawable.image_revenge);
                            }
                    }else if(bundle.getInt("惑星") == 5 ){
                        //木星
                        ResultOdai.setText("笑顔達成度　　:" + i5 +"%");
                            if(i5 >= 80){
                                imageResultMonster.setImageResource(R.drawable.m_moku2);
                                imageResultText.setImageResource(R.drawable.result_ok);
                                //写真を表示
                                ImageView picView = (ImageView)getView().findViewById(R.id.imageResultPicture);
                                picView.setImageURI(Uri.fromFile(file));
                                btnStageSelect.setImageResource(R.drawable.map_back);
                            }else{
                                imageResultMonster.setImageResource(R.drawable.image_upup);
                                imageResultText.setImageResource(R.drawable.image_ng);
                                //写真を表示
                                ImageView picView = (ImageView)getView().findViewById(R.id.imageResultPicture);
                                picView.setImageURI(Uri.fromFile(file));
                                btnStageSelect.setImageResource(R.drawable.image_revenge);
                            }
                    }else if(bundle.getInt("惑星") == 6 ){
                        //土星
                        ResultOdai.setText("悲しみ達成度　　:" + i6 +"%");
                            if(i6 >= 80){
                                imageResultMonster.setImageResource(R.drawable.m_do2);
                                imageResultText.setImageResource(R.drawable.result_ok);
                                //写真を表示
                                ImageView picView = (ImageView)getView().findViewById(R.id.imageResultPicture);
                                picView.setImageURI(Uri.fromFile(file));
                                btnStageSelect.setImageResource(R.drawable.map_back);
                            }else{
                                imageResultMonster.setImageResource(R.drawable.m_do1);
                                imageResultText.setImageResource(R.drawable.image_ng);
                                //写真を表示
                                ImageView picView = (ImageView)getView().findViewById(R.id.imageResultPicture);
                                picView.setImageURI(Uri.fromFile(file));
                                btnStageSelect.setImageResource(R.drawable.image_revenge);
                            }
                    }else if(bundle.getInt("惑星") == 7 ){
                        //天王星
                        ResultOdai.setText("恐怖達成度　　:" + i7 +"%");
                            if(i7 >= 80){
                                imageResultMonster.setImageResource(R.drawable.m_ten2);
                                imageResultText.setImageResource(R.drawable.result_ok);
                                //写真を表示
                                ImageView picView = (ImageView)getView().findViewById(R.id.imageResultPicture);
                                picView.setImageURI(Uri.fromFile(file));
                                btnStageSelect.setImageResource(R.drawable.map_back);
                            }else{
                                imageResultMonster.setImageResource(R.drawable.image_tensi);
                                imageResultText.setImageResource(R.drawable.image_ng);
                                //写真を表示
                                ImageView picView = (ImageView)getView().findViewById(R.id.imageResultPicture);
                                picView.setImageURI(Uri.fromFile(file));
                                btnStageSelect.setImageResource(R.drawable.image_revenge);
                            }
                    }else if(bundle.getInt("惑星") == 8 ){
                        //海王星
                        ResultOdai.setText("嫌悪達成度　　:" + i8 +"%");
                            if(i8 >= 80){
                                imageResultMonster.setImageResource(R.drawable.m_kai2);
                                imageResultText.setImageResource(R.drawable.result_ok);
                                //写真を表示
                                ImageView picView = (ImageView)getView().findViewById(R.id.imageResultPicture);
                                picView.setImageURI(Uri.fromFile(file));
                                btnStageSelect.setImageResource(R.drawable.map_back);
                            }else{
                                imageResultMonster.setImageResource(R.drawable.image_dh);
                                imageResultText.setImageResource(R.drawable.image_ng);
                                //写真を表示
                                ImageView picView = (ImageView)getView().findViewById(R.id.imageResultPicture);
                                picView.setImageURI(Uri.fromFile(file));
                                btnStageSelect.setImageResource(R.drawable.image_revenge);
                            }
                    }

                }catch (Exception e){
                    Toast.makeText(getContext(), "データエラー", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        //IDからオブジェクトを取得
        btn1 = (ImageButton) view.findViewById(R.id.btnStageSelect);

        //ボタンをリスナーに登録
        btn1.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btnStageSelect) {
            //マップ  押下時
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.layout_main, new MapFragment());
            ft.commit();
        }else{
            //もう一度  押下時
            FragmentTransaction ft2 = getFragmentManager().beginTransaction();
            ft2.replace(R.id.layout_main,new CameraFragment());
            ft2.commit();
        }
    }
}


