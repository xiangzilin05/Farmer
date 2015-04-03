package com.lxh.farmer.db;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.lxh.farmer.model.Product;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Bitmap.CompressFormat;
import android.util.Log;

public class FarmerDB {
	
	/**
	 * 数据库名
	 */
	public static final String DB_NAME = "farmer";
	
	/**
	 * 数据库版本
	 */
	public static final int VERSION = 1;
	
	private static FarmerDB farmerDB;
	
	private SQLiteDatabase db;
	
	/**
	 * 构造方法私有化
	 */
	private FarmerDB(Context context) {
		FarmerOpenHelper dbHelper = new FarmerOpenHelper(context, DB_NAME, null, VERSION);
		db = dbHelper.getWritableDatabase();
	}
	
	/**
	 * 获取FarmerDB的实例
	 */
	public synchronized static FarmerDB getInstance(Context context) {
		if (farmerDB == null) {
			farmerDB = new FarmerDB(context);
		}
		return farmerDB;
	}
	
	/**
	 * 将Product实例存储到数据库
	 */
	public void saveProduct(Product product) {
		if (product != null) {
			ContentValues values = new ContentValues();
			values.put("id", product.getId());
			values.put("productName", product.getProductName());
			values.put("productCode", product.getProductCode());
			values.put("titleInfo", product.getTitleInfo());
			values.put("status", product.getStatus());
			values.put("isAvailable", product.isAvailable());
			values.put("mianImg", imageToBlob(product.getMianImg()));
			values.put("thumbImgUrl", product.getThumbImg());
			values.put("imgArray", product.getImgArray());
			values.put("categoryId", product.getCategoryId());
			values.put("intro", product.getIntro());
			values.put("taglist", product.getTaglist());
			values.put("unit", product.getUnit());
			values.put("salesPrice", product.getSalesPrice());
			values.put("pageView", product.getPageView());
			values.put("productTypeId", product.getProductTypeId());
			values.put("isComposite", product.isComposite());
			values.put("compositeScopeId", product.getCompositeScopeId());
			values.put("ProductSpeciesIdInclude", product.getProductSpeciesIdInclude());
			values.put("modifiedOn", product.getModifiedOn());
			db.insert("allProducts", null, values);
		}
	}
	
	/**
	 * 从数据库读取所有商品的信息
	 */
	public List<Product> loadAllProducts() {
		List<Product> list = new ArrayList<Product>();
		Cursor cursor = db.query("allProducts", null, null, null, null, null, null);
		Log.e("FarmerDB", cursor.getCount() + "");
		if (cursor.moveToFirst()) {
			do {
				Product product = new Product();
				product.setId(cursor.getInt(cursor.getColumnIndex("id")));
				product.setProductName(cursor.getString(cursor.getColumnIndex("productName")));
				product.setProductCode(cursor.getString(cursor.getColumnIndex("productCode")));
				product.setTitleInfo(cursor.getString(cursor.getColumnIndex("titleInfo")));
				product.setStatus(cursor.getInt(cursor.getColumnIndex("status")));
				product.setAvailable(cursor.getInt(cursor.getColumnIndex("isAvailable")));
				product.setMianImg(blobToImage(cursor.getBlob(cursor.getColumnIndex("mianImg"))));
				product.setThumbImg(cursor.getString(cursor.getColumnIndex("thumbImgUrl")));
				product.setImgArray(cursor.getString(cursor.getColumnIndex("imgArray")));
				product.setCategoryId(cursor.getInt(cursor.getColumnIndex("categoryId")));
				product.setIntro(cursor.getString(cursor.getColumnIndex("intro")));
				product.setTaglist(cursor.getString(cursor.getColumnIndex("taglist")));
				product.setUnit(cursor.getString(cursor.getColumnIndex("unit")));
				product.setSalesPrice(cursor.getDouble(cursor.getColumnIndex("salesPrice")));
				product.setPageView(cursor.getInt(cursor.getColumnIndex("pageView")));
				product.setProductTypeId(cursor.getInt(cursor.getColumnIndex("productTypeId")));
				product.setComposite(cursor.getInt(cursor.getColumnIndex("isComposite")));
				product.setCompositeScopeId(cursor.getString(cursor.getColumnIndex("compositeScopeId")));
				product.setProductSpeciesIdInclude(cursor.getString(cursor.getColumnIndex("ProductSpeciesIdInclude")));
				product.setModifiedOn(cursor.getString(cursor.getColumnIndex("modifiedOn")));
				list.add(product);
			} while (cursor.moveToNext());
		}
		return list;
	}
	
	public byte[] imageToBlob(Bitmap bitmap) {
		if (bitmap != null) {
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			// 将数据进行压缩成PNG编码数据，存储质量100%
			bitmap.compress(CompressFormat.PNG, 100, outputStream);
			return outputStream.toByteArray();
		}
		return null;
	}
	
	public Bitmap blobToImage(byte[] b) {
		if (b != null && b.length > 0) {
			return BitmapFactory.decodeByteArray(b, 0, b.length);
		}
		return null;
	}

}

























