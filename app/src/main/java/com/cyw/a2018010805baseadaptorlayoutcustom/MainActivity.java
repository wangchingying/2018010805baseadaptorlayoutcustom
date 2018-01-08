package com.cyw.a2018010805baseadaptorlayoutcustom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    ListView lv1;
    Boolean[] chks=new Boolean[8];
    //泛型+Collection, Map是Interface, HashMap是class, 都可用, 改成物件甚麼東西都能放,因為要加入圖檔,圖檔Integer不是String
    ArrayList<Map<String, Object>> mylist = new ArrayList<>();

    //ArrayList<HashMap<String,String>> mylist= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv1 = (ListView) findViewById(R.id.listView);
        HashMap<String, Object> m1 = new HashMap<>();
        HashMap<String, Object> m2 = new HashMap<>();
        HashMap<String, Object> m3 = new HashMap<>();
        HashMap<String, Object> m4 = new HashMap<>();
        HashMap<String, Object> m5 = new HashMap<>();
        HashMap<String, Object> m6 = new HashMap<>();
        HashMap<String, Object> m7 = new HashMap<>();
        HashMap<String, Object> m8 = new HashMap<>();

        m1.put("city", "台北");
        m1.put("code", "02");
        m1.put("img", R.drawable.taipei);
        mylist.add(m1);
        m2.put("city", "台中");
        m2.put("code", "04");
        m2.put("img", R.drawable.taichung);
        mylist.add(m2);
        m3.put("city", "台南");
        m3.put("code", "06");
        m3.put("img", R.drawable.tainan);
        mylist.add(m3);
        m4.put("city", "高雄");
        m4.put("code", "07");
        m4.put("img", R.drawable.kaohsung);
        mylist.add(m4);
        m5.put("city", "台北5");
        m5.put("code", "502");
        m5.put("img", R.drawable.taipei);
        mylist.add(m5);
        m6.put("city", "台中6");
        m6.put("code", "06");
        m6.put("img", R.drawable.taichung);
        mylist.add(m6);
        m7.put("city", "台南7");
        m7.put("code", "07");
        m7.put("img", R.drawable.tainan);
        mylist.add(m7);
        m8.put("city", "高雄8");
        m8.put("code", "08");
        m8.put("img", R.drawable.kaohsung);
        mylist.add(m8);
        lv1 = (ListView) findViewById(R.id.listView);
        Myadapter adapter = new Myadapter();
        lv1.setAdapter(adapter);
    }
    public void click1(View v)
    {
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<chks.length;i++)
        {
            if (chks[i])
            {
                sb.append(mylist.get(i).get("city") + ",");
            }
        }
        Toast.makeText(MainActivity.this, sb.toString(), Toast.LENGTH_LONG).show();    }

    class Myadapter extends BaseAdapter
    {

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
        public View getView(final int position, View view, ViewGroup viewGroup) {
            LayoutInflater inflater=LayoutInflater.from(MainActivity.this);
            View v=inflater.inflate(R.layout.myitem,null);
            Log.d("GetView","Position"+position);
            TextView tv=v.findViewById(R.id.textView);
            tv.setText(mylist.get(position).get("city").toString());
            TextView tv2=v.findViewById(R.id.textView2);
            tv2.setText(mylist.get(position).get("code").toString());
            ImageView iv=v.findViewById(R.id.imageView);
            iv.setImageResource((Integer)mylist.get(position).get("img"));

            CheckBox cb=(CheckBox)v.findViewById(R.id.checkBox);
            cb.setChecked(chks[position]);
            cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    chks[position]=b;
                }
            });

            return v;
        }
    }
}
