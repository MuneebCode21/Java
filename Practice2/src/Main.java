// Final class can't be extended
class Constants {
    public static final String SCHOOL_NAME = "Smart School";
}

class Person {
    private String name;
    private int age;

    // Constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Encapsulation - Getter
    public int getAge() {
        return age;
    }

    // Setter
    public void setAge(int age) {
        this.age = age;
    }

    public void speak() {
        System.out.println(name + " says hello");
    }
}

// Inheritance
class Student extends Person {
    private int[] marks;

    // Constructor uses super to call parent
    public Student(String name, int age, int[] marks) {
        super(name, age); // calling Person constructor
        this.marks = marks;
    }

    // Method Overriding - Runtime Polymorphism
    @Override
    public void speak() {
        System.out.println("Student introduces himself");
    }

    public int totalMarks() {
        int sum = 0;
        for (int m : marks) sum += m;
        return sum;
    }

    // Static method - shared
    public static void schoolInfo() {
        System.out.println("School: " + Constants.SCHOOL_NAME);
    }
}

// Singleton Class
class Principal {
    private static Principal obj;

    private Principal() {}

    public static Principal getInstance() {
        if (obj == null) obj = new Principal();
        return obj;
    }

    public void announce() {
        System.out.println("Principal announces holiday");
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        int[] marks = {80, 85, 90};
        Student s = new Student("Ali", 18, marks);
        s.speak(); // overridden
        System.out.println("Age: " + s.getAge());
        System.out.println("Total Marks: " + s.totalMarks());

        Student.schoolInfo(); // static method

        Principal p = Principal.getInstance();
        p.announce();
    }
}
