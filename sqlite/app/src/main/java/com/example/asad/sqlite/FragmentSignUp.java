package com.example.asad.sqlite;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.telecom.TelecomManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EdgeEffect;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class FragmentSignUp extends Fragment {
    View view2;
    Button button;
    EditText editText,editText2;
    private RadioGroup radioGroup;
    private RadioButton radioButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.signup_fragment, container, false);
        view2=view;
        button=view2.findViewById(R.id.buttonsignup);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                editText=(EditText)view2.findViewById(R.id.editTextUsername2);
                editText2=(EditText)view2.findViewById(R.id.editTextPassword4);

                // get selected radio button from radioGroup



                String name=editText.getText().toString();
                String password=editText2.getText().toString();

                FeedReaderDbHelper dbHelper = new FeedReaderDbHelper(getContext());
                // Gets the data repository in write mode
                SQLiteDatabase db = dbHelper.getWritableDatabase();

// Create a new map of values, where column names are the keys
                ContentValues values = new ContentValues();
                values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE, name);
                values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_SUBTITLE, password);

// Insert the new row, returning the primary key value of the new row
                long newRowId = db.insert(FeedReaderContract.FeedEntry.TABLE_NAME, null, values);


              //  UserData udata = new UserData(name,password,gender);
                //udata.save();
                FragmentTransaction transection=getFragmentManager().beginTransaction();
                FragmentListing login = new FragmentListing();
                transection.replace(R.id.container, login);
                transection.commit();

                Toast.makeText(getActivity(),"Saved data",Toast.LENGTH_SHORT).show();

            }
        });
        return view;
    }

}
