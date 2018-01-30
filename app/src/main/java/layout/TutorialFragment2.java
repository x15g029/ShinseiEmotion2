package layout;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import jp.ac.fjb.x15g020.emotionjudgmentapp_ver2.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TutorialFragment2 extends Fragment implements View.OnClickListener{


    private Button btn1;
    private Button btn2;

    public TutorialFragment2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tutorial2, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        //IDからオブジェクトを取得
        btn1 = (Button) view.findViewById(R.id.b1);
        btn2 = (Button) view.findViewById(R.id.b2);

        //ボタンをリスナーに登録
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.b1) {
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.layout_main, new TutorialFragment1());
            ft.commit();
        }
        else if(view.getId() == R.id.b2){
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.layout_main, new TutorialFragment3());
            ft.commit();
        }
    }
}
