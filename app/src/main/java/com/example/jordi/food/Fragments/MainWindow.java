package com.example.jordi.food.Fragments;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.jordi.food.Adapters.AdapterEat;
import com.example.jordi.food.Adapters.Eat;
import com.example.jordi.food.DataForAll;
import com.example.jordi.food.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MainWindow.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MainWindow#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainWindow extends Fragment {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private int offsetDay;

    private TextView textDate;
    private AdapterEat adapterEat;
    private ArrayList<Eat> listEat;
    private ListView listView;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MainWindow.
     */
    // TODO: Rename and change types and number of parameters
    public static MainWindow newInstance(String param1, String param2) {
        MainWindow fragment = new MainWindow(0);
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public MainWindow(int offsetDay) {
        // Required empty public constructor
        this.offsetDay = offsetDay;
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
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initVariables(view);
    }

    private String createDate () {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(calendar.getTimeInMillis() + offsetDay*24*3600*1000); // adding one day, if necessary
        String[] daysOfWeek = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "Septembet",
                "October", "November", "December"};
        return "" + daysOfWeek[calendar.get(Calendar.DAY_OF_WEEK)-1] + ", " + calendar.get(Calendar.DAY_OF_MONTH) +
                " " + months[calendar.get(Calendar.MONTH)-1] + " " + calendar.get(Calendar.YEAR);
    }

    private void initVariables (View view) {
        textDate = (TextView) view.findViewById(R.id.date);
        textDate.setText(createDate());
        listEat = new ArrayList<>();
        listEat.add(DataForAll.weeklySchedule.get(Calendar.getInstance().get(Calendar.DAY_OF_YEAR)+offsetDay).getBreakfast());
        listEat.add(DataForAll.weeklySchedule.get(Calendar.getInstance().get(Calendar.DAY_OF_YEAR)+offsetDay).getLunch());
        listEat.add(DataForAll.weeklySchedule.get(Calendar.getInstance().get(Calendar.DAY_OF_YEAR)+offsetDay).getDinner());
        Log.i("length listEat", "" + listEat.size());
        adapterEat = new AdapterEat(this.getActivity(), listEat);
        listView = (ListView) view.findViewById(R.id.listMainMenu);
        listView.setAdapter(adapterEat);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_window, container, false);
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
        public void onFragmentInteraction(Uri uri);
    }

}
