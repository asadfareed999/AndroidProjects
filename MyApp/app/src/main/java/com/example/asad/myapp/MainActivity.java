package com.example.asad.myapp;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction transection2 = getSupportFragmentManager().beginTransaction();
        FragmentLogin login = new FragmentLogin();
        transection2.replace(R.id.contianer1, login);
        transection2.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.item1:
                //CODE HERE


                FragmentTransaction transection = getSupportFragmentManager().beginTransaction();
                FragmentSignUp sign = new FragmentSignUp();
                transection.replace(R.id.contianer1, sign);
                transection.commit();
                return true;


            case R.id.itemlogin:
                //CODE HERE


                FragmentTransaction transection2 = getSupportFragmentManager().beginTransaction();
                FragmentLogin login = new FragmentLogin();
                transection2.replace(R.id.contianer1, login);
                transection2.commit();
                return true;


            case R.id.itemLists:
                //CODE HERE


                FragmentTransaction transection3 = getSupportFragmentManager().beginTransaction();
                FragmentListing listing = new FragmentListing();
                transection3.replace(R.id.contianer1, listing);
                transection3.commit();
                return true;


            case R.id.iteminfo:
                //CODE HERE


                FragmentTransaction transection4 = getSupportFragmentManager().beginTransaction();
                FragmentView fragmentView = new FragmentView();
                transection4.replace(R.id.contianer1, fragmentView);
                transection4.commit();
                return true;

            case R.id.itemdelete:
                //CODE HERE
                UserData.deleteAll(UserData.class);
                return true;


            case R.id.itemexit:
                //CODE HERE
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
                return true;


            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
