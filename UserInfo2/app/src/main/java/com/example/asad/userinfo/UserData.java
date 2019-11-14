package com.example.asad.userinfo;

import android.graphics.Bitmap;

import com.orm.SugarRecord;

public class UserData extends SugarRecord<UserData> {

    private String Name;
    private byte[] byteArray ;

    public UserData() {
    }

    UserData(String name, byte[] byteArray ) {
        Name = name;
        this.byteArray = byteArray;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public byte[] getByteArray() {
        return byteArray;
    }

    public void setByteArray(byte[] byteArray ) {
        this.byteArray = byteArray;
    }
}
