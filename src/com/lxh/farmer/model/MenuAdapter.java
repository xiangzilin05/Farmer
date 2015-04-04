package com.lxh.farmer.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.lxh.farmer.R;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MenuAdapter extends BaseAdapter {
	private LayoutInflater inflate;
	private List<Product> productList;

	public MenuAdapter(Context context, List<Product> data) {
		inflate = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		productList = data;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return productList.size();

	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return productList.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		// TODO Auto-generated method stub
		ViewHolder vh;
		if (arg1 == null) {
			vh = new ViewHolder();
			arg1 = inflate.inflate(R.layout.menulist, null);
			vh.thumbImg = (ImageView) arg1.findViewById(R.id.thumb_img);
			vh.productName = (TextView) arg1.findViewById(R.id.product_name);
			vh.salesPrice = (TextView) arg1.findViewById(R.id.sales_price);
			vh.unit = (TextView) arg1.findViewById(R.id.unit);
			arg1.setTag(vh);
		} else {
			vh = (ViewHolder) arg1.getTag();
		}
		vh.thumbImg.setImageBitmap(productList.get(arg0).getMianImg());
		vh.productName.setText(productList.get(arg0).getProductName());
		vh.salesPrice.setText(productList.get(arg0).getSalesPrice() + "Ԫ");		
		vh.unit.setText(productList.get(arg0).getUnit().toString());
		return arg1;
	}

	private class ViewHolder {
		private ImageView thumbImg;
		private TextView productName;
		private TextView salesPrice;
		private TextView unit;
	}

}
