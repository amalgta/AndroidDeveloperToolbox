package com.styx.androiddevelopertoolbox.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.styx.androiddevelopertoolbox.R;

/**
 * Created by amalg on 16-06-2016.
 */
public class HomeFragment extends android.support.v4.app.Fragment {

    //Overriden method onCreateView
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //Returning the layout file after inflating
        //Change R.layout.tab1 in you classes
        return inflater.inflate(R.layout.fragment_main, container, false);
    }
}