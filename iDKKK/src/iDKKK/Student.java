package iDKKK;

public class Student {
    String name;
    private int rollNo;
    double marks;
    double average;

    Student(String name, int rollNo, double marks) {
        this.name = name;
        this.rollNo = rollNo;
        this.marks = marks;
        this.average = calculateAverage(marks);
    }

    public int getrollNo() {
        return rollNo;
    }

    public double calculateAverage(double marks) {
        return marks; 
    }
    
    public void displayResult() {
        System.out.println("Student: " + name + ", Roll No: " + rollNo + ", Marks: " + marks);
    }
}




