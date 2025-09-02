package lol;
import java.util.Scanner;

// Superclass
class Animal {
    private String name; // private field
    protected int age;

    // Constructor
    Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getter and Setter for private variable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Methods to be overridden
    public void makeSound() {
        System.out.println("Animal makes a sound.");
    }

    public void move() {
        System.out.println("Animal moves in some way.");
    }

    public void info() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

// Subclass Bird
class Bird extends Animal {
    Bird(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " chirps.");
    }

    @Override
    public void move() {
        System.out.println(getName() + " flies in the sky.");
    }
}

// Subclass Fish
class Fish extends Animal {
    Fish(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " makes bubble sounds.");
    }

    @Override
    public void move() {
        System.out.println(getName() + " swims in water.");
    }
}

// Subclass Mammal
class Mammal extends Animal {
    Mammal(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " growls or barks.");
    }

    @Override
    public void move() {
        System.out.println(getName() + " runs on land.");
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Animal[] zoo = new Animal[5]; // Array to store animals
        int count = 0;

        int choice;

        do {
            System.out.println("\n--- Animal Zoo Menu ---");
            System.out.println("1. Add Bird");
            System.out.println("2. Add Fish");
            System.out.println("3. Add Mammal");
            System.out.println("4. Show All Animals");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    if (count < zoo.length) {
                        System.out.print("Enter bird name: ");
                        String bname = scanner.nextLine();
                        System.out.print("Enter bird age: ");
                        int bage = scanner.nextInt();
                        zoo[count++] = new Bird(bname, bage);
                        System.out.println("Bird added.");
                    } else {
                        System.out.println("Zoo is full.");
                    }
                    break;

                case 2:
                    if (count < zoo.length) {
                        System.out.print("Enter fish name: ");
                        String fname = scanner.nextLine();
                        System.out.print("Enter fish age: ");
                        int fage = scanner.nextInt();
                        zoo[count++] = new Fish(fname, fage);
                        System.out.println("Fish added.");
                    } else {
                        System.out.println("Zoo is full.");
                    }
                    break;

                case 3:
                    if (count < zoo.length) {
                        System.out.print("Enter mammal name: ");
                        String mname = scanner.nextLine();
                        System.out.print("Enter mammal age: ");
                        int mage = scanner.nextInt();
                        zoo[count++] = new Mammal(mname, mage);
                        System.out.println("Mammal added.");
                    } else {
                        System.out.println("Zoo is full.");
                    }
                    break;

                case 4:
                    if (count == 0) {
                        System.out.println("No animals in the zoo yet.");
                    } else {
                        System.out.println("\n--- All Animals ---");
                        for (int i = 0; i < count; i++) {
                            zoo[i].info();           // parent method
                            zoo[i].makeSound();      // overridden
                            zoo[i].move();           // overridden
                            System.out.println();
                        }
                    }
                    break;

                case 5:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 5);

        scanner.close();
    }
}
