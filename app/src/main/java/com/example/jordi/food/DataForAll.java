package com.example.jordi.food;

import com.example.jordi.food.Adapters.Dish;
import com.example.jordi.food.Adapters.Eat;
import com.example.jordi.food.Adapters.Ingredient;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.TreeMap;

/**
 * Created by jordi on 21/07/16.
 */
public class DataForAll {
    public static ArrayList<Eat> demoMenuList = new ArrayList<>(); // not necessary right now

    public static TreeMap<Integer, ArrayList<Eat>> weeklySchedule = new TreeMap<>();

    public static String breakfast = "Breakfast";
    public static String lunch = "Lunch";
    public static String dinner = "Dinner";

    public static Dish selectedDish;

    public static void createData () {
        /*
        DataForAll.demoMenuList.add(new Eat("Breakfast", "Milk", "Cookies", "Juice", "", "", ""));
        DataForAll.demoMenuList.add(new Eat("Lunch", "Soup", "Chicken", "Apple", "", "", ""));
        DataForAll.demoMenuList.add(new Eat("Dinner", "Rice", "Fish", "Orange", "", "", ""));
        */
        ArrayList<Eat> day1 = new ArrayList<>();
        ArrayList<Eat> day2 = new ArrayList<>();
        ArrayList<Eat> day3 = new ArrayList<>();
        ArrayList<Eat> day4 = new ArrayList<>();
        ArrayList<Eat> day5 = new ArrayList<>();
        ArrayList<Eat> day6 = new ArrayList<>();
        ArrayList<Eat> day7 = new ArrayList<>();

        // Breakfast
        ArrayList<Ingredient> ingredientsMilk = new ArrayList<>();
        ingredientsMilk.add(new Ingredient("milk", 0.5));
        Dish milk = new Dish("Milk", "", 0.2, ingredientsMilk, "");

        ArrayList<Ingredient> ingredientsCookies = new ArrayList<>();
        ingredientsCookies.add(new Ingredient("cookies", 0.1));
        Dish cookies = new Dish("Cookies", "", 0.2, ingredientsCookies, "");

        ArrayList<Ingredient> ingredientsOrangeJuice = new ArrayList<>();
        ingredientsOrangeJuice.add(new Ingredient("orange juice", 0.1));
        Dish orangeJuice = new Dish("Orange juice", "", 0.2, ingredientsOrangeJuice, "");

        ArrayList<Ingredient> ingredientsAppleJuice = new ArrayList<>();
        ingredientsAppleJuice.add(new Ingredient("orange juice", 0.1));
        Dish appleJuice = new Dish("Apple juice", "", 0.2, ingredientsAppleJuice, "");

        // Lunch or dinner
        ArrayList<Ingredient> ingredientsSoup = new ArrayList<>();
        ingredientsSoup.add(new Ingredient("caldo de pollastre", 1));
        ingredientsSoup.add(new Ingredient("galets", 0.2));
        Dish soup = new Dish("Soup", "", 10, ingredientsSoup, "Boil during 10 min");

        ArrayList<Ingredient> ingredientsCousCous = new ArrayList<>();
        ingredientsCousCous.add(new Ingredient("cous-cous", 0.4));
        ingredientsCousCous.add(new Ingredient("bacon", 0.1));
        ingredientsCousCous.add(new Ingredient("pastanaga", 0.5));
        ingredientsCousCous.add(new Ingredient("carbasso", 0.5));
        Dish cousCous = new Dish("Cous-cous", "", 15, ingredientsCousCous, "Put all on a paella");

        ArrayList<Ingredient> ingredientsFideua = new ArrayList<>();
        ingredientsFideua.add(new Ingredient("caldo de peix", 1));
        ingredientsFideua.add(new Ingredient("fideus", 0.3));
        Dish fideua = new Dish("Fideua", "", 30, ingredientsFideua, "Put the noodles on a paella and then add the stock");

        ArrayList<Ingredient> ingredientsHamburguer = new ArrayList<>();
        ingredientsHamburguer.add(new Ingredient("hamburguesa", 0.2));
        ingredientsHamburguer.add(new Ingredient("ceba", 0.2));
        ingredientsHamburguer.add(new Ingredient("ous", 0.2));
        Dish hamburguer = new Dish("Hamburguer", "", 20, ingredientsHamburguer, "Cook all the food");

        ArrayList<Ingredient> ingredientsOmelet = new ArrayList<>();
        ingredientsOmelet.add(new Ingredient("patates", 0.4));
        ingredientsOmelet.add(new Ingredient("ceba", 0.2));
        ingredientsOmelet.add(new Ingredient("ous", 0.2));
        Dish omelet = new Dish("Hamburguer", "", 15, ingredientsOmelet, "Put the potatoes and the onion on the food" +
                "and then add the eggs");

        ArrayList<Ingredient> ingredientsApple = new ArrayList<>();
        ingredientsApple.add(new Ingredient("apple", 0.2));
        Dish apple = new Dish("Apple", "", 0.3, ingredientsApple, "");

        ArrayList<Ingredient> ingredientsYogurt = new ArrayList<>();
        ingredientsYogurt.add(new Ingredient("yogurt", 0.2));
        Dish yogurt = new Dish("Yougurt", "", 0.3, ingredientsYogurt, "");

        day1.add(new Eat(DataForAll.breakfast, milk, cookies, orangeJuice));
        day2.add(new Eat(DataForAll.breakfast, milk, cookies, appleJuice));
        day3.add(new Eat(DataForAll.breakfast, milk, cookies, appleJuice));
        day4.add(new Eat(DataForAll.breakfast, milk, cookies, orangeJuice));
        day5.add(new Eat(DataForAll.breakfast, milk, cookies, appleJuice));
        day6.add(new Eat(DataForAll.breakfast, milk, cookies, orangeJuice));
        day7.add(new Eat(DataForAll.breakfast, milk, cookies, orangeJuice));

        day1.add(new Eat(DataForAll.lunch, soup, hamburguer, apple));
        day2.add(new Eat(DataForAll.lunch, fideua, hamburguer, yogurt));
        day3.add(new Eat(DataForAll.lunch, soup, omelet, yogurt));
        day4.add(new Eat(DataForAll.lunch, fideua, omelet, apple));
        day5.add(new Eat(DataForAll.lunch, soup, omelet, apple));
        day6.add(new Eat(DataForAll.lunch, cousCous, hamburguer, yogurt));
        day7.add(new Eat(DataForAll.lunch, fideua, omelet, apple));

        day1.add(new Eat(DataForAll.dinner, cousCous, omelet, yogurt));
        day2.add(new Eat(DataForAll.dinner, soup, omelet, yogurt));
        day3.add(new Eat(DataForAll.dinner, cousCous, hamburguer, apple));
        day4.add(new Eat(DataForAll.dinner, soup, hamburguer, yogurt));
        day5.add(new Eat(DataForAll.dinner, cousCous, omelet, yogurt));
        day6.add(new Eat(DataForAll.dinner, soup, omelet, apple));
        day7.add(new Eat(DataForAll.dinner, cousCous, hamburguer, yogurt));

        DataForAll.weeklySchedule.put(Calendar.getInstance().get(Calendar.DAY_OF_YEAR), day1);
        DataForAll.weeklySchedule.put(Calendar.getInstance().get(Calendar.DAY_OF_YEAR)+1, day2);
        DataForAll.weeklySchedule.put(Calendar.getInstance().get(Calendar.DAY_OF_YEAR)+2, day3);
        DataForAll.weeklySchedule.put(Calendar.getInstance().get(Calendar.DAY_OF_YEAR)+3, day4);
        DataForAll.weeklySchedule.put(Calendar.getInstance().get(Calendar.DAY_OF_YEAR)+4, day5);
        DataForAll.weeklySchedule.put(Calendar.getInstance().get(Calendar.DAY_OF_YEAR)+5, day6);
        DataForAll.weeklySchedule.put(Calendar.getInstance().get(Calendar.DAY_OF_YEAR)+6, day7);

    }
}
