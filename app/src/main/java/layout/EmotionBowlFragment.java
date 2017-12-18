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

        SharedPreferences pref =
                getContext().getSharedPreferences( "pref", getContext().MODE_PRIVATE );

        // "bowl1" というキーで保存されている値を読み出す
        ImageView imageBowl = (ImageView)getView().findViewById(R.id.imageBowl);
        String hoge = pref.getString("bowl","");
        String huga = "クリア";


        if(hoge.equals(huga)){
            imageBowl.setImageResource(R.drawable.bowl1);
        }


        Button b1 = (Button)getView().findViewById(R.id.button);
        b1.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        //マップ  押下時
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.layout_main, new MapFragment());
        ft.commit();
    }
}
