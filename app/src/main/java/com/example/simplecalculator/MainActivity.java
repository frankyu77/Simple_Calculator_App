package com.example.simplecalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<String> calculation = new ArrayList<>();
    private double currentNumber = 0;
    private double previousNumber = 0;
    private double rsf = 0;
    private String currentOperation;

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
                previousNumber = 0;
                currentNumber = 0;
                currentOperation = "";
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
                currentOperation = "+";
                operationClicked();
            }
        });

        subtractButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentOperation = "-";
                operationClicked();
            }
        });

        multiplyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentOperation = "*";
                operationClicked();
            }
        });

        divisionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentOperation = "/";
                operationClicked();
            }
        });

        equalsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentOperation == "+") { // ONLY FOR PLUS BUTTON RN
                    setCurrentNumber();
                    rsf = previousNumber + currentNumber;
                    printResult(rsf);
                } else if (currentOperation == "-") {
                    setCurrentNumber();
                    rsf = previousNumber - currentNumber;
                    printResult(rsf);
                } else if (currentOperation == "*") {
                    setCurrentNumber();
                    rsf = previousNumber * currentNumber;
                    printResult(rsf);
                } else if (currentOperation == "/") {
                    setCurrentNumber();
                    rsf = previousNumber / currentNumber;
                    printResult(rsf);
                } else {
                    answer.setText("Error");
                }
            }
        });
    }

    //creates the numbers and sets the answer TextView to the number inputed
    private void displayingNumbers(Button button, String num) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculation.add(num);
                String result = getNumber();
                //result = creatingNumbers(num);
                answer.setText(result);
            }
        });
    }

    //sets currentNumber when equal sign is clicked
    private void setCurrentNumber() {
        String result = getNumber();
        currentNumber = Double.parseDouble(result);
    }

    //sets previousNumber when an operation is clicked
    private void operationClicked() {
        String result = getNumber();
        previousNumber = Double.parseDouble(result);

        calculation.clear();
        answer.setText("0");
    }

    //prints the result after the equals button is pressed
    private void printResult(double r) {
        calculation.clear();
        calculation.add(Double.toString(r));

        DecimalFormat format = new DecimalFormat("0.#");
        answer.setText(format.format(r));
    }

    // brings the numbers inputted together into one number
    @NonNull
    private String getNumber() {
        String result = "";
        for (int i = 0; i < calculation.size(); i++) {
            result += calculation.get(i);
        }
        return result;
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