package mb;

public class Vehicles {
    protected String company;
    private String color;
    private char type; // e.g. C for Car, B for Bike
    private double price;
    private int modelYear;
    private boolean isAvailable;

    public Vehicles(String company, String color, char type, double price, int modelYear, boolean isAvailable) {
        this.company = company;
        this.color = color;
        this.type = type;
        this.price = price;
        this.modelYear = modelYear;
        this.isAvailable = isAvailable;
    }

    public String getCompany() { return company; }
    public String getColor() { return color; }
    public char getType() { return type; }
    public double getPrice() { return price; }
    public int getModelYear() { return modelYear; }
    public boolean getAvailability() { return isAvailable; }

    public void setPrice(double price) {
        if (price > 0) this.price = price;
    }

    public void setAvailability(boolean available) {
        this.isAvailable = available;
    }

    @Override
    public String toString() {
        return "Company: " + company + " | Color: " + color +
               " | Type: " + type + " | Price: $" + price + " | Model Year: " + modelYear +
               " | Available: " + (isAvailable ? "Yes" : "No");
    }

    public void drive() {
        System.out.println(company + " is being driven.");
    }
}
