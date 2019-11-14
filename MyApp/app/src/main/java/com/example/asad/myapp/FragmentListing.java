package com.example.asad.myapp;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import static com.example.asad.myapp.UserData.*;

public class FragmentListing extends Fragment {
     View view2;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private ViewGroup mLinearLayout;
    Context context;
    List<UserData> list;
    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        final View view=inflater.inflate(R.layout.listing_fragment, container, false);
        mLinearLayout =(LinearLayout)view.findViewById(R.id.item);
        //


        List<com.example.asad.myapp.UserData> list = com.example.asad.myapp.UserData.listAll(com.example.asad.myapp.UserData.class);

        int max=list.size();
        for (int position=0;position<max;position++){
            final View layout2 = LayoutInflater.from(getActivity()).inflate(R.layout.list_item, mLinearLayout, false);
            view2=layout2;
            final UserData myListData =  list.get(position);
            TextView name=(TextView)layout2.findViewById(R.id.textlistUserName);
            TextView password=(TextView)layout2.findViewById(R.id.textlistPassword);
            name.setText(list.get(position).getName());
            password.setText(list.get(position).getPassword());
            mLinearLayout.addView(layout2);

            int indexValue = mLinearLayout.indexOfChild(layout2);
            layout2.setTag(Integer.toString(indexValue));
            LinearLayout Items=view2.findViewById(R.id.linear);
            Items.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {

                    String index = (String) v.getTag();

                    FragmentTransaction transection=getFragmentManager().beginTransaction();
                    FragmentView ldf = new FragmentView ();
                    Bundle args = new Bundle();
                    args.putString("Index", index);
                    ldf.setArguments(args);
                    transection.replace(R.id.contianer1, ldf);
                    transection.commit();
                }
            });
        }



        return view;
    }
    private int getViewIndex (ViewGroup viewGroup, View view)
    {
        return viewGroup.indexOfChild(view);
    }

    private void addLayout() {
        View layout2 = LayoutInflater.from(context).inflate(R.layout.list_item, mLinearLayout, false);

        mLinearLayout.addView(layout2);
    }


}
