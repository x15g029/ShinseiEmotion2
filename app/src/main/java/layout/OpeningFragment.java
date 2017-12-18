package layout;


import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import jp.ac.fjb.x15g020.emotionjudgmentapp_ver2.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class OpeningFragment extends Fragment{

    //タイプライター風
    private TextView textView;
    String put_txt =
            "宇宙から地球を見下ろした\n" +
                "人間がたくさんいる。\n" +
                    "嫌だと思っているのに笑っている人ばかりだ。\n"+
                        "７つの表情ボールを持っているのに、\nどうして不愛想なんだろう\n"+
                            "ぼくら表情ボール欲しいし、やつらから奪っちゃおう！";
    int i = 0;
    String put_word = "";
    String put_text = "";

    private static int TIMEOUT_MESSAGE = 1;
    private static int INTERVAL = 100;//速度調節はここで  100がちょうどいいかも

    public OpeningFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_opening, container, false);
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
                Button btnNext = new Button(getContext());
                btnNext.setText("タップして");
                btnNext.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        FragmentTransaction ft = getFragmentManager().beginTransaction();
                        ft.replace(R.id.layout_main, new GaidoStartFragment());
                        ft.commit();
                    }
                });
                LinearLayout linearLayout = (LinearLayout)getView().findViewById(R.id.LinearLayout);
                linearLayout.addView(btnNext);
            }

        }
    };

}

