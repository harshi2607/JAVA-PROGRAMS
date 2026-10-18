
    import java.util.Scanner;

public class InventoryManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] products = {"Rice", "Sugar", "Oil"};
        double[] prices = {60, 45, 120};
        int[] stock = {100, 80, 50};

        int choice;

        do {
            System.out.println("\n=== INVENTORY MANAGEMENT SYSTEM ===");
            System.out.println("1. Display Products");
            System.out.println("2. Sell Product and Generate Bill");
            System.out.println("3. Update Stock");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\nProduct\tPrice\tStock");
                    for (int i = 0; i < products.length; i++) {
                        System.out.println(products[i] + "\tRs."
                                + prices[i] + "\t" + stock[i]);
                    }
                    break;

                case 2:
                    System.out.println("Select Product:");
                    for (int i = 0; i < products.length; i++) {
                        System.out.println((i + 1) + ". " + products[i]);
                    }

                    System.out.print("Enter product number: ");
                    int product = sc.nextInt();

                    if (product < 1 || product > products.length) {
                        System.out.println("Invalid product!");
                        break;
                    }

                    int index = product - 1;

                    System.out.print("Enter quantity: ");
                    int quantity = sc.nextInt();

                    if (quantity <= 0 || quantity > stock[index]) {
                        System.out.println("Invalid quantity or insufficient stock!");
                        break;
                    }

                    double amount = prices[index] * quantity;
                    double discount = amount * 0.05;
                    double taxableAmount = amount - discount;
                    double gst = taxableAmount * 0.05;
                    double total = taxableAmount + gst;

                    stock[index] -= quantity;

                    System.out.println("\n===== CUSTOMER BILL =====");
                    System.out.println("Product: " + products[index]);
                    System.out.println("Quantity: " + quantity);
                    System.out.println("Amount: Rs. " + amount);
                    System.out.println("Discount (5%): Rs. " + discount);
                    System.out.println("GST (5%): Rs. " + gst);
                    System.out.println("Total Bill: Rs. " + total);
                    System.out.println("Stock updated successfully!");
                    break;

                case 3:
                    System.out.print("Enter product number (1-3): ");
                    int p = sc.nextInt();

                    if (p < 1 || p > products.length) {
                        System.out.println("Invalid product!");
                        break;
                    }

                    System.out.print("Enter quantity to add: ");
                    int add = sc.nextInt();

                    if (add <= 0) {
                        System.out.println("Quantity must be positive.");
                        break;
                    }

                    stock[p - 1] += add;
                    System.out.println("Stock updated successfully!");
                    System.out.println("Available stock: "
                            + stock[p - 1]);
                    break;

                case 0:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 0);

        sc.close();
    }
}

