import java.util.ArrayList;
import java.util.Scanner;

class Candidate {
    String name;
    String skill;
    String status;

    Candidate(String name, String skill) {
        this.name = name;
        this.skill = skill;
        this.status = "Pending";
    }

    void display() {
        System.out.println("Name: " + name);
        System.out.println("Skill: " + skill);
        System.out.println("Interview Status: " + status);
        System.out.println("--------------------");
    }
}

public class CandidateManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Candidate> list = new ArrayList<>();

        int choice;

        do {
            System.out.println("\n=== CANDIDATE MANAGEMENT ===");
            System.out.println("1. Add Candidate");
            System.out.println("2. Display Candidates");
            System.out.println("3. Search by Skill");
            System.out.println("4. Update Interview Status");
            System.out.println("5. Recruitment Report");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter candidate name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter skill: ");
                    String skill = sc.nextLine();

                    list.add(new Candidate(name, skill));
                    System.out.println("Candidate added successfully!");
                    break;

                case 2:
                    if (list.isEmpty()) {
                        System.out.println("No candidate records.");
                    }
                    for (Candidate c : list) {
                        c.display();
                    }
                    break;

                case 3:
                    System.out.print("Enter skill to search: ");
                    String search = sc.nextLine();
                    boolean found = false;

                    for (Candidate c : list) {
                        if (c.skill.equalsIgnoreCase(search)) {
                            c.display();
                            found = true;
                        }
                    }

                    if (!found) {
                        System.out.println("No matching candidates.");
                    }
                    break;

                case 4:
                    System.out.print("Enter candidate name: ");
                    String candidateName = sc.nextLine();
                    boolean updated = false;

                    for (Candidate c : list) {
                        if (c.name.equalsIgnoreCase(candidateName)) {
                            System.out.print(
                                "Enter status (Selected/Rejected/Pending): ");
                            c.status = sc.nextLine();
                            System.out.println("Status updated!");
                            updated = true;
                            break;
                        }
                    }

                    if (!updated) {
                        System.out.println("Candidate not found.");
                    }
                    break;

                case 5:
                    System.out.println("Total Candidates: " + list.size());
                    int selected = 0;

                    for (Candidate c : list) {
                        if (c.status.equalsIgnoreCase("Selected")) {
                            selected++;
                        }
                    }

                    System.out.println("Selected Candidates: " + selected);
                    System.out.println("Other Candidates: "
                            + (list.size() - selected));
                    break;

                case 0:
                    System.out.println("Exiting application.");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 0);

        sc.close();
    }
}
