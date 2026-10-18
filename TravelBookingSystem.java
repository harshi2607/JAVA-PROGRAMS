import java.util.Scanner;

public class TravelBookingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String customerName, destination;
        int choice, persons;
        double price, total;

        System.out.println("=== TRAVEL BOOKING SYSTEM ===");
        System.out.print("Enter customer name: ");
        customerName = sc.nextLine();

        do {
            System.out.println("\n1. Goa - Rs. 5000/person");
            System.out.println("2. Ooty - Rs. 4000/person");
            System.out.println("3. Hyderabad - Rs. 3000/person");
            System.out.print("Choose destination: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    destination = "Goa";
                    price = 5000;
                    break;
                case 2:
                    destination = "Ooty";
                    price = 4000;
                    break;
                case 3:
                    destination = "Hyderabad";
                    price = 3000;
                    break;
                default:
                    System.out.println("Invalid choice!");
                    continue;
            }

            System.out.print("Enter number of persons: ");
            persons = sc.nextInt();

            if (persons <= 0) {
                System.out.println("Invalid number of persons!");
                continue;
            }

            total = price * persons;
            System.out.println("\n--- BOOKING DETAILS ---");
            System.out.println("Customer: " + customerName);
            System.out.println("Destination: " + destination);
            System.out.println("Persons: " + persons);
            System.out.println("Total amount: Rs. " + total);

            System.out.print("Payment completed? (1=Yes, 0=No): ");
            int payment = sc.nextInt();

            if (payment == 1)
                System.out.println("Booking confirmed!");
            else
                System.out.println("Payment pending.");

            System.out.println("Travel schedule: Contact the travel agency.");
            break;

        } while (true);

        sc.close();
    }
}
