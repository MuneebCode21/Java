package practice4;

//Base class
class Person {
 private String name;
 private String cnic;
 protected double balance;

 public Person(String name, String cnic, double balance) {
     this.name = name;
     this.cnic = cnic;
     this.balance = balance;
 }

 public String getName() {
     return name;
 }

 public String getCnic() {
     return cnic;
 }

 public double getBalance() {
     return balance;
 }

 public void displayInfo() {
     System.out.println("Name: " + name);
     System.out.println("CNIC: " + cnic);
     System.out.println("Balance: " + balance);
 }

 public void deposit(double amount) {
     if (amount > 0) {
         balance += amount;
         System.out.println("Deposited: " + amount);
     } else {
         System.out.println("Invalid deposit amount.");
     }
 }

 public void withdraw(double amount) {
     if (amount > 0 && balance >= amount) {
         balance -= amount;
         System.out.println("Withdrawn: " + amount);
     } else {
         System.out.println("Insufficient balance or invalid amount.");
     }
 }
}
