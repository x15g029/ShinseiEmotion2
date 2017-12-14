package layout;


import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

import jp.ac.fjb.x15g020.emotionjudgmentapp_ver2.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class GaidoStartFragment extends Fragment {

    private ImageView imageView;
    private Animation animation;

    public GaidoStartFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gaido_start, container, false);
        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //アニメーション開始
        imageView = (ImageView) getView().findViewById(R.id.ImageAnime);
        animation = AnimationUtils.loadAnimation(getContext(), R.anim.anime_gaido_tojo);
        imageView.startAnimation(animation);
//imageView.setImageResource(R.drawable.image_guide);


        //アニメーション後に正面ガイドくんに切り替え
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //5秒後に実行する処理
                imageView.setImageResource(R.drawable.image_guide);
            }
        }, 5000);
    }
}



