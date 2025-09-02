package human;

public class Main {

	public static void main(String[] args) {
		
		Human human1= new Human ("NEEB", 22, 67.5);
		Human human2= new Human ("CHEEB", 18, 54.5);
		
		System.out.println(human1.name);
		System.out.println();
		System.out.println(human2.age);
		System.out.println();
		System.out.println(human1.weight);
		System.out.println();
		System.out.println(human2.name);
		System.out.println();
		System.out.println(human1.age);

		human1.sleep();
		human2.Awake();
	}
	

}
