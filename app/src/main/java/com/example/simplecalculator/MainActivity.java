package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<String> calculation = new ArrayList<>();
    private int rsf = 0;

    private TextView answer;
    private Button clearButton;
    private Button negativeButton;  //do last
    private Button percentageButton;  //do last

    private Button divisionButton;
    private Button multiplyButton;
    private Button subtractButton;
    private Button addButton;
    private Button equalsButton;
    private Button decimal;

    private Button zero;
    private Button one;
    private Button two;
    private Button three;
    private Button four;
    private Button five;
    private Button six;
    private Button seven;
    private Button eight;
    private Button nine;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUp();

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculation = new ArrayList<>();
                answer.setText("0");
            }
        });

        displayingNumbers(zero, "0");
        displayingNumbers(one, "1");
        displayingNumbers(two, "2");
        displayingNumbers(three, "3");
        displayingNumbers(four, "4");
        displayingNumbers(five, "5");
        displayingNumbers(six, "6");
        displayingNumbers(seven, "7");
        displayingNumbers(eight, "8");
        displayingNumbers(nine, "9");

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculation.add("+");
            }
        });
    }

    //creates the numbers and sets the answer TextView to the number inputed
    private void displayingNumbers(Button button, String num) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String result;
                result = Integer.toString(creatingNumbers(num));
                answer.setText(result);
            }
        });
    }

    //returns all numbers inputted before an operation
    private int creatingNumbers(String num) {
        String numInputed = "";
        calculation.add(num);

        for (int i = 0; i < calculation.size(); i++) {
            if (calculation.get(i) == "+" || calculation.get(i) == "-" ||
                    calculation.get(i) == "*" || calculation.get(i) == "/") {
                calculation.clear();
                calculation.add(Integer.toString(this.rsf));
                calculation.add("+");

                testing();

            } else  {
                numInputed += calculation.get(i);
                this.rsf = Integer.parseInt(numInputed);
            }
        }

        return this.rsf;
    }

    private void testing() {
        String string = "";
        for (int i = 0; i < calculation.size(); i++) {
            string += calculation.get(i);
        }

        Log.d("HELLO", string);
    }

    //assign all the buttons/textview to the private variables above
    private void setUp() {
        answer = (TextView) findViewById(R.id.answer);

        clearButton = (Button) findViewById(R.id.clearbutton);
        negativeButton = (Button) findViewById(R.id.negativesignbutton);
        percentageButton = (Button) findViewById(R.id.percentagebutton);
        divisionButton = (Button) findViewById(R.id.divisionbutton);
        multiplyButton = (Button) findViewById(R.id.timesbutton);
        subtractButton = (Button) findViewById(R.id.minusbutton);
        addButton = (Button) findViewById(R.id.plusbutton);
        equalsButton = (Button) findViewById(R.id.equalsbutton);
        decimal = (Button) findViewById(R.id.periodbutton);

        zero = (Button) findViewById(R.id.button0);
        one = (Button) findViewById(R.id.button1);
        two = (Button) findViewById(R.id.button2);
        three = (Button) findViewById(R.id.button3);
        four = (Button) findViewById(R.id.button4);
        five = (Button) findViewById(R.id.button5);
        six = (Button) findViewById(R.id.button6);
        seven = (Button) findViewById(R.id.button7);
        eight = (Button) findViewById(R.id.button8);
        nine = (Button) findViewById(R.id.button9);
    }

}