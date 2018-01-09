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
    boolean[] chks=new boolean[8];
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
        //context, data(mylist), boolean陣列要去給Myadapter建構式, 如此boolean才能傳回來,下面click1按了才有資料
        MyAdapter adapter = new MyAdapter(MainActivity.this,mylist,chks);
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

}
