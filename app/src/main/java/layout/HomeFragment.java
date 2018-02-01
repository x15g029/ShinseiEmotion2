package layout;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.AppLaunchChecker;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import jp.ac.fjb.x15g020.emotionjudgmentapp_ver2.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {


    private ImageButton btnTool;
    private ImageButton btnBowl;
    private ImageButton btnMap;
    private ImageButton roketto;
    private Animation animation;
    private ImageView a1;
    private MediaPlayer mediaPlayer;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_home, container, false);

        //BGM再生
        mediaPlayer = MediaPlayer.create(getContext(), R.raw.bgm_bowl);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();
        
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        //IDからオブジェクトを取得
        btnTool = (ImageButton) view.findViewById(R.id.image1);
        btnBowl = (ImageButton) view.findViewById(R.id.image2);
        btnMap = (ImageButton) view.findViewById(R.id.image3);

        //ボタンをリスナーに登録
        btnTool.setOnClickListener(this);
        btnBowl.setOnClickListener(this);
        btnMap.setOnClickListener(this);

    }

    @Override
    public void onClick(final View view) {
        FragmentTransaction ft = getFragmentManager().beginTransaction();

        if(view.getId() == R.id.image1){
            //ツール
            ft.replace(R.id.layout_main, new MapFragment());
            ft.commit();
        }else if(view.getId() == R.id.image2){
            //水晶
            ft.replace(R.id.layout_main, new EmotionBowlFragment());
            ft.commit();
        }else if(view.getId() == R.id.image3){
            //マップ
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                //5秒後に実行する処理
                public void run() {
                    //ロケットを消す
                    btnMap.setVisibility(View.INVISIBLE);

                }
            }, 0);

            handler.postDelayed(new Runnable() {
                @Override
                public void run() {

                    //飛ばすロケット表示
                    ImageView kari = new ImageView(getContext());
                    kari.setImageResource(R.drawable.home4);

                    LinearLayout rokettoLay = (LinearLayout) getView().findViewById(R.id.Roketto);
                    rokettoLay.addView(kari);

                    //アニメーションセット
                    animation = AnimationUtils.loadAnimation(getContext(), R.anim.anime_ueni);
                    rokettoLay.setAnimation(animation);

                }
            },10);

            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    //画面遷移
                    FragmentTransaction ft1 = getFragmentManager().beginTransaction();
                    ft1.replace(R.id.layout_main, new MapFragment());
                    ft1.commit();
                }
            },2010);

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
