package layout;


import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.File;

import jp.ac.fjb.x15g020.emotionjudgmentapp_ver2.R;
import jp.ac.fjb.x15g020.emotionjudgmentapp_ver2.model.CameraPreview;
import jp.ac.fjb.x15g020.emotionjudgmentapp_ver2.model.EmotionEngine;
import jp.ac.fjb.x15g020.emotionjudgmentapp_ver2.view.CameraFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class PictureCheckFragment extends Fragment {

    CameraPreview mCamera;
    private ImageButton btn1;
    private ImageButton btn2;
    private String path;

    public PictureCheckFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_picture_check, container, false);

        //カメラで撮影した写真の一時保存データを取得  (よくわからんけどフィールドにしてある)
         path = Environment.getExternalStorageDirectory()+"/emotionjudgment.jpg";

        //一時保存データのパスをFileにセット　（Uriで指定できるようにするため？）
        File file = new File(path);

        //撮影した写真をプレビューに表示
        ImageView picView = (ImageView)view.findViewById(R.id.PictureView);
        picView.setImageURI(Uri.fromFile(file));


//        //～確認用～　　テキスト表示で確認
//        TextView textView = (TextView)view.findViewById(R.id.textView);
//        textView.setText("確認用" + path);



        return view;
    }

//    @Override
//    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//
//        //IDからオブジェクトを取得
//        btn1 = (ImageButton) view.findViewById(R.id.btnBack);
//        btn2 = (ImageButton) view.findViewById(R.id.btnNext);
//        //ボタンをリスナーに登録
//        btn1.setOnClickListener(this);
//        btn2.setOnClickListener(this);
//
//    }


//    @Override
//    public void onClick(View view) {
//        if(view.getId() == R.id.btnBack) {
//            //もう一度撮影  押下時
//            FragmentTransaction ft = getFragmentManager().beginTransaction();
//            ft.replace(R.id.layout_main, new CameraFragment());
//            ft.commit();
//        }else{
//            //判定する　 押下時
//            FragmentTransaction ft2 = getFragmentManager().beginTransaction();
//            ft2.replace(R.id.layout_main,new ResultOkFragment());
//            ft2.commit();
//        }
//    }
}
