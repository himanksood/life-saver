package com.example.dell.home1;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class videoActivity extends Activity {

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onRestoreInstanceState(savedInstanceState);
		if (savedInstanceState != null) {
			selectedVideoLocation = Uri.parse(savedInstanceState
					.getString("videoURI"));
			currentPos = savedInstanceState.getInt("currentPos");
			playvideo();

		}
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
		if (null != selectedVideoLocation) {
			VideoView vv = (VideoView) findViewById(R.id.vidplayer);
			outState.putString("videoURI", selectedVideoLocation.toString());
			outState.putInt("currentPos", vv.getCurrentPosition());
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode == requestCode) {
			if (resultCode == Activity.RESULT_OK) {
				selectedVideoLocation = data.getData();
				playvideo();
			}
		}
	}

	private final int requestCode = 1;

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		// TODO Auto-generated method stub

		switch (item.getItemId()) {

		case R.id.menuPickMedia:

			Toast.makeText(this, "menu clicked", Toast.LENGTH_SHORT).show();
			Intent pickMedia = new Intent(Intent.ACTION_GET_CONTENT);
			pickMedia.setType("video/*");

			startActivityForResult(pickMedia, requestCode);

		default:
			break;
		}
		return super.onMenuItemSelected(featureId, item);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		getMenuInflater().inflate(R.menu.menu_videoview, menu);
		return true;
	}

	Uri selectedVideoLocation;
	int currentPos = 0;

	private void playvideo() {
		VideoView vv = (VideoView) findViewById(R.id.vidplayer);
		MediaController mc = new MediaController(this) {

			@Override
			public void hide() {
				// TODO Auto-generated method stub
				show();
			}
		};

		vv.setMediaController(mc);
		vv.setVideoURI(selectedVideoLocation);
		vv.seekTo(currentPos);
		vv.start();
		mc.show();
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.video_activity);
		 VideoView vv = (VideoView) findViewById(R.id.vidplayer);

		String path = getIntent().getStringExtra("path");
		 MediaController mc = new MediaController(this) {

		 @Override
		 public void hide() {
		 show();
		 }
		 };

		 vv.setMediaController(mc);
		 vv.setVideoPath(Environment.getExternalStorageDirectory().getPath()
		 + path);
		 vv.start();
		 mc.show();

	}

}
