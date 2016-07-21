package com.example.jordi.food;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.jordi.food.Fragments.MainWindow;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity implements MainWindow.OnFragmentInteractionListener{

    private DrawerLayout mDrawerLayout;
    private ArrayList<String> arrayMenu = new ArrayList<String>();
    private ListView listViewMenu;
    private ArrayAdapter<String> adapterMenu;
    private Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initVariables();
        funcioLlistaLateral();
    }

    /** Swaps fragments in the main content view */
    private void selectItem(int position) {
        // Create a new fragment and specify the planet to show based on position
        fragment = new MainWindow();
        Bundle args = new Bundle();
        Log.i("Position", "" + position);
        //args.putString("nomComanda", arrayMenu.get(position));
        //fragment.setArguments(args);

        // Insert the fragment by replacing any existing fragment
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if (fragment == null) {
            fragmentTransaction.add(R.id.content_frame, fragment);
        } else {
            fragmentTransaction.replace(R.id.content_frame, fragment);
        }
        fragmentTransaction.commit();

        // Highlight the selected item, update the title, and close the drawer
        listViewMenu.setItemChecked(position, true);
        Log.i("nomMenu", arrayMenu.get(position));
        CharSequence chsq = arrayMenu.get(position);
        if (chsq != null) {
            getSupportActionBar().setTitle(chsq);
        }
        mDrawerLayout.closeDrawer(listViewMenu);
    }

    private void funcioLlistaLateral () {
        listViewMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectItem(position);
            }
        });
    }

    private void initVariables () {
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);;
        arrayMenu = new ArrayList<String>();
        arrayMenu.add("Profile");
        arrayMenu.add("Today");
        arrayMenu.add("Tomorrow");
        arrayMenu.add("Food schedule");
        adapterMenu = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, arrayMenu);
        listViewMenu = (ListView) findViewById(R.id.left_drawer);;
        listViewMenu.setAdapter(adapterMenu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
