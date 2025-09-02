package garage;

public class garage {
    Car[] cars;  // Array to hold cars
    int index = 0;  // To keep track of where to park next

    garage(int size) {
        cars = new Car[size];  // Allocate array space
    }

    void park(Car mycar) {
        if (index < cars.length) {
            cars[index] = mycar;
            System.out.println("Your " + mycar.name + " is parked in slot " + (index + 1));
            index++;
        } else {
            System.out.println("Garage is full! Can't park " + mycar.name);
        }
    }

    void showCars() {
        System.out.println("\nCars currently in the garage:");
        for (int i = 0; i < index; i++) {
            System.out.println("- Slot " + (i + 1) + ": " + cars[i].name);
        }
    }
}
