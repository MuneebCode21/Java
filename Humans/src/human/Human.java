package human;

public class Human {
	
	String name;
	int age;
	double weight;
	
	Human (String name, int age, double weight)
	{
		this.name=name;
		this.age=age;
		this.weight=weight;
	}
	
	void sleep()
	{
		System.out.println(this.name+" Is Sleeping");

	}
	
	void Awake()
	{
		System.out.println(this.name+" Is Awake");
	}

}
