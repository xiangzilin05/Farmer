package com.lxh.farmer.activity;


import com.lxh.farmer.R;
import com.lxh.farmer.view.SlidingMenu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends Activity {
	
	private String access_token;
	private SlidingMenu menu;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		Intent in = getIntent();
		Bundle bundle = in.getExtras();
		access_token = bundle.getString("access_token");
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu);
		
		menu = (SlidingMenu) findViewById(R.id.menu);
		
		
	}
	
	/**
	 * 通过点击按钮，实现被隐藏的用户界面在关闭和打开间的切换
	 * @param view
	 */
	public void toggleAccount(View view) {
		//SlidingMenu自带的方法实现了切换功能
		menu.toggle();
	}

}
