package com.example.dvmhi.snakeio;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Point;
import android.view.Display;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ListView;
import com.example.dvmhi.snakeio.adapter.CustomListAdapter;
import com.example.dvmhi.snakeio.model.Items;
import java.util.ArrayList;
import java.util.List;

class MainActivity extends Activity {
    // Declare an instance of SnakeEngine
    SnakeEngine snakeEngine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Get the pixel dimensions of the screen
        Display display = getWindowManager().getDefaultDisplay();

        // Initialize the result into a Point object
        Point size = new Point();
        display.getSize(size);

        // Create a new instance of the SnakeEngine class
        snakeEngine = new SnakeEngine(this, size);

        // Make snakeEngine the view of the Activity
        setContentView(snakeEngine);

        setContentView(R.layout.mainactivity);

        SQLiteDatabase myDB = null;

        try {

            //Create a Database if doesnt exist otherwise Open It

            myDB = this.openOrCreateDatabase("leaderboard", MODE_PRIVATE, null);

            //Create table in database if it doesnt exist allready

            myDB.execSQL("CREATE TABLE IF NOT EXISTS scores (name TEXT, score TEXT);");

            //Select all rows from the table

            Cursor cursor = myDB.rawQuery("SELECT * FROM scores", null);

            //If there are no rows (data) then insert some in the table

            if (cursor != null) {
                if (cursor.getCount() == 0) {

                    myDB.execSQL("INSERT INTO scores (name, score) VALUES ('Andy', '7');");
                    myDB.execSQL("INSERT INTO scores (name, score) VALUES ('Marie', '4');");
                    myDB.execSQL("INSERT INTO scores (name, score) VALUES ('George', '1');");

                }
            }

        } catch (Exception e) {

        } finally {

            //Initialize and create a new adapter with layout named list found in mainactivity layout

            listView = (ListView) findViewById(R.id.list);
            adapter = new CustomListAdapter(this, itemsList);
            listView.setAdapter(adapter);

            Cursor cursor = myDB.rawQuery("SELECT * FROM scores", null);

            if (cursor.moveToFirst()) {

                //read all rows from the database and add to the Items array

                while (!cursor.isAfterLast()) {

                    Items items = new Items();

                    items.setName(cursor.getString(0));
                    items.setScore(cursor.getString(1));

                    itemsList.add(items);
                    cursor.moveToNext();


                }
            }

            //All done, so notify the adapter to populate the list using the Items Array

            adapter.notifyDataSetChanged();
        }
    }

    // Start the thread in snakeEngine
    @Override
    protected void onResume() {
        super.onResume();
        snakeEngine.resume();
    }

    // Stop the thread in snakeEngine
    @Override
    protected void onPause() {
        super.onPause();
        snakeEngine.pause();
    }

    private List<Items> itemsList = new ArrayList<Items>();
    private ListView listView;
    private CustomListAdapter adapter;
}