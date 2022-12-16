package com.example.astroquiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GameOverActivity extends AppCompatActivity {

    private DataBaseHelper databaseHelper = new DataBaseHelper(GameOverActivity.this);
    TextView score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);

        databaseHelper.updateScore(HomepageActivity.new_score,HomepageActivity.LoggedIn);
        score = findViewById(R.id.Score);
        //Displaying the score, by setting up the text for the TextView 'score'.
        score.setText("Score : "+HomepageActivity.new_score);

        //checking if the score is higher or not
        //and updating the user score if true
        CheckScore();

    }

    //Replay method. Simply creates a new HomePage Activity.

    public void replay(View view){
        Intent i = new Intent(getApplicationContext(), HomepageActivity.class);
        startActivity(i);
        finish();//Closing the active GameOverActivity, so the user can't go back to the GameOverActivity
        // after pressing the GoBack Button
    }

    public void ranking(View view){
        Intent i = new Intent(getApplicationContext(), TopScoreActivity.class);
        startActivity(i);
    }

    //If the user presses the GoBack button It should create a new HomePageActivity, i.e launching
    //the replay method. We then Override the GoBack Button.
    @Override
    public void onBackPressed() {

    }

    //checking whether we have a top score or not method
    public void CheckScore(){

        //temporary variable that represents the old score of the user
        double old_score;
        old_score = databaseHelper.getUserScore(HomepageActivity.LoggedIn);
        if(HomepageActivity.new_score > old_score){
            databaseHelper.updateScore(HomepageActivity.new_score,HomepageActivity.LoggedIn);
        }
        else{
            //do nothing
        }
    }
}