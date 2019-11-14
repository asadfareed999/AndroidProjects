package com.example.asad.layoutdesign;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

public class UserData extends BaseObservable {
    String title;
    String subtitle;
    String name;
    String email;
    String password;
    String retypepassword;
   static   String email2;

    public UserData(){

    }

    public UserData(String title, String subtitle, String name, String email, String password, String retypepassword) {
        this.title = title;
        this.subtitle = subtitle;
        this.name = name;
        this.email = email;
        this.password = password;
        this.retypepassword = retypepassword;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getRetypepassword() {
        return retypepassword;
    }

    public void setRetypepassword(String retypepassword) {
        this.retypepassword = retypepassword;
    }

    public void setEmail2(String email2) {
        this.email2 = email2;
        notifyPropertyChanged(BR.UserData);
    }
    @Bindable
    public String getEmail2() {
        if (email2 == null) {
            return "";
        }
        return email2;
    }

}

