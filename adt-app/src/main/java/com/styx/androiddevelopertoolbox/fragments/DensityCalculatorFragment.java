package com.styx.androiddevelopertoolbox.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.styx.androiddevelopertoolbox.R;
import com.styx.androiddevelopertoolbox.utils.Utils;

/**
 * Created by amalg on 16-06-2016.
 */
public class DensityCalculatorFragment extends android.support.v4.app.Fragment {
    EditText mdpi_width, mdpi_height, hdpi_height, hdpi_width, retina_height, retina_width, xhdpi_height, xhdpi_width;

    public void setData(Utils.DensityCalculator.RES density) {
        Double height = 0.0, width = 0.0;
        if (density == Utils.DensityCalculator.RES.MDPI) {
            try {
                height = Double.parseDouble(mdpi_height.getText().toString());
                width = Double.parseDouble(mdpi_width.getText().toString());
            } catch (Exception e) {
                height = 0.0;
                width = 0.0;
            }
        } else if (density == Utils.DensityCalculator.RES.HDPI) {
            try {
                height = Double.parseDouble(hdpi_height.getText().toString());
                width = Double.parseDouble(hdpi_width.getText().toString());
            } catch (Exception e) {
                height = 0.0;
                width = 0.0;
            }
        } else if (density == Utils.DensityCalculator.RES.RETINA) {
            try {
                height = Double.parseDouble(retina_height.getText().toString());
                width = Double.parseDouble(retina_width.getText().toString());
            } catch (Exception e) {
                height = 0.0;
                width = 0.0;
            }
        } else if (density == Utils.DensityCalculator.RES.XHDPI) {
            try {
                height = Double.parseDouble(xhdpi_height.getText().toString());
                width = Double.parseDouble(xhdpi_width.getText().toString());
            } catch (Exception e) {
                height = 0.0;
                width = 0.0;
            }
        }
        Double[][] calculatedDensity = Utils.DensityCalculator.getDensity(density, height, width);
        mdpi_height.setText(String.valueOf(Math.round(calculatedDensity[0][0])));
        mdpi_width.setText(String.valueOf(Math.round(calculatedDensity[0][1])));

        hdpi_height.setText(String.valueOf(Math.round(calculatedDensity[1][0])));
        hdpi_width.setText(String.valueOf(Math.round(calculatedDensity[1][1])));


        retina_height.setText(String.valueOf(Math.round(calculatedDensity[2][0])));
        retina_width.setText(String.valueOf(Math.round(calculatedDensity[2][1])));

        xhdpi_height.setText(String.valueOf(Math.round(calculatedDensity[3][0])));
        xhdpi_width.setText(String.valueOf(Math.round(calculatedDensity[3][1])));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_densitycalculator, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        mdpi_height = (EditText) getActivity().findViewById(R.id.mdpi_height);
        mdpi_width = (EditText) getActivity().findViewById(R.id.mdpi_width);
        hdpi_height = (EditText) getActivity().findViewById(R.id.hdpi_height);
        hdpi_width = (EditText) getActivity().findViewById(R.id.hdpi_width);
        retina_height = (EditText) getActivity().findViewById(R.id.retina_height);
        retina_width = (EditText) getActivity().findViewById(R.id.retina_width);
        xhdpi_height = (EditText) getActivity().findViewById(R.id.xhdpi_height);
        xhdpi_width = (EditText) getActivity().findViewById(R.id.xhdpi_width);

        mdpi_height.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                setData(Utils.DensityCalculator.RES.MDPI);
            }
        });
        mdpi_width.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                setData(Utils.DensityCalculator.RES.MDPI);
            }
        });
        hdpi_height.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                setData(Utils.DensityCalculator.RES.HDPI);
            }
        });
        hdpi_width.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                setData(Utils.DensityCalculator.RES.HDPI);
            }
        });
        retina_height.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                setData(Utils.DensityCalculator.RES.RETINA);
            }
        });
        retina_width.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                setData(Utils.DensityCalculator.RES.RETINA);
            }
        });
        xhdpi_height.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                setData(Utils.DensityCalculator.RES.XHDPI);
            }
        });
        xhdpi_width.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                setData(Utils.DensityCalculator.RES.XHDPI);
            }
        });
        /* Minor Patch for changing values from IME OK button from soft keyboard on width buttons  */
        mdpi_width.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                setData(Utils.DensityCalculator.RES.MDPI);
                return false;
            }
        });
        hdpi_width.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                setData(Utils.DensityCalculator.RES.HDPI);
                return false;
            }
        });
        retina_width.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                setData(Utils.DensityCalculator.RES.RETINA);
                return false;
            }
        });
        xhdpi_width.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                setData(Utils.DensityCalculator.RES.XHDPI);
                return false;
            }
        });
    }

}