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
	 * ͨ�������ť��ʵ�ֱ����ص��û������ڹرպʹ򿪼���л�
	 * @param view
	 */
	public void toggleAccount(View view) {
		//SlidingMenu�Դ��ķ���ʵ�����л�����
		menu.toggle();
	}

}
