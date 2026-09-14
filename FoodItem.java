package park.model;

public class FoodItem {
    private final String id;
    private String name;
    private String category;
    private double price;
    private boolean available;

    public FoodItem(String id, String name, String category, double price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.available = true;
    }
    public String getId() { return id; }
    public String getName() { return name; }
    public String getCategory() { return category; }
    public double getPrice() { return price; }
    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }
}
