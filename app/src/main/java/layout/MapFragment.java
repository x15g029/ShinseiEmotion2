package layout;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


import jp.ac.fjb.x15g020.emotionjudgmentapp_ver2.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MapFragment extends Fragment implements View.OnClickListener {

    private ImageButton btn1;
    private ImageButton btn2;
    private ImageButton btn3;
    private ImageButton btn4;
    private ImageButton btn5;
    private ImageButton btn6;
    private ImageButton btn7;
    private ImageButton btn8;
    public FragmentTransaction ft_c;
    public EncounterSuiFragment f_c;
    public MediaPlayer mediaPlayer;

    public MapFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_map, container, false);

        //BGM再生だ
        mediaPlayer = MediaPlayer.create(getContext(), R.raw.bgm_map);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();

        return view;
    }



    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        //IDからオブジェクトを取得
        btn1 = (ImageButton) view.findViewById(R.id.btnSui);
        btn2 = (ImageButton) view.findViewById(R.id.btnKin);
        btn3 = (ImageButton) view.findViewById(R.id.btnTi);
        btn4 = (ImageButton) view.findViewById(R.id.btnKa);
        btn5 = (ImageButton) view.findViewById(R.id.btnMoku);
        btn6 = (ImageButton) view.findViewById(R.id.btnDo);
        btn7 = (ImageButton) view.findViewById(R.id.btnTen);
        btn8 = (ImageButton) view.findViewById(R.id.btnKai);

        //ボタンをリスナーに登録
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Bundle bundle = new Bundle();
        ft_c = getFragmentManager().beginTransaction();
         f_c = new EncounterSuiFragment();
        if(view.getId() == R.id.btnSui) {
            //水星  押下時
            bundle.putInt("惑星",1);
            f_c.setArguments(bundle);
            ft_c.replace(R.id.layout_main,f_c);
//            mediaPlayer.stop();
//            mediaPlayer.release();
            ft_c.commit();
        }else if(view.getId() == R.id.btnKin){
            //金星　 押下時
            bundle.putInt("惑星",2);
            f_c.setArguments(bundle);
            ft_c.replace(R.id.layout_main,f_c);
//            mediaPlayer.stop();
//            mediaPlayer.release();
            ft_c.commit();
        }else if(view.getId() == R.id.btnTi){
            //地球　 押下時
            bundle.putInt("惑星",3);
            f_c.setArguments(bundle);
            ft_c.replace(R.id.layout_main,f_c);
//            mediaPlayer.stop();
//            mediaPlayer.release();
            ft_c.commit();
        }else if(view.getId() == R.id.btnKa){
            //火星　 押下時
            bundle.putInt("惑星",4);
            f_c.setArguments(bundle);
            ft_c.replace(R.id.layout_main,f_c);
//            mediaPlayer.stop();
//            mediaPlayer.release();
            ft_c.commit();
        }else if(view.getId() == R.id.btnMoku){
            //木星　 押下時
            bundle.putInt("惑星",5);
            f_c.setArguments(bundle);
            ft_c.replace(R.id.layout_main,f_c);
//            mediaPlayer.stop();
//            mediaPlayer.release();
            ft_c.commit();
        }else if(view.getId() == R.id.btnDo){
            //土星　 押下時
            bundle.putInt("惑星",6);
            f_c.setArguments(bundle);
            ft_c.replace(R.id.layout_main,f_c);
//            mediaPlayer.stop();
//            mediaPlayer.release();
            ft_c.commit();
        }else if(view.getId() == R.id.btnTen){
            //天王星　 押下時
            bundle.putInt("惑星",7);
            f_c.setArguments(bundle);
            ft_c.replace(R.id.layout_main,f_c);
//            mediaPlayer.stop();
//            mediaPlayer.release();
            ft_c.commit();
        }else if(view.getId() == R.id.btnKai){
            //海王星　 押下時
            bundle.putInt("惑星",8);
            f_c.setArguments(bundle);
            ft_c.replace(R.id.layout_main,f_c);
//            mediaPlayer.stop();
//            mediaPlayer.release();
            ft_c.commit();
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
