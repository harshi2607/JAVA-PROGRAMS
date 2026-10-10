import java.util.Scanner;
public class HospitalManagement {
   
    static Scanner sc = new Scanner(System.in);

    static String[] patientName = new String[100];
    static int[] patientAge = new int[100];
    static String[] disease = new String[100];
    static int count = 0;

    static void registerPatient() {
        System.out.print("Enter Patient Name: ");
        patientName[count] = sc.nextLine();

        System.out.print("Enter Age: ");
        patientAge[count] = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Disease: ");
        disease[count] = sc.nextLine();

        count++;

        System.out.println("Patient registered successfully!");
    }

    static void viewPatients() {
        if (count == 0) {
            System.out.println("No patient records found.");
            return;
        }

        System.out.println("\n--- Patient Records ---");

        for (int i = 0; i < count; i++) {
            System.out.println("Patient ID : " + (i + 1));
            System.out.println("Name      : " + patientName[i]);
            System.out.println("Age       : " + patientAge[i]);
            System.out.println("Disease   : " + disease[i]);
            System.out.println("-----------------------");
        }
    }

    static void bookAppointment() {
        System.out.print("Enter Patient ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        if (id >= 1 && id <= count) {
            System.out.print("Enter Doctor Name: ");
            String doctor = sc.nextLine();

            System.out.print("Enter Appointment Date: ");
            String date = sc.nextLine();

            System.out.println("Appointment booked successfully!");
            System.out.println("Patient : " + patientName[id - 1]);
            System.out.println("Doctor  : " + doctor);
            System.out.println("Date    : " + date);
        } else {
            System.out.println("Invalid Patient ID.");
        }
    }

    static void billing() {
        System.out.print("Enter Patient ID: ");
        int id = sc.nextInt();

        if (id >= 1 && id <= count) {
            System.out.print("Enter Consultation Fee: ");
            double consultation = sc.nextDouble();

            System.out.print("Enter Medicine Fee: ");
            double medicine = sc.nextDouble();

            double total = consultation + medicine;

            System.out.println("Patient Name : " + patientName[id - 1]);
            System.out.println("Total Bill   : Rs." + total);
        } else {
            System.out.println("Invalid Patient ID.");
        }
    }

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n===== HOSPITAL MANAGEMENT SYSTEM =====");
            System.out.println("1. Register Patient");
            System.out.println("2. View Patients");
            System.out.println("3. Book Appointment");
            System.out.println("4. Billing");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    registerPatient();
                    break;

                case 2:
                    viewPatients();
                    break;

                case 3:
                    bookAppointment();
                    break;

                case 4:
                    billing();
                    break;

                case 5:
                    System.out.println("Thank you!");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}

