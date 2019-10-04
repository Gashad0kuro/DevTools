package org.eliger.calculator;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test.
     * 
     * @throws CalculatorException
     */
    @Test
    public void firstCalculatorTest() throws CalculatorException {
        Calculator calc;
        calc = new Calculator(1,2,'+');
        assertEquals(3, calc.calculate() );
       
    }
    @Test
    public void ioCalcTest() throws CalculatorException {
        Calculator calc;
        Exception ex = null;
        try {
            calc = new Calculator("12 ** 4");
            calc.calculate();
        } catch (Exception e) {
            ex = e;
        }

        assert(ex != null);
        
        
       
    }

}
