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
    boolean[] chks;
    ArrayList<Map<String, Object>> mylist = new ArrayList<>();
    Context context;
    public MyAdapter(Context context, ArrayList<Map<String, Object>> mylist,boolean[] chks)
    {
        this.context=context;
        this.mylist=mylist;
        this.chks=chks;
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
        ViewHolder viewHolder;
        //為了不要讓系統一直findviewbyid,浪費資源又會lag, 建立一個viewHolder裝起來
        if (v==null)
        {
            LayoutInflater inflater=LayoutInflater.from(context);
            v=inflater.inflate(R.layout.myitem,null);
            viewHolder=new ViewHolder();
            viewHolder.tv=v.findViewById(R.id.textView);
            viewHolder.tv2=v.findViewById(R.id.textView2);
            viewHolder.iv=v.findViewById(R.id.imageView);
            viewHolder.cb=v.findViewById(R.id.checkBox);
            v.setTag(viewHolder);
        }
        //如果已經有裝東西了,就拿回來用
        else
        {
            viewHolder=(ViewHolder)v.getTag();
        }

        //Log.d("GetView","Position"+position);

        viewHolder.tv.setText(mylist.get(position).get("city").toString());
        viewHolder.tv2.setText(mylist.get(position).get("code").toString());
        viewHolder.iv.setImageResource((Integer)mylist.get(position).get("img"));
        //若之前有打勾, 這一行在使資源回收時勾勾不會被拿掉
        viewHolder.cb.setOnCheckedChangeListener(null);
        viewHolder.cb.setChecked(chks[position]);
        viewHolder.cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                chks[position]=b;
            }
        });

        return v;
    }
    static class ViewHolder
    {
        TextView tv;
        TextView tv2;
        ImageView iv;
        CheckBox cb;
    }
}
