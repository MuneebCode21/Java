
public class Main {

	public static void main(String[] args) {
		
		Animals A = new Birds("humming" , 323);
		Animals B = new Fish("Dolphin", 1222);
		Animals C = new Mammals("Lion" , 232);
		
		A.name();
		A.eat(22000.00);
		A.travel();
		

		B.name();
		B.eat(324536.00);
		B.travel();
		

		C.name();
		C.eat(1214444.00);
		C.travel();
	}

}
