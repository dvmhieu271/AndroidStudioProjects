package com.example.dvmhi.quadraticequationsolver;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import com.example.dvmhi.quadraticequationsolver.QuadSolve;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void buttonCalculate(View view) {
        InputMethodManager inputManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);

        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

        EditText editText1 = (EditText) findViewById(R.id.edit_message1);
        EditText editText2 = (EditText) findViewById(R.id.edit_message2);
        EditText editText3 = (EditText) findViewById(R.id.edit_message3);
        TextView textViewAnswer = (TextView) findViewById(R.id.TextView_Answer);
        TextView textViewAnswer2 = (TextView) findViewById(R.id.TextView_Answer2);

        String A = editText1.getText().toString();
        String B = editText2.getText().toString();
        String C = editText3.getText().toString();

        String xxresults = QuadSolve.quadSolveMain(A, B, C);
        String factoringresults = QuadSolve.factorMain(A, B, C);

        textViewAnswer.setText(xxresults);

        textViewAnswer2.setText(factoringresults);
    }

    public void buttonReset(View view) {
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }
}