package practice4;

//Subclass using inheritance and final student ID
class Student extends Person {
 final String studentId;

 public Student(String name, String cnic, double balance, String studentId) {
     super(name, cnic, balance);
     this.studentId = studentId;
 }

 @Override
 public void displayInfo() {
     super.displayInfo();
     System.out.println("Student ID: " + studentId);
 }
}
