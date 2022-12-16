package com.example.astroquiz;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DataBaseHelper extends SQLiteOpenHelper {

    // Database Version

    private static final int DATABASE_VERSION = 1;

    // Name of our DataBase

    private static final String DATABASE_NAME = "astroquiz.db";

    // Name of our Table

    private static final String TABLE_USER = "user";

    // Names of all the Columns that we will be using in our Astroquiz project

    private static final String COLUMN_USER_USERNAME = "user_username";
    private static final String COLUMN_USER_PASSWORD = "user_password";
    private static final String COLUMN_USER_SCORE = "user_score";

    // create table sql query

    private String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_USER + "("
            + COLUMN_USER_USERNAME + " TEXT,"
            + COLUMN_USER_SCORE + " REAL," + COLUMN_USER_PASSWORD + " TEXT" + ")";

    // drop table sql query

    private String DROP_USER_TABLE = "DROP TABLE IF EXISTS " + TABLE_USER;


    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USER_TABLE);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //Drop User Table if exist

        db.execSQL(DROP_USER_TABLE);

        // Create tables again

        onCreate(db);

    }

    public void addUser(UserModal user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_USERNAME, user.getUsername());
        values.put(COLUMN_USER_PASSWORD, user.getPassword());

        // Inserting Row
        db.insert(TABLE_USER, null, values);
        db.close();
    }



    @SuppressLint("Range")
    public ArrayList<UserModal> getAllUser() {

        // array of columns to fetch

        String[] columns = {
                COLUMN_USER_USERNAME,
                COLUMN_USER_SCORE,
                COLUMN_USER_PASSWORD
        };

        // sorting orders

        String sortOrder =
                COLUMN_USER_SCORE + " ASC";
        ArrayList<UserModal> userList = new ArrayList<UserModal>();

        SQLiteDatabase db = this.getReadableDatabase();

        // query the user table

        Cursor cursor = db.query(TABLE_USER, //Table to query
                columns,    //columns to return
                null,        //columns for the WHERE clause
                null,        //The values for the WHERE clause
                null,       //group the rows
                null,       //filter by row groups
                null); //The sort order


        // Traversing through all rows and adding to our list

        if (cursor.moveToFirst()) {
            do {
                UserModal user = new UserModal();
                user.setUsername(cursor.getString(cursor.getColumnIndex(COLUMN_USER_USERNAME)));
                user.setScore(cursor.getDouble(cursor.getColumnIndex(COLUMN_USER_SCORE)));
                user.setPassword(cursor.getString(cursor.getColumnIndex(COLUMN_USER_PASSWORD)));

                // Adding user record to list

                userList.add(user);

            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        // return user list

        return userList;
    }

    public void updateScore(double score, String username) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_SCORE, score);

        // Updating row

        db.update(TABLE_USER, values, COLUMN_USER_USERNAME + " = ?",
                new String[]{username});
        db.close();
    }

    //Checking whether the username already exists in our database.

    public boolean checkUsername(String username) {

        // array of columns to fetch
        String[] columns = {
                COLUMN_USER_USERNAME
        };
        SQLiteDatabase db = this.getReadableDatabase();

        // selection criteria
        String selection = COLUMN_USER_USERNAME + " = ?";

        // selection argument

        String[] selectionArgs = {username};

        // query user table with condition

        Cursor cursor = db.query(TABLE_USER, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                      //filter by row groups
                null);                      //The sort order


        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();

        if (cursorCount > 0) {
            return true;
        }

        return false;
    }

    public boolean checkUser(String username, String password) {

        // array of columns to fetch

        String[] columns = {
                COLUMN_USER_USERNAME
        };
        SQLiteDatabase db = this.getReadableDatabase();

        // selection criteria

        String selection = COLUMN_USER_USERNAME + " = ?" + " AND " + COLUMN_USER_PASSWORD + " = ?";

        // selection arguments

        String[] selectionArgs = {username, password};

        // query user table with conditions

        Cursor cursor = db.query(TABLE_USER, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                       //filter by row groups
                null);                      //The sort order


        //The number of cursors generated after executing the query. In our case, this should always
        //get a value of 1, since there is only one user with the username and password entered
        //at any given time.

        int cursorCount = cursor.getCount();

        cursor.close();
        db.close();
        if (cursorCount > 0) {
            return true;
        }

        return false;
    }



    @SuppressLint("Range")
    public double getUserScore(String username) {

        //the current score of the user currently logged in

        double score = 0;

        // array of columns to fetch

        String[] columns = {
                COLUMN_USER_SCORE
        };

        SQLiteDatabase db = this.getReadableDatabase();

        // selection criteria

        String selection = COLUMN_USER_USERNAME + " = ?";

        // selection arguments

        String[] selectionArgs = {username};

        // query user table with conditions

        Cursor cursor = db.query(TABLE_USER, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                       //filter by row groups
                null);                      //The sort order


        // Traversing through all rows and adding to our list

        if (cursor.moveToFirst()) {
            do {
                score = cursor.getDouble(cursor.getColumnIndex(COLUMN_USER_SCORE));

            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        // return user list

        return score;
    }
}
