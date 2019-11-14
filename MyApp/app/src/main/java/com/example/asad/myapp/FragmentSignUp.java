package com.example.asad.myapp;

import android.content.Intent;
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
                radioGroup = (RadioGroup)view2.findViewById(R.id.radio);
                // get selected radio button from radioGroup
                int selectedId = radioGroup.getCheckedRadioButtonId();

                // find the radiobutton by returned id
                radioButton = (RadioButton)view2.findViewById(selectedId);


                String name=editText.getText().toString();
                String password=editText2.getText().toString();
                String gender=radioButton.getText().toString();



                UserData udata = new UserData(name,password,gender);
                udata.save();
                Toast.makeText(getActivity(),"Saved data",Toast.LENGTH_SHORT).show();

            }
        });
        return view;
    }

}
