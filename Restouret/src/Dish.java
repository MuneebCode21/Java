
class Dish {
    private String name;
    private double price;
    private boolean hasSauce;
    protected String type; // e.g. "Dine-In" or "Parcel"

    // Constructor without sauce
    public Dish(String name, double price, String type) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.hasSauce = false;
    }

    // Constructor with sauce option
    public Dish(String name, double price, String type, boolean hasSauce) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.hasSauce = hasSauce;
    }

    public void displayDish(int index) {
        System.out.println(index + ". " + name + " | Type: " + type +
                " | Price: Rs. " + price + " | Sauce: " + (hasSauce ? "Yes" : "No"));
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}