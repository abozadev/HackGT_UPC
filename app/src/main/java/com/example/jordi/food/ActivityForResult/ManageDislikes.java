package com.example.jordi.food.ActivityForResult;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.jordi.food.R;

import java.util.ArrayList;

public class ManageDislikes extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_dislikes);

        final EditText editText = (EditText) findViewById(R.id.addDislike);
        Button addButton = (Button) findViewById(R.id.buttonAddDislike);
        ListView listView = (ListView) findViewById(R.id.manageDisLikeList);
        final ArrayList<String> listItems = new ArrayList<String>();
        //listItems.add("First Item - added on Activity Create");
        //TODO ADD ITEMS TO LIST FROM DATA

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, listItems);
        listView.setAdapter(adapter);

        Button saveButton = (Button) findViewById(R.id.buttonSaveDislike);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent data = new Intent();
                data.putExtra("likes", listItems);
                setResult(RESULT_OK, data);
                finish();
            }
        });

        Button cancelButton = (Button) findViewById(R.id.buttonCancelDislike);

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent data = new Intent();
                data.putExtra("likes", listItems);
                setResult(RESULT_CANCELED, data);
                finish();
            }
        });


        addButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                listItems.add(editText.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position,
                                    long id) {
                Toast.makeText(getApplicationContext(), "Clicked", Toast.LENGTH_LONG)
                        .show();
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(AdapterView<?> av, View v, int pos, long id) {
                listItems.remove(pos);
                adapter.notifyDataSetChanged();
                return false;
            }
        });
    }
}