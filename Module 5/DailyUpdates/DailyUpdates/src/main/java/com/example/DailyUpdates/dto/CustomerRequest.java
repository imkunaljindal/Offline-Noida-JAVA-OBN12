package com.example.DailyUpdates.dto;

public class CustomerRequest {

    private String name;

    private int age;

    private String email;

    private Gender gender;

    private String mobNo;

    public CustomerRequest() {
    }

    public CustomerRequest(String name, int age, String email, Gender gender, String mobNo) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.gender = gender;
        this.mobNo = mobNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getMobNo() {
        return mobNo;
    }

    public void setMobNo(String mobNo) {
        this.mobNo = mobNo;
    }
}
