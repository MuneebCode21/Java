package labtask;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter the radius of the cylinder:");
		double r = input.nextDouble();
		
		System.out.println("Enter the height of the cylinder:");
		double h = input.nextDouble();
		
		Cylinder myobj1 = new Cylinder();
		myobj1.area(2,4);
		
		Cylinder myobj2 = new Cylinder();
		myobj2.volume(2,4);
		
		
		
	}

}
