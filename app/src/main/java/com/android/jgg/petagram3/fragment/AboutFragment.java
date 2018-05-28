package com.android.jgg.petagram3.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.support.v4.app.Fragment;

import com.android.jgg.petagram3.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class AboutFragment extends android.support.v4.app.Fragment {


    public AboutFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_about, container, false);
        View v = inflater.inflate(R.layout.fragment_recyclerview, container, false);
        return v;

    }

}
