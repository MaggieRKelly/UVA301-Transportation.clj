package uk.ac.tees.q5073545.lecturermanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


/**
 * Created by Maggie on 15/02/2017.
 */

public class DatabaseHandler extends SQLiteOpenHelper
{

    //Database Name
    private  static final String DATABASE_NAME = "Lecturers.db";

    // contacts table name
    private static final String TABLE_NAME= "lecturers";

    //contacts Table columns names
    private static final String COL_ID = "_id";     // Primary key column must be _id
    private static final String COL_NAME = "name";
    private static final String COL_PHONE = "phone";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // Generate Create SQL Statement
        String CREATE_CONTACTS_TABLE = "CREATE TABLE "
                + TABLE_NAME
                + "(" + COL_ID  + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COL_NAME + " TEXT,"
                + COL_PHONE + " TEXT" + ")";

        // Execute/run create SQL statement
        db.execSQL(CREATE_CONTACTS_TABLE);

        Log.d("Database", "Database Created.");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldNum, int newNum)
    {
        // Drop older table if exists and create fresh (deletes all data)
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }





    }
