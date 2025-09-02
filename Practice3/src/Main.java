public class Main {
    public static void main(String[] args) {

        Person p1 = new Student("Ali", 21, "S101", "Computer Science");

        // Even though p1 is of type Person, the overridden method in Student is called
        p1.display();

        // You can also create multiple Person-type references
        Person[] people = new Person[2];
        people[0] = new Person("Ahmed", 45);
        people[1] = new Student("Sara", 19, "S202", "Electrical Engineering");

        System.out.println("\n-- Polymorphic Array Output --");
        for (Person p : people) {
            p.display(); // Calls correct method at runtime
        }
    }
}
