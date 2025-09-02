public class Car {
	
	private String company;
	private String name;
	private int model;
	private String color;
	private double value;
	
	public Car(String company, String name, int model, String color, double value) {
		this.company=company;
		this.name=name;
		this.model=model;
		this.color=color;
		this.value=value;
		this.setValue(value);
	}

	private void setValue(double value) {
		if (value>=50000.00) {
			 this.setValue(20000.00);				
		} else {
			System.out.println("WAH WAH");
		}
		
	}

	public void drive() {
	    System.out.println(name + " is driving.");
	}

	
	public String getCompany() {
		return company;
	}
	
	public String getName() {
		return name;
	}
	
	private void setModel(int value) {
		this.model=model;
		
	}
	
	public String getColor() {
		return color;
	}
	
	public double getValue() {
		return value;	
	}
	
	@Override
	
	public String  toString() {
		return "Company:" + company + " " + "Name: " + name + " "+ "Model: "+ model+ " "+ "Color: "+ color + " "+ "Value: "+ value;
	
		
		
	}

}
