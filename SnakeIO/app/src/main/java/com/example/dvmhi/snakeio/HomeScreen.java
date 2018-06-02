package com.example.dvmhi.snakeio;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by dvmhi on 24-May-18.
 */

public class HomeScreen extends AppCompatActivity {


    private EditText playerName;
    private ListView lvScore;
    private ArrayList<String> listScore;
    private ArrayAdapter<String> adapterScore;

    @Override
    protected  void onCreate(Bundle savedInstanceState){
        super.onCreate((savedInstanceState));
        setContentView((R.layout.home_screen));

        playerName = (EditText) findViewById(R.id.edt_player_name);
        lvScore = findViewById(R.id.lv_score);

        listScore = new ArrayList<String>();
        adapterScore = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,listScore);

        listScore.add("Hieu -- score:70");
        listScore.add("Chinh -- score:80");

        lvScore.setAdapter(adapterScore);

    }

    public void clickOnPlay(View view){
        Intent playScreen = new Intent(HomeScreen.this,PlayScreen.class);
        startActivity(playScreen);
    }

}
