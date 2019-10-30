package org.eliger.calculator;

public class Function {

    private Number left = 2;
    private Number right = 2;
    private char math = '+';
    private String operation = "Cos";
    private Number answer = 0;
    //-----------Constructors
    /* For Factorial */
    public Function(char math, Number left) {
        this.left = left;
        this.math = math;
    }

    /* For Exponentiation */
    public Function(Number right, char math, Number left) {
        this.left = left;
        this.math = math;
        this.right = right;
    }

    /* For Sin & Cos & abs */
    /*
     * public NewFeature(String operation, Number left) { this.left = left;
     * this.operation = operation; }
     */

    public Function(String operation) {
        try {
            parseFeatureExpression(operation);
        } catch (CalculatorException e) {
            // Auto-generated catch block
            e.printStackTrace();
        }
    }

    //------Parsers Function

       /* Get String */

       private void setOperation(String operation) {
        this.operation = operation.toLowerCase();

    }

    /* Number operation For Sin Cos Abs */

    private void setNumber(Number expression) {
        this.right = expression;
    }

    private Number getNumberFromString(String number) {
        number = number.replace(',', '.');
        Number ans = Double.parseDouble(number);
        if (ans.equals(Double.valueOf(ans.intValue())))
            ans = ans.intValue();
        return ans;
    }

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

    /* Display answer */

    public void displayAnswer() {
        if (this.answer.equals(Double.valueOf(this.answer.intValue())))
            this.answer = this.answer.intValue();
        System.out.println("The result is: " + this.answer);
    }

    //-----Parser
    /* parse Expression for Sin Cos Abs */
    public void parseFeatureExpression(String expression) throws CalculatorException {
        if (!expression.matches("[A-Za-z]{3}\\(\\-?[0-9]+([\\.,][0-9]+)?\\)"))
            throw new CalculatorException("The expression does not match expression pattern");

        // Set Number
        setNumber(getNumberFromString(expression.substring(4, expression.length() - 1)));

        // Set Operation
        setOperation(expression.substring(0, 3));

        // Calculate
        calculate();

        // Display answer
        displayAnswer();

        /*
         * char[] mass = expression.toCharArray();
         * 
         * for (int i = 0; i < mass.length; i++) { if (i > 3 && i < mass.length - 1) {
         * // System.out.println( expression.substring(4,expression.length()-1)); }
         * 
         * }
         */

    }

}