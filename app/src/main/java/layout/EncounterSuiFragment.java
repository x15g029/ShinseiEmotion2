package layout;


import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;

import jp.ac.fjb.x15g020.emotionjudgmentapp_ver2.R;
import jp.ac.fjb.x15g020.emotionjudgmentapp_ver2.view.CameraFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class EncounterSuiFragment extends Fragment implements View.OnClickListener{


    private ImageButton btn1;
    private ImageButton btn2;
    private Bundle bundle;
    public MediaPlayer mediaPlayer;

    public EncounterSuiFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_encounter_sui, container, false);



        bundle = getArguments();
        if(bundle.getInt("惑星") == 1){
            //BGM再生
            mediaPlayer = MediaPlayer.create(getContext(), R.raw.bgm_sui);
            mediaPlayer.setLooping(true);
            mediaPlayer.start();
        }else if(bundle.getInt("惑星") == 2){
            //BGM再生
            mediaPlayer = MediaPlayer.create(getContext(), R.raw.bgm_kin);
            mediaPlayer.setLooping(true);
            mediaPlayer.start();
        }else if(bundle.getInt("惑星") == 3){
            //BGM再生
            mediaPlayer = MediaPlayer.create(getContext(), R.raw.bgm_moku);
            mediaPlayer.setLooping(true);
            mediaPlayer.start();
        }else if(bundle.getInt("惑星") == 4){
            //BGM再生
            mediaPlayer = MediaPlayer.create(getContext(), R.raw.bgm_ka);
            mediaPlayer.setLooping(true);
            mediaPlayer.start();
        }else if(bundle.getInt("惑星") == 5){
            //BGM再生
            mediaPlayer = MediaPlayer.create(getContext(), R.raw.bgm_moku);
            mediaPlayer.setLooping(true);
            mediaPlayer.start();
        }else if(bundle.getInt("惑星") == 6){
            //BGM再生
            mediaPlayer = MediaPlayer.create(getContext(), R.raw.bgm_do);
            mediaPlayer.setLooping(true);
            mediaPlayer.start();
        }else if(bundle.getInt("惑星") == 7){
            //BGM再生
            mediaPlayer = MediaPlayer.create(getContext(), R.raw.bgm_ten);
            mediaPlayer.setLooping(true);
            mediaPlayer.start();
        }else if(bundle.getInt("惑星") == 8){
            //BGM再生
            mediaPlayer = MediaPlayer.create(getContext(), R.raw.bgm_kai);
            mediaPlayer.setLooping(true);
            mediaPlayer.start();
        }


        //キャラクターが動くやつ
        view.findViewById(R.id.imageMonster).startAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.anime));

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //惑星ごとの宇宙人を表示
        bundle = getArguments();
//        System.out.println("送られてきたデータ:"+bundle.getInt("惑星"));
        if(bundle.getInt("惑星") == 1 ){
            //水星
            ImageView Monster = (ImageView)getView().findViewById(R.id.imageMonster);
            ImageView Odai = (ImageView)getView().findViewById(R.id.imageOdai);
            Odai.setImageResource(R.drawable.odai_odoroki);
            Monster.setImageResource(R.drawable.m_sui1);
        }else if(bundle.getInt("惑星") == 2 ){
            //金星
            ImageView Monster = (ImageView)getView().findViewById(R.id.imageMonster);
            ImageView Odai = (ImageView)getView().findViewById(R.id.imageOdai);
            Odai.setImageResource(R.drawable.odai_kexno);
            Monster.setImageResource(R.drawable.m_kin1);
        }else if(bundle.getInt("惑星") == 3 ){
            //地球
            ImageView Monster = (ImageView)getView().findViewById(R.id.imageMonster);
            ImageView Odai = (ImageView)getView().findViewById(R.id.imageOdai);
            Odai.setImageResource(R.drawable.odai_egao);
            Monster.setImageResource(R.drawable.m_ti1);
        }else if(bundle.getInt("惑星") == 4 ){
            //火星
            ImageView Monster = (ImageView)getView().findViewById(R.id.imageMonster);
            ImageView Odai = (ImageView)getView().findViewById(R.id.imageOdai);
            Odai.setImageResource(R.drawable.odai_ikari);
            Monster.setImageResource(R.drawable.m_ka1);
        }else if(bundle.getInt("惑星") == 5 ){
            //木星
            ImageView Monster = (ImageView)getView().findViewById(R.id.imageMonster);
            ImageView Odai = (ImageView)getView().findViewById(R.id.imageOdai);
            Odai.setImageResource(R.drawable.odai_egao);
            Monster.setImageResource(R.drawable.m_moku1);
        }else if(bundle.getInt("惑星") == 6 ){
            //土星
            ImageView Monster = (ImageView)getView().findViewById(R.id.imageMonster);
            ImageView Odai = (ImageView)getView().findViewById(R.id.imageOdai);
            Odai.setImageResource(R.drawable.odai_kanasimi);
            Monster.setImageResource(R.drawable.m_do1);
        }else if(bundle.getInt("惑星") == 7 ){
            //天王星
            ImageView Monster = (ImageView)getView().findViewById(R.id.imageMonster);
            ImageView Odai = (ImageView)getView().findViewById(R.id.imageOdai);
            Odai.setImageResource(R.drawable.odai_keibetu);
            Monster.setImageResource(R.drawable.m_ten1);
        }else if(bundle.getInt("惑星") == 8 ){
            //海王星
            ImageView Monster = (ImageView)getView().findViewById(R.id.imageMonster);
            ImageView Odai = (ImageView)getView().findViewById(R.id.imageOdai);
            Odai.setImageResource(R.drawable.odai_kyouhu);
            Monster.setImageResource(R.drawable.m_kai1);
        }







        //IDからオブジェクトを取得
        btn1 = (ImageButton) view.findViewById(R.id.btnCamera);
        btn2 = (ImageButton) view.findViewById(R.id.btnBack);

        //ボタンをリスナーに登録
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btnCamera) {
            //カメラ 押下時
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
        }else{
            //戻る  押下時
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.layout_main, new MapFragment());
            if(mediaPlayer != null) {
//                mediaPlayer.stop();
//                mediaPlayer.release();
            }
            ft.commit();
            }
        }
    @Override
    public void onResume() {
        super.onResume();
        if(mediaPlayer == null) {
            mediaPlayer.start();
        }


    }

    @Override
    public void onPause() {
        super.onPause();
        if(mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
        }
    }

}

