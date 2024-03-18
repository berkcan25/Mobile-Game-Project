package com.example.myapplication.FlappyBirdCode;

public class BackgroundImage {
    private int bgImageX, bgImageY,backgroundImageVelocity ;

    public BackgroundImage() {
        bgImageX = 0;
        bgImageY = 0;
        backgroundImageVelocity = 3;
    }

    public int getBgImageX(){
        return bgImageX;
    }
    public int getBgImageY() {
        return bgImageY;
    }

    public int getBgImageVelocity() {
        return backgroundImageVelocity;
    }

    public void setBgImageX(int bgImageX) {
        this.bgImageX = bgImageX;
    }

    public void setBackgroundImageY(int bgImageY) {
        this.bgImageY = bgImageY;
    }

    public void setBackgroundImageVelocity(int backgroundImageVelocity) {
        this.backgroundImageVelocity = backgroundImageVelocity;
    }
}
