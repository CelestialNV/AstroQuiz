package com.example.astroquiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
public class HomepageActivity extends AppCompatActivity {

    //Static value to pass data to other activities. Mainly, from HomepageActivity
    // to QuestionActivity and vise versa.

    static Button ClickedButton;

    static String LoggedIn;

    //same for passing data from HomePageActivity to GameOverActivity.

    static double new_score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        new_score = 0;
    }

    //Go to QuestionActivity Method.

    public void GotoQuestion(View view){
        ClickedButton = (Button) view;
        ClickedButton.setEnabled(false);
        Intent i = new Intent(getApplicationContext(), QuestionActivity.class);
        startActivity(i);
    }
}