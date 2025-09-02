
public class Encapsulation {

	private String name;
	private int age;
	private String race;
	
	// public Encapsulation(String name, int age, String race) {
	//	this.name=name;
//		this.age=age;
	//	this.race=race;
	//}

	public String getName() {
		return name;
		
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age=age;
	}
	
	public String getRace() {
		return race;
	}
	
	public void setRace(String race) {
		this.race=race;
	}
}
