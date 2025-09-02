package practice1002;

class Animal {
	
	private String name;
	private int age;
	
	Animal(String n, int a){
		this.name=n;
		this.age=a;
	
	}
	
	public String getname() {
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
    
	void draw() {
        System.out.println("Name is : " + name + "Age is : " + age);
    }
}
