package com.example.android.android.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.mariuszgromada.math.mxparser.*;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getName();
    TextView inputTextView;
    TextView ansTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button oneButton = (Button) findViewById(R.id.button_1);
        oneButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Log.v(LOG_TAG, "user hits 1");
                writeEqn("1");
            }
        });
        Button twoButton = (Button) findViewById(R.id.button_2);
        twoButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Log.v(LOG_TAG, "user hits 2");
                writeEqn("2");
            }
        });
        Button threeButton = (Button) findViewById(R.id.button_3);
        threeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Log.v(LOG_TAG, "user hits 3");
                writeEqn("3");
            }
        });
        Button fourButton = (Button) findViewById(R.id.button_4);
        fourButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Log.v(LOG_TAG, "user hits 4");
                writeEqn("4");
            }
        });
        Button fiveButton = (Button) findViewById(R.id.button_5);
        fiveButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Log.v(LOG_TAG, "user hits 5");
                writeEqn("5");
            }
        });
        Button sixButton = (Button) findViewById(R.id.button_6);
        sixButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Log.v(LOG_TAG, "user hits 6");
                writeEqn("6");
            }
        });
        Button svnButton = (Button) findViewById(R.id.button_7);
        svnButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Log.v(LOG_TAG, "user hits 7");
                writeEqn("7");
            }
        });
        Button ehtButton = (Button) findViewById(R.id.button_8);
        ehtButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Log.v(LOG_TAG, "user hits 8");
                writeEqn("8");
            }
        });
        Button nineButton = (Button) findViewById(R.id.button_9);
        nineButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Log.v(LOG_TAG, "user hits 9");
                writeEqn("9");
            }
        });
        Button clearButton = (Button) findViewById(R.id.button_clear);
        clearButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Log.v(LOG_TAG, "user hits C");
                clearScreen();
            }
        });
        Button divisionButton = (Button) findViewById(R.id.button_divide);
        divisionButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Log.v(LOG_TAG, "user hits /");
                writeEqn("/");
            }
        });
        Button multiplyButton = (Button) findViewById(R.id.button_multiply);
        multiplyButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Log.v(LOG_TAG, "user hits x");
                writeEqn("*");
            }
        });
        Button addButton = (Button) findViewById(R.id.button_add);
        addButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Log.v(LOG_TAG, "user hits +");
                writeEqn("+");
            }
        });
        Button minusButton = (Button) findViewById(R.id.button_minus);
        minusButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Log.v(LOG_TAG, "user hits -");
                writeEqn("-");
            }
        });
        Button equalsButton = (Button) findViewById(R.id.button_equals);
        equalsButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Log.v(LOG_TAG, "user hits =");
                inputTextView = (TextView) findViewById(R.id.input_bar);
                String eqnString = inputTextView.getText().toString();

                Expression e = new Expression(eqnString);
                String ans = String.valueOf(e.calculate());
                ansTextView = (TextView) findViewById(R.id.ans_bar);
                ansTextView.setText(ans);
            }
        });
        Button zeroButton = (Button) findViewById(R.id.button_0);
        zeroButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Log.v(LOG_TAG, "user hits 0");
                writeEqn("0");
            }
        });
        Button Button_00 = (Button) findViewById(R.id.button_00);
        Button_00.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Log.v(LOG_TAG, "user hits 00");
                writeEqn("00");
            }
        });
        Button decimalButton = (Button) findViewById(R.id.button_decimal);
        decimalButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Log.v(LOG_TAG, "user hits .");
                writeEqn(".");
            }
        });
    }

    private boolean checkEqn(String eqn){
        int flag = 0;

        for(int i = 0; i < eqn.length() - 1; i++){
            if((eqn.charAt(i) == '+' || eqn.charAt(i) == '-' || eqn.charAt(i) == '/'
                    || eqn.charAt(i) == '*') && (eqn.charAt(i+1) == '+' || eqn.charAt(i+1) == '-'
                    || eqn.charAt(i+1) == '/' || eqn.charAt(i+1) == '*')){
                Log.e(LOG_TAG,"Malformed equation");
                flag = 1;
                break;
            }

            else if(eqn.charAt(0) == '+' || eqn.charAt(0) == '-' ||
                    eqn.charAt(0) == '/' || eqn.charAt(0) == '*'){
                Log.e(LOG_TAG,"Malformed equation");
                flag = 1;
                break;
            }
        }
        if(flag == 0)
            return true;
        else
            return false;
    }

    private void writeEqn(String value){
        inputTextView = (TextView) findViewById(R.id.input_bar);
        String eqnString = inputTextView.getText().toString();
        eqnString += value;
        inputTextView.setText(eqnString);
        if(checkEqn(eqnString) == true){
            Log.v(LOG_TAG, eqnString);
            inputTextView.setText(eqnString);
        }else{
            Toast.makeText(getApplicationContext(),"Malformed input",Toast.LENGTH_SHORT).show();
        }
    }

    private void clearScreen(){
        inputTextView = (TextView) findViewById(R.id.input_bar);
        inputTextView.setText("");
        ansTextView = (TextView) findViewById(R.id.ans_bar);
        ansTextView.setText("0");
    }
}
