package layout;


import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

import jp.ac.fjb.x15g020.emotionjudgmentapp_ver2.R;
import jp.ac.fjb.x15g020.emotionjudgmentapp_ver2.model.CameraPreview;
import jp.ac.fjb.x15g020.emotionjudgmentapp_ver2.model.EmotionEngine;
import jp.ac.fjb.x15g020.emotionjudgmentapp_ver2.view.CameraFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class PictureCheckFragment extends Fragment implements View.OnClickListener,EmotionEngine.EmotionListener{

    CameraPreview mCamera;
    private ImageButton btn1;
    private ImageButton btn2;
    private String path;
    private Bundle bundle;

    public PictureCheckFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_picture_check, container, false);

        //カメラで撮影した写真の一時保存データを取得  (よくわからんけどフィールドにしてある)
         path = getContext().getCacheDir()+"/emotionjudgment.jpg";
        //一時保存データのパスをFileにセット　（Uriで指定できるようにするため？）
        File file = new File(path);
        //写真を表示
        ImageView picView = (ImageView)view.findViewById(R.id.PictureView);
        picView.setImageURI(Uri.fromFile(file));

        //エモーションエンジンの呼び出し
        EmotionEngine.getEmotion(path,this);

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
                TextView text = getView().findViewById(R.id.textStatus);
//                    String msg = String.format("怒り　:%f\n軽蔑　:%f\nムカ　:%f\n恐れ　:%f\n喜び　:%f\n無表情:%f\n悲しみ:%f\n驚き　:%f\n",
//                            anger,contempt,disgust,fear,happiness,neutral,sadness,surprise);

                String msg1 = String.format("怒り　:%f\n笑顔　:%f\n真顔　:%f\n哀愁　:%f\n",
                    p.anger, p.happiness, p.neutral, p.sadness);
                text.setText(msg1);
                //text.setText(msg);
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

        //インスタンス取得
        btn1 = (ImageButton) view.findViewById(R.id.btnBack);
        btn2 = (ImageButton) view.findViewById(R.id.btnNext);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btnBack) {
            //もう一度撮影  押下時
            bundle =getArguments();
            if(bundle.getInt("惑星") == 1 ){
                //水星  押下時
                bundle.putInt("惑星",1);
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                Fragment f = new CameraFragment();
                f.setArguments(bundle);
                ft.replace(R.id.layout_main,f);
                ft.commit();
            }else if(bundle.getInt("惑星") == 2 ){
                //金星  押下時
                bundle.putInt("惑星",2);
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                Fragment f = new CameraFragment();
                f.setArguments(bundle);
                ft.replace(R.id.layout_main,f);
                ft.commit();
            }else if(bundle.getInt("惑星") == 3 ){
                //地球  押下時
                bundle.putInt("惑星",3);
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                Fragment f = new CameraFragment();
                f.setArguments(bundle);
                ft.replace(R.id.layout_main,f);
                ft.commit();
            }else if(bundle.getInt("惑星") == 4 ){
                //火星  押下時
                bundle.putInt("惑星",4);
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                Fragment f = new CameraFragment();
                f.setArguments(bundle);
                ft.replace(R.id.layout_main,f);
                ft.commit();
            }else if(bundle.getInt("惑星") == 5 ){
                //木星  押下時
                bundle.putInt("惑星",5);
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                Fragment f = new CameraFragment();
                f.setArguments(bundle);
                ft.replace(R.id.layout_main,f);
                ft.commit();
            }else if(bundle.getInt("惑星") == 6 ){
                //土星  押下時
                bundle.putInt("惑星",6);
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                Fragment f = new CameraFragment();
                f.setArguments(bundle);
                ft.replace(R.id.layout_main,f);
                ft.commit();
            }else if(bundle.getInt("惑星") == 7 ){
                //天王星  押下時
                bundle.putInt("惑星",7);
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                Fragment f = new CameraFragment();
                f.setArguments(bundle);
                ft.replace(R.id.layout_main,f);
                ft.commit();
            }else if(bundle.getInt("惑星") == 8 ){
                //海王星  押下時
                bundle.putInt("惑星",8);
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                Fragment f = new CameraFragment();
                f.setArguments(bundle);
                ft.replace(R.id.layout_main,f);
                ft.commit();
            }
        }else if(view.getId() == R.id.btnNext){
            //判定する　 押下時
            bundle =getArguments();
            if(bundle.getInt("惑星") == 1 ){
                //水星  押下時
                bundle.putInt("惑星",1);
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                Fragment f = new ResultOkFragment();
                f.setArguments(bundle);
                ft.replace(R.id.layout_main,f);
                ft.commit();
            }else if(bundle.getInt("惑星") == 2 ){
                //金星  押下時
                bundle.putInt("惑星",2);
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                Fragment f = new ResultOkFragment();
                f.setArguments(bundle);
                ft.replace(R.id.layout_main,f);
                ft.commit();
            }else if(bundle.getInt("惑星") == 3 ){
                //地球  押下時
                bundle.putInt("惑星",3);
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                Fragment f = new ResultOkFragment();
                f.setArguments(bundle);
                ft.replace(R.id.layout_main,f);
                ft.commit();
            }else if(bundle.getInt("惑星") == 4 ){
                //火星  押下時
                bundle.putInt("惑星",4);
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                Fragment f = new ResultOkFragment();
                f.setArguments(bundle);
                ft.replace(R.id.layout_main,f);
                ft.commit();
            }else if(bundle.getInt("惑星") == 5 ){
                //木星  押下時
                bundle.putInt("惑星",5);
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                Fragment f = new ResultOkFragment();
                f.setArguments(bundle);
                ft.replace(R.id.layout_main,f);
                ft.commit();
            }else if(bundle.getInt("惑星") == 6 ){
                //土星  押下時
                bundle.putInt("惑星",6);
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                Fragment f = new ResultOkFragment();
                f.setArguments(bundle);
                ft.replace(R.id.layout_main,f);
                ft.commit();
            }else if(bundle.getInt("惑星") == 7 ){
                //天王星  押下時
                bundle.putInt("惑星",7);
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                Fragment f = new ResultOkFragment();
                f.setArguments(bundle);
                ft.replace(R.id.layout_main,f);
                ft.commit();
            }else if(bundle.getInt("惑星") == 8 ){
                //海王星  押下時
                bundle.putInt("惑星",8);
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                Fragment f = new ResultOkFragment();
                f.setArguments(bundle);
                ft.replace(R.id.layout_main,f);
                ft.commit();
            }
        }
    }
}
