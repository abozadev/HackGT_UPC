package com.example.jordi.food;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;


public class Info extends ActionBarActivity {

    private String dishName;
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
        Intent intent = getIntent();
        dishName = intent.getStringExtra("name");
        title = (TextView) findViewById(R.id.title);
        title.setText(dishName);
        imageView = (ImageView) findViewById(R.id.imgDish);
        listIngredients = (TextView) findViewById(R.id.textIngredients);
        listIntructions = (TextView) findViewById(R.id.explanationCook);
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
