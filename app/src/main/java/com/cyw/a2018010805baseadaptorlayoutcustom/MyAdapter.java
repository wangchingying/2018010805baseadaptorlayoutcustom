package com.cyw.a2018010805baseadaptorlayoutcustom;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Student on 2018/1/9.
 */

public class MyAdapter extends BaseAdapter {
    boolean[] chks=new boolean[8];
    ArrayList<Map<String, Object>> mylist = new ArrayList<>();
    Context context;
    public MyAdapter(Context context, ArrayList<Map<String, Object>> mylist)
    {
        this.context=context;
        this.mylist=mylist;
    }

    @Override
    public int getCount() {
        return mylist.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    //getView中 int i的 i 是指listveiw裡面的第幾項,也就是position,注意加了final
    //getView的View v就是資源回收的view
    public View getView(final int position, View v, ViewGroup viewGroup) {

        if (v==null)
        {
            LayoutInflater inflater=LayoutInflater.from(context);
            v=inflater.inflate(R.layout.myitem,null);
        }

        Log.d("GetView","Position"+position);
        TextView tv=v.findViewById(R.id.textView);
        tv.setText(mylist.get(position).get("city").toString());
        TextView tv2=v.findViewById(R.id.textView2);
        tv2.setText(mylist.get(position).get("code").toString());
        ImageView iv=v.findViewById(R.id.imageView);
        iv.setImageResource((Integer)mylist.get(position).get("img"));

//        CheckBox cb=(CheckBox)v.findViewById(R.id.checkBox);
//        cb.setChecked(chks[position]);
//        cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//                chks[position]=b;
//            }
//        });

        return v;
    }
}
