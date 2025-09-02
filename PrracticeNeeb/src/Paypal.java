class  Paypal implements PaymentSystem.A{
	double amount;
	Paypal(double amount){
		this.amount=amount;
	}
	 @Override
	    public void pay() {
	        System.out.println("Paying via Paypal...");
	    }

	 
	@Override
	public void DisplayAmount() {
		System.out.println("Paypal Amount is :" + amount);
		
	}
	
		
}
