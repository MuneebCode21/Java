// First interface
interface Playable {
    void play(); // abstract by default
}

// Second interface
interface Trainable {
    void train();
}

// Abstract class (for abstraction)
abstract class Player {
    private String name;
    private int age;

    // Constructor
    public Player(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getter and Setter (Encapsulation)
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    // Abstract method
    abstract void displayRole();

    // Normal method
    public void introduce() {
        System.out.println("Hi, I'm " + name + ", age " + age);
    }
}

// Concrete class implementing multiple interfaces + extending abstract class
class FootballPlayer extends Player implements Playable, Trainable {

    private String position;

    // Constructor
    public FootballPlayer(String name, int age, String position) {
        super(name, age); // call parent constructor
        this.position = position;
    }

    // Overriding abstract method from Player
    @Override
    void displayRole() {
        System.out.println(getName() + " plays as a " + position);
    }

    // Overriding methods from interfaces
    @Override
    public void play() {
        System.out.println(getName() + " is playing football.");
    }

    @Override
    public void train() {
        System.out.println(getName() + " is training hard.");
    }

    // Getter & Setter for position
    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }
}

// Main class
public class Main {
    public static void main(String[] args) {
        // Create object using constructor
        FootballPlayer p1 = new FootballPlayer("Messi", 37, "Forward");

        // Call parent class methods
        p1.introduce();       // from abstract class
        p1.displayRole();     // overridden abstract method

        // Call interface methods
        p1.play();            // from Playable
        p1.train();           // from Trainable

        // Use setter to update data
        p1.setPosition("Attacking Midfielder");
        p1.setAge(38);

        // Use getter to retrieve data
        System.out.println("Updated Position: " + p1.getPosition());
        System.out.println("Updated Age: " + p1.getAge());
    }
}
