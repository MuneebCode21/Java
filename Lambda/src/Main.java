interface BankService {
    void withdraw(double amount);
    void deposit(double amount);
    void checkBalance();
}

class Account implements BankService {
    private String accountHolder;
    private double balance;

    public Account(String accountHolder, double balance) {
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    @Override
    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        }
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    @Override
    public void checkBalance() {
        System.out.println(accountHolder + "'s Balance: " + balance);
    }
}

public class Main {
    public static void main(String[] args) {
        BankService myAcc = new Account("Ali", 5000);

        myAcc.checkBalance();   
        myAcc.deposit(1500);    
        myAcc.withdraw(2000);   
        myAcc.checkBalance();
       }
}
