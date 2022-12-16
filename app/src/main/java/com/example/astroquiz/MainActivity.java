package com.example.astroquiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private DataBaseHelper databaseHelper = new DataBaseHelper(MainActivity.this);



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    //Checking if the user credentials exist in our database
    //i.e checking login information method

    public void CheckLogin(View view) {

        EditText username = findViewById(R.id.User);
        EditText password = findViewById(R.id.mdp);



        if (databaseHelper.checkUser(username.getText().toString(),password.getText().toString())) {
            HomepageActivity.LoggedIn = username.getText().toString();
            Intent i = new Intent(getApplicationContext(), HomepageActivity.class);
            startActivity(i);
        } else {
            Toast.makeText(getApplicationContext(),
                    "Username or Password is wrong...", Toast.LENGTH_SHORT).show();
        }
    }

        //Adding user to our database if he/she doesn't already exist
        //i.e signing up user method

        public void SignUp(View view){

            EditText username = findViewById(R.id.User);
            EditText password = findViewById(R.id.mdp);

            if(!databaseHelper.checkUsername(username.getText().toString())){

                UserModal new_user = new UserModal(username.getText().toString(),password.getText().toString());

                databaseHelper.addUser(new_user);

                Toast.makeText(getApplicationContext(),
                        "Account created successfully...",Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(getApplicationContext(),
                        "Username already exists...",Toast.LENGTH_SHORT).show();
            }
    }
}