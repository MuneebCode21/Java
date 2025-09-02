 class  BankTransfer implements PaymentSystem.A{
	double amount;
	BankTransfer(double amount){
		this.amount=amount;
	}
	 @Override
	    public void pay() {
	        System.out.println("Paying via Bank...");
	    }

	@Override
	public void DisplayAmount() {
		System.out.println("BankTransfer Amount is :" + amount);
		
	}
	
		
}
