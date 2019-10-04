package org.eliger.calculator;

public class CalculatorException extends Exception {    
    private static final long serialVersionUID = 1L;
    public CalculatorException(String text) {
        super(text);
    }
    public CalculatorException(Exception ex) {
        super(ex);
    }
    public CalculatorException(String text, Exception ex) {
        super(text, ex);
    }

}