interface Introuction {
    void message(String name, char symbol, int age, double price);
}

// Abstract Class (Abstraction)
abstract class Vehicle {
    private String name;   // Encapsulation (private fields)
    private char symbol;
    private int age;
    private double price;

    // Constructor
    public Vehicle (String name, char symbol, int age, double price) {
        this.name = name;
        this.symbol = symbol;
        this.age = age;
        this.price = price;
    }

    // Getters and Setters (Encapsulation)
    public String getName() { return name; }
    public char getSymbol() { return symbol; }
    public int getAge() { return age; }
    public double getPrice() { return price; }

    // Abstract method (must be overridden in child)
    public abstract void displayInfo();
}