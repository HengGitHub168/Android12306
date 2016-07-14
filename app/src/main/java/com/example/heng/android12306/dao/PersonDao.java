package com.example.heng.android12306.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.heng.android12306.bean.Person;
import com.example.heng.android12306.util.DBHelper;

import java.util.ArrayList;
import java.util.List;


public class PersonDao {
    private DBHelper dbHelper;

    //构造方法完成初始
    public PersonDao(Context context) {
        dbHelper = new DBHelper(context);
    }

    //实现用户的添加
    public long addPerson(Person person) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("email", person.getEmail());
        values.put("password", person.getPassword());
        values.put("userName", person.getUserName());
        values.put("gender", person.getGender());
        values.put("idCard", person.getIdCard());
        values.put("phone", person.getPhone());
        values.put("lastTime", person.getLastTime());
        values.put("userSate", person.getUserSate());
        long count = 0;
        db.beginTransaction();//事务开始
        try {
            count = db.insert("person", null, values);
            db.setTransactionSuccessful();//设置事务成功
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.endTransaction();//结束事务
            db.close();
        }

        return count;
    }

    /*//实现删除用户的
    public int deletePerson(int id) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        int count = 0;
        try {
            count = db.delete("person", "id=?", new String[]{String.valueOf(id)});
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.close();
        }
        return count;
    }*/

    //实现修改
    public int updatePerson(Person person) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("email", person.getEmail());
        values.put("password", person.getPassword());
        values.put("userName", person.getUserName());
        values.put("gender", person.getGender());
        values.put("idCard", person.getIdCard());
        values.put("phone", person.getPhone());
        values.put("lastTime", person.getLastTime());
        values.put("userSate", person.getUserSate());
        int count = 0;
        try {
            count = db.update("person", values, "id=?", new String[]{String.valueOf(person.getId())});
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.close();
        }
        return count;
    }

    //根据id查询一条记录
    public Person findById(int id) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Person person = null;

        // Cursor cursor = db.query("person", null, "id=?", new String[]{String.valueOf(id)}, null, null, null);
        String sql = "select * from person where id=?";
        Cursor cursor = db.rawQuery(sql, new String[]{String.valueOf(id)});

        if (cursor.moveToNext()) {
            int Personid = cursor.getInt(cursor.getColumnIndex("id"));
            String email = cursor.getString(cursor.getColumnIndex("email"));
            String password = cursor.getString(cursor.getColumnIndex("password"));
            String userName = cursor.getString(cursor.getColumnIndex("userName"));
            String gender = cursor.getString(cursor.getColumnIndex("gender"));
            String idCard = cursor.getString(cursor.getColumnIndex("idCard"));
            String phone = cursor.getString(cursor.getColumnIndex("phone"));
            String lastTime = cursor.getString(cursor.getColumnIndex("lastTime"));
            int userSate = cursor.getInt(cursor.getColumnIndex("userSate"));
            person = new Person(Personid, email, password, userName, gender, idCard, phone, lastTime, userSate);
        }
        if (cursor != null) {
            cursor.close();
        }
        if (db != null) {
            db.close();
        }
        return person;
    }

    //查找所有记录
    public List<Person> getAll() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        List<Person> persons = new ArrayList<Person>();
        Person person = null;

        Cursor cursor = db.query("person", null, null, null, null, null, null);
        while (cursor.moveToNext()) {
            int Personid = cursor.getInt(cursor.getColumnIndex("id"));
            String email = cursor.getString(cursor.getColumnIndex("email"));
            String password = cursor.getString(cursor.getColumnIndex("password"));
            String userName = cursor.getString(cursor.getColumnIndex("userName"));
            String gender = cursor.getString(cursor.getColumnIndex("gender"));
            String idCard = cursor.getString(cursor.getColumnIndex("idCard"));
            String phone = cursor.getString(cursor.getColumnIndex("phone"));
            String lastTime = cursor.getString(cursor.getColumnIndex("lastTime"));
            int userSate = cursor.getInt(cursor.getColumnIndex("userSate"));
            person = new Person(Personid, email, password, userName, gender, idCard, phone, lastTime, userSate);
            persons.add(person);
        }
        if (cursor != null) {
            cursor.close();
        }
        if (db != null) {
            db.close();
        }

        return persons;
    }

    //根据用户名和密码查
    public boolean findByNameAndPwd(String userEmail, String userPwd) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String sql = "select * from person where email=? and password=?";
        Cursor cursor = db.rawQuery(sql, new String[]{userEmail, userPwd});
        if (cursor.moveToNext()) {
            return true;
        } else {
            return false;
        }

    }

}
