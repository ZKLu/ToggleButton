package com.samlu.togglebutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

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
        toggleButton.setSlideBackgroundResource(R.drawable.slide_icon);
        toggleButton.setSwitchBackgroundResource(R.drawable.slide_background);
        toggleButton.setToggleState(ToggleButton.ToggleState.Open);

        toggleButton.setOnToggleStateChangeListener(new ToggleButton.OnToggleStateChangeListener() {
            @Override
            public void onToggleStateChange(ToggleButton.ToggleState state) {
                Toast.makeText(getApplicationContext(),state == ToggleButton.ToggleState.Open?"开启":"关闭",
                        Toast.LENGTH_LONG);
            }
        });
    }
}
