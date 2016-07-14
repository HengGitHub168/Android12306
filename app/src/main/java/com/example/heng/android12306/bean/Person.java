package com.example.heng.android12306.bean;


public class Person {
    private int id;
    private String email;
    private String password;
    private String userName;
    private String gender;
    private String idCard;
    private String phone;
    private String lastTime;
    private int userSate;

    public Person(int id, String email, String password, String userName, String gender, String idCard, String phone, String lastTime, int userSate) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.userName = userName;
        this.gender = gender;
        this.idCard = idCard;
        this.phone = phone;
        this.lastTime = lastTime;
        this.userSate = userSate;


    }

    public Person() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLastTime() {
        return lastTime;
    }

    public void setLastTime(String lastTime) {
        this.lastTime = lastTime;
    }

    public int getUserSate() {
        return userSate;
    }

    public void setUserSate(int userSate) {
        this.userSate = userSate;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", userName='" + userName + '\'' +
                ", gender='" + gender + '\'' +
                ", idCard='" + idCard + '\'' +
                ", phone='" + phone + '\'' +
                ", lastTime='" + lastTime + '\'' +
                ", userSate=" + userSate +
                '}';
    }
}
