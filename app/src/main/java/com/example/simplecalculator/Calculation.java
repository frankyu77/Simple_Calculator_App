package com.example.simplecalculator;

import java.util.ArrayList;
import java.util.List;

// class that handles all the calculation for the calculator
public class Calculation {
    List<String> calculations;
    double result;

    //sets up Calculation with empty array and result = 0
    public Calculation() {
        calculations = new ArrayList<String>();
        result = 0;
    }

    //adds an operation to the array
    //if two operations are added in a row, then take the most recent operation added and remove the
    //  previous
    public void addOperation(String operation) {
        int index = this.calculations.size() - 1;

        if (this.calculations.get(index) == "+" ||
                this.calculations.get(index) == "-" ||
                this.calculations.get(index) == "*" ||
                this.calculations.get(index) == "/") {

            if (!(this.calculations.get(index) == operation)) {
                this.calculations.remove(index);
                this.calculations.add(operation);
            }

        } else {
            this.calculations.add(operation);
        }
    }

    //adds a number to the array
    public void addNumber(String number) {
        this.calculations.add(number);
    }

    //iterates through the array and computes the result for the formula in the array
    public double computeCalculation() {
        result = Double.parseDouble(this.calculations.get(0));

        for (int i = 1; i < this.calculations.size(); i++) {
            if (this.calculations.get(i) == "+") {
                result += Double.parseDouble(this.calculations.get(i+1));
            } else if (this.calculations.get(i) == "-") {
                result -= Double.parseDouble(this.calculations.get(i+1));
            } else if (this.calculations.get(i) == "*") {
                result *= Double.parseDouble(this.calculations.get(i+1));
            } else if (this.calculations.get(i) == "/") {
                result /= Double.parseDouble(this.calculations.get(i+1));
            }
        }

        return result;
    }


    //clears the array
    public void clear() {
        calculations.clear();
    }

    //returns size of array
    public int getSize() {
        return this.calculations.size();
    }

    //returns the result
    public double getResult() {
        return this.result;
    }

    //returns the array
    public List<String> getCalculations() {
        return this.calculations;
    }
}
