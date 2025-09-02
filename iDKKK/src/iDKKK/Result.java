package iDKKK;

public class Result extends Student {
    String grade;

    Result(String name, int rollNo, double marks, String grade) {
        super(name, rollNo, marks);
        this.grade = grade;
    }
    
    @Override
    public void displayResult() {
        if (average >= 50) {
            System.out.println("Name: " + name + " Roll No: " + getrollNo() + 
                " Marks: " + marks + " Grade: " + grade);
        } else {
            System.out.println("Failed");
        }
    }
}
