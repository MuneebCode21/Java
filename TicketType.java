package park.model;

public enum TicketType {
    DAY_PASS("Day Pass", 45.0),
    CHILD_PASS("Child Pass", 30.0),
    SENIOR_PASS("Senior Pass", 32.0),
    VIP_PASS("VIP Pass", 85.0),
    FAMILY_PACK("Family Pack", 150.0);

    private final String label;
    private final double price;
    TicketType(String label, double price) { this.label = label; this.price = price; }
    public String getLabel() { return label; }
    public double getPrice() { return price; }
}
