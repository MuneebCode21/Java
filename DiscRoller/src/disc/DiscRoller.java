package disc;

import java.util.Random;

public class DiscRoller {
	
	Random random;
	int number;
	
	DiscRoller()
	{
		random= new Random();
		roll();
		
	}
	
	void roll()
	{
		number= random.nextInt(6)+1;
		System.out.println(number);
	}

}
