public class Main {
    public static void main(String[] args) {
        
        Cars myCar = new Cars("Toyota", 'T', 3, 4500.00);
        

        // Using lambda for Introduction
        Introuction intro = (n, s, a, p) -> {
            System.out.println("🚗 Welcome to the Car Showroom!");
            System.out.println("Name: " + n + 
                               ", Symbol: " + s + 
                               ", Age: " + a + 
                               " years, Price: $" + p);
        };

        // Lambda call
        intro.message(myCar.getName(), myCar.getSymbol(), myCar.getAge(), myCar.getPrice());

        // Abstract method call (Overriding in action)
        myCar.displayInfo();
    }
}