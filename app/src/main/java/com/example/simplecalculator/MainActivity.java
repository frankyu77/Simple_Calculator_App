package com.example.simplecalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

// CALCULATOR ROUNDS ALL DECIMALS TO ONE DECIMAL PLACE
public class MainActivity extends AppCompatActivity {
    private List<String> creatingNumbers = new ArrayList<>();
    private List<String> calculation = new ArrayList<>();
    private double currentNumber = 0;
    private double previousNumber = 0;
    private double rsf = 0;
    //private String currentOperation;

    private EditText answer;
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
                creatingNumbers = new ArrayList<>();
                calculation = new ArrayList<>();
                previousNumber = 0;
                currentNumber = 0;
                //currentOperation = "";
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
        displayingNumbers(decimal, ".");

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //currentOperation = "+";
                operationClicked();
                calculation.add("+");
            }
        });

        subtractButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //currentOperation = "-";
                operationClicked();
                calculation.add("-");
            }
        });

        multiplyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //currentOperation = "*";
                operationClicked();
                calculation.add("*");
            }
        });

        divisionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //currentOperation = "/";
                operationClicked();
                calculation.add("/");
            }
        });

        equalsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
/*                if (currentOperation == "+") { // ONLY FOR PLUS BUTTON RN
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
                currentOperation = "=";
*/
                setCurrentNumber();

                rsf = Double.parseDouble(calculation.get(0));

                for (int i = 1; i < calculation.size(); i++) {
                    if (calculation.get(i) == "+") {
                        rsf += Double.parseDouble(calculation.get(i+1));
                    } else if (calculation.get(i) == "-") {
                        rsf -= Double.parseDouble(calculation.get(i+1));
                    } else if (calculation.get(i) == "*") {
                        rsf *= Double.parseDouble(calculation.get(i+1));
                    } else if (calculation.get(i) == "/") {
                        rsf /= Double.parseDouble(calculation.get(i+1));
                    }
                }

                printResult(rsf);
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
                answer.setText(result);
            }
        });
    }

    //sets currentNumber when equal sign is clicked
    private void setCurrentNumber() {
        String result = getNumber();
        //currentNumber = Double.parseDouble(result);
        creatingNumbers.clear();
        calculation.add(result);
    }

    //sets previousNumber when an operation is clicked
    private void operationClicked() {
        String result = getNumber();
        //previousNumber = Double.parseDouble(result);

        creatingNumbers.clear();
        calculation.add(result);
        answer.setText("0");
    }

    // brings the numbers inputted together into one number
    @NonNull
    private String getNumber() {
        String result = "";
        for (int i = 0; i < creatingNumbers.size(); i++) {
            result += creatingNumbers.get(i);
        }

        if (result.indexOf(".") != result.lastIndexOf(".")) {
            creatingNumbers = new ArrayList<>();
            calculation = new ArrayList<>();
            previousNumber = 0;
            currentNumber = 0;
            answer.setText("Error");
            return "Error";
        }

        return result;
    }

    //prints the result after the equals button is pressed
    private void printResult(double r) {
        creatingNumbers.clear();
        creatingNumbers.add(Double.toString(r));

        DecimalFormat format = new DecimalFormat("0.########");
        answer.setText(format.format(r));
    }


    //assign all the buttons/textview to the private variables above
    private void setUp() {
        answer = (EditText) findViewById(R.id.answer);

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