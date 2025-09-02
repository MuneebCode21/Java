package garage;

public class Main {
    public static void main(String[] args) {

        garage myGarage = new garage(2);  // Garage with space for 2 cars

        Car car1 = new Car("Corolla");
        Car car2 = new Car("Suzuki");
        Car car3 = new Car("Civic");  // Just to test if garage is full

        myGarage.park(car1); // Park Corolla
        myGarage.park(car2); // Park Suzuki
        myGarage.park(car3); // Garage full

        myGarage.showCars(); // Show all cars in garage
    }
}
