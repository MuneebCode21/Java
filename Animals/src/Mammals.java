 class Mammals implements Animals{
	private String words;
	private int value;
	 Mammals(String words,int value) {
		this.words=words;
		this.value=value;
	}
	
	public String getName() {
		return words;
	}
	
	public void setName(String words) {
		 this.words=words;
	}
	
	public int getTravel() {
		return value;
	}
	
	public void setTravel(int value) {
		this.value=value;
	}
	
	@Override
	public void name() {
		System.out.println("HELLO My name is:" + getName());
	}
	
		
	@Override
	public void eat(double calories) {
		System.out.println("I eat:" + calories);
	}
	
	@Override
	public void travel() {
		System.out.println("I travel around:" + getTravel());
	}
	
	
}
