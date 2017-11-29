package layout;


import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.File;

import jp.ac.fjb.x15g020.emotionjudgmentapp_ver2.R;
import jp.ac.fjb.x15g020.emotionjudgmentapp_ver2.model.EmotionEngine;
import jp.ac.fjb.x15g020.emotionjudgmentapp_ver2.view.CameraFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class PictureCheckFragment extends Fragment {


    public PictureCheckFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_picture_check, container, false);


        String path = Environment.getExternalStorageDirectory()+"/emotionjudgment.jpg";
        File file = new File(path);

        //テキスト表示で確認
        TextView textView = (TextView)view.findViewById(R.id.textView);
        textView.setText("確認用" + path);

        //画像表示で確認
        ImageView picView = (ImageView)view.findViewById(R.id.PictureView);
        picView.setImageURI(Uri.fromFile(file));



        return view;
    }





}
