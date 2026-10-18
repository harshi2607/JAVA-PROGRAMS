import java.util.Scanner;

public class AttendanceManagement {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("==================================");
        System.out.println("   ATTENDANCE MANAGEMENT SYSTEM");
        System.out.println("==================================");

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();

        if (n <= 0) {
            System.out.println("Number of students must be positive.");
            sc.close();
            return;
        }

        String[] names = new String[n];
        int[] totalClasses = new int[n];
        int[] attendedClasses = new int[n];
        double[] percentage = new double[n];

        // Enter student attendance details
        for (int i = 0; i < n; i++) {

            System.out.println("\nStudent " + (i + 1));

            System.out.print("Enter student name: ");
            names[i] = sc.nextLine();

            System.out.print("Enter total classes conducted: ");
            totalClasses[i] = sc.nextInt();

            if (totalClasses[i] < 0) {
                System.out.println("Total classes cannot be negative.");
                sc.close();
                return;
            }

            System.out.print("Enter classes attended: ");
            attendedClasses[i] = sc.nextInt();
            sc.nextLine();

            if (attendedClasses[i] < 0 ||
                    attendedClasses[i] > totalClasses[i]) {
                System.out.println("Invalid attendance details.");
                sc.close();
                return;
            }

            // Calculate attendance percentage
            if (totalClasses[i] > 0) {
                percentage[i] =
                    (attendedClasses[i] * 100.0)
                    / totalClasses[i];
            } else {
                percentage[i] = 0.0;
            }
        }

        // Display attendance report
        System.out.println("\n==============================================");
        System.out.println("             ATTENDANCE REPORT");
        System.out.println("==============================================");

        System.out.printf("%-18s %-10s %-10s %-12s %-12s%n",
                "Name", "Total", "Attended", "Percentage", "Status");

        System.out.println(
                "--------------------------------------------------------------");

        for (int i = 0; i < n; i++) {

            String status;

            if (percentage[i] < 75.0) {
                status = "LOW";
            } else {
                status = "ELIGIBLE";
            }

            System.out.printf("%-18s %-10d %-10d %-11.2f%% %-12s%n",
                    names[i],
                    totalClasses[i],
                    attendedClasses[i],
                    percentage[i],
                    status);
        }

        // Notify students with low attendance
        System.out.println("\n----- LOW ATTENDANCE NOTIFICATIONS -----");

        boolean found = false;

        for (int i = 0; i < n; i++) {

            if (percentage[i] < 75.0) {
                System.out.println(
                    "Alert: " + names[i]
                    + ", your attendance is "
                    + String.format("%.2f", percentage[i])
                    + "%. Please improve your attendance.");

                found = true;
            }
        }

        if (!found) {
            System.out.println("No students have low attendance.");
        }

        System.out.println("\nReport generated successfully!");
        sc.close();
    }
}
