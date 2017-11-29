package layout;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import jp.ac.fjb.x15g020.emotionjudgmentapp_ver2.R;
import jp.ac.fjb.x15g020.emotionjudgmentapp_ver2.view.CameraFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class EncounterKinFragment extends Fragment implements View.OnClickListener {

    private ImageButton btn1;
    private ImageButton btn2;

    public EncounterKinFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_encounter_kin, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        //IDからオブジェクトを取得
        btn1 = (ImageButton) view.findViewById(R.id.btnCamera);
        btn2 = (ImageButton) view.findViewById(R.id.btnBack);

        //ボタンをリスナーに登録
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btnCamera) {
            //カメラ 押下時
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.layout_main, new CameraFragment());
            ft.commit();
        }else{
            //戻る  押下時
            FragmentTransaction ft2 = getFragmentManager().beginTransaction();
            ft2.replace(R.id.layout_main,new MapFragment());
            ft2.commit();
        }
    }
}
