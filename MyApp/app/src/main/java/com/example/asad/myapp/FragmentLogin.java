package com.example.asad.myapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import androidx.fragment.app.Fragment;

public class FragmentLogin extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
        EditText editText,editText2;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.login_fragment, container, false);
        Button button=view.findViewById(R.id.login);
         editText=view.findViewById(R.id.editTextUsername);
         editText2=view.findViewById(R.id.editTextPassword);


        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


                String name=editText.getText().toString();
                String password=editText2.getText().toString();
                String status="Login Failed";
                List<UserData> list = com.example.asad.myapp.UserData.listAll(com.example.asad.myapp.UserData.class);
                int size=list.size();
                for (int i=0;i<size;i++){
                    String name2=list.get(i).getName();
                    String pass2=list.get(i).getPassword();
                    if (name.equals(name2) && pass2.equals(password)){
                        status="Login Successful";
                    }

                }
                if (status.equals("Login Failed")){
                    editText.setError("invalid name");
                    editText2.setError("invalid password");
                }
                Toast.makeText(getActivity(),status,Toast.LENGTH_SHORT).show();

            }
        });

        return view;
    }
}
