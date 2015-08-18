package com.example.aloo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class joineddetails {
	
	public static final String KEY_ROWID = "_id";
	public static final String KEY_JOINED = "persons_joined";
	public static final String KEY_USER = "persons_user";
	
	private static final String DATABASE_NAME = "JoinedDB";
	private static final String DATABASE_TABLE = "join_table";
	private static final int DATABASE_VERSION = 1;
	
	private DBHelper ourHelper;
	private final Context ourContext;
	private SQLiteDatabase ourDatabase;
	
	public static class DBHelper extends SQLiteOpenHelper{

		public DBHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			db.execSQL( "CREATE TABLE " + DATABASE_TABLE + " (" +
					KEY_ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
					KEY_USER + " TEXT NOT NULL, " + KEY_JOINED + " TEXT NOT NULL);");					
					
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
			// TODO Auto-generated method stub
			db.execSQL("DROP TABLE IF EXIST "+DATABASE_TABLE);
			onCreate(db);
		}
				
	}
	public joineddetails(Context c){
		ourContext = c;
	}
	
	public joineddetails Open() throws SQLException{
		ourHelper = new DBHelper(ourContext);
		ourDatabase = ourHelper.getWritableDatabase();
		return this;
	}
	
	public void Close(){
		ourHelper.close();
	}

	public long createEntry(String user,String joined) {
		// TODO Auto-generated method stub
		ContentValues cv = new ContentValues();
		cv.put(KEY_USER, user);
		cv.put(KEY_JOINED, joined);
		return ourDatabase.insert(DATABASE_TABLE, null, cv);
	}

	public String getData() {
		// TODO Auto-generated method stub
		String[] columns = new String[]{KEY_ROWID, KEY_USER, KEY_JOINED};
		Cursor c = ourDatabase.query(false, DATABASE_TABLE, columns, null, null, null, null, null, null);
		String result = "";
		int iRow = c.getColumnIndex(KEY_ROWID);
		int iUser = c.getColumnIndex(KEY_USER);
		int iJoined = c.getColumnIndex(KEY_JOINED);
		
		for(c.moveToFirst(); !c.isAfterLast();c.moveToNext()){
			result = result + c.getString(iRow) + " " + c.getString(iUser) + " ---> " + c.getString(iJoined) + "/100 \n";
		}	
		return result;
	}


	public void updateEntry(long lRow, String sJoined) {
		// TODO Auto-generated method stub
		ContentValues cvUpdate = new ContentValues();
		cvUpdate.put(KEY_JOINED, sJoined);
		ourDatabase.update(DATABASE_TABLE, cvUpdate, KEY_ROWID+"="+lRow , null);
	}

	public void deleteEntry(long l1) {
		// TODO Auto-generated method stub
		ourDatabase.delete(DATABASE_TABLE, KEY_ROWID+"="+l1, null);
	}
	public int CheckDetails(String a,String b)
	{
		String[] columns = new String[]{KEY_ROWID, KEY_USER, KEY_JOINED};
		Cursor c = ourDatabase.query(false, DATABASE_TABLE, columns, null, null, null, b, b, b);
		int flag=2;
		int iRow = c.getColumnIndex(KEY_ROWID);
		int iJoined = c.getColumnIndex(KEY_JOINED);
		int iUser = c.getColumnIndex(KEY_USER);
		
		for(c.moveToFirst(); !c.isAfterLast();c.moveToNext()){
			if(c.getString(iUser).equalsIgnoreCase(a) && c.getString(iJoined).equalsIgnoreCase(b) )
			{
				flag =1;
				break;
			}
			
			}
		return flag;
	}
	public void abc()
	{
		
	}

}
