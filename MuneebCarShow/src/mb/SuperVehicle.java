package mb;

public class SuperVehicle extends Car {
    private boolean hasTurbo;
    private boolean hasAirbags;

    public SuperVehicle(String company,  String color,int modelYear, double price, boolean hasTurbo, boolean hasAirbags) {
        super(company, color, modelYear,price,hasTurbo,hasAirbags);
        this.hasTurbo = hasTurbo;
        this.hasAirbags = hasAirbags;
    }

    public boolean hasTurbo() { return hasTurbo; }
    public boolean hasAirbags() { return hasAirbags; }

    public void activateTurbo() {
        if (hasTurbo)
            System.out.println(getCompany() + " is now using TURBO BOOST!");
        else
            System.out.println(getCompany() + " has no turbo installed.");
    }

    public void deployAirbags() {
        if (hasAirbags)
            System.out.println(getCompany() + "'s airbags deployed safely.");
        else
            System.out.println(getCompany() + " has no airbags.");
    }

    @Override
    public String toString() {
        return super.toString() + " | Turbo: " + (hasTurbo ? "Yes" : "No") +
               " | Airbags: " + (hasAirbags ? "Yes" : "No");
    }
}
