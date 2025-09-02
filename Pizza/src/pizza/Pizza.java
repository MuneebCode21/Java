package pizza;

public class Pizza {
	
	String bread;
	String topping;
	String flavor;
	int mfg;
	int exp;
	double price;
	
	Pizza(String bread,String topping, String flavor, int mfg, int exp, double price){
		
		this.bread=bread;
		this.topping=topping;
		this.flavor=flavor;
		this.mfg=mfg;
		this.exp=exp;
		this.price=price;	
		
	}
	
	Pizza(String bread,String topping, String flavor, double price){
		
		this.bread=bread;
		this.topping=topping;
		this.flavor=flavor;
		this.price=price;		
		
	}
	

}
