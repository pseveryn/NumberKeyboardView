package com.acollider.calculator;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CalculatorView calculatorView = new CalculatorView(this);
        calculatorView.setShowSpaces(true);

        FrameLayout contentView = (FrameLayout)findViewById(R.id.content_view);
        contentView.addView(calculatorView);
    }

}
