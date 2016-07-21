package com.example.jordi.food.Adapters;

/**
 * Created by jordi on 21/07/16.
 */
public class Eat {
    private String eatingTime;
    private String firstDish;
    private String secondDish;
    private String thirdDish;
    private String imgFirstDish;
    private String imgSecondDish;
    private String imgThirdDish;

    public Eat () {
        this.eatingTime = new String();
        this.firstDish = new String();
        this.secondDish = new String();
        this.thirdDish = new String();
        this.imgFirstDish = new String();
        this.imgSecondDish = new String();
        this.imgThirdDish = new String();
    }

    public Eat(String eatingTime, String firstDish, String secondDish, String thirdDish, String imgFirstDish, String imgSecondDish, String imgThirdDish) {
        this.eatingTime = eatingTime;
        this.firstDish = firstDish;
        this.secondDish = secondDish;
        this.thirdDish = thirdDish;
        this.imgFirstDish = imgFirstDish;
        this.imgSecondDish = imgSecondDish;
        this.imgThirdDish = imgThirdDish;
    }

    public String getEatingTime() {
        return eatingTime;
    }

    public void setEatingTime(String eatingTime) {
        this.eatingTime = eatingTime;
    }

    public String getFirstDish() {
        return firstDish;
    }

    public void setFirstDish(String firstDish) {
        this.firstDish = firstDish;
    }

    public String getSecondDish() {
        return secondDish;
    }

    public void setSecondDish(String secondDish) {
        this.secondDish = secondDish;
    }

    public String getThirdDish() {
        return thirdDish;
    }

    public void setThirdDish(String thirdDish) {
        this.thirdDish = thirdDish;
    }

    public String getImgFirstDish() {
        return imgFirstDish;
    }

    public void setImgFirstDish(String imgFirstDish) {
        this.imgFirstDish = imgFirstDish;
    }

    public String getImgSecondDish() {
        return imgSecondDish;
    }

    public void setImgSecondDish(String imgSecondDish) {
        this.imgSecondDish = imgSecondDish;
    }

    public String getImgThirdDish() {
        return imgThirdDish;
    }

    public void setImgThirdDish(String imgThirdDish) {
        this.imgThirdDish = imgThirdDish;
    }
}
