package com.example.dvmhi.finalexam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText editName, editAge, editAddress;
    Button btnAdd;
    ArrayList<Information>arrInfo=new ArrayList<Information>();
    ArrayAdapter<Information>adapter=null;
    ListView lvInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getFormWidgets();
        addEventFormWidgets();
    }

    public void getFormWidgets()
    {
        editName=(EditText) findViewById(R.id.editname);
        editAge=(EditText) findViewById(R.id.editage);
        editAddress=(EditText) findViewById(R.id.editaddress);
        btnAdd=(Button) findViewById(R.id.add);
        lvInfo=(ListView) findViewById(R.id.info);
        adapter=new ArrayAdapter<Information>
                (this, android.R.layout.simple_list_item_1, arrInfo);
        lvInfo.setAdapter(adapter);
    }

    public void addEventFormWidgets()
    {
        btnAdd.setOnClickListener(new MyButtonEvent());
        lvInfo.setOnItemClickListener(new MyListViewEvent());
        lvInfo.setOnItemLongClickListener(new MyListViewEvent());
    }

    private class MyButtonEvent implements View.OnClickListener
    {
        @Override
        public void onClick(View v) {
            switch(v.getId())
            {
                case R.id.add:
                    processAddInfo();
                    break;
            }
        }

    }

    private class MyListViewEvent implements
            AdapterView.OnItemClickListener,
            AdapterView.OnItemLongClickListener
    {

        @Override
        public boolean onItemLongClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
            arrInfo.remove(arg2);
            adapter.notifyDataSetChanged();
            return false;
        }

        @Override
        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
            Toast.makeText(MainActivity.this, arrInfo.get(arg2).getName(), Toast.LENGTH_LONG).show();
        }

    }

    public void processAddInfo()
    {
        String name=editName.getText()+"";
        String age=editAge.getText()+"";
        String address=editAddress.getText()+"";
        Information job=new Information(name, age, address);
        arrInfo.add(job);
        adapter.notifyDataSetChanged();
        editName.setText("");
        editAge.setText("");
        editAddress.setText("");
        editName.requestFocus();
    }
}
