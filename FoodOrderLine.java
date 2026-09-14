package park.model;

public class FoodOrderLine {
    private final FoodItem item;
    private final int quantity;
    public FoodOrderLine(FoodItem item, int quantity) { this.item = item; this.quantity = quantity; }
    public FoodItem getItem() { return item; }
    public int getQuantity() { return quantity; }
    public double getLineTotal() { return item.getPrice() * quantity; }
}
