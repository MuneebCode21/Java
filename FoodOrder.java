package park.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FoodOrder {
    private final String id;
    private final String customer;
    private final List<FoodOrderLine> lines = new ArrayList<>();
    private final LocalDateTime createdAt = LocalDateTime.now();

    public FoodOrder(String id, String customer) { this.id = id; this.customer = customer; }
    public String getId() { return id; }
    public String getCustomer() { return customer; }
    public List<FoodOrderLine> getLines() { return lines; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void addLine(FoodOrderLine line) { lines.add(line); }
    public double getTotal() { return lines.stream().mapToDouble(FoodOrderLine::getLineTotal).sum(); }
}
