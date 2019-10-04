package org.eliger.calculator;

public class Calculator {
    private Number left, right;
    private char math = '+';
    public Calculator(Number left, Number right, char math) {
        this.left = left;
        this.right = right;
        this.math = math;
    }
    public Calculator(String expression) throws CalculatorException {
        parseExpression(expression);
    }
    public void setExpression(Number left, Number right, char math) {
        this.left = left;
        this.right = right;
        this.math = math;
    }
    public void setExpression(String expression) throws CalculatorException {
        parseExpression(expression);
    }
    public void parseExpression(String expression) throws CalculatorException {
        if (!expression.matches("\\-?\\d+[\\.,]?\\d*\\s*[+\\-\\*/]\\s*\\-?\\d+[\\.,]?\\d*"))
            throw new CalculatorException("The expression does not match expression pattern");
        int i = 1;
        while (true) {
            boolean br = false;
            switch (expression.charAt(i)) {
                case ' ': case '+': case '-': case '*': case '/':
                    br = true;
                default:
                    i++;
            }
            if (br)
                break;
        }
        this.left = getNumber(expression.substring(0, i));
        while (expression.charAt(i) == ' ')
            i++;
        this.math = expression.charAt(i);
        i++;
        while (expression.charAt(i) == ' ')
            i++;
        this.right = getNumber(expression.substring(i, expression.length()));
    }
    private static Number getNumber(String number) {
        number = number.replace(',', '.');
        Number ans = new Double(number);
        if (ans.equals(ans.intValue()))
            ans = new Integer(ans.intValue());
        return ans;
    }
    private static Number getNumber(double number) {
        if (number == (int) number) {
            return new Integer((int) number);
        }
        return new Double(number);
    }
    public Number calculate() {
        switch(this.math) {
            case '+':
                return getNumber(this.left.doubleValue() + this.right.doubleValue());
            case '-':
                return getNumber(this.left.doubleValue() - this.right.doubleValue());
            case '*':
                return getNumber(this.left.doubleValue() * this.right.doubleValue());
            case '/':
                return getNumber(this.left.doubleValue() / this.right.doubleValue());
            default:
                return null;
        }
    }
    public Number getLeft() {
        return left;
    }
    public Number getRight() {
        return right;
    }
    public char getMath() {
        return math;
    }
}