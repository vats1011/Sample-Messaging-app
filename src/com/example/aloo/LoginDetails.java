package com.example.aloo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class LoginDetails {

	public static final String KEY_ROWID = "_id";
	public static final String KEY_NAME = "persons_name";
	public static final String KEY_EMAIL = "persons_email";
	public static final String KEY_PHONE = "persons_phone";
	public static final String KEY_USER = "persons_user";

	private static final String DATABASE_NAME = "HotORNotDB";
	private static final String DATABASE_TABLE = "People_table";
	private static final int DATABASE_VERSION = 1;

	private DBHelper ourHelper;
	private final Context ourContext;
	private SQLiteDatabase ourDatabase;

	private static class DBHelper extends SQLiteOpenHelper {

		public DBHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			db.execSQL("CREATE TABLE " + DATABASE_TABLE + " (" + KEY_ROWID
					+ " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_NAME
					+ " TEXT NOT NULL, " + KEY_EMAIL + " TEXT NOT NULL, "
					+ KEY_PHONE + " TEXT NOT NULL, " + KEY_USER
					+ " TEXT NOT NULL);");
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
			// TODO Auto-generated method stub
			db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
			onCreate(db);
		}

	}

	public LoginDetails(Context c) {
		ourContext = c;
	}

	public LoginDetails Open() throws SQLException {
		ourHelper = new DBHelper(ourContext);
		ourDatabase = ourHelper.getWritableDatabase();
		return this;
	}

	public void Close() {
		ourHelper.close();
	}

	public long createEntry(String name, String email, String phone, String user) {
		// TODO Auto-generated method stub
		ContentValues cv = new ContentValues();
		cv.put(KEY_NAME, name);
		cv.put(KEY_EMAIL, email);
		cv.put(KEY_PHONE, phone);
		cv.put(KEY_USER, user);
		return ourDatabase.insert(DATABASE_TABLE, null, cv);
	}

	public String getData() {
		// TODO Auto-generated method stub
		String[] columns = new String[] { KEY_ROWID, KEY_NAME, KEY_EMAIL,
				KEY_PHONE, KEY_USER };
		Cursor c = ourDatabase.query(DATABASE_TABLE, columns, null, null, null,
				null, null);
		String result = "";
		int iRow = c.getColumnIndex(KEY_ROWID);
		int iName = c.getColumnIndex(KEY_NAME);
		int iEmail = c.getColumnIndex(KEY_EMAIL);
		int iPhone = c.getColumnIndex(KEY_PHONE);
		int iUser = c.getColumnIndex(KEY_USER);

		for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
			result = result + c.getString(iRow) + " " + c.getString(iName)
					+ " ---> " + c.getString(iEmail) + c.getString(iPhone)
					+ "/100 \n";
		}
		return result;
	}

	public String getName(long l) {
		// TODO Auto-generated method stub
		String[] columns = new String[] { KEY_ROWID, KEY_NAME, KEY_EMAIL,
				KEY_PHONE };
		Cursor c = ourDatabase.query(DATABASE_TABLE, columns, KEY_ROWID + "="
				+ l, null, null, null, null);

		if (c != null) {
			c.moveToFirst();
			String name = c.getString(1);
			return name;
		}
		return null;
	}

	public String getEmail(long l) {
		// TODO Auto-generated method stub
		String[] columns = new String[] { KEY_ROWID, KEY_NAME, KEY_EMAIL,
				KEY_PHONE };
		Cursor c = ourDatabase.query(DATABASE_TABLE, columns, KEY_ROWID + "="
				+ l, null, null, null, null);
		if (c != null) {
			c.moveToFirst();
			String email = c.getString(2);
			return email;
		}
		return null;
	}

	public String getPhone(long l) {
		// TODO Auto-generated method stub
		String[] columns = new String[] { KEY_ROWID, KEY_NAME, KEY_EMAIL,
				KEY_PHONE };
		Cursor c = ourDatabase.query(DATABASE_TABLE, columns, KEY_ROWID + "="
				+ l, null, null, null, null);
		if (c != null) {
			c.moveToFirst();
			String phone = c.getString(3);
			return phone;
		}
		return null;
	}

	public void updateEntry(long lRow, String sName, String sEmail,
			String sPhone) {
		// TODO Auto-generated method stub
		ContentValues cvUpdate = new ContentValues();
		cvUpdate.put(KEY_NAME, sName);
		cvUpdate.put(KEY_EMAIL, sEmail);
		cvUpdate.put(KEY_PHONE, sPhone);
		ourDatabase.update(DATABASE_TABLE, cvUpdate, KEY_ROWID + "=" + lRow,
				null);
	}

	public void deleteEntry(long l1) {
		// TODO Auto-generated method stub
		ourDatabase.delete(DATABASE_TABLE, KEY_ROWID + "=" + l1, null);
	}

	public int CheckDetails(String a, String b, String d, String e) {
		String[] columns = new String[] { KEY_ROWID, KEY_NAME, KEY_EMAIL,
				KEY_PHONE,KEY_USER };
		Cursor c = ourDatabase.query(DATABASE_TABLE, columns, null, null, null,
				null, null);
		int flag = 2;
		int iRow = c.getColumnIndex(KEY_ROWID);
		int iName = c.getColumnIndex(KEY_NAME);
		int iEmail = c.getColumnIndex(KEY_EMAIL);
		int iPhone = c.getColumnIndex(KEY_PHONE);
		int iUser = c.getColumnIndex(KEY_USER);

		for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
			if (c.getString(iName).equalsIgnoreCase(a)
					&& c.getString(iEmail).equalsIgnoreCase(b)
					&& c.getString(iPhone).equalsIgnoreCase(d)
					&& c.getString(iUser).equalsIgnoreCase(e)) {
				flag = 1;
				break;
			}

		}
		return flag;
	}

	public void abc() {

	}
}
