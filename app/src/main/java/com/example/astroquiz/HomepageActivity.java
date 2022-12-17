package com.example.astroquiz;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
public class HomepageActivity extends AppCompatActivity {

    //Static value to pass data to other activities. Mainly, from HomepageActivity
    // to QuestionActivity and vise versa.

    static Button ClickedButton;

    static String LoggedIn;

    //These will be used to save the button state when the user switches to landscape mode
    static ButtonSave PhysicsButton = new ButtonSave();
    static ButtonSave ScienceButton = new ButtonSave();
    static ButtonSave AstrologyButton = new ButtonSave();
    static ButtonSave SportsButton = new ButtonSave();
    static ButtonSave HistoryButton = new ButtonSave();
    static ButtonSave GeographyButton = new ButtonSave();
    static ButtonSave ArtButton = new ButtonSave();
    static ButtonSave TechnologyButton = new ButtonSave();
    static ButtonSave MathButton = new ButtonSave();




    //same for passing data from HomePageActivity to GameOverActivity.

    static double new_score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        GameSaver();
        new_score = 0;
    }

    //Go to QuestionActivity Method.

    public void GotoQuestion(View view){
        ClickedButton = (Button) view;
        ClickedButton.setEnabled(false);
        Intent i = new Intent(getApplicationContext(), QuestionActivity.class);
        startActivity(i);
    }




    //This method is used to save the changes that could happen after changing to landscape mode
    public void GameSaver(){
        if(PhysicsButton.isButtonClicked()){
            Button button = findViewById(R.id.physics);
            button.setEnabled(false);
            button.setBackgroundColor(Color.parseColor(PhysicsButton.getButtonColor()));
        }
        if(ScienceButton.isButtonClicked()){
            Button button = findViewById(R.id.science);
            button.setEnabled(false);
            button.setBackgroundColor(Color.parseColor(ScienceButton.getButtonColor()));
        }
        if(ArtButton.isButtonClicked()){
            Button button = findViewById(R.id.art);
            button.setEnabled(false);
            button.setBackgroundColor(Color.parseColor(ArtButton.getButtonColor()));
        }
        if(HistoryButton.isButtonClicked()){
            Button button = findViewById(R.id.history);
            button.setEnabled(false);
            button.setBackgroundColor(Color.parseColor(HistoryButton.getButtonColor()));
        }
        if(SportsButton.isButtonClicked()){
            Button button = findViewById(R.id.sports);
            button.setEnabled(false);
            button.setBackgroundColor(Color.parseColor(SportsButton.getButtonColor()));
        }
        if(AstrologyButton.isButtonClicked()){
            Button button = findViewById(R.id.astrology);
            button.setEnabled(false);
            button.setBackgroundColor(Color.parseColor(AstrologyButton.getButtonColor()));
        }
        if(GeographyButton.isButtonClicked()){
            Button button = findViewById(R.id.geography);
            button.setEnabled(false);
            button.setBackgroundColor(Color.parseColor(GeographyButton.getButtonColor()));
        }
        if(MathButton.isButtonClicked()){
            Button button = findViewById(R.id.math);
            button.setEnabled(false);
            button.setBackgroundColor(Color.parseColor(MathButton.getButtonColor()));
        }
        if(TechnologyButton.isButtonClicked()){
            Button button = findViewById(R.id.technology);
            button.setEnabled(false);
            button.setBackgroundColor(Color.parseColor(TechnologyButton.getButtonColor()));
        }


    }
}