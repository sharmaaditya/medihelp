package com.techblogon.loginexample;
import java.util.LinkedList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;


public class PrescriptionDataBaseAdapter 
{
		static final String DATABASE_NAME = "prescription2.db";
		static final int DATABASE_VERSION = 1;
		public static final int NAME_COLUMN = 1;
		// TODO: Create public field for each column in your table.
		// SQL Statement to create a new database.
//		String Mem_ID=
		static final String DATABASE_CREATE = "create table "+"presc"+
		                             "( " +"USERNAME text, MEMBERNAME  text, MEDICINE text, DOSE int, DAYS_LEFT int," + " primary key (USERNAME, MEMBERNAME, MEDICINE) ); ";
		// Variable to hold the database instance
		public static  SQLiteDatabase db;
		// Context of the application using the database.
		private final Context context;
		// Database open/upgrade helper
		private PrescriptionDataBaseHelper dbHelper;
		public  PrescriptionDataBaseAdapter(Context _context) 
		{
			context = _context;
			dbHelper = new PrescriptionDataBaseHelper(context, DATABASE_NAME, null, DATABASE_VERSION);
		}
		public  PrescriptionDataBaseAdapter open() throws SQLException 
		{
			db = dbHelper.getWritableDatabase();
			return this;
		}
		public void close() 
		{
			db.close();
		}

		public  SQLiteDatabase getDatabaseInstance()
		{
			return db;
		}

		static public void insertEntry(String userName, String memberName, String medicine, int dose, int days_left)
		{
	       ContentValues newValues = new ContentValues();
			// Assign values for each row.
			newValues.put("USERNAME", userName);
			newValues.put("MEMBERNAME", memberName);
			newValues.put("MEDICINE", medicine);
			newValues.put("DOSE", dose);
			newValues.put("DAYS_LEFT", days_left);
			
			// Insert the row into your table
			db.insert("presc", null, newValues);
			///Toast.makeText(context, "Reminder Is Successfully Saved", Toast.LENGTH_LONG).show();
		}
		public int deleteEntry(String UserName)
		{
			//String id=String.valueOf(ID);
		    String where="USERNAME=?";
		    int numberOFEntriesDeleted= db.delete("LOGIN", where, new String[]{UserName}) ;
	       // Toast.makeText(context, "Number fo Entry Deleted Successfully : "+numberOFEntriesDeleted, Toast.LENGTH_LONG).show();
	        return numberOFEntriesDeleted;
		}	
		static public List<String> getMembers(String userName) 
		{
			List<String> membernames = new LinkedList<String>();
			//String query = "Select UNIQUE(MEMBERNAME) where USERNAME= " + userName + " FROM presc"; 
			Cursor cursor=db.query(true,"presc", null, " USERNAME=?", new String[]{userName}, "MEMBERNAME", null, null ,null);

			if(cursor.getCount()<1) // UserName Not Exist
	        {
	        	cursor.close();
	        	return membernames;
	        }
		    cursor.moveToFirst();
		    do{
		    	membernames.add(cursor.getString(1));
		    }while(cursor.moveToNext());
			//String password= cursor.getString(cursor.getColumnIndex("PASSWORD"));
			cursor.close();
			return membernames;				
		}
		
		static public List<String[]> getMedicines(String userName, String memName) 
		{
			List<String[]> medlist = new LinkedList<String[]>();
			//String query = "Select UNIQUE(MEMBERNAME) where USERNAME= " + userName + " FROM presc"; 
			Cursor cursor=db.query("presc", null, " USERNAME=? and MEMBERNAME=?", new String[]{userName, memName}, null, null, null);

			if(cursor.getCount()<1) // UserName Not Exist
	        {
	        	cursor.close();
	        	return medlist;
	        }
		    cursor.moveToFirst();
		    do{
		    	String S[]={cursor.getString(2), cursor.getString(3), cursor.getString(4)};
		    	medlist.add(S);
		    }while(cursor.moveToNext());
			//String password= cursor.getString(cursor.getColumnIndex("PASSWORD"));
			cursor.close();
			return medlist;				
		}
		public void  updateEntry(String userName,String password)
		{
			// Define the updated row content.
			ContentValues updatedValues = new ContentValues();
			// Assign values for each row.
			updatedValues.put("USERNAME", userName);
			updatedValues.put("PASSWORD",password);
			
	        String where="USERNAME = ?";
		    db.update("LOGIN",updatedValues, where, new String[]{userName});			   
		}		
}

