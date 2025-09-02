// 1st Functional Interface (for student introduction)
@FunctionalInterface
interface Introduction {
    void introduce(String name, int age, String role);
}

// 2nd Functional Interface (for fee calculation)
@FunctionalInterface
interface FeeCalculator {
    double calculate(double baseFee, double discount);
}

// 3rd Functional Interface (for grading system)
@FunctionalInterface
interface Grader {
    String grade(int marks);
}

// Abstract class (Abstraction + Encapsulation)
abstract class Person {
    private String name;    // Encapsulation + Info Hiding
    private int age;

    // Constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getters (Info hiding: no direct field access)
    public String getName() { return name; }
    public int getAge() { return age; }

    // Abstract Method (must be overridden in subclasses)
    public abstract void displayRole();
}

// Abstract Student class (template for all students)
abstract class Student extends Person implements Introduction {
    private int marks;

    public Student(String name, int age, int marks) {
        super(name, age);  // Constructor chaining
        this.marks = marks;
    }

    public int getMarks() { return marks; }

    @Override
    public void displayRole() {
        System.out.println("👨‍🎓 Student: " + getName() + ", Age: " + getAge() + ", Marks: " + marks);
    }
}

// ✅ Concrete subclass of Student
class HighSchoolStudent extends Student {
    public HighSchoolStudent(String name, int age, int marks) {
        super(name, age, marks);
    }

    @Override
    public void introduce(String name, int age, String role) {
        System.out.println("Hi, I'm " + name + ", Age: " + age + ", Role: " + role);
    }
}

// Subclass Teacher (Inheritance + Overriding)
class Teacher extends Person {
    private String subject;

    public Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    public String getSubject() { return subject; }

    @Override
    public void displayRole() {
        System.out.println("👩‍🏫 Teacher: " + getName() + ", Age: " + getAge() + ", Subject: " + subject);
    }
}

// Subclass Staff (Inheritance + Overriding)
class Staff extends Person {
    private String department;

    public Staff(String name, int age, String department) {
        super(name, age);
        this.department = department;
    }

    public String getDepartment() { return department; }

    @Override
    public void displayRole() {
        System.out.println("🛠️ Staff: " + getName() + ", Age: " + getAge() + ", Department: " + department);
    }
}

// Main Class
public class Main {
    public static void main(String[] args) {

        System.out.println("===== 🎓 SCHOOL MANAGEMENT SYSTEM =====");

        // Runtime Polymorphism (Parent reference to child objects)
        Person[] people = {
            new HighSchoolStudent("Ali", 16, 85),  // ✅ Now works
            new Teacher("Sara", 35, "Mathematics"),
            new Staff("John", 40, "Administration")
        };

        // 1st Functional Interface (Lambda for Introduction)
        Introduction intro = (name, age, role) -> {
            System.out.println("Welcome " + role + "! Name: " + name + ", Age: " + age);
        };

        // 2nd Functional Interface (Lambda for Fee Calculation)
        FeeCalculator feeCalc = (base, discount) -> base - (base * discount / 100);

        // 3rd Functional Interface (Lambda for Grading System)
        Grader grader = (marks) -> {
            if (marks >= 90) return "A+";
            else if (marks >= 75) return "B";
            else if (marks >= 50) return "C";
            else return "F";
        };

        // Loop through people (For loop demonstration)
        for (Person p : people) {
            p.displayRole(); // Overridden method

            // Introduction using lambda
            intro.introduce(p.getName(), p.getAge(), p.getClass().getSimpleName());

            // Extra logic for students only
            if (p instanceof Student s) {  // Java 16+ pattern matching
                System.out.println("Marks: " + s.getMarks());
                System.out.println("Grade: " + grader.grade(s.getMarks()));

                // Fee calculation example
                double fee = 20000;
                double finalFee = feeCalc.calculate(fee, 10); // 10% discount
                System.out.println("Final Fee after discount: " + finalFee);
            }

            System.out.println("----------------------------------");
        }

        // Switch Example (menu simulation)
        int choice = 2;
        switch (choice) {
            case 1 -> System.out.println("📚 School Info: Welcome to ABC High School.");
            case 2 -> System.out.println("🏫 Today's Schedule: Math, Science, Sports.");
            case 3 -> System.out.println("🎉 Events: Annual Sports Day next week!");
            default -> System.out.println("Invalid choice.");
        }
    }
}
