public class SquareFunctionTrace {

    // Function to compute the square of an integer
    public static int 
 {
        System.out.println("✏️ Pencil Trace: Called square(" + n + ")");
        int result = n * n;
        System.out.println("✏️ Pencil Trace: Calculating " + n + " * " + n + " = " + result);
        return result;
    }

    public static void main(String[] args) {
        int input = 7;
        System.out.println("Input: " + input);
        int output = square(input);
        System.out.println("Output: " + output);
    }
}
