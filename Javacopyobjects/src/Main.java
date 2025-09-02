public class Main {

	public static void main(String[] args) {
		
		Car car1 = new Car("Honda","Civic",2023,"RED",750000.00);
		Car car2 = new Car("Toyota","Corolla",2023,"White",700000.00);
		Car car3 = new Car("Suzuki","Swift",2023,"Black",230000.00);
		Supercar car4 = new Supercar("Hyundai","Sonnata",2025,"Grey",14000000.00);
	
		
		System.out.println(" * WELCOME TO MUNEEB CAR SHOWROOM * " );
		System.out.println();
		System.out.println("Feel free to check out our cars: ");
		System.out.println();
		System.out.println(car1.toString());
		System.out.println(car2.toString());
		System.out.println(car3.toString());
		car3.drive();
		car4.drive();
		System.out.println(car4.toString());
		
	}	
}
