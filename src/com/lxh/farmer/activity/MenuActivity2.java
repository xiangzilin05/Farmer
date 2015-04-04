package com.lxh.farmer.activity;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.transform.ErrorListener;
import javax.xml.transform.TransformerException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.lxh.farmer.R;
import com.lxh.farmer.R.string;
import com.lxh.farmer.db.FarmerDB;
import com.lxh.farmer.model.DataHelper;
import com.lxh.farmer.model.MenuAdapter;
import com.lxh.farmer.model.ShopOwner;
import com.lxh.farmer.model.Product;
import com.lxh.farmer.util.Utility;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

public class MenuActivity2 extends Activity {
	
	private String url = "http://farms.thinkv.cn/Seller/Product/AllProductList";
	private static final String AUTHORIZATION_KEY = "Authorization";
	private List<Product> allProducts = new ArrayList<Product>();
	private ListView mlist;
	private String access_token;
	private MenuAdapter mAdapter;
	private ShopOwner sh = new ShopOwner();
	private FarmerDB farmerDB;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		Intent in = getIntent();
		Bundle bundle = in.getExtras();
		access_token = bundle.getString("access_token");
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu);
		
//		farmerDB = FarmerDB.getInstance(this);
				
//		queryAllProducts();

	}

	private void queryAllProducts() {
		// TODO Auto-generated method stub
		allProducts = farmerDB.loadAllProducts();
		if (allProducts.size() > 0) {
			Log.e("queryAllProducts", "从数据库读取数据");	
			mAdapter = new MenuAdapter(MenuActivity2.this, allProducts);
			initView();
		} else {
			queryFromServer();
		}
	}

	private void queryFromServer() {
		// TODO Auto-generated method stub
		RequestQueue queue = DataHelper.getDate(this);
		JsonArrayRequest req = new JsonArrayRequest(url,
				new Listener<JSONArray>() {

					@Override
					public void onResponse(JSONArray response) {
						Log.e("queryFromServer", "从服务器下载数据");
						Utility.handleAllProductsResonse(farmerDB, response);
						queryAllProducts();
					}
				}, null) {

			@Override//自定义Http的头信息
			public Map<String, String> getHeaders() throws AuthFailureError {
				// TODO Auto-generated method stub

				Map<String, String> headers = super.getHeaders();

				if (headers == null || headers.equals(Collections.emptyMap())) {
					headers = new HashMap<String, String>();
				}

				headers.put("Accept", "application/json");
				headers.put("Content-Type", "application/json; charset=UTF-8");

				addAccessToken(headers);

				return headers;
			}

			private void addAccessToken(Map<String, String> headers) {
				// TODO Auto-generated method stub
				if (access_token != null) {
					headers.put(AUTHORIZATION_KEY, "Bearer " + access_token);
				}

			}

		};
		queue.add(req);
	}

	private void initView() {
		// TODO Auto-generated method stub
		mlist = (ListView) findViewById(R.id.mylist);
		mlist.setAdapter(mAdapter);
	}

}
