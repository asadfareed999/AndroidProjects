package com.example.asad.sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.provider.BaseColumns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.Fragment;




public class FragmentListing extends Fragment {
     View view2;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private ViewGroup mLinearLayout;
    Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        final View view=inflater.inflate(R.layout.listing_fragment, container, false);
        mLinearLayout =(LinearLayout)view.findViewById(R.id.item);
        //


        FeedReaderDbHelper dbHelper = new FeedReaderDbHelper(getContext());
        SQLiteDatabase db = dbHelper.getReadableDatabase();

// Define a projection that specifies which columns from the database
// you will actually use after this query.
        String[] projection = {
                BaseColumns._ID,
                FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE,
                FeedReaderContract.FeedEntry.COLUMN_NAME_SUBTITLE
        };

// Filter results WHERE "title" = 'My Title'
        String selection = FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE + " = ?";
        String[] selectionArgs = { "My Title" };

// How you want the results sorted in the resulting Cursor
        String sortOrder =
                FeedReaderContract.FeedEntry.COLUMN_NAME_SUBTITLE + " DESC";

        Cursor cursor = db.query(
                FeedReaderContract.FeedEntry.TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                selection,              // The columns for the WHERE clause
                selectionArgs,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                sortOrder               // The sort order
        );
        int Count=0;
        List itemIds = new ArrayList<Integer>();
        while(cursor.moveToNext()) {
            long itemId = cursor.getLong(
                    cursor.getColumnIndexOrThrow(FeedReaderContract.FeedEntry._ID));
            itemIds.add(itemId);
            Count++;
        }
        cursor.close();

            final View layout2 = LayoutInflater.from(getActivity()).inflate(R.layout.list_item, mLinearLayout, false);
            view2=layout2;
            TextView name=(TextView)layout2.findViewById(R.id.textlistUserName);
            TextView password=(TextView)layout2.findViewById(R.id.textlistPassword);


                name.setText(itemIds.get(0).toString());
                password.setText(itemIds.get(0).toString());
                mLinearLayout.addView(layout2);



            int indexValue = mLinearLayout.indexOfChild(layout2);
            layout2.setTag(Integer.toString(indexValue));





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
