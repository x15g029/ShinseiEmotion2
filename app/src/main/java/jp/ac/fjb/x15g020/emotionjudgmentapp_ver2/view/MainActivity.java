package jp.ac.fjb.x15g020.emotionjudgmentapp_ver2.view;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import jp.ac.fjb.x15g020.emotionjudgmentapp_ver2.R;
import jp.ac.fjb.x15g020.emotionjudgmentapp_ver2.model.Permission;

public class MainActivity extends AppCompatActivity {
	Permission mPermission;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//Android6.0以降用パーミッション設定
		mPermission = new Permission();
		mPermission.setOnResultListener(new Permission.ResultListener() {
			@Override
			public void onResult() {

				//パーミッション設定完了後の初期化処理を入れる
				//フラグメントの切り替え
				FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
				//ほむほーむへ
				ft.replace(R.id.layout_main,new CameraFragment());
				ft.commit();
			}
		});
		mPermission.requestPermissions(this);
	}
}
