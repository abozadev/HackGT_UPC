package com.example.jordi.food.ActivityForResult;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.jordi.food.DataForAll;
import com.example.jordi.food.R;

import java.util.ArrayList;

public class ManageLikes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_likes);

        final EditText editText = (EditText) findViewById(R.id.addLike);
        Button addButton = (Button) findViewById(R.id.buttonAddLike);
        ListView listView = (ListView) findViewById(R.id.manageLikeList);
        final ArrayList<String> listItems = new ArrayList<>(DataForAll.setLikes);
        //listItems.add("First Item - added on Activity Create");
        //TODO ADD ITEMS TO LIST FROM DATA

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, listItems);
        listView.setAdapter(adapter);

        Button saveButton = (Button) findViewById(R.id.buttonSaveLike);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent data = new Intent();
                data.putExtra("likes", listItems);
                setResult(RESULT_OK, data);
                for (String like : listItems) {
                    DataForAll.setLikes.add(like);
                }
                finish();
            }
        });

        Button cancelButton = (Button) findViewById(R.id.buttonCancelLike);

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

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){

            @Override
            public boolean onItemLongClick(AdapterView<?> av, View v, final int pos, long id)
            {
                DataForAll.setLikes.remove(listItems.get(pos));
                listItems.remove(pos);
                adapter.notifyDataSetChanged();
                /*
                AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
                builder.setMessage("Do you want to remove " + listItems.get(pos) + "?")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                DataForAll.setLikes.remove(listItems.get(pos));
                                listItems.remove(pos);
                                adapter.notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // User cancelled the dialog
                            }
                        }).setIcon(android.R.drawable.ic_dialog_alert).create().show();
                 */


                return false;
            }
        });
    }



}
