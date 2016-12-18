package com.example.finalexamcpsu2016;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.finalexamcpsu2016.adapter.Adapter;
import com.example.finalexamcpsu2016.db.DatabaseHelper;
import com.example.finalexamcpsu2016.model.login;

import java.util.ArrayList;

public class UserListActivity extends AppCompatActivity {
    private DatabaseHelper mHelper;
    private SQLiteDatabase mDb;

    private ArrayList<login> mImageList = new ArrayList<>();
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);

        mHelper = new DatabaseHelper(this);
        mDb = mHelper.getWritableDatabase();
        mListView = (ListView) findViewById(R.id.listView);

        ///แสดงผลเป็นชนิด ListView โดยแสดงหวยย้อนหลังแบบไม่ละเอียด
        Cursor cursor = mDb.query(DatabaseHelper.TABLE_NAME, null, null, null, null, null, null);
        mImageList.clear();
        while (cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_NAME));
            String username = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_USERNAME));
            String password = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_PASSWORD));

            login aa = new login(name , username,password);
            mImageList.add(aa);
        }

        ///set ค่าให้แก่ adapter
       Adapter adapter = new Adapter(
                this,
                R.layout.list_item,
                mImageList

        );

        mListView.setAdapter(adapter);
    }
}
