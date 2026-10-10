
import java.util.*;

public class studentmarks{

    static class Student {
        int id;
        String name;
        String department;
        int semester;
        int totalClasses = 0;
        int presentClasses = 0;
        LinkedHashMap<String, Integer> marks = new LinkedHashMap<>();

        Student(int id, String name, String department, int semester) {
            this.id = id;
            this.name = name;
            this.department = department;
            this.semester = semester;
        }
    }

    static Scanner sc = new Scanner(System.in);
    static LinkedHashMap<Integer, Student> students = new LinkedHashMap<>();

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n==================================");
            System.out.println(" UNIVERSITY STUDENT RECORD SYSTEM");
            System.out.println("==================================");
            System.out.println("1. Add Student Profile");
            System.out.println("2. View Student Profiles");
            System.out.println("3. Record Attendance");
            System.out.println("4. Add Subject Marks");
            System.out.println("5. View Semester Performance");
            System.out.println("6. Generate Report Card");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = readInt();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    recordAttendance();
                    break;
                case 4:
                    addMarks();
                    break;
                case 5:
                    semesterPerformance();
                    break;
                case 6:
                    generateReport();
                    break;
                case 7:
                    System.out.println("Thank you for using the system!");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    static int readInt() {
        while (!sc.hasNextInt()) {
            System.out.print("Enter a valid number: ");
            sc.next();
        }
        return sc.nextInt();
    }

    static Student findStudent() {
        System.out.print("Enter Student ID: ");
        int id = readInt();

        Student s = students.get(id);

        if (s == null) {
            System.out.println("Student not found!");
        }

        return s;
    }

    static void addStudent() {
        System.out.print("Enter Student ID: ");
        int id = readInt();

        if (students.containsKey(id)) {
            System.out.println("Student ID already exists!");
            return;
        }

        sc.nextLine();

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Department: ");
        String department = sc.nextLine();

        System.out.print("Enter Semester: ");
        int semester = readInt();

        if (semester < 1 || semester > 12) {
            System.out.println("Invalid semester!");
            return;
        }

        students.put(id, new Student(id, name, department, semester));
        System.out.println("Student profile added successfully!");
    }

    static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No student records available.");
            return;
        }

        System.out.println("\n--- STUDENT PROFILES ---");

        for (Student s : students.values()) {
            System.out.println("ID: " + s.id
                    + " | Name: " + s.name
                    + " | Department: " + s.department
                    + " | Semester: " + s.semester);
        }
    }

    static void recordAttendance() {
        Student s = findStudent();
        if (s == null) return;

        System.out.print("Number of classes held: ");
        int held = readInt();

        System.out.print("Number of classes attended: ");
        int attended = readInt();

        if (held <= 0 || attended < 0 || attended > held) {
            System.out.println("Invalid attendance values!");
            return;
        }

        s.totalClasses += held;
        s.presentClasses += attended;

        System.out.println("Attendance recorded successfully!");
        System.out.printf("Overall Attendance: %.2f%%%n",
                100.0 * s.presentClasses / s.totalClasses);
    }

    static void addMarks() {
        Student s = findStudent();
        if (s == null) return;

        sc.nextLine();

        System.out.print("Enter Subject Name: ");
        String subject = sc.nextLine().trim();

        if (subject.isEmpty()) {
            System.out.println("Subject name cannot be empty!");
            return;
        }

        System.out.print("Enter Marks (0-100): ");
        int mark = readInt();

        if (mark < 0 || mark > 100) {
            System.out.println("Marks must be between 0 and 100!");
            return;
        }

        s.marks.put(subject, mark);
        System.out.println("Marks added successfully!");
    }

    static void semesterPerformance() {
        Student s = findStudent();
        if (s == null) return;

        if (s.marks.isEmpty()) {
            System.out.println("No marks available.");
            return;
        }

        int total = 0;
        int count = s.marks.size();

        System.out.println("\n--- SEMESTER PERFORMANCE ---");

        for (Map.Entry<String, Integer> entry : s.marks.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
            total += entry.getValue();
        }

        double percentage = (double) total / count;

        System.out.println("Total Marks: " + total + "/" + (count * 100));
        System.out.printf("Percentage: %.2f%%%n", percentage);
        System.out.println("Grade: " + getGrade(percentage));
    }

    static String getGrade(double percentage) {
        if (percentage >= 90) return "A+";
        if (percentage >= 80) return "A";
        if (percentage >= 70) return "B";
        if (percentage >= 60) return "C";
        if (percentage >= 50) return "D";
        return "F";
    }

    static void generateReport() {
        Student s = findStudent();
        if (s == null) return;

        int total = 0;
        int count = s.marks.size();

        System.out.println("\n==================================");
        System.out.println("         STUDENT REPORT CARD");
        System.out.println("==================================");
        System.out.println("Student ID : " + s.id);
        System.out.println("Name       : " + s.name);
        System.out.println("Department : " + s.department);
        System.out.println("Semester   : " + s.semester);

        System.out.println("\n--- SUBJECT MARKS ---");

        if (s.marks.isEmpty()) {
            System.out.println("No subject marks entered.");
        } else {
            for (Map.Entry<String, Integer> entry : s.marks.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue() + "/100");
                total += entry.getValue();
            }

            double percentage = (double) total / count;

            System.out.println("----------------------------------");
            System.out.println("Total Marks : " + total + "/" + (count * 100));
            System.out.printf("Percentage  : %.2f%%%n", percentage);
            System.out.println("Grade       : " + getGrade(percentage));
            System.out.println("Result      : " +
                    (percentage >= 40 ? "PASS" : "FAIL"));
        }

        System.out.println("\n--- ATTENDANCE ---");

        if (s.totalClasses > 0) {
            double attendance = 100.0 * s.presentClasses / s.totalClasses;
            System.out.printf("Attendance: %.2f%%%n", attendance);
            System.out.println("Classes Attended: " + s.presentClasses);
            System.out.println("Total Classes: " + s.totalClasses);
        } else {
            System.out.println("Attendance not recorded.");
        }

        System.out.println("==================================");
        System.out.println("       END OF REPORT CARD");
        System.out.println("==================================");
    }
}

