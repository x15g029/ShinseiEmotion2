package layout;


import android.graphics.drawable.Drawable;
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

    public EncounterSuiFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_encounter_sui, container, false);



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
            ImageView Monster = (ImageView)getView().findViewById(R.id.imageMonster);
            ImageView Odai = (ImageView)getView().findViewById(R.id.imageOdai);
            Odai.setImageResource(R.drawable.odai1);
            Monster.setImageResource(R.drawable.image_chac);
        }else if(bundle.getInt("惑星") == 2 ){
            ImageView Monster = (ImageView)getView().findViewById(R.id.imageMonster);
            ImageView Odai = (ImageView)getView().findViewById(R.id.imageOdai);
            Odai.setImageResource(R.drawable.odai2);
            Monster.setImageResource(R.drawable.image_kani);
        }else if(bundle.getInt("惑星") == 3 ){
            ImageView Monster = (ImageView)getView().findViewById(R.id.imageMonster);
            ImageView Odai = (ImageView)getView().findViewById(R.id.imageOdai);
            Odai.setImageResource(R.drawable.odai3);
            Monster.setImageResource(R.drawable.image_guide);
        }else if(bundle.getInt("惑星") == 4 ){
            ImageView Monster = (ImageView)getView().findViewById(R.id.imageMonster);
            ImageView Odai = (ImageView)getView().findViewById(R.id.imageOdai);
            Odai.setImageResource(R.drawable.odai4);
            Monster.setImageResource(R.drawable.image_tako);
        }else if(bundle.getInt("惑星") == 5 ){
            ImageView Monster = (ImageView)getView().findViewById(R.id.imageMonster);
            ImageView Odai = (ImageView)getView().findViewById(R.id.imageOdai);
            Odai.setImageResource(R.drawable.odai5);
            Monster.setImageResource(R.drawable.image_upup);
        }else if(bundle.getInt("惑星") == 6 ){
            ImageView Monster = (ImageView)getView().findViewById(R.id.imageMonster);
            ImageView Odai = (ImageView)getView().findViewById(R.id.imageOdai);
            Odai.setImageResource(R.drawable.odai6);
            Monster.setImageResource(R.drawable.image_guide);
        }else if(bundle.getInt("惑星") == 7 ){
            ImageView Monster = (ImageView)getView().findViewById(R.id.imageMonster);
            ImageView Odai = (ImageView)getView().findViewById(R.id.imageOdai);
            Odai.setImageResource(R.drawable.odai7);
            Monster.setImageResource(R.drawable.image_tensi);
        }else if(bundle.getInt("惑星") == 8 ){
            ImageView Monster = (ImageView)getView().findViewById(R.id.imageMonster);
            ImageView Odai = (ImageView)getView().findViewById(R.id.imageOdai);
            Odai.setImageResource(R.drawable.odai8);
            Monster.setImageResource(R.drawable.image_dh);
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
            ft.commit();
            }
        }
    }

