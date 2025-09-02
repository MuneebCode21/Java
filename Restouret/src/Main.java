import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Dish[] menu = {
            new Dish("Chicken Biryani", 350, "Dine-In", true),
            new Dish("Zinger Burger", 250, "Parcel", false),
            new Dish("Beef Karahi", 600, "Dine-In", true),
            new Dish("Paratha Roll", 150, "Parcel"),
            new SpecialDish("Royal Platter", 1200, "Dine-In", true, "Best served with mint raita."),
            new SpecialDish("Grilled Fish", 800, "Parcel", true, "Spicy & smoky from Chef's oven.")
        };

        System.out.print("Welcome to ByteBite Restaurant! 🍔\nEnter your name: ");
        String customerName = scan.nextLine();

        System.out.print("Enter your available balance (Rs): ");
        double balance = scan.nextDouble();

        int choice;
        do {
            System.out.println("\n🧾 MENU:");
            for (int i = 0; i < menu.length; i++) {
                menu[i].displayDish(i + 1);
            }

            System.out.println("0. Exit");
            System.out.print("\nChoose your dish by number (0 to Exit): ");
            choice = scan.nextInt();

            if (choice == 0) {
                System.out.println("Thanks for visiting, " + customerName + "! Have a great day!");
                break;
            }

            if (choice < 1 || choice > menu.length) {
                System.out.println("❌ Invalid choice! Try again.");
                continue;
            }

            Dish selectedDish = menu[choice - 1];
            double price = selectedDish.getPrice();

            if (balance >= price) {
                System.out.println("✅ Order confirmed: " + selectedDish.getName());
                balance -= price;
                System.out.println("Remaining balance: Rs. " + balance);
            } else {
                System.out.println("❌ You don't have enough balance to buy " + selectedDish.getName());
                System.out.println("Required: Rs. " + price + ", Available: Rs. " + balance);
            }

        } while (true);

        scan.close();
    }
}