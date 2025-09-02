 class  CreditClass implements PaymentSystem.A{
	double amount;
	CreditClass(double amount){
		this.amount=amount;
	}
	 @Override
	    public void pay() {
	        System.out.println("Paying via CreditCard...");
	    }

	@Override
	public void DisplayAmount() {
		System.out.println("Credit Amount is :" + amount);
		
	}
	
		
}
