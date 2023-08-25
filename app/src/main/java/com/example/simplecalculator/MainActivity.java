package com.example.simplecalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

// CALCULATOR ROUNDS ALL DECIMALS TO ONE DECIMAL PLACE
public class MainActivity extends AppCompatActivity {
    private List<String> creatingNumbers = new ArrayList<>();
    private Calculation calculation = new Calculation();
    private double currentNumber = 0;
    private double previousNumber = 0;
    private double rsf = 0;
    //private String currentOperation;

    private EditText answerText;
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
                creatingNumbers.clear();
                calculation.clear();
                rsf = 0;
                answerText.setText("0");
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
        displayingNumbers(decimal, ".");

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operationClicked();
                calculation.addOperation("+");
            }
        });

        subtractButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operationClicked();
                calculation.addOperation("-");
            }
        });

        multiplyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operationClicked();
                calculation.addOperation("*");
            }
        });

        divisionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operationClicked();
                calculation.addOperation("/");
            }
        });

        equalsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setCurrentNumber();
                rsf = calculation.computeCalculation();
                printResult(rsf);
            }
        });

        negativeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                creatingNumbers.add(0, "-");
                String result = getNumber();
                creatingNumbers.clear();
                calculation.addNumber(result);
                answerText.setText(result);
            }
        });

        percentageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double actualResult;
                double result = Double.parseDouble(getNumber());
                actualResult = result / 100;
                creatingNumbers.clear();
                calculation.addNumber(Double.toString(actualResult));
                answerText.setText(Double.toString(actualResult));
            }
        });
    }

    //creates the numbers and sets the answer TextView to the number inputed
    private void displayingNumbers(Button button, String num) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                creatingNumbers.add(num);
                String result = getNumber();
                //result = creatingNumbers(num);
                answerText.setText(result);
            }
        });
    }

    //sets currentNumber when equal sign is clicked
    private void setCurrentNumber() {
        String result = getNumber();
        //currentNumber = Double.parseDouble(result);
        creatingNumbers.clear();
        calculation.addNumber(result);
    }

    //sets previousNumber when an operation is clicked
    private void operationClicked() {
        String result = getNumber();
        creatingNumbers.clear();

        if (result.length() != 0) {
            calculation.addNumber(result);
        }
        answerText.setText("0");
    }

    // brings the numbers inputted together into one number
    @NonNull
    private String getNumber() {
        String result = "";
        for (int i = 0; i < creatingNumbers.size(); i++) {
            result += creatingNumbers.get(i);
        }

        if (result.indexOf(".") != result.lastIndexOf(".")) {
            creatingNumbers.clear();
            calculation.clear();
            rsf = 0;
            answerText.setText("Error");
            return "Error";
        }

        return result;
    }

    //prints the result after the equals button is pressed
    private void printResult(double r) {
        creatingNumbers.clear();
        creatingNumbers.add(Double.toString(r));

        DecimalFormat format = new DecimalFormat("0.########");
        answerText.setText(format.format(r));
    }


    //assign all the buttons/textview to the private variables above
    private void setUp() {
        answerText = (EditText) findViewById(R.id.answer);

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