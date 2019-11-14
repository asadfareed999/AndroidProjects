package com.example.asad.myapp;

import android.graphics.Bitmap;

import com.orm.SugarRecord;

public class UserData extends SugarRecord<UserData> {

    private String Name;
    private String Password;
    private String Gender;

    public UserData() {
    }

    UserData(String name, String password,String gender ) {
        Name = name;
        Password = password;
        Gender=gender;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password ) {
        Password = password;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }
}
