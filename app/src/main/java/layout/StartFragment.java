package layout;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.AppLaunchChecker;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.util.Log;

import jp.ac.fjb.x15g020.emotionjudgmentapp_ver2.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class StartFragment extends Fragment implements View.OnClickListener {


    private ImageButton btn1;

    public StartFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_start, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        //IDからオブジェクトを取得
        btn1 = (ImageButton) view.findViewById(R.id.btnStart);

        //ボタンをリスナーに登録
        btn1.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        FragmentTransaction ft = getFragmentManager().beginTransaction();

        if(AppLaunchChecker.hasStartedFromLauncher(getContext())){
            //二度目の起動
            ft.replace(R.id.layout_main, new MapFragment());
            ft.commit();
        }else{
            //初回起動
            ft.replace(R.id.layout_main, new OpeningFragment());
            ft.commit();
        }

        AppLaunchChecker.onActivityCreate(getActivity());
    }
}
