package com.example.jordi.food;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by august on 22/07/16.
 */
public class CustomDialog extends Dialog implements View.OnClickListener {

    public Activity c;
    public Dialog d;
    public Button yes;
    int  year, month, day;
    List<String> spinnerArray =  new ArrayList<String>();

    public CustomDialog(Activity a) {
        super(a);
        // TODO Auto-generated constructor stub
        this.c = a;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.custom_dialog);
        Button yes = (Button) findViewById(R.id.buttonOrder2);
        yes.setOnClickListener(this);

        Calendar calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        String curDate = new String(day+"/"+month+"/"+year);
        spinnerArray.add(curDate);

        for (int i = 0; i < 6; ++i) {
            try {
                curDate = getNextDate(curDate);
                spinnerArray.add(curDate);
            }
            catch (Exception e) {

            }
        }

        Spinner sOrder = (Spinner) findViewById(R.id.spinnerOrderDate);

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                c.getApplicationContext(), android.R.layout.simple_spinner_item, spinnerArray);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sOrder.setAdapter(adapter);

        sOrder.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> parentView,
                                       View selectedItemView, int position, long id) {
                // Object item = parentView.getItemAtPosition(position);
                adapter.notifyDataSetChanged();
            }

            public void onNothingSelected(AdapterView<?> arg0) {// do nothing
            }

        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button2:
                Toast.makeText(c,"Order send",Toast.LENGTH_LONG).show();
                c.finish();
                break;
            default:
                break;
        }
        dismiss();
    }


    public static String getNextDate(String  curDate) throws Exception {
        final SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        final Date date = format.parse(curDate);
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        return format.format(calendar.getTime());
    }
}
