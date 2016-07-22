package com.example.jordi.food;

import com.example.jordi.food.Adapters.DailySchedule;
import com.example.jordi.food.Adapters.Dish;
import com.example.jordi.food.Adapters.Eat;
import com.example.jordi.food.Adapters.Ingredient;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Created by jordi on 21/07/16.
 */
public class DataForAll {
    public static ArrayList<Eat> demoMenuList = new ArrayList<>(); // not necessary right now

    public static TreeMap<Integer, DailySchedule> weeklySchedule = new TreeMap<>();

    public static String breakfast = "Breakfast";
    public static String lunch = "Lunch";
    public static String dinner = "Dinner";
    public static String[] daysOfWeek = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
    public static String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "Septembet",
            "October", "November", "December"};

    public static Dish selectedDish;

    public static ArrayList<String> getAllIngredients (int ini, int fi) {

        TreeSet<String> result = new TreeSet<>();
        for (int i = ini; i < fi; ++i) {
            DailySchedule elem = (DailySchedule) DataForAll.weeklySchedule.values().toArray()[i];
            for (Ingredient ingredient : elem.getBreakfast().getFirstDish().getIngredients()) {
                result.add(ingredient.getName());
            }
            for (Ingredient ingredient : elem.getBreakfast().getSecondDish().getIngredients()) {
                result.add(ingredient.getName());
            }
            for (Ingredient ingredient : elem.getBreakfast().getThirdDish().getIngredients()) {
                result.add(ingredient.getName());
            }
            for (Ingredient ingredient : elem.getLunch().getFirstDish().getIngredients()) {
                result.add(ingredient.getName());
            }
            for (Ingredient ingredient : elem.getLunch().getSecondDish().getIngredients()) {
                result.add(ingredient.getName());
            }
            for (Ingredient ingredient : elem.getLunch().getThirdDish().getIngredients()) {
                result.add(ingredient.getName());
            }
            for (Ingredient ingredient : elem.getDinner().getFirstDish().getIngredients()) {
                result.add(ingredient.getName());
            }
            for (Ingredient ingredient : elem.getDinner().getSecondDish().getIngredients()) {
                result.add(ingredient.getName());
            }
            for (Ingredient ingredient : elem.getDinner().getThirdDish().getIngredients()) {
                result.add(ingredient.getName());
            }
        }
        return new ArrayList<>(result);
    }

    public static void createData () {
        /*
        DataForAll.demoMenuList.add(new Eat("Breakfast", "Milk", "Cookies", "Juice", "", "", ""));
        DataForAll.demoMenuList.add(new Eat("Lunch", "Soup", "Chicken", "Apple", "", "", ""));
        DataForAll.demoMenuList.add(new Eat("Dinner", "Rice", "Fish", "Orange", "", "", ""));
        */
        DailySchedule day1 = new DailySchedule();
        DailySchedule day2 = new DailySchedule();
        DailySchedule day3 = new DailySchedule();
        DailySchedule day4 = new DailySchedule();
        DailySchedule day5 = new DailySchedule();
        DailySchedule day6 = new DailySchedule();
        DailySchedule day7 = new DailySchedule();

        // Breakfast
        ArrayList<Ingredient> ingredientsMilk = new ArrayList<>();
        ingredientsMilk.add(new Ingredient("milk", 0.5));
        Dish milk = new Dish("Milk", "@drawable/llet", 0.2, ingredientsMilk, "");

        ArrayList<Ingredient> ingredientsCookies = new ArrayList<>();
        ingredientsCookies.add(new Ingredient("cookies", 0.1));
        Dish cookies = new Dish("Cookies", "@drawable/galetes", 0.2, ingredientsCookies, "");

        ArrayList<Ingredient> ingredientsOrangeJuice = new ArrayList<>();
        ingredientsOrangeJuice.add(new Ingredient("orange juice", 0.1));
        Dish orangeJuice = new Dish("Orange juice", "@drawable/suc_pressec", 0.2, ingredientsOrangeJuice, "");

        ArrayList<Ingredient> ingredientsAppleJuice = new ArrayList<>();
        ingredientsAppleJuice.add(new Ingredient("apple juice", 0.1));
        Dish appleJuice = new Dish("Apple juice", "@drawable/suc_poma", 0.2, ingredientsAppleJuice, "");

        // Lunch or dinner
        ArrayList<Ingredient> ingredientsSoup = new ArrayList<>();
        ingredientsSoup.add(new Ingredient("caldo de pollastre", 1));
        ingredientsSoup.add(new Ingredient("galets", 0.2));
        Dish soup = new Dish("Soup", "@drawable/sopa", 10, ingredientsSoup, "Boil during 10 min");

        ArrayList<Ingredient> ingredientsCousCous = new ArrayList<>();
        ingredientsCousCous.add(new Ingredient("cous-cous", 0.4));
        ingredientsCousCous.add(new Ingredient("bacon", 0.1));
        ingredientsCousCous.add(new Ingredient("pastanaga", 0.5));
        ingredientsCousCous.add(new Ingredient("carbasso", 0.5));
        Dish cousCous = new Dish("Cous-cous", "@drawable/cous_cous", 15, ingredientsCousCous, "Put all on a paella");

        ArrayList<Ingredient> ingredientsFideua = new ArrayList<>();
        ingredientsFideua.add(new Ingredient("caldo de peix", 1));
        ingredientsFideua.add(new Ingredient("fideus", 0.3));
        Dish fideua = new Dish("Fideua", "@drawable/fideua", 30, ingredientsFideua, "Put the noodles on a paella and then add the stock");

        ArrayList<Ingredient> ingredientsHamburguer = new ArrayList<>();
        ingredientsHamburguer.add(new Ingredient("hamburguesa", 0.2));
        ingredientsHamburguer.add(new Ingredient("ceba", 0.2));
        ingredientsHamburguer.add(new Ingredient("ous", 0.2));
        Dish hamburguer = new Dish("Hamburguer", "@drawable/hamburguesa", 20, ingredientsHamburguer, "Cook all the food");

        ArrayList<Ingredient> ingredientsOmelet = new ArrayList<>();
        ingredientsOmelet.add(new Ingredient("patates", 0.4));
        ingredientsOmelet.add(new Ingredient("ceba", 0.2));
        ingredientsOmelet.add(new Ingredient("ous", 0.2));
        Dish omelet = new Dish("Omelet", "@drawable/truita", 15, ingredientsOmelet, "Put the potatoes and the onion on the food" +
                "and then add the eggs");

        ArrayList<Ingredient> ingredientsApple = new ArrayList<>();
        ingredientsApple.add(new Ingredient("apple", 0.2));
        Dish apple = new Dish("Apple", "@drawable/poma", 0.3, ingredientsApple, "");

        ArrayList<Ingredient> ingredientsYogurt = new ArrayList<>();
        ingredientsYogurt.add(new Ingredient("yogurt", 0.2));
        Dish yogurt = new Dish("Yougurt", "@drawable/iogurt", 0.3, ingredientsYogurt, "");

        day1.setBreakfast(new Eat(DataForAll.breakfast, milk, cookies, orangeJuice));
        day2.setBreakfast(new Eat(DataForAll.breakfast, milk, cookies, appleJuice));
        day3.setBreakfast(new Eat(DataForAll.breakfast, milk, cookies, appleJuice));
        day4.setBreakfast(new Eat(DataForAll.breakfast, milk, cookies, orangeJuice));
        day5.setBreakfast(new Eat(DataForAll.breakfast, milk, cookies, appleJuice));
        day6.setBreakfast(new Eat(DataForAll.breakfast, milk, cookies, orangeJuice));
        day7.setBreakfast(new Eat(DataForAll.breakfast, milk, cookies, orangeJuice));

        day1.setLunch(new Eat(DataForAll.lunch, soup, hamburguer, apple));
        day2.setLunch(new Eat(DataForAll.lunch, fideua, hamburguer, yogurt));
        day3.setLunch(new Eat(DataForAll.lunch, soup, omelet, yogurt));
        day4.setLunch(new Eat(DataForAll.lunch, fideua, omelet, apple));
        day5.setLunch(new Eat(DataForAll.lunch, soup, omelet, apple));
        day6.setLunch(new Eat(DataForAll.lunch, cousCous, hamburguer, yogurt));
        day7.setLunch(new Eat(DataForAll.lunch, fideua, omelet, apple));

        day1.setDinner(new Eat(DataForAll.dinner, cousCous, omelet, yogurt));
        day2.setDinner(new Eat(DataForAll.dinner, soup, omelet, yogurt));
        day3.setDinner(new Eat(DataForAll.dinner, cousCous, hamburguer, apple));
        day4.setDinner(new Eat(DataForAll.dinner, soup, hamburguer, yogurt));
        day5.setDinner(new Eat(DataForAll.dinner, cousCous, omelet, yogurt));
        day6.setDinner(new Eat(DataForAll.dinner, soup, omelet, apple));
        day7.setDinner(new Eat(DataForAll.dinner, cousCous, hamburguer, yogurt));

        DataForAll.weeklySchedule.put(Calendar.getInstance().get(Calendar.DAY_OF_YEAR), day1);
        DataForAll.weeklySchedule.put(Calendar.getInstance().get(Calendar.DAY_OF_YEAR)+1, day2);
        DataForAll.weeklySchedule.put(Calendar.getInstance().get(Calendar.DAY_OF_YEAR)+2, day3);
        DataForAll.weeklySchedule.put(Calendar.getInstance().get(Calendar.DAY_OF_YEAR)+3, day4);
        DataForAll.weeklySchedule.put(Calendar.getInstance().get(Calendar.DAY_OF_YEAR)+4, day5);
        DataForAll.weeklySchedule.put(Calendar.getInstance().get(Calendar.DAY_OF_YEAR)+5, day6);
        DataForAll.weeklySchedule.put(Calendar.getInstance().get(Calendar.DAY_OF_YEAR)+6, day7);

    }
}
