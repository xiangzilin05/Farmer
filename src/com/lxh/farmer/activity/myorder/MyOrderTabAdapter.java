package com.lxh.farmer.activity.myorder;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MyOrderTabAdapter extends FragmentPagerAdapter
{

	public static String[] TITLES = new String[]
	{ "待付款", "待发货", "已发货", "已完成"};

	public MyOrderTabAdapter(FragmentManager fm)
	{
		super(fm);
	}

	@Override
	public Fragment getItem(int arg0)
	{
		TabFragment fragment = new TabFragment(arg0);
		return fragment;
	}

	@Override
	public int getCount()
	{
		return TITLES.length;
	}

	@Override
	public CharSequence getPageTitle(int position)
	{
		return TITLES[position];
	}

}
