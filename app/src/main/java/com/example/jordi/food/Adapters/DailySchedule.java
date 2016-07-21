package com.example.jordi.food.Adapters;

/**
 * Created by jordi on 21/07/16.
 */
public class DailySchedule {
    private Eat breakfast;
    private Eat lunch;
    private Eat dinner;

    public DailySchedule() {
        breakfast = new Eat();
        lunch = new Eat();
        dinner = new Eat();
    }

    public DailySchedule(Eat breakfast, Eat lunch, Eat dinner) {
        this.breakfast = breakfast;
        this.lunch = lunch;
        this.dinner = dinner;
    }

    public Eat getBreakfast() {
        return breakfast;
    }

    public void setBreakfast(Eat breakfast) {
        this.breakfast = breakfast;
    }

    public Eat getLunch() {
        return lunch;
    }

    public void setLunch(Eat lunch) {
        this.lunch = lunch;
    }

    public Eat getDinner() {
        return dinner;
    }

    public void setDinner(Eat dinner) {
        this.dinner = dinner;
    }
}
