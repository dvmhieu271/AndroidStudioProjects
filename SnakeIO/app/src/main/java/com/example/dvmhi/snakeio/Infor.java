package com.example.dvmhi.snakeio;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by dvmhi on 24-May-18.
 */

public class Infor extends AppCompatActivity {
    private EditText name;
    private EditText pass;
    private Button login;


    @Override
    protected  void onCreate(Bundle savedInstanceState){
        super.onCreate((savedInstanceState));
        setContentView((R.layout.lo));

        name = (EditText)findViewById(R.id.lName);
        pass = (EditText)findViewById(R.id.lPass);
        login = (Button)findViewById(R.id.lLogin);

        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                validate(name.getText().toString(),pass.getText().toString());
            }
        });
    }
    private void validate(String userName , String userPass){
        if ((userName == "Admin") && (userPass == "1")){
            Intent intent = new Intent(Infor.this, MainActivity.class);
            startActivity(intent);
        }
    }
}
