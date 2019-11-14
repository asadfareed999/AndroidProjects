package com.example.asad.userinfo;

import android.service.autofill.UserData;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;



import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    List<UserData> list;
    RecyclerView recyclerView;
    MyListAdapter adapter;
    Toolbar toolbar;
    FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //toolbar = (Toolbar) findViewById(R.id.toolbar);
       // setSupportActionBar(toolbar);


        recyclerView = (RecyclerView) findViewById(R.id.recyclerView2);
        //List<com.example.asad.userinfo.UserData> list = com.example.asad.userinfo.UserData.listAll(com.example.asad.userinfo.UserData.class);

       // adapter = new MyListAdapter(list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
       // recyclerView.setAdapter(adapter);


    /*
        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Add.class));
            }
        });*/
    }

    @Override
    protected void onResume() {
        List<com.example.asad.userinfo.UserData> list = com.example.asad.userinfo.UserData.listAll(com.example.asad.userinfo.UserData.class);
            MyListAdapter adapter=new MyListAdapter(list);
            recyclerView.setAdapter(adapter);

        super.onResume();

    }

    public void Add(View view){

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent=new Intent(this,Add.class);
            startActivity(intent);
            return true;
        }

        if (id == R.id.action_settings2) {
            com.example.asad.userinfo.UserData.deleteAll(com.example.asad.userinfo.UserData.class);
            List<com.example.asad.userinfo.UserData> list = com.example.asad.userinfo.UserData.listAll(com.example.asad.userinfo.UserData.class);
            MyListAdapter adapter=new MyListAdapter(list);
            recyclerView.setAdapter(adapter);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}

