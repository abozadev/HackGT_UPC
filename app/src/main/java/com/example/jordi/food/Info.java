package com.example.jordi.food;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jordi.food.Adapters.Dish;
import com.example.jordi.food.Adapters.Ingredient;


public class Info extends ActionBarActivity {

    private Dish dish;
    private TextView title;
    private ImageView imageView;
    private TextView listIngredients;
    private TextView listIntructions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        initVariables();

    }

    private void initVariables () {
        dish = DataForAll.selectedDish;
        title = (TextView) findViewById(R.id.title);
        title.setText(dish.getName());
        imageView = (ImageView) findViewById(R.id.imgDish);
        listIngredients = (TextView) findViewById(R.id.textIngredients);
        String strIngredients = new String();
        for (Ingredient auxIng : dish.getIngredients()) {
            strIngredients = strIngredients + "- " + auxIng.getName() + "\n";
        }
        listIngredients.setText(strIngredients);
        listIntructions = (TextView) findViewById(R.id.explanationCook);
        listIntructions.setText(dish.getHowToCook());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_info, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
