package layout;


import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import jp.ac.fjb.x15g020.emotionjudgmentapp_ver2.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class GaidoStartFragment extends Fragment{

    private ImageView imageView;
    private Animation animation;
    private TextView textSerihu;
    private  String Pserihu;


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
    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //アニメーション開始
        imageView = (ImageView) getView().findViewById(R.id.ImageAnime);
        textSerihu = (TextView) getView().findViewById(R.id.textSerihu);
        animation = AnimationUtils.loadAnimation(getContext(), R.anim.anime_gaido_tojo);
        imageView.startAnimation(animation);




        //アニメーション終了後
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            //5秒後に実行する処理
            public void run() {
                //正面ガイド君に切り替える
                imageView.setImageResource(R.drawable.image_guide);
                Pserihu = "今";
                textSerihu.setText(Pserihu);
            }
        }, 3200);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Pserihu = Pserihu + "キ";
                textSerihu.setText(Pserihu);
            }
        },3300);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Pserihu = Pserihu + "ミ";
                textSerihu.setText(Pserihu );
            }
        },3400);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Pserihu = Pserihu + "は";
                textSerihu.setText(Pserihu );
            }
        },3500);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Pserihu = Pserihu + "表";
                textSerihu.setText(Pserihu);
            }
        },3600);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Pserihu = Pserihu + "情";
                textSerihu.setText(Pserihu);
            }
        },3700);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Pserihu = Pserihu + "ボ";
                textSerihu.setText(Pserihu);
            }
        },3800);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Pserihu = Pserihu + "ー";
                textSerihu.setText(Pserihu);
            }
        },3900);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Pserihu = Pserihu + "ル";
                textSerihu.setText(Pserihu);
            }
        },4000);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Pserihu = Pserihu + "を";
                textSerihu.setText(Pserihu);
            }
        },4100);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Pserihu = Pserihu + "奪";
                textSerihu.setText(Pserihu);
            }
        },4200);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Pserihu = Pserihu + "わ";
                textSerihu.setText(Pserihu);
            }
        },4300);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Pserihu = Pserihu + "れ";
                textSerihu.setText(Pserihu);
            }
        },4400);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Pserihu = Pserihu + "た";
                textSerihu.setText(Pserihu);
            }
        },4500);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Pserihu = Pserihu + "ん";
                textSerihu.setText(Pserihu);
            }
        },4600);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Pserihu = Pserihu + "だ";
                textSerihu.setText(Pserihu);
            }
        },4700);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Pserihu = Pserihu + "。\n\n";
                textSerihu.setText(Pserihu);
            }
        },4800);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Pserihu = Pserihu + "鏡";
                textSerihu.setText(Pserihu);
            }
        },4900);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Pserihu = Pserihu + "を";
                textSerihu.setText(Pserihu);
            }
        },5000);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Pserihu = Pserihu + "見";
                textSerihu.setText(Pserihu);
            }
        },5100);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Pserihu = Pserihu + "て";
                textSerihu.setText(Pserihu);
            }
        },5200);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Pserihu = Pserihu + "ご";
                textSerihu.setText(Pserihu);
            }
        },5300);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Pserihu = Pserihu + "ら";
                textSerihu.setText(Pserihu);
            }
        },5400);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Pserihu = Pserihu + "ん";
                textSerihu.setText(Pserihu);
            }
        },5500);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Pserihu = Pserihu + "。\n\n";
                textSerihu.setText(Pserihu);
            }
        },5600);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Pserihu = Pserihu + "全";
                textSerihu.setText(Pserihu);
            }
        },5700);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Pserihu = Pserihu + "て";
                textSerihu.setText(Pserihu);
            }
        },5800);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Pserihu = Pserihu + "の";
                textSerihu.setText(Pserihu);
            }
        },5900);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Pserihu = Pserihu + "表";
                textSerihu.setText(Pserihu);
            }
        },6000);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Pserihu = Pserihu + "情";
                textSerihu.setText(Pserihu);
            }
        },6100);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Pserihu = Pserihu + "が";
                textSerihu.setText(Pserihu);
            }
        },6200);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Pserihu = Pserihu + "失";
                textSerihu.setText(Pserihu);
            }
        },6300);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Pserihu = Pserihu + "わ";
                textSerihu.setText(Pserihu);
            }
        },6400);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Pserihu = Pserihu + "れ";
                textSerihu.setText(Pserihu);
            }
        },6500);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Pserihu = Pserihu + "、";
                textSerihu.setText(Pserihu);
            }
        },6600);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Pserihu = Pserihu + "真";
                textSerihu.setText(Pserihu);
            }
        },6700);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Pserihu = Pserihu + "顔";
                textSerihu.setText(Pserihu);
            }
        },6800);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Pserihu = Pserihu + "に";
                textSerihu.setText(Pserihu);
            }
        },6900);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Pserihu = Pserihu + "な";
                textSerihu.setText(Pserihu);
            }
        },7000);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Pserihu = Pserihu + "っ";
                textSerihu.setText(Pserihu);
            }
        },7100);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Pserihu = Pserihu + "て";
                textSerihu.setText(Pserihu);
            }
        },7200);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Pserihu = Pserihu + "い";
                textSerihu.setText(Pserihu);
            }
        },7300);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Pserihu = Pserihu + "る";
                textSerihu.setText(Pserihu);
            }
        },7400);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Pserihu = Pserihu + "よ";
                textSerihu.setText(Pserihu);
            }
        },7500);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Pserihu = Pserihu + "。\n\n";
                textSerihu.setText(Pserihu);
            }
        },7600);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Pserihu = Pserihu + "こ";
                textSerihu.setText(Pserihu);
            }
        },7700);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Pserihu = Pserihu + "の";
                textSerihu.setText(Pserihu);
            }
        },7800);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Pserihu = Pserihu + "ま";
                textSerihu.setText(Pserihu);
            }
        },7900);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Pserihu = Pserihu + "ま";
                textSerihu.setText(Pserihu);
            }
        },8000);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Pserihu = Pserihu + "で";
                textSerihu.setText(Pserihu);
            }
        },8100);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Pserihu = Pserihu + "は";
                textSerihu.setText(Pserihu);
            }
        },8200);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Pserihu = Pserihu + "楽";
                textSerihu.setText(Pserihu);
            }
        },8300);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Pserihu = Pserihu + "し";
                textSerihu.setText(Pserihu);
            }
        },8400);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Pserihu = Pserihu + "い";
                textSerihu.setText(Pserihu);
            }
        },8500);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Pserihu = Pserihu + "時";
                textSerihu.setText(Pserihu);
            }
        },8600);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Pserihu = Pserihu + "に";
                textSerihu.setText(Pserihu);
            }
        },8700);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Pserihu = Pserihu + "笑";
                textSerihu.setText(Pserihu);
            }
        },8800);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Pserihu = Pserihu + "え";
                textSerihu.setText(Pserihu);
            }
        },8900);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Pserihu = Pserihu + "な";
                textSerihu.setText(Pserihu);
            }
        },9000);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Pserihu = Pserihu + "く";
                textSerihu.setText(Pserihu);
            }
        },9100);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Pserihu = Pserihu + "な";
                textSerihu.setText(Pserihu);
            }
        },9200);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Pserihu = Pserihu + "っ";
                textSerihu.setText(Pserihu);
            }
        },9300);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Pserihu = Pserihu + "て";
                textSerihu.setText(Pserihu);
            }
        },9400);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Pserihu = Pserihu + "し";
                textSerihu.setText(Pserihu);
            }
        },9500);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Pserihu = Pserihu + "ま";
                textSerihu.setText(Pserihu);
            }
        },9600);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Pserihu = Pserihu + "う。\n\n";
                textSerihu.setText(Pserihu);
            }
        },9700);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Pserihu = Pserihu + "で";
                textSerihu.setText(Pserihu);
            }
        },9800);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Pserihu = Pserihu + "も";
                textSerihu.setText(Pserihu);
            }
        },9900);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Pserihu = Pserihu + "、";
                textSerihu.setText(Pserihu);
            }
        },10100);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Pserihu = Pserihu + "今";
                textSerihu.setText(Pserihu);
            }
        },10200);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Pserihu = Pserihu + "な";
                textSerihu.setText(Pserihu);
            }
        },10300);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Pserihu = Pserihu + "ら";
                textSerihu.setText(Pserihu);
            }
        },10400);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Pserihu = Pserihu + "ま";
                textSerihu.setText(Pserihu);
            }
        },10500);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Pserihu = Pserihu + "だ";
                textSerihu.setText(Pserihu);
            }
        },10600);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Pserihu = Pserihu + "取";
                textSerihu.setText(Pserihu);
            }
        },10700);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Pserihu = Pserihu + "り";
                textSerihu.setText(Pserihu);
            }
        },10800);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Pserihu = Pserihu + "返";
                textSerihu.setText(Pserihu);
            }
        },10900);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Pserihu = Pserihu + "す";
                textSerihu.setText(Pserihu);
            }
        },11000);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Pserihu = Pserihu + "方";
                textSerihu.setText(Pserihu);
            }
        },11100);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Pserihu = Pserihu + "法";
                textSerihu.setText(Pserihu);
            }
        },11200);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Pserihu = Pserihu + "が";
                textSerihu.setText(Pserihu);
            }
        },11300);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Pserihu = Pserihu + "あ";
                textSerihu.setText(Pserihu);
            }
        },11400);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Pserihu = Pserihu + "る";
                textSerihu.setText(Pserihu);
            }
        },11500);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Pserihu = Pserihu + "！\n\n\n";
                textSerihu.setText(Pserihu);
            }
        },11600);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Button btnChuto = new Button(getContext());
                btnChuto.setText("取り返す方法を知る▼");
                btnChuto.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        FragmentTransaction ft = getFragmentManager().beginTransaction();
                        ft.replace(R.id.layout_main, new TutorialFragment1());
                        ft.commit();
                    }
                });

                LinearLayout layout = (LinearLayout)getView().findViewById(R.id.LinearLayout);
                layout.addView(btnChuto);
            }
        },12100);


    }


}



