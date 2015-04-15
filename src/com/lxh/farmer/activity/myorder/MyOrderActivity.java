package com.lxh.farmer.activity.myorder;

import java.util.List;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Window;

import com.lxh.farmer.R;
import com.viewpagerindicator.TabPageIndicator;

public class MyOrderActivity extends FragmentActivity
{
	private ViewPager mViewPager;
	private TabPageIndicator mTabPageIndicator;
	private MyOrderTabAdapter mAdapter ;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_myorder);
		
		initView();
	}

	private void initView()
	{
		mViewPager = (ViewPager) findViewById(R.id.id_viewpager);
		mTabPageIndicator = (TabPageIndicator) findViewById(R.id.id_indicator);
		mAdapter = new MyOrderTabAdapter(getSupportFragmentManager());
		mViewPager.setAdapter(mAdapter);
		
		mTabPageIndicator.setViewPager(mViewPager, 0);
	}
	
	

}
