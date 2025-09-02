package student.fee;

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student();  // default constructor
        Student s2 = new Student(1, "Ali", 100000); // parameter
        Student s3 = new Student(s2); // copy constructor

        s2.PrintFee();            // parent method
        s2.PrintFee(5000);        // overloaded

        NC nc = new NC(2, "Ahmed", 120000);
        GC gc = new GC(3, "Zain", 130000);
        PC pc = new PC(4, "Sara", 140000);

        nc.PrintFee();
        gc.PrintFee();
        pc.PrintFee();
    }
}
