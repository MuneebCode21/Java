package park.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Ticket {
    private final String id;
    private final TicketType type;
    private final String visitorName;
    private final double price;
    private final LocalDateTime purchasedAt;

    public Ticket(String id, TicketType type, String visitorName, double price) {
        this.id = id;
        this.type = type;
        this.visitorName = visitorName;
        this.price = price;
        this.purchasedAt = LocalDateTime.now();
    }

    public String getId() { return id; }
    public TicketType getType() { return type; }
    public String getVisitorName() { return visitorName; }
    public double getPrice() { return price; }
    public LocalDateTime getPurchasedAt() { return purchasedAt; }
    public String getTimestamp() { return purchasedAt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")); }
}
