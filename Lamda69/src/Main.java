@FunctionalInterface
interface Doubler {
    int doubleIt(int x);   // abstract method
}

@FunctionalInterface
interface EvenChecker {
    boolean isEven(int x); // abstract method
}

public class Main {
    public static void main(String[] args) {
        
        // Lambda for doubling a number
        Doubler doubler = (x) -> x * 2;

        // Lambda for checking even number
        EvenChecker checker = (x) -> x % 2 == 0;

        int num = 5;

        int doubled = doubler.doubleIt(num);
        boolean isEven = checker.isEven(doubled);

        System.out.println("Original number: " + num);
        System.out.println("After doubling: " + doubled);
        System.out.println("Is doubled number even? " + isEven);
    }
}
