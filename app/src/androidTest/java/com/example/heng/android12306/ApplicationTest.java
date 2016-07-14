package com.example.heng.android12306;

import android.app.Application;
import android.test.ApplicationTestCase;

import com.example.heng.android12306.bean.Person;
import com.example.heng.android12306.dao.PersonDao;
import com.example.heng.android12306.util.DBHelper;


public class ApplicationTest extends ApplicationTestCase<Application> {
    private DBHelper dbHelper;

    public ApplicationTest() {
        super(Application.class);
    }

    public void test() {
        int a = 2;
        int b = 3;
        assertEquals(5, a + b);
    }

    //测试类，用来测试创建数据库
    public void testCreaeDB() {
        dbHelper = new DBHelper(getContext());
        dbHelper.getWritableDatabase();
    }

    //测试向用户表中添加数据
    public void testAddPerson() {
        Person person = new Person();
        person.setEmail("lxf");
        person.setPassword("1234");
        person.setUserName("张三");
        person.setGender("男");
        person.setIdCard("12313213123213");
        person.setPhone("123456565656");
        person.setLastTime("1234");
        person.setUserSate(1);

        PersonDao personDao = new PersonDao(getContext());
        personDao.addPerson(person);
    }

  /*  //测试删除一条记录
    public void testDeletePerson() {
        PersonDao personDao = new PersonDao(getContext());
        personDao.deletePerson(1);
    }*/
}