package layout;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;


import jp.ac.fjb.x15g020.emotionjudgmentapp_ver2.R;
import jp.ac.fjb.x15g020.emotionjudgmentapp_ver2.view.CameraFragment;

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

    public MapFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_map, container, false);
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
        if(view.getId() == R.id.btnSui) {
            //水星  押下時
            bundle.putInt("惑星",1);
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            Fragment f = new EncounterSuiFragment();
            f.setArguments(bundle);
            ft.replace(R.id.layout_main,f);
            ft.commit();
        }else if(view.getId() == R.id.btnKin){
            //金星　 押下時
            bundle.putInt("惑星",2);
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            Fragment f = new EncounterSuiFragment();
            f.setArguments(bundle);
            ft.replace(R.id.layout_main,f);
            ft.commit();
        }else if(view.getId() == R.id.btnTi){
            //地球　 押下時
            bundle.putInt("惑星",3);
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            Fragment f = new EncounterSuiFragment();
            f.setArguments(bundle);
            ft.replace(R.id.layout_main,f);
            ft.commit();
        }else if(view.getId() == R.id.btnKa){
            //火星　 押下時
            bundle.putInt("惑星",4);
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            Fragment f = new EncounterSuiFragment();
            f.setArguments(bundle);
            ft.replace(R.id.layout_main,f);
            ft.commit();
        }else if(view.getId() == R.id.btnMoku){
            //木星　 押下時
            bundle.putInt("惑星",5);
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            Fragment f = new EncounterSuiFragment();
            f.setArguments(bundle);
            ft.replace(R.id.layout_main,f);
            ft.commit();
        }else if(view.getId() == R.id.btnDo){
            //土星　 押下時
            bundle.putInt("惑星",6);
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            Fragment f = new EncounterSuiFragment();
            f.setArguments(bundle);
            ft.replace(R.id.layout_main,f);
            ft.commit();
        }else if(view.getId() == R.id.btnTen){
            //天王星　 押下時
            bundle.putInt("惑星",7);
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            Fragment f = new EncounterSuiFragment();
            f.setArguments(bundle);
            ft.replace(R.id.layout_main,f);
            ft.commit();
        }else if(view.getId() == R.id.btnKai){
            //海王星　 押下時
            bundle.putInt("惑星",8);
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            Fragment f = new EncounterSuiFragment();
            f.setArguments(bundle);
            ft.replace(R.id.layout_main,f);
            ft.commit();
        }
    }

}
