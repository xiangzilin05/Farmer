package com.lxh.farmer.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class FarmerOpenHelper extends SQLiteOpenHelper {
	
	/**
	 * AllProducts表建表语句
	 */
	public static final String CREATE_AllPRODUCTS ="CREATE TABLE allProducts ("
												+ "id                      INTEGER PRIMARY KEY NOT NULL,"
											    + "productName             TEXT,"
											    + "productCode             TEXT,"
											    + "titleInfo               TEXT,"
											    + "status                  INTEGER,"
											    + "isAvailable             INTEGER,"
											    + "mianImg              BLOB,"
											    + "thumbImgUrl             TEXT,"
											    + "imgArray                TEXT,"
											    + "categoryId              INTEGER,"
											    + "intro                   TEXT,"
											    + "taglist                 TEXT,"
											    + "unit                    TEXT,"
											    + "salesPrice              DOUBLE,"
											    + "pageView                INTEGER,"
											    + "productTypeId           INTEGER,"
											    + "isComposite             INTEGER,"
											    + "compositeScopeId        TEXT,"
											    + "ProductSpeciesIdInclude TEXT,"
											    + "modifiedOn              TEXT)";

	public FarmerOpenHelper(Context context, String name,
			CursorFactory factory, int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(CREATE_AllPRODUCTS);	//创建AllProducts表
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}

}
