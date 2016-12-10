package com.abuosama.b_34demobaseadapterclass;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText et1,et2,et3;
    Button b1;
    ListView lv;
    ArrayList<Employee> al;

    MyAdapter m;



    public class MyAdapter extends BaseAdapter {


        @Override
        public int getCount() {
            return al.size();
        }

        @Override
        public Object getItem(int pos) {
            return al.get(pos);
        }

        @Override
        public long getItemId(int pos) {
            return pos;
        }

        @Override
        public View getView(int pos, View view, ViewGroup viewGroup) {

            Employee e=al.get(pos);
           View v=getLayoutInflater().inflate(R.layout.row,viewGroup,false);

            TextView tv1= (TextView) v.findViewById(R.id.textview1);
            TextView tv2= (TextView) v.findViewById(R.id.textview2);
            TextView tv3= (TextView) v.findViewById(R.id.textview3);
            tv1.setText(e.getEno());
            tv2.setText(e.getEname());
            tv3.setText(e.getEsal());

            return v;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = (EditText) findViewById(R.id.edittext1);
        et2 = (EditText) findViewById(R.id.edittext2);
        et3 = (EditText) findViewById(R.id.edittext3);

        b1 = (Button) findViewById(R.id.button);

        lv = (ListView) findViewById(R.id.listview1);
        al=new ArrayList<Employee>();
        m=new MyAdapter();
        lv.setAdapter(m);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String eno1=et1.getText().toString();
                String ename2=et2.getText().toString();
                String esal3=et3.getText().toString();
                Employee employee=new Employee();
                employee.setEno(eno1);
                employee.setEname(ename2);
                employee.setEsal(esal3);
                al.add(employee);
                m.notifyDataSetChanged();
                et1.setText("");
                et1.requestFocus();
                et2.setText("");
                et2.requestFocus();
                et3.setText("");
                et3.requestFocus();


            }
        });


    }
}
