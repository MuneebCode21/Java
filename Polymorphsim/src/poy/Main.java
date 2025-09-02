package poy;

public class Main {

	public static void main(String[] args) {
		
		Car car = new Car();
		Bicycle bicycle = new Bicycle();
		Boat boat = new Boat();
		
		Vehicle [] racers = {car,bicycle,boat};
		
		for (Vehicle x : racers) {
			x.go();
		}
		
		

	}

}
