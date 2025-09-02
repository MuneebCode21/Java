package practice4;

//Subclass for Employee
class Employee extends Person {
 private static final String BANK_NAME = "Global Bank";
 private String employeeId;

 public Employee(String name, String cnic, double balance, String employeeId) {
     super(name, cnic, balance);
     this.employeeId = employeeId;
 }

 @Override
 public void displayInfo() {
     super.displayInfo();
     System.out.println("Employee ID: " + employeeId);
     System.out.println("Bank: " + BANK_NAME);
 }
}
