package com.example.jordi.food.Fragments;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.jordi.food.CustomDialog;
import com.example.jordi.food.DataForAll;
import com.example.jordi.food.MapsActivity;
import com.example.jordi.food.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FoodSupplyWindow.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FoodSupplyWindow#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FoodSupplyWindow extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private int ini = 0;
    private int fin = 6;
    List<String> spinnerArray =  new ArrayList<String>();

    private ArrayList<String> listItems;

    int  year, month, day;

    private OnFragmentInteractionListener mListener;

    private Spinner from, to;
    public FoodSupplyWindow() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FoodSupplyWindow.
     */
    // TODO: Rename and change types and number of parameters
    public static FoodSupplyWindow newInstance(String param1, String param2) {
        FoodSupplyWindow fragment = new FoodSupplyWindow();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_food_suply_window, container, false);

        from = (Spinner) view.findViewById(R.id.spinnerFrom);

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

        Button openMap = (Button) view.findViewById(R.id.buttonOpenMap);


        openMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), MapsActivity.class);
                startActivity(i);
            }
        });

        Button openOrder = (Button) view.findViewById(R.id.buttonOrder);


        openOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomDialog cdd = new CustomDialog(getActivity());
                cdd.show();
            }
        });




        listItems = DataForAll.getAllIngredients(ini,fin);

        final ListView listView = (ListView) view.findViewById(R.id.listIngredients);


        final ArrayAdapter<String> adapterIngredients = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, listItems);
        listView.setAdapter(adapterIngredients);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getActivity(), android.R.layout.simple_spinner_item, spinnerArray);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        from = (Spinner) view.findViewById(R.id.spinnerFrom);
        to = (Spinner) view.findViewById(R.id.spinnerTo);
        from.setAdapter(adapter);
        to.setAdapter(adapter);

        from.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> parentView,
                                       View selectedItemView, int position, long id) {
                // Object item = parentView.getItemAtPosition(position);

                ini = from.getSelectedItemPosition();
                listItems.clear();
                listItems = DataForAll.getAllIngredients(ini,fin);
                ArrayAdapter<String> adapterIngredients = new ArrayAdapter<String>(getActivity(),
                        android.R.layout.simple_list_item_1, listItems);
                listView.setAdapter(adapterIngredients);
            }

            public void onNothingSelected(AdapterView<?> arg0) {// do nothing
            }

        });

        to.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> parentView,
                                       View selectedItemView, int position, long id) {
                // Object item = parentView.getItemAtPosition(position);

                fin = to.getSelectedItemPosition();
                listItems.clear();
                listItems = DataForAll.getAllIngredients(ini,fin);
                ArrayAdapter<String> adapterIngredients = new ArrayAdapter<String>(getActivity(),
                        android.R.layout.simple_list_item_1, listItems);
                listView.setAdapter(adapterIngredients);

            }

            public void onNothingSelected(AdapterView<?> arg0) {// do nothing
            }

        });



        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
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
