package practice1002;

class  Dog extends Animal{
	
	double price;
	Dog(String n, int a, double price) {
		super(n, a);
		this.price=price;
	}
	
	public void draw() {
		System.out.println("Name is : " + getname() + " \n" + "Age is : " + getAge()+ "\n " + "Price is :" + price );
		
	}
	
}