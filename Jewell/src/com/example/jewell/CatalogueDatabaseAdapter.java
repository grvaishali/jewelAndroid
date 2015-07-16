package com.example.jewell;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CatalogueDatabaseAdapter {

	CatalogueHelper helper;

	public CatalogueDatabaseAdapter(Context context) {
		helper = new CatalogueHelper(context);
	}

	public String checkData(String name, String password) {
		SQLiteDatabase db = helper.getWritableDatabase();
		// Select _id,Name,Password from catalogueTable where name="?" and
		// password=?
		String[] columns = { CatalogueHelper.J_id };
		String selectionArgs[] = { name, password };
		Cursor cursor = db.query(CatalogueHelper.TABLE_NAME, columns,
				CatalogueHelper.Name + " =? AND " + CatalogueHelper.Password
						+ " =?", selectionArgs, null, null, null);
		StringBuffer buffer = new StringBuffer();
		while (cursor.moveToNext()) {
			int index1 = cursor.getColumnIndex(CatalogueHelper.J_id);
			int id = cursor.getInt(index1);
			buffer.append(id + "\n");
		}
		return buffer.toString();

	}

	static class CatalogueHelper extends SQLiteOpenHelper {
		private static final String DATABASE_NAME = "jewellDatabase";
		private static final String TABLE_NAME = "jewellTable";
		private static final int DATABASE_VERSION = 1;
		private static final String J_id = "J_ID";
		private static final String Name = "Name"; // Name is column1
		private static final String Password = "Password"; // Password is
															// column2
		private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME
				+ "(" + J_id + " INTEGER PRIMARY KEY AUTOINCREMENT," + Name
				+ " VARCHAR(255)," + Password + " VARCHAR(255));";
		String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
		private Context context;

		public CatalogueHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
			this.context = context;
			Message.message(context, "Contructor called");
			System.out.println(context.getDatabasePath(DATABASE_NAME));

		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			// CREATE TABLE
			try {
				db.execSQL(CREATE_TABLE);
				Message.message(context, "DATABASE CREATED");

			} catch (SQLException e) {
				e.printStackTrace();

			}

		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			db.execSQL(DROP_TABLE);
			onCreate(db);
			Message.message(context, "DATABASE Upgraded");
		}

	}
}
