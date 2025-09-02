package speed;

public class Main {

    public static void main(String[] args) {

        Bicycle myBike = new Bicycle();
        Car myCar = new Car();

        myBike.drive();    
        myBike.horn();     // New method

        myCar.drive();     // Overridden method
        myCar.stop();      // Inherited method from Vehicle

    }
}
