package mb;

public class Bike extends Vehicles {
    private boolean hasDiscBrakes;

    public Bike(String company, String color,int modelYear, double price, boolean isAvailable, boolean hasDiscBrakes) {
        super(company, color, 'B', price, modelYear, isAvailable);
        this.hasDiscBrakes = hasDiscBrakes;
    }

    public boolean hasDiscBrakes() { return hasDiscBrakes; }

    @Override
    public String toString() {
        return super.toString() + " | Disc Brakes: " + (hasDiscBrakes ? "Yes" : "No");
    }

    public void popWheelie() {
        System.out.println(getCompany() + " is popping a wheelie!");
    }
}

