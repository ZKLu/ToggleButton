package com.samlu.togglebutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.samlu.togglebutton.view.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private ToggleButton toggleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
    }

    private void initUI() {
        toggleButton = (ToggleButton) findViewById(R.id.togglebutton);
        toggleButton.setSlideBackgroundResource(R.drawable.slide_background);
        toggleButton.setSwitchBackgroundResource(R.drawable.slide_background);
        toggleButton.setToggleState(ToggleButton.ToggleState.Open);
    }
}
