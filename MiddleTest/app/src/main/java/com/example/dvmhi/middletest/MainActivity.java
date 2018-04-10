package com.example.dvmhi.middletest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnEqual;
    TextView result;
    ArrayList<String> arrResults=new ArrayList<String>();
    ArrayAdapter<String> adapter=null;
    ListView listResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnEqual = findViewById(R.id.equal);
        listResults = findViewById(R.id.listresults);
        adapter=new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, arrResults);
        listResults.setAdapter(adapter);

        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText(result.getText());
                arrResults.add(result.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });
    }
}