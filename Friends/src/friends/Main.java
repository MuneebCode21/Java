package friends;

public class Main {

	public static void main(String[] args) {
		
		Friends friend1= new Friends("Haseeb");
		Friends friend2= new Friends("Raja");
		Friends friend3= new Friends("Haris");
		
		System.out.println(Friends.numberoffriends);
		
		Friends.displayFriends();
		
	}

}
