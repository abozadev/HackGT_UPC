package com.example.jordi.food.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.jordi.food.R;

import java.util.List;

/**
 * Created by jordi on 21/07/16.
 */
public class AdapterEat extends ArrayAdapter<Eat> {
    public AdapterEat(Context context, List<Eat> data) {
        super(context, R.layout.layout_eat, data);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View row = inflater.inflate(R.layout.layout_eat, parent, false);

        return row;
    }
}
