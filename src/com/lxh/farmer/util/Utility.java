package com.lxh.farmer.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Application;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.Volley;
import com.lxh.farmer.activity.MenuActivity;
import com.lxh.farmer.db.FarmerDB;
import com.lxh.farmer.model.Product;

public class Utility {
	
	static Bitmap bitmap;

	/**
	 * 解析和处理服务器返回的所有产品信息
	 */
	public static boolean handleAllProductsResonse(FarmerDB farmerDB,
			JSONArray response) {
		if (response.length() > 0) {
			for (int i = 0; i < response.length(); i++) {
				Product product = new Product();
				JSONObject tmpobj;
				try {
					tmpobj = response.getJSONObject(i);
					product.setId(tmpobj.getInt("Id"));
					product.setProductName(tmpobj.getString("ProductName"));
					product.setProductCode(tmpobj.getString("ProductCode"));
					product.setTitleInfo(tmpobj.getString("TitleInfo"));
					product.setStatus(tmpobj.getInt("Status"));
					product.setAvailable(booleanToInt(tmpobj
							.getBoolean("IsAvailable")));
					product.setMianImg(imageRequest(tmpobj.getString("MainImg")));
					product.setThumbImg(tmpobj.getString("ThumbImg"));
					product.setImgArray(tmpobj.getString("ImgArray"));
					product.setCategoryId(tmpobj.getInt("CategoryId"));
					product.setIntro(tmpobj.getString("Intro"));
					product.setTaglist(tmpobj.getString("TagList"));
					product.setUnit(tmpobj.getString("Unit"));
					product.setSalesPrice(tmpobj.getDouble("SalesPrice"));
					product.setPageView(tmpobj.getInt("Pageview"));
					product.setProductTypeId(tmpobj.getInt("ProductTypeId"));
					product.setComposite(booleanToInt(tmpobj
							.getBoolean("IsComposite")));
					product.setCompositeScopeId(tmpobj
							.getString("CompositeScopeId"));
					product.setProductSpeciesIdInclude(tmpobj
							.getString("ProductSpeciesIdInclude"));
					product.setModifiedOn(tmpobj.getString("ModifiedOn")
							.replaceAll("T", " "));
					Log.e("FromServer", "product: " + product);
					farmerDB.saveProduct(product);

				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return true;
		}
		return false;
	}

	public static int booleanToInt(boolean b) {
		if (b) {
			return 1;
		}
		return 0;
	}
	
	/**
	 * 获取网络图片
	 * @param url
	 * @return
	 */
	public static Bitmap imageRequest(String url) {
		try {
			url = "http://farms.thinkv.cn" + url;
			url = URLEncoder.encode(url, "UTF-8");
			url = url.replaceAll("%2F", "/");
			url = url.replaceAll("%3A", ":");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Log.e("URL", url);
		RequestQueue mQueue = Volley.newRequestQueue(MyApplication.getContext());
		ImageRequest imageRequest = new ImageRequest(url,
				new Response.Listener<Bitmap>() {
					@Override
					public void onResponse(Bitmap response) {
						bitmap = response;
						Log.e("Utility.imageRequest", "从服务器取得图片");
					}
				}, 0, 0, Config.RGB_565, new Response.ErrorListener() {
					@Override
					public void onErrorResponse(VolleyError error) {
						bitmap = null;
						Log.e("Utility.imageRequest", "从服务器未取得图片");
					}
				});
		mQueue.add(imageRequest);
		return bitmap;
	}
}
