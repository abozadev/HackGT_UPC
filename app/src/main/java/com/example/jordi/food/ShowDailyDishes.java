package com.example.jordi.food;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.jordi.food.Adapters.AdapterEat;
import com.example.jordi.food.Adapters.Eat;

import java.util.ArrayList;
import java.util.Calendar;


public class ShowDailyDishes extends ActionBarActivity {

    private TextView textDate;
    private AdapterEat adapterEat;
    private ArrayList<Eat> listEat;
    private ListView listView;
    private int offsetDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_daily_dishes);
        initVariables();
    }

    private String createDate () {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(calendar.getTimeInMillis() + offsetDay*24*3600*1000); // adding one day, if necessary
        String[] daysOfWeek = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "Septembet",
                "October", "November", "December"};
        return "" + daysOfWeek[calendar.get(Calendar.DAY_OF_WEEK)-1] + ", " + calendar.get(Calendar.DAY_OF_MONTH) +
                " " + months[calendar.get(Calendar.MONTH)-1] + " " + calendar.get(Calendar.YEAR);
    }

    private void initVariables () {
        Intent intent = getIntent();
        offsetDay = intent.getIntExtra("offset", 0);
        textDate = (TextView) findViewById(R.id.date);
        textDate.setText(createDate());
        listEat = new ArrayList<>();
        listEat.add(DataForAll.weeklySchedule.get(Calendar.getInstance().get(Calendar.DAY_OF_YEAR)+offsetDay).getBreakfast());
        listEat.add(DataForAll.weeklySchedule.get(Calendar.getInstance().get(Calendar.DAY_OF_YEAR)+offsetDay).getLunch());
        listEat.add(DataForAll.weeklySchedule.get(Calendar.getInstance().get(Calendar.DAY_OF_YEAR)+offsetDay).getDinner());
        Log.i("length listEat", "" + listEat.size());
        adapterEat = new AdapterEat(getApplicationContext(), listEat);
        listView = (ListView) findViewById(R.id.listMainMenu);
        listView.setAdapter(adapterEat);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_show_daily_dishes, menu);
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
