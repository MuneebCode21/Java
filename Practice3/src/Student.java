public class Student extends Person {
    final String studentId;
    String course;

    public Student(String name, int age, String studentId, String course) {
        super(name, age);
        this.studentId = studentId;
        this.course = course;
    }

    @Override
    public void display() {
        System.out.println("Name: " + getName() +
                           ", Age: " + age +
                           ", Student ID: " + studentId +
                           ", Course: " + course);
    }
}
