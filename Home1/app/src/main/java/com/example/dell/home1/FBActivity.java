package com.example.dell.home1;

import org.brickred.socialauth.android.DialogListener;
import org.brickred.socialauth.android.SocialAuthAdapter;
import org.brickred.socialauth.android.SocialAuthAdapter.Provider;
import org.brickred.socialauth.android.SocialAuthError;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FBActivity extends Activity {
	SocialAuthAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fb_activity);
		adapter = new SocialAuthAdapter(new ResponseListener());
		adapter.addProvider(Provider.FACEBOOK, R.drawable.ic_launcher);
		Button shareButton = (Button) findViewById(R.id.button1);
		adapter.enable(shareButton);
	}

	final class ResponseListener implements DialogListener {

		@Override
		public void onBack() {
			// TODO Auto-generated method stub

		}

		@Override
		public void onCancel() {
			// TODO Auto-generated method stub

		}

		@Override
		public void onComplete(Bundle arg0) {
			// TODO Auto-generated method stub
			EditText tx = (EditText) findViewById(R.id.txtStatus);
			adapter.updateStatus(tx.getText().toString());
			String providerName = arg0.getString(SocialAuthAdapter.PROVIDER);
			Toast.makeText(FBActivity.this, "Status Update On" + providerName,
					Toast.LENGTH_LONG).show();
		}

		@Override
		public void onError(final SocialAuthError arg0) {
			// TODO Auto-generated method stub
			new Handler().post(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					Toast.makeText(FBActivity.this,
							"Error" + arg0.getMessage(), Toast.LENGTH_LONG)
							.show();
				}
			});
		}
	}
}
