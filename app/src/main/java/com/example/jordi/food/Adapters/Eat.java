package com.example.jordi.food.Adapters;

/**
 * Created by jordi on 21/07/16.
 */
public class Eat {
    private Dish firstDish;
    private Dish secondDish;
    private Dish thirdDish;
    private String eatingTime; // breakfast, lunch or dinner

    public Eat () {
        this.eatingTime = new String();
        this.firstDish = new Dish();
        this.secondDish = new Dish();
        this.thirdDish = new Dish();
    }

    public Eat(String eatingTime, Dish firstDish, Dish secondDish, Dish thirdDish) {
        this.eatingTime = eatingTime;
        this.firstDish = firstDish;
        this.secondDish = secondDish;
        this.thirdDish = thirdDish;
    }

    public String getEatingTime() {
        return eatingTime;
    }

    public void setEatingTime(String eatingTime) {
        this.eatingTime = eatingTime;
    }

    public Dish getFirstDish() {
        return firstDish;
    }

    public void setFirstDish(Dish firstDish) {
        this.firstDish = firstDish;
    }

    public Dish getSecondDish() {
        return secondDish;
    }

    public void setSecondDish(Dish secondDish) {
        this.secondDish = secondDish;
    }

    public Dish getThirdDish() {
        return thirdDish;
    }

    public void setThirdDish(Dish thirdDish) {
        this.thirdDish = thirdDish;
    }
}
