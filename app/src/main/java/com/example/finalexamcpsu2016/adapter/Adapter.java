package com.example.finalexamcpsu2016.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.finalexamcpsu2016.R;
import com.example.finalexamcpsu2016.model.login;

import java.util.ArrayList;

/**
 * Created by User on 18/12/59.
 */

public class Adapter  extends ArrayAdapter<login> {
    private Context mContext;
    private int mLayoutResId;
    private ArrayList<login> mList;

    public Adapter(Context mContext, int resource, ArrayList<login> logins) {
        super(mContext, resource, logins);

        this.mContext = mContext;
        this.mLayoutResId = resource;
        this.mList = logins;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View itemLayout = convertView;

        if(itemLayout == null){
            itemLayout = View.inflate(mContext, mLayoutResId, null);
        }
        TextView tv = (TextView) itemLayout.findViewById(R.id.tv_list) ;

        login value = mList.get(position);
        tv.setText(value.name);

        return itemLayout;
    }
}
