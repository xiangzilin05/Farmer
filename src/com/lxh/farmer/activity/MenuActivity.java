package com.lxh.farmer.activity;


import com.lxh.farmer.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class MenuActivity extends Activity {
	
	private String access_token;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		Intent in = getIntent();
		Bundle bundle = in.getExtras();
		access_token = bundle.getString("access_token");
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu);
		
	}

}
