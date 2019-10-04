package org.eliger.calculator;

public final class App {
    private App() {
    }
    public static void main(String[] args) {
        Calculator calc = new Calculator(1, 2, '+');
        System.out.printf("%s %s %s = %s\n", calc.getLeft(), calc.getMath(), calc.getRight(), calc.calculate());
        while (true) {
            System.out.print("Input expression to calculate (or \"exit\" to stop): ");
            String line = System.console().readLine();
            if (line.equals("exit"))
                break;
            try {
                calc.setExpression(line);
                System.out.println("The result is: " + calc.calculate());
            } catch (Exception ex) {
                System.out.println("Input is invalid:");
                ex.printStackTrace();
            }
        }
                                                                                                  
    }
}