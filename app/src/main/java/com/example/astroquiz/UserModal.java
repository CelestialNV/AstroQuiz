package com.example.astroquiz;


//Modal class for The login screen
//contains the id for a user, his username and password


public class UserModal
{
    public UserModal(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UserModal() {
        this.username = null;
        this.password = null;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    private String username;
    private String password;
    private double score;




}
