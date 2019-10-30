package org.eliger.calculator;

public class Function {

    private Number left = 2;
    private Number right = 2;
    private char math = '!';
    private String operation = "Cos";
    private Number answer = 0;

    // ============Constructors=================
    // #1
    /* For Factorial */
    public Function(Number left) {
        this.left = left;
    }

    // #2
    /* For Sin & Cos & abs & Exponentiation */
    public Function(String operation) {
        try {
            parseExpression(operation);
        } catch (CalculatorException e) {
            // Auto-generated catch block
            e.printStackTrace();
        }
    }

    // =============SETTERS===================
    // #1
    // ------Parser Function
    private void setOperation(String operation) {
        this.operation = operation.toLowerCase();

    }

    // #2
    /*--------------Factorial */
    private void setNumberFactorial(Number expression) {
        this.left = expression;
    }

    // #3
    // ---------- Sin Cos Abs */
    private void setNumber(Number expression) {
        this.right = expression;
    }

    // #4
    // ----------Exponential Number
    private void setExpNumber(String expression) {
        int i = 1;
        while (true) {
            boolean br = false;
            switch (expression.charAt(i)) {
            case '^':
            case ' ':
                br = true;
            default:
                i++;
            }
            if (br)
                break;
        }
        this.left = getNumberFromString(expression.substring(0, i));
        while (expression.charAt(i) == ' ')
            i++;
        this.math = expression.charAt(i);
        i++;
        while (expression.charAt(i) == ' ')
            i++;
        this.right = getNumberFromString(expression.substring(i, expression.length()));
    }

    // ==================GETTERS==================
    // #1

    private Number getFactorialNumberFromString(String number) {
        Number ans = Double.parseDouble(number);
        if (ans.equals(Double.valueOf(ans.intValue())))
            ans = ans.intValue();
        return ans;
    }

    // #2
    private Number getNumberFromString(String number) {
        number = number.replace(',', '.');
        Number ans = Double.parseDouble(number);
        if (ans.equals(Double.valueOf(ans.intValue())))
            ans = ans.intValue();
        return ans;
    }

    // =============CALCULATORS=================

    // #1 Factorial
    private Integer factorial(Integer n) {
        if (n >= 2) {
            return (n * factorial(n - 1));
        } else {
            return 1;
        }
    }

    // #2 Cos Sin Abs
    private void calculate() {
        double ans = 0;
        switch (this.operation) {
        case "cos":
            ans = Math.cos(this.right.doubleValue());
            this.answer = ans;
            break;
        case "sin":
            ans = Math.sin(this.right.doubleValue());
            this.answer = ans;
            break;
        case "abs":
            ans = Math.abs(this.right.doubleValue());
            this.answer = ans;
            break;
        default:
            System.out.println("No such function");
            break;
        }
    }

    // #3
    // -----------Exponential
    private void calculateExp() {
        this.answer = Math.pow(this.left.doubleValue(), this.right.doubleValue());
    }

    // ===================DISPLAY====================
    /* Display answer */

    public void displayAnswer() {
        if (this.answer.equals(Double.valueOf(this.answer.intValue())))
            this.answer = this.answer.intValue();
        System.out.println("The result is: " + this.answer);
    }

    // ===================PARSER====================

    /* parse Expression for Sin Cos Abs */
    public void parseExpression(String expression) throws CalculatorException {

        if (expression.matches("[A-Za-z]{3}\\(\\-?[0-9]+([\\.,][0-9]+)?\\)")) {
            // Its Abs or Cos or Sin
            // Set Number
            setNumber(getNumberFromString(expression.substring(4, expression.length() - 1)));
            // Set Operation
            setOperation(expression.substring(0, 3));
            // Calculate
            calculate();

        } else if (expression.matches("\\-?[0-9]+!")) {
            // Its Factorial
            // Set Number
            setNumberFactorial(getFactorialNumberFromString(expression.substring(0, expression.length() - 1)));

            // Calculate
            this.answer = factorial((this.left).intValue());

        } else if (expression.matches("\\-?[0-9]+([\\.,][0-9]+)?\\s*\\^\\s*\\-?[0-9]+([\\.,][0-9]+)?")) {
            // Its Exponential
            // set Number
            setExpNumber(expression);

            // calculate
            calculateExp();

        } else {
            throw new CalculatorException("The expression does not match expression pattern");
        }

    }

}