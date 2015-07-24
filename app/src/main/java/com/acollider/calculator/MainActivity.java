package com.acollider.calculator;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.acollider.numberkeyboardview.CalculatorView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CalculatorView calculatorView = new CalculatorView(this);
        calculatorView.setShowSelectors(true);
        calculatorView.build();

        FrameLayout contentView = (FrameLayout)findViewById(R.id.content_view);
        contentView.addView(calculatorView);
    }

}
