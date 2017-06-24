package com.example.dell.home1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.Toast;

public class MyActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.my_activity);
	}

	public void clicked1(View v) {
		EditText txt = (EditText) findViewById(R.id.txtURL);
		String str = txt.getText().toString();
		WebView wv = (WebView) findViewById(R.id.wbMain);
		Toast.makeText(this, "Loading Now", Toast.LENGTH_SHORT).show();
		wv.getSettings().setJavaScriptEnabled(true);
		wv.loadUrl(str);
		// wv.loadData("<h1>yuuy</h1>", "text/html", null);
	}

}
