package com.example.jordi.food.Adapters;

import java.util.ArrayList;

/**
 * Created by jordi on 21/07/16.
 */
public class Dish {
    private String name;
    private String img;
    private double time; // in minuts
    private ArrayList<Ingredient> ingredients;
    private String howToCook;

    public Dish () {
        this.name = new String();
        this.img = new String();
        this.time = 0;
        this.ingredients = new ArrayList<>();
        this.howToCook = new String();
    }

    public Dish(String name, String img, double time, ArrayList<Ingredient> ingredients, String howToCook) {
        this.name = name;
        this.img = img;
        this.time = time;
        this.ingredients = ingredients;
        this.howToCook = howToCook;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public String getHowToCook() {
        return howToCook;
    }

    public void setHowToCook(String howToCook) {
        this.howToCook = howToCook;
    }
}
