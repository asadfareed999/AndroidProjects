package com.example.asad.myapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class FragmentView extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //String value = getArguments().getString("YourKey");
        //value=value+"L";
        //int index=Integer.parseInt(value);
        // Inflate the layout for this fragment

        final View view=inflater.inflate(R.layout.view_fragment, container, false);

        TextView textView=view.findViewById(R.id.textUserName3);
        TextView textView2=view.findViewById(R.id.textPassword3);
        TextView textView3=view.findViewById(R.id.textGender3);
        Bundle bundle=getArguments();
        if (bundle!=null){

            String index=String.valueOf(bundle.getString("Index"));
            int index2=Integer.parseInt(index);
            index2-=1;
            List<UserData> list = com.example.asad.myapp.UserData.listAll(com.example.asad.myapp.UserData.class);
            textView.setText(list.get(index2).getName());
            textView2.setText(list.get(index2).getPassword());
            textView3.setText(list.get(index2).getGender());
            Toast.makeText(getActivity(),"name :"+list.get(index2).getName()+" and password : "+list.get(index2).getPassword(),Toast.LENGTH_SHORT).show();
        }
        return view;
    }

}
