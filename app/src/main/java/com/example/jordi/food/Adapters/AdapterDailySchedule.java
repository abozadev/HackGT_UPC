package com.example.jordi.food.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.jordi.food.R;

import java.util.List;

/**
 * Created by jordi on 21/07/16.
 */
public class AdapterDailySchedule extends ArrayAdapter<DailySchedule> {

    public AdapterDailySchedule (Context context, List<DailySchedule> data) {
        super(context, R.layout.layout_daily_schedule, data);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View row = inflater.inflate(R.layout.layout_eat, parent, false);
        final DailySchedule dailySchedule = getItem(position);

        TextView breakfastFirstDish = (TextView) row.findViewById(R.id.breakfastFirstDish);
        TextView breakfastSecondDish = (TextView) row.findViewById(R.id.breakfastSecondDish);
        TextView breakfastThirdDish = (TextView) row.findViewById(R.id.breakfastThirdDish);
        TextView lunchFirstDish = (TextView) row.findViewById(R.id.lunchFirstDish);
        TextView lunchSecondDish = (TextView) row.findViewById(R.id.lunchSecondDish);
        TextView lunchThirdDish = (TextView) row.findViewById(R.id.lunchThirdDish);
        TextView dinnerFirstDish = (TextView) row.findViewById(R.id.dinnerFirstDish);
        TextView dinnerSecondDish = (TextView) row.findViewById(R.id.dinnerSecondDish);
        TextView dinnerThirdDish = (TextView) row.findViewById(R.id.dinnerThirdDish);

        breakfastFirstDish.setText(dailySchedule.getBreakfast().getFirstDish().getName());
        breakfastSecondDish.setText(dailySchedule.getBreakfast().getSecondDish().getName());
        breakfastThirdDish.setText(dailySchedule.getBreakfast().getThirdDish().getName());
        lunchFirstDish.setText(dailySchedule.getLunch().getFirstDish().getName());
        lunchSecondDish.setText(dailySchedule.getLunch().getSecondDish().getName());
        lunchThirdDish.setText(dailySchedule.getLunch().getThirdDish().getName());
        dinnerFirstDish.setText(dailySchedule.getDinner().getFirstDish().getName());
        dinnerSecondDish.setText(dailySchedule.getDinner().getSecondDish().getName());
        dinnerThirdDish.setText(dailySchedule.getDinner().getThirdDish().getName());

        return row;
    }
}
