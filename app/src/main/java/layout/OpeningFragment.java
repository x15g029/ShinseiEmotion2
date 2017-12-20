package layout;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import jp.ac.fjb.x15g020.emotionjudgmentapp_ver2.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class OpeningFragment extends Fragment{

    //タイプライター風
    private TextView textView;
    String put_txt =
            "\n\n\n　　　地球には人間が住んでいる\n\n" +
                "　　　人間は７つの表情ボールを持っていて\n\n　　　見るたび表情が変わって面白いんだ\n\n" +
                    "　　　あれ？あそこにいる人\n\n　　　なんだか表情が少ないな・・・\n\n"+
                        "　　　７つの表情ボールを持っているのに\n\n　　　どうして不愛想なんだろう\n\n"+
                            "　　　表情ボール必要ないなら\n\n　　　貰っても良いよね！取りに行こうっと！";
    int i = 0;
    String put_word = "";
    String put_text = "";

    private static int TIMEOUT_MESSAGE = 1;
    private static int INTERVAL = 100;//速度調節はここで  100がちょうどいいかも
    public MediaPlayer mediaPlayer;

    public OpeningFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_opening, container, false);

        //BGM再生
        mediaPlayer = MediaPlayer.create(getContext(), R.raw.bgm_start);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();


        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //ぼたん取得してthisかくとこ
        textView = (TextView)getView().findViewById(R.id.textView1);
        handler.sendEmptyMessage(TIMEOUT_MESSAGE);

    }

    private Handler handler = new Handler(){
        @Override
        public void dispatchMessage(Message msg) {
            // 文字列を配列に１文字ずつセット
            char data[] = put_txt.toCharArray();

            // 配列数を取得
            int arr_num = data.length;

            if(i < arr_num){
                if (msg.what == TIMEOUT_MESSAGE) {
                    put_word = String.valueOf(data[i]);
                    put_text = put_text + put_word;

                    textView.setText(put_text);
                    handler.sendEmptyMessageDelayed(TIMEOUT_MESSAGE, INTERVAL);
                    i++;
                }else{
                    super.dispatchMessage(msg);
                }
            }else if(i == arr_num){
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    //5秒後に実行する処理
                    public void run() {
                        //次画面へ
                        FragmentTransaction ft = getFragmentManager().beginTransaction();
                        ft.replace(R.id.layout_main, new GaidoStartFragment());
                        mediaPlayer.stop();
                        ft.commit();
                    }
                }, 5000);
            }

        }
    };

}

