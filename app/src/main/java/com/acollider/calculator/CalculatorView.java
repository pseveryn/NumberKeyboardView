package com.acollider.calculator;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by s.parkhomenko on 16.07.2015.
 */
public class CalculatorView extends FrameLayout{
    private final static String[] values = new String[]{"1","2","3","4","5","6","7","8","9",",","0","Backsp"};
    private Context context;
    private TextView tvDisplay;
    private String integers = "0";
    private String hundredths = "00";
    private boolean workingWithIntegers = true;
    private int index;

    public CalculatorView(Context context) {
        super(context);
        this.context = context;
        initKeyboard();
    }

    private void initKeyboard(){
        View mainView =((LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.calculator_layout, this);

        LinearLayout keyBoardView1Row = (LinearLayout)mainView.findViewById(R.id.keyboard_1row);
        LinearLayout keyBoardView2Row = (LinearLayout)mainView.findViewById(R.id.keyboard_2row);
        LinearLayout keyBoardView3Row = (LinearLayout)mainView.findViewById(R.id.keyboard_3row);
        LinearLayout keyBoardView4Row = (LinearLayout)mainView.findViewById(R.id.keyboard_4row);
        LinearLayout[] rows = new LinearLayout[]{keyBoardView1Row,keyBoardView2Row,keyBoardView3Row,keyBoardView4Row};
        int rowIndex = 0;
        int j = 0;
        for (int i=0; i<values.length; i++){
            TextView btn = new TextView(context);
            TableRow.LayoutParams params = new TableRow.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT);
            params.weight=(float)0.33;
            btn.setTextSize(22);
            btn.setLayoutParams(params);
            btn.setGravity(Gravity.CENTER);
            btn.setText(values[i]);
            btn.setTag(values[i]);
            btn.setOnClickListener(clickListener);
            rows[rowIndex].addView(btn);
            j++;
            if (j==3){
                rowIndex++;
                j=0;
            }
        }
    }

    private View.OnClickListener clickListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            String input = (String)v.getTag();
            performInput(input);
        }
    };

    private void performInput(String input){
        if (input.equals(",")&&workingWithIntegers){
            workingWithIntegers = false;
        } else if (input.equals("Backsp")){

        } else {
            if (workingWithIntegers){
                addNumber(integers);
            } else {
                addNumber(hundredths);
            }
        }
    }

    private void addNumber(integers){

    }

}
