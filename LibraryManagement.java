
    
import java.util.*;

public class LibraryManagement {

    static Scanner sc = new Scanner(System.in);

    static String[] bookName = new String[100];
    static String[] author = new String[100];
    static boolean[] issued = new boolean[100];

    static int count = 0;

    static void addBook() {

        System.out.print("Enter Book Name: ");
        bookName[count] = sc.nextLine();

        System.out.print("Enter Author Name: ");
        author[count] = sc.nextLine();

        issued[count] = false;

        count++;

        System.out.println("Book added successfully!");
    }

    static void viewBooks() {

        if (count == 0) {
            System.out.println("No books available.");
            return;
        }

        System.out.println("\n--------- BOOK LIST ---------");

        for (int i = 0; i < count; i++) {

            System.out.println("Book ID : " + (i + 1));
            System.out.println("Book   : " + bookName[i]);
            System.out.println("Author : " + author[i]);

            if (issued[i])
                System.out.println("Status : Issued");
            else
                System.out.println("Status : Available");

            System.out.println("-----------------------------");
        }
    }

    static void issueBook() {

        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        if (id >= 1 && id <= count) {

            if (!issued[id - 1]) {
                issued[id - 1] = true;

                System.out.println(
                    "Book issued successfully to the student."
                );
            } else {
                System.out.println("Book is already issued.");
            }

        } else {
            System.out.println("Invalid Book ID.");
        }
    }

    static void returnBook() {

        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();

        if (id >= 1 && id <= count) {

            if (issued[id - 1]) {
                issued[id - 1] = false;

                System.out.println("Book returned successfully.");
            } else {
                System.out.println("This book was not issued.");
            }

        } else {
            System.out.println("Invalid Book ID.");
        }
    }

    static void calculateFine() {

        System.out.print("Enter number of overdue days: ");
        int days = sc.nextInt();

        double fine = 0;

        if (days > 0) {
            fine = days * 2;
        }

        System.out.println("Overdue Days : " + days);
        System.out.println("Fine Amount  : Rs." + fine);
    }

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n====== LIBRARY MANAGEMENT SYSTEM ======");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Calculate Fine");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    addBook();
                    break;

                case 2:
                    viewBooks();
                    break;

                case 3:
                    issueBook();
                    break;

                case 4:
                    returnBook();
                    break;

                case 5:
                    calculateFine();
                    break;

                case 6:
                    System.out.println("Thank you!");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
