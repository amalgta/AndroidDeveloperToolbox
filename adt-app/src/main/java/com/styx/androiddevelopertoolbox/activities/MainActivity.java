package com.styx.androiddevelopertoolbox.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.styx.androiddevelopertoolbox.R;
import com.styx.androiddevelopertoolbox.utils.Utils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView hw=(TextView)findViewById(R.id.hello_text);
        hw.setText(new Utils().getTitle());
    }
}
