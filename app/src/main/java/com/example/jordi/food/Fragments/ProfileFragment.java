package com.example.jordi.food.Fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jordi.food.ActivityForResult.ManageDislikes;
import com.example.jordi.food.ActivityForResult.ManageLikes;
import com.example.jordi.food.DataForAll;
import com.example.jordi.food.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ProfileFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    static final int MANAGE_LIKES_REQUEST = 1;
    static final int MANAGE_DISLIKES_REQUEST = 2;

    public static final int RESULT_CANCELED    = 0;
    /** Standard activity result: operation succeeded. */
    public static final int RESULT_OK           = -1;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    private SharedPreferences sharedPref;

    private TextView textName;
    private TextView textEmail;

    public ProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
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
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        Button button = (Button) view.findViewById(R.id.buttonManageLike);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //TODO Manage like
                Intent intent = new Intent(getActivity(), ManageLikes.class);
                startActivityForResult(intent, MANAGE_LIKES_REQUEST);
            }
        });

        Button button2 = (Button) view.findViewById(R.id.buttonManageDislike);
        button2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //TODO Manage dislike
                Intent intent = new Intent(getActivity(), ManageDislikes.class);
                startActivityForResult(intent, MANAGE_DISLIKES_REQUEST);
            }
        });

        Button buttonSave = (Button) view.findViewById(R.id.buttonSave);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataForAll.userName = textName.getText().toString();
                DataForAll.email = textEmail.getText().toString();
                Toast.makeText(getActivity(), "Saved", Toast.LENGTH_SHORT).show();
            }
        });

        textName = (TextView) view.findViewById(R.id.textName);
        textEmail = (TextView) view.findViewById(R.id.textEmail);
        if (DataForAll.userName.length() > 0) {
            textName.setText(DataForAll.userName);
        }
        if (DataForAll.email.length() > 0) {
            textEmail.setText(DataForAll.email);
        }
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

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check which request we're responding to
        if (requestCode == MANAGE_LIKES_REQUEST) {
            // Make sure the request was successful
            if (resultCode == RESULT_OK) {
                //TODO SAVE LIKES DATA
            }
        }

        if (requestCode == MANAGE_DISLIKES_REQUEST) {
            // Make sure the request was successful
            if (resultCode == RESULT_OK) {
                //TODO SAVE DISLIKES DATA
            }
        }
    }

}
