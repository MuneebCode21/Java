package mb;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n======= Vehicle Showroom Menu =======");
            System.out.println("1. Add & Display a Car");
            System.out.println("2. Add & Display a Bike");
            System.out.println("3. Add & Display a Super Vehicle");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            
            while (!input.hasNextInt()) {
                System.out.print("Please enter a valid number (1-4): ");
                input.next(); // discard invalid input
            }
            choice = input.nextInt();
            input.nextLine();  // consume leftover newline

            switch (choice) {
                case 1:
                    System.out.println("\n--- Enter Car Details ---");
                    System.out.print("Company: ");
                    String cComp = input.nextLine();
                    System.out.print("Color: ");
                    String cColor = input.nextLine();
                    System.out.print("Model Year: ");
                    int cModel = input.nextInt();
                    System.out.print("Price: ");
                    double cPrice = input.nextDouble();
                    System.out.print("Available (true/false): ");
                    boolean cAvail = input.nextBoolean();
                    System.out.print("Has Airbags (true/false): ");
                    boolean hasAC = input.nextBoolean();
                    input.nextLine(); // consume newline

                    Car car = new Car(cComp, cColor, cModel, cPrice, cAvail, hasAC);
                    System.out.println("\n--- Car Info ---");
                    System.out.println(car);
                    break;

                case 2:
                    System.out.println("\n--- Enter Bike Details ---");
                    System.out.print("Company: ");
                    String bComp = input.nextLine();
                    System.out.print("Color: ");
                    String bColor = input.nextLine();
                    System.out.print("Model Year: ");
                    int bModel = input.nextInt();
                    System.out.print("Price: ");
                    double bPrice = input.nextDouble();
                    System.out.print("Available (true/false): ");
                    boolean bAvail = input.nextBoolean();
                    System.out.print("Has ABS (true/false): ");
                    boolean abs = input.nextBoolean();
                    input.nextLine(); // consume newline

                    Bike bike = new Bike(bComp, bColor, bModel, bPrice, bAvail, abs);
                    System.out.println("\n--- Bike Info ---");
                    System.out.println(bike);
                    break;

                case 3:
                    System.out.println("\n--- Enter Super Vehicle Details ---");
                    System.out.print("Company: ");
                    String sComp = input.nextLine();
                    System.out.print("Color: ");
                    String sColor = input.nextLine();
                    System.out.print("Model Year: ");
                    int sModel = input.nextInt();
                    System.out.print("Price: ");
                    double sPrice = input.nextDouble();
                    System.out.print("Available (true/false): ");
                    boolean sAvail = input.nextBoolean();
                    System.out.print("Has Turbo (true/false): ");
                    boolean turbo = input.nextBoolean();
                    System.out.print("Has Nitro (true/false): ");

                    SuperVehicle sv = new SuperVehicle(sComp, sColor, sModel, sPrice, sAvail, turbo);
                    System.out.println("\n--- Super Vehicle Info ---");
                    System.out.println(sv);
                    break;

                case 4:
                    System.out.println("Exiting showroom menu. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option. Please choose between 1 and 4.");
            }

        } while (choice != 4);

        input.close();
    }
}
