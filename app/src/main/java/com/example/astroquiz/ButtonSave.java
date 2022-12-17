package com.example.astroquiz;

public class ButtonSave {
    public String getButtonColor() {
        return ButtonColor;
    }

    public void setButtonColor(String buttonColor) {
        ButtonColor = buttonColor;
    }

    public boolean isButtonClicked() {
        return ButtonClicked;
    }

    public void setButtonClicked(boolean buttonClicked) {
        ButtonClicked = buttonClicked;
    }

    private String ButtonColor;
    private boolean ButtonClicked = false;
}
