 class Cars extends Vehicle {
    public Cars(String name, char symbol, int age, double price) {
        super(name, symbol, age, price);
    }

    // Overriding abstract method
    @Override
    public void displayInfo() {
        System.out.println("Car Info → " + getName() + " (" + getSymbol() + ")");
    }
}