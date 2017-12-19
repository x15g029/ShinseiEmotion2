package layout;


import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.ImageViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import jp.ac.fjb.x15g020.emotionjudgmentapp_ver2.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class EmotionBowlFragment extends Fragment implements View.OnClickListener {


    private SharedPreferences pref;
    private ImageView viewSui;
    private ImageView viewKin;
    private ImageView viewKa;
    private ImageView viewMoku;
    private ImageView viewDo;
    private ImageView viewTen;
    private ImageView viewKai;


    public EmotionBowlFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_emotion_bowl, container, false);


        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        pref =
                getContext().getSharedPreferences( "pref", getContext().MODE_PRIVATE );

        // インスタンス取得
         viewSui = (ImageView)getView().findViewById(R.id.imageBowlSui);
         viewKin = (ImageView)getView().findViewById(R.id.imageBowlKin);
         viewKa = (ImageView)getView().findViewById(R.id.imageBowlKa);
         viewMoku = (ImageView)getView().findViewById(R.id.imageBowlMoku);
         viewDo = (ImageView)getView().findViewById(R.id.imageBowlDo);
         viewTen = (ImageView)getView().findViewById(R.id.imageBowlTen);
         viewKai = (ImageView)getView().findViewById(R.id.imageBowlKai);

        //データセット
        String keySui = pref.getString("bowlsui","");
        String keyKin = pref.getString("bowlkin","");
        String keyKa = pref.getString("bowlka","");
        String keyMoku = pref.getString("bowlmoku","");
        String keyDo = pref.getString("bowldo","");
        String keyTen = pref.getString("bowlten","");
        String keyKai = pref.getString("bowlkai","");

        String clear = "クリア";


        //クリアしている惑星の水晶を表示
        if(keySui.equals(clear)){
            viewSui.setImageResource(R.drawable.dai_bowl_sui);
        }

        if(keyKin.equals(clear)){
            viewKin.setImageResource(R.drawable.dai_bowl_kin);
        }

        if(keyKa.equals(clear)){
            viewKa.setImageResource(R.drawable.dai_bowl_ka);
        }

        if(keyMoku.equals(clear)){
            viewMoku.setImageResource(R.drawable.dai_bowl_moku);
        }

        if(keyDo.equals(clear)){
            viewDo.setImageResource(R.drawable.dai_bowl_do);
        }

        if(keyTen.equals(clear)){
            viewTen.setImageResource(R.drawable.dai_bowl_ten);
        }

        if(keyKai.equals(clear)){
            viewKai.setImageResource(R.drawable.dai_bowl_kai);
        }


        Button b1 = (Button)getView().findViewById(R.id.btnMap);
        b1.setOnClickListener(this);

        Button b2 = (Button)getView().findViewById(R.id.btnReset);
        b2.setOnClickListener(this);

        Button test = (Button)getView().findViewById(R.id.testbtn);
        test.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btnMap) {
            //マップ  押下時
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.layout_main, new MapFragment());
            ft.commit();
        }else if(view.getId() == R.id.btnReset) {
            //リセット　押下時
            SharedPreferences.Editor editor = pref.edit();
            editor.putString("bowlsui","");
            editor.putString("bowlkin","");
            editor.putString("bowlka","");
            editor.putString("bowlmoku","");
            editor.putString("bowldo","");
            editor.putString("bowlten","");
            editor.putString("bowlkai","");
            editor.commit();
            viewSui.setImageResource(R.drawable.dai_sui);
            viewKin.setImageResource(R.drawable.dai_kin);
            viewKa.setImageResource(R.drawable.dai_ka);
            viewMoku.setImageResource(R.drawable.dai_moku);
            viewDo.setImageResource(R.drawable.dai_do);
            viewTen.setImageResource(R.drawable.dai_ten);
            viewKai.setImageResource(R.drawable.dai_kai);
        }else if(view.getId() == R.id.testbtn) {
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.layout_main, new OpeningFragment());
            ft.commit();
        }
    }
}
