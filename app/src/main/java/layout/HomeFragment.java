package layout;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.AppLaunchChecker;
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
public class HomeFragment extends Fragment implements View.OnClickListener {


    private ImageButton btnTool;
    private ImageButton btnBowl;
    private ImageButton btnMap;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_home, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        //IDからオブジェクトを取得
        btnTool = (ImageButton) view.findViewById(R.id.image1);
        btnBowl = (ImageButton) view.findViewById(R.id.image2);
        btnMap = (ImageButton) view.findViewById(R.id.image3);

        //ボタンをリスナーに登録
        btnTool.setOnClickListener(this);
        btnBowl.setOnClickListener(this);
        btnMap.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        FragmentTransaction ft = getFragmentManager().beginTransaction();

        if(view.getId() == R.id.image1){
            //ツール
            ft.replace(R.id.layout_main, new MapFragment());
            ft.commit();
        }else if(view.getId() == R.id.image2){
            //水晶
            ft.replace(R.id.layout_main, new EmotionBowlFragment());
            ft.commit();
        }else if(view.getId() == R.id.image3){
            //マップ
            ft.replace(R.id.layout_main, new MapFragment());
            ft.commit();
        }
    }
}
