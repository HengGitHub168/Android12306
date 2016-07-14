package com.example.heng.android12306.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE = "tickets.db";
    private static final int VERSION = 1;

    public DBHelper(Context context) {
        super(context, DATABASE, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {//创建数据表
        String sql = "create table person(id integer primary key autoincrement,"
                + "email varchar(50) not null,"
                + "password varchar(50) not null,"
                + "userName varchar(50) not null,"
                + "gender varchar(10) not null,"
                + "idCard varchar(50) not null,"
                + "phone varchar(50) not null,"
                + "lastTime varchar(50)  ,"
                + " userSate integer)";


        String sql1 = "create table Contact(Contactid Integer not null,"
                + "ContactName varchar(50) not null,"
                + "ContactCardID varchar(50) not null,"
                + "ContactPhone varchar(50) not null,"
                + "ContactState Integer not null";

        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "drop table if exists person";
        db.execSQL(sql);
        this.onCreate(db);
    }


}
