package com.example.aloo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class GroupChat {
	public static final String KEY_GROUP = "group_name";
	public static final String KEY_USER = "user_name";
	public static final String KEY_MESSAGE = "message";

	private static final String DATABASE_NAME = "GroupChat";
	private static final String DATABASE_TABLE = "messageTable";
	private static final int DATABASE_VERSION = 1;
	
	private DbHelper ourHelper;
	private final Context ourContext;
	private SQLiteDatabase ourDatabase;
	

	private static class DbHelper extends SQLiteOpenHelper {

		public DbHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			db.execSQL("CREATE TABLE " + DATABASE_TABLE + " (" + KEY_GROUP
					+ " TEXT NOT NULL, " + KEY_USER
					+ " TEXT NOT NULL, " + KEY_MESSAGE + " TEXT NOT NULL);");
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub
			db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
			onCreate(db);
		}
	}
	
	public GroupChat(Context c)
	{
		ourContext = c;
	}

	public GroupChat open() throws SQLException {
		ourHelper = new DbHelper(ourContext);
		ourDatabase = ourHelper.getWritableDatabase();
		return this;
	}

	public void close() {
		ourHelper.close();
		ourDatabase.close();
	}

	public long createEntry(String gName, String uName, String message) {
		// TODO Auto-generated method stub
		ContentValues cv = new ContentValues();
		cv.put(KEY_GROUP, gName);
		cv.put(KEY_USER, uName);
		cv.put(KEY_MESSAGE, message);
		return ourDatabase.insert(DATABASE_TABLE, null, cv);
	}
	
	public String getData() {
		// TODO Auto-generated method stub
		String[] columns = new String[] { KEY_GROUP, KEY_USER, KEY_MESSAGE };
		Cursor c = ourDatabase.query(DATABASE_TABLE, columns, null, null, null,
				null, null);
		String result = "";

		int iGroup = c.getColumnIndex(KEY_GROUP);
		int iUser = c.getColumnIndex(KEY_USER);
		int iMessage = c.getColumnIndex(KEY_MESSAGE);

		for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
			result = result + c.getString(iGroup) + " " + c.getString(iUser)
					+ " " + c.getString(iMessage) + "\n";
		}

		return result;
	}
	
	//check entered data
	public String getLastData() {
		// TODO Auto-generated method stub
		String[] columns = new String[] { KEY_GROUP, KEY_USER, KEY_MESSAGE };
		Cursor c = ourDatabase.query(DATABASE_TABLE, columns, null, null, null,
				null, null);
		String result = "";

		int iGroup = c.getColumnIndex(KEY_GROUP);
		int iUser = c.getColumnIndex(KEY_USER);
		int iMessage = c.getColumnIndex(KEY_MESSAGE);
		if(c.moveToLast())
			result =c.getString(iGroup) + " " + c.getString(iUser)+ " " + c.getString(iMessage) + "\n";
		else
			result="Error";
		return result;
	}
}
