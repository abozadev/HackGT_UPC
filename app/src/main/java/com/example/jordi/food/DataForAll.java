package com.example.jordi.food;

import com.example.jordi.food.Adapters.Eat;

import java.util.ArrayList;

/**
 * Created by jordi on 21/07/16.
 */
public class DataForAll {
    public static ArrayList<Eat> demoMenuList = new ArrayList<>();

    public static void createData () {
        DataForAll.demoMenuList.add(new Eat("Breakfast", "Milk", "Cookies", "Juice", "", "", ""));
        DataForAll.demoMenuList.add(new Eat("Lunch", "Soup", "Chicken", "Apple", "", "", ""));
        DataForAll.demoMenuList.add(new Eat("Dinner", "Rice", "Fish", "Orange", "", "", ""));
    }
}
