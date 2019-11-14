package com.example.asad.sqlite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction transection2 = getSupportFragmentManager().beginTransaction();
        FragmentSignUp login = new FragmentSignUp();
        transection2.replace(R.id.container, login);
        transection2.commit();
    }
}
