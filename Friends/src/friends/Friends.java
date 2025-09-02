package friends;

public class Friends {
	
	String name;
	static int numberoffriends;
	
	Friends(String name){
		this.name= name;
		numberoffriends++;
		
	}
	
	public static void displayFriends() {
		System.out.println("You have"+ numberoffriends+ "friends");
		
	}

	

}
