import java.util.Scanner;

class Calculator {
    private double a;
    private double b;

    public void setValues(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double calculate(String operator) {
        if (operator == "add")
            return a + b;
        else if (operator == "subtract")
            return a - b;
        else if (operator.equals("multiply"))
            return a * b;
        else if (operator.equals("divide") && b != 0)
            return a / b;
        else
            return 0;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Calculator c = new Calculator();

        System.out.print("Enter value of a: ");
        double x = scan.nextInt();
        
        System.out.print("Enter value of b: ");
        double y = scan.nextInt();

        System.out.print("Enter operation (add, subtract, multiply, divide): ");
        String operation = scan.next();

        c.setValues(x, y);

        double result = c.calculate(operation);
        System.out.println("Result is: " + result);
    }
}
