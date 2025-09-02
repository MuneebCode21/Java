package iDKKK;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);	
		Student[] students = new Student[2];

		for (int i = 0; i < 2; i++) {
		    System.out.print("Enter name: ");
		    String name = sc.nextLine();

		    System.out.print("Enter roll number: ");
		    int roll = sc.nextInt();

		    System.out.print("Enter marks: ");
		    double marks = sc.nextDouble();
		    sc.nextLine(); // clear buffer

		    System.out.print("Enter grade: ");
		    String grade = sc.nextLine();

		    students[i] = new Result(name, roll, marks, grade);
		} 

		for (Student s : students) {
		    s.displayResult(); // Calls overridden version in Result
		} sc.close();
	} 
} 
