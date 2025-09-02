package Super;

public class Main {

	public static void main(String[] args) {
		
		Hero hero1 = new Hero("Muneeb", 18, "SuperStrength");
		Hero hero2 = new Hero("Haseeb", 22, "SuperSpeed");
		Hero hero3 = new Hero("Rooj", 24, "SuperReflexes");
		
		System.out.println(hero1.name + hero1.age + hero1.power);
		System.out.println(hero2.name + hero2.age + hero2.power);
		System.out.println(hero3.name + hero3.age + hero3.power);
		
		System.out.println(hero1.toString());
		
	}

}
