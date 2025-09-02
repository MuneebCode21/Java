
public class Main {

	public static void main(String[] args) {


		Encapsulation obj1 = new Encapsulation();
		Encapsulation obj2 = new Encapsulation();
	//	Encapsulation obj2 = new Encapsulation("Haseeb", 18,"Rajput");
	//	Encapsulation obj3 = new Encapsulation("Rafeh", 25, "Gujar");
		
	//	System.out.println(obj1.getName() + " "+ obj1.getAge()+ " "+ obj1.getRace());
	//	System.out.println(obj2.getName() + " "+ obj2.getAge()+ " "+ obj2.getRace());
	//	System.out.println(obj3.getName() + " "+ obj3.getAge()+ " "+ obj3.getRace());
		
		obj1.setName("Muneeb");
		obj1.setAge(22);
		obj1.setRace("Gujar");
		
		System.out.println("Name is: " + obj1.getName()+ "\n "+ "Age is :"+ obj1.getAge()+"\n "+ "Race is:" + obj1.getRace() );
		
		obj2.setName("Haseeb");
		obj2.setAge(18);
		obj2.setRace("Gujar");
		
		System.out.println("Name is: " + obj2.getName()+ "\n "+ "Age is :"+ obj2.getAge()+"\n "+ "Race is:" + obj2.getRace() );
		
		


	}

}
