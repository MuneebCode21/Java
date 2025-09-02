public class Main {
    static int x = 5;

    static void increment() {
        x++;
        System.out.println("Static x: " + x);
    }

    public static void main(String[] args) {
        Main e1 = new Main();
        Main e2 = new Main();

        e1.increment();
        e2.increment();
    }
}
