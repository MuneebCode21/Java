package refrigrator;

public class Main {

	public static void main(String[] args) {
		
		
		food food1= new food ("DHAAL");
		food food2= new food ("CHAPATTI");
		food food3= new food ("RICE");
		
		//refrigerator [0]= food1;
		//refrigerator [1]= food2;
		//refrigerator [2]= food3;
		
		food[] refrigrator= {food1,food2,food3};
		
		System.out.println(refrigrator[0].name);
		System.out.println(refrigrator[1].name);
		System.out.println(refrigrator[2].name);
		
	}

}
