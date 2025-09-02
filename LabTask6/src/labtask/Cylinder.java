package labtask;

public class Cylinder {
	
	double p1 = 3.14;

	
	public void volume (double r , double h) {
		
		System.out.println("The volume is : " + p1 + r*r*h);
	}
		
	public void area (double r, double h) {
		
		System.out.println("The Area is : " + (2* (p1*r*r)) + 2*(p1*r*h));
	}
}
	
