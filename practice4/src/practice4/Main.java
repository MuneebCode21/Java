package practice4;

import java.util.Scanner;
//Main class with menu logic
public class Main {
 public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     Person user;

     System.out.println("Welcome to Global Bank System!");
     System.out.println("Select account type:\n1. Student\n2. Employee");
     int type = sc.nextInt();
     sc.nextLine(); // Consume newline

     System.out.print("Enter Name: ");
     String name = sc.nextLine();

     System.out.print("Enter CNIC: ");
     String cnic = sc.nextLine();

     System.out.print("Enter Initial Balance: ");
     double balance = sc.nextDouble();
     sc.nextLine();

     if (type == 1) {
         System.out.print("Enter Student ID: ");
         String sid = sc.nextLine();
         user = new Student(name, cnic, balance, sid); // upcasting
     } else {
         System.out.print("Enter Employee ID: ");
         String eid = sc.nextLine();
         user = new Employee(name, cnic, balance, eid); // upcasting
     }

     // Menu loop
     int choice;
     do {
         System.out.println("\n--- Banking Menu ---");
         System.out.println("1. Display Account Info");
         System.out.println("2. Deposit Money");
         System.out.println("3. Withdraw Money");
         System.out.println("4. Check Balance");
         System.out.println("5. Exit");
         System.out.print("Enter your choice: ");
         choice = sc.nextInt();

         switch (choice) {
             case 1:
                 user.displayInfo(); // polymorphic call
                 break;
             case 2:
                 System.out.print("Enter amount to deposit: ");
                 double dep = sc.nextDouble();
                 user.deposit(dep);
                 break;
             case 3:
                 System.out.print("Enter amount to withdraw: ");
                 double wd = sc.nextDouble();
                 user.withdraw(wd);
                 break;
             case 4:
                 System.out.println("Current Balance: " + user.getBalance());
                 break;
             case 5:
                 System.out.println("Thank you for using Global Bank!");
                 break;
             default:
                 System.out.println("Invalid choice!");
         }
     } while (choice != 5);
 }
}

