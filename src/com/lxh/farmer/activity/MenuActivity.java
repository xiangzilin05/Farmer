package com.lxh.farmer.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.lxh.farmer.R;
import com.lxh.farmer.activity.myorder.MyOrderActivity;
import com.lxh.farmer.view.SlidingMenu;

public class MenuActivity extends Activity implements OnClickListener {

	private String access_token;
	private SlidingMenu menu;

	private TextView tv_myBuyer;
	private TextView tv_myOrder;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		Intent in = getIntent();
		Bundle bundle = in.getExtras();
		access_token = bundle.getString("access_token");

		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu);

		menu = (SlidingMenu) findViewById(R.id.menu);

		tv_myBuyer = (TextView) findViewById(R.id.tv_mybuyer);
		tv_myBuyer.setOnClickListener(this);
		
		tv_myOrder = (TextView) findViewById(R.id.tv_myorder);
		tv_myOrder.setOnClickListener(this);
	}

	// public void myBuyer(View view) {
	// Intent intent = new Intent(this, MyBuyerActivity.class);
	// startActivity(intent);
	// }

	/**
	 * 通过点击按钮，实现被隐藏的用户界面在关闭和打开间的切换
	 * 
	 * @param view
	 */
	public void toggleAccount(View view) {
		// SlidingMenu自带的方法实现了切换功能
		menu.toggle();
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		int id = v.getId();
		switch (id) {
		case R.id.tv_myorder:
			Intent intent = new Intent(this, MyOrderActivity.class);
			startActivity(intent);
			break;

		}
	}

}















