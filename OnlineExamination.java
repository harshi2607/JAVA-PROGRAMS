import java.util.Scanner;

public class OnlineExamination {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== ONLINE EXAMINATION SYSTEM ===");
        System.out.print("Enter student name: ");
        String name = sc.nextLine();

        int marks = 0;
        String[] questions = {
            "1. Which language is used for this program?",
            "2. Which keyword creates an object in Java?",
            "3. Which symbol ends a Java statement?",
            "4. Which method starts a Java program?",
            "5. Which data type stores whole numbers?"
        };

        String[] options = {
            "1. Java  2. HTML  3. CSS",
            "1. class  2. new  3. void",
            "1. ,  2. ;  3. :",
            "1. start()  2. main()  3. run()",
            "1. int  2. String  3. boolean"
        };

        int[] answers = {1, 2, 2, 2, 1};

        for (int i = 0; i < questions.length; i++) {
            System.out.println("\n" + questions[i]);
            System.out.println(options[i]);
            System.out.print("Enter your answer (1-3): ");
            int answer = sc.nextInt();

            if (answer == answers[i]) {
                marks++;
            }
        }

        System.out.println("\n=== EXAM RESULT ===");
        System.out.println("Student Name: " + name);
        System.out.println("Total Questions: " + questions.length);
        System.out.println("Marks Obtained: " + marks);
        System.out.println("Percentage: "
                + (marks * 100.0 / questions.length) + "%");

        if (marks >= 3) {
            System.out.println("Result: PASS");
        } else {
            System.out.println("Result: FAIL");
        }

        sc.close();
    }
}
