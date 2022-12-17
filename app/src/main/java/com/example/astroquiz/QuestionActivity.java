package com.example.astroquiz;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class QuestionActivity extends AppCompatActivity {
    public TextView question;
    public Button answer_1;
    public Button answer_2;
    public Button answer_3;
    public Button answer_4;
    int random_question = new Random().nextInt(5)*5;

    static public int answered = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_question);

        //setting up the question

        this.question = findViewById(R.id.question);

        //setting up the first answer

        this.answer_1 = findViewById(R.id.answer1);

        //setting up the second answer

        this.answer_2 = findViewById(R.id.answer2);

        //setting up the third answer

        this.answer_3 = findViewById(R.id.answer3);

        //setting up the forth answer

        this.answer_4 = findViewById(R.id.answer4);

        setQuestion(getQuestion());



    }

    //Return the question plus answers that will be displayed on QuestionActivity

    public String[] getQuestion(){
        Resources res = getResources();
        String[] data = new String[0];

        switch (HomepageActivity.ClickedButton.getText().toString()){
            case "science":
                data = res.getStringArray(R.array.science_question);
                HomepageActivity.ScienceButton.setButtonClicked(true);
                break;
            case "astrology":
                data = res.getStringArray(R.array.astrology_question);
                HomepageActivity.AstrologyButton.setButtonClicked(true);
                break;
            case "art":
                data = res.getStringArray(R.array.art_question);
                HomepageActivity.ArtButton.setButtonClicked(true);
                break;
            case "geography":
                data = res.getStringArray(R.array.geography_question);
                HomepageActivity.GeographyButton.setButtonClicked(true);
                break;
            case "math":
                data = res.getStringArray(R.array.math_question);
                HomepageActivity.MathButton.setButtonClicked(true);
                break;
            case "physics":
                data = res.getStringArray(R.array.physics_question);
                HomepageActivity.PhysicsButton.setButtonClicked(true);
                break;
            case "sports":
                data = res.getStringArray(R.array.sports_question);
                HomepageActivity.SportsButton.setButtonClicked(true);
                break;
            case "history":
                data = res.getStringArray(R.array.history_question);
                HomepageActivity.HistoryButton.setButtonClicked(true);
                break;
            case "technology":
                data = res.getStringArray(R.array.technology_question);
                HomepageActivity.TechnologyButton.setButtonClicked(true);
                break;
            default:
                break;
        }

        return data;

    }

    public void setQuestion(String[] data){

        //setting the text for the question field.

        this.question.setText(data[random_question]);

        //randomizing the right answer. Every new occurrence of the same question will have different
        //answer placements.

        int random = new Random().nextInt(4) + 1;

        switch(random){
            case 1:
                setAnswer(answer_1,answer_2,answer_3,answer_4,data);
                break;
            case 2:
                setAnswer(answer_2,answer_3,answer_4,answer_1,data);
                break;
            case 3:
                setAnswer(answer_3,answer_4,answer_1,answer_2,data);
                break;
            case 4:
                setAnswer(answer_4,answer_1,answer_2,answer_3,data);
                break;

        }

    }

    public void setAnswer(Button Right_answer,Button Wrong_answer_1,Button Wrong_answer_2,Button Wrong_answer_3, String[] data){

        //setting up text answers

        Right_answer.setText(data[random_question+1]);

        Wrong_answer_1.setText(data[random_question+2]);

        Wrong_answer_2.setText(data[random_question+3]);

        Wrong_answer_3.setText(data[random_question+4]);

        //setting up the method for the right answer Button

        Right_answer.setOnClickListener(view -> {
            HomepageActivity.ClickedButton.setBackgroundColor(Color.parseColor("#228B22"));
            HomepageActivity.new_score += 100;
            answered++;
            manage(HomepageActivity.ClickedButton.getText().toString(),"#228B22" );
            CheckGameOver();
            finish();
        });

        //setting up the method for the wrong answer Button 1

        Wrong_answer_1.setOnClickListener(view -> {
            HomepageActivity.ClickedButton.setBackgroundColor(Color.parseColor("#bb2222"));
            HomepageActivity.new_score -= 100;
            answered++;
            manage(HomepageActivity.ClickedButton.getText().toString(),"#bb2222" );
            CheckGameOver();
            finish();
        });

        //setting up the method for the wrong answer Button 2

        Wrong_answer_2.setOnClickListener(view -> {
            HomepageActivity.ClickedButton.setBackgroundColor(Color.parseColor("#bb2222"));
            HomepageActivity.new_score -= 100;
            answered++;
            manage(HomepageActivity.ClickedButton.getText().toString(),"#bb2222" );
            CheckGameOver();
            finish();
        });

        //setting up the method for the wrong answer Button 3

        Wrong_answer_3.setOnClickListener(view -> {
            HomepageActivity.ClickedButton.setBackgroundColor(Color.parseColor("#bb2222"));
            HomepageActivity.new_score -= 100;
            answered++;
            manage(HomepageActivity.ClickedButton.getText().toString(),"#bb2222" );
            CheckGameOver();
            finish();
        });
    }

    public void CheckGameOver(){
        if(answered == 9){

            //Resetting the game over condition, which, in this case is answering all 9 questions

            answered = 0;

            //Go to GameOverActivity method

            Intent i = new Intent(getApplicationContext(), GameOverActivity.class);

            startActivity(i);
        }
    }

    public void manage(String ClickedButtonName,String color ){

        switch (ClickedButtonName){
            case "science":
                HomepageActivity.ScienceButton.setButtonColor(color);
                break;
            case "physics":
                HomepageActivity.PhysicsButton.setButtonColor(color);
                break;
            case "art":
                HomepageActivity.ArtButton.setButtonColor(color);
                break;
            case "sports":
                HomepageActivity.SportsButton.setButtonColor(color);
                break;
            case "astrology":
                HomepageActivity.AstrologyButton.setButtonColor(color);
                break;
            case "math":
                HomepageActivity.MathButton.setButtonColor(color);
                break;
            case "geography":
                HomepageActivity.GeographyButton.setButtonColor(color);
                break;
            case "history":
                HomepageActivity.HistoryButton.setButtonColor(color);
                break;
            case "technology":
                HomepageActivity.TechnologyButton.setButtonColor(color);
                break;
            default:
                break;
        }
    }

    //Override onBackPressed so the user has to answer the question before going back.

    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(),
                "Answer the question first...",Toast.LENGTH_SHORT).show();
    }
    }