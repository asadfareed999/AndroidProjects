package com.example.asad.userinfo;

import android.graphics.Bitmap;

import com.orm.SugarRecord;

public class UserData extends SugarRecord<UserData> {

    private String Name;
    private Bitmap bitmap;

    public UserData() {
    }

    UserData(String name, Bitmap bitmap) {
        Name = name;
        this.bitmap = bitmap;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }
}
