package mb;

public class Car extends Vehicles {
    private boolean hasAC;

     public Car(String company, String color,int modelYear, double price, boolean isAvailable, boolean hasAC) {
        super(company, color,'A', price, modelYear, isAvailable);
        this.hasAC = hasAC;
    }


	public boolean hasAC() {
		return hasAC; 
	}

    @Override
    public String toString() {
        return super.toString() + " | AC: " + (hasAC ? "Yes" : "No");
    }

    public void openTrunk() {
        System.out.println(getCompany() + "'s trunk is now open.");
    }
}
