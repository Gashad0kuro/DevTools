package org.eliger.calculator;

public final class App {
    private App() {
    }

    public static void main(String[] args) {

        Calculator calc = new Calculator(1, 2, '+');
        // System.out.printf("%s %s %s = %s\n", calc.getLeft(), calc.getMath(),
        // calc.getRight(), calc.calculate());
        
        System.out.print(
                "Hello! Select calculator: \nEnter \"1\" to use ordinary calculator. \nEnter \"2\" to use functions. \nEnter anything else to exit. \n");
        String answ = System.console().readLine();
        switch (answ) {
        case "1":
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
            break;

        case "2":
            Function function = new Function("2 ^ 3");
            function.displayAnswer();
            break;

        default:
            break;
        }

    }
}