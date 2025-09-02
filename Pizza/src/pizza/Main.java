package pizza;

public class Main {

	public static void main(String[] args) {
				
		Pizza mypizza= new Pizza("THICK","TIKKA","RED CHILLI",200.00);
		
		System.out.println(" * WELCOME TO MUNEEB PIZZA * ");
		System.out.println();
		System.out.println(" Here are the ingredients: ");
		System.out.println(mypizza.bread);
		System.out.println(mypizza.topping);
		System.out.println(mypizza.flavor);
		System.out.println(mypizza.price);
		

	}

}
