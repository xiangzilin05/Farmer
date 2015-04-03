package com.lxh.farmer.activity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.example.login.R;
import com.example.login.R.layout;

import android.R.string;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class DownLoadApkActivity extends Activity {
	private Button down;
	private Button install;

	private final int START = 0X001;
	private final int RUNNING = 0X002;
	private final int OVER = 0X003;
	private ProgressBar pb;
//	private String path = "http://farms.thinkv.cn/farms.apk";
	private String path = "http://pica.nipic.com/2008-03-11/200831115141343_2.jpg";
	private Handler myHandler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			switch (msg.what) {
			case RUNNING:
				pb.setProgress(msg.arg1);
				break;
			case OVER:
				pb.setVisibility(View.GONE);
				installApk();
				break;
			default:
				break;
			}

		}

	};

	protected void onCreate(android.os.Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.update);
		pb = (ProgressBar) this.findViewById(R.id.progess);
		down = (Button) this.findViewById(R.id.Update);
		down.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				downLoadApkThread dlt = new downLoadApkThread();
				pb.setVisibility(View.VISIBLE);
				dlt.start();
			}
		});

	}

	private class downLoadApkThread extends Thread {

		@Override
		public void run() {
			// TODO Auto-generated method stub

			download(path);
		}

	}

	public void download(String path) {
		URL url;

		try {
			url = new URL(path);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.connect();
			InputStream in = conn.getInputStream();
			FileOutputStream out = openFileOutput("update.apk",
					MODE_WORLD_READABLE);// 下载完可读权�?
			byte[] buff = new byte[1024];// �?域网中传输数据一包大�?1500除去包头
			int filesize = conn.getContentLength();
			int curReadSize = 0;
			int sizeCount = 0;
			int process = 0;

			while (true) {
				curReadSize = in.read(buff);
				if (curReadSize <= 0) {
					myHandler.sendEmptyMessage(OVER);
					break;
				}
				sizeCount += curReadSize;
				process = sizeCount * 100 / filesize;
				out.write(buff);
				Message msg = new Message();
				msg.what = RUNNING;
				msg.arg1 = process;
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				myHandler.sendMessage(msg);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void installApk() {
		String savePath = this.getFilesDir().getPath() + "/";
		File file = new File(savePath, "update.apk");
		if (!file.exists()) {
			return;

		}
		Intent it = new Intent(Intent.ACTION_VIEW);
		//it.setDataAndType(Uri.fromFile(file), "application/vnd.android");// 从file中取出路�?
		it.setDataAndType(Uri.fromFile(file),  "image/jpeg");// 从file中取出路�?
																			// mime格式apk

	}
private class asycnDownload extends AsyncTask<String,Integer,String>{

	@Override
	protected String doInBackground(String... arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
}
