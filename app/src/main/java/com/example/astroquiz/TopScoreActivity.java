package com.example.astroquiz;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;


public class TopScoreActivity extends AppCompatActivity {

    private DataBaseHelper databaseHelper = new DataBaseHelper(TopScoreActivity.this);
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_score);

        //Our listView for displaying all the users and their score
        listView = findViewById(R.id.ranking_list);

        //using a custom adapter to display te usernames and their score
        UserAdapter adapter = new UserAdapter(getApplicationContext(),databaseHelper.getAllUser());
        listView.setAdapter(adapter);
    }
}