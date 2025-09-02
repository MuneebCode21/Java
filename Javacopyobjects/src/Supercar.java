
public class Supercar extends Car {
		
	boolean isturbo;
	
	public Supercar(String company, String name, int model, String color, double value) {
		super(company, name, model, color, value);
		this.isturbo = true;
		
	}
	
	@Override
	public void drive() {
		System.out.println(getName()+ "Is driving very fast like rooom");
	}
	
	public String toString() {
		
		return super.toString() + "isturbo: " + isturbo;
	}

}
