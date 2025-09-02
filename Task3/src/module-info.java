public class SquareExample {

    // Function to return square of a number
    public static int square(int number) {
        return number * number;
    }

    public static void main(String[] args) {
        int input = 4;
        int result = square(input);

        System.out.println("Input: " + input);
        System.out.println("Square: " + result);
    }
}
