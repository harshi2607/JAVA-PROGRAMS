
    import java.time.LocalDate;
import java.time.Period;
import java.time.DayOfWeek;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Birthday {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Display current date
        LocalDate today = LocalDate.now();
        System.out.println("==================================");
        System.out.println(" DIGITAL BIRTHDAY REMINDER SYSTEM");
        System.out.println("==================================");
        System.out.println("Today's Date: " + today);

        // Accept person's details
        System.out.print("Enter person's name: ");
        String name = sc.nextLine();

        LocalDate dob;

        // Read and validate date of birth
        while (true) {
            try {
                System.out.print("Enter date of birth (dd-MM-yyyy): ");
                String input = sc.nextLine();

                DateTimeFormatter formatter =
                        DateTimeFormatter.ofPattern("dd-MM-uuuu")
                                .withResolverStyle(
                                        java.time.format.ResolverStyle.STRICT);

                dob = LocalDate.parse(input, formatter);

                if (dob.isAfter(today)) {
                    System.out.println(
                            "Date of birth cannot be in the future.");
                    continue;
                }

                break;

            } catch (Exception e) {
                System.out.println(
                        "Invalid date! Please use dd-MM-yyyy.");
                        System.out.println("Error:"+e.getMessage());
            }
        }

        // Display date of birth
        DateTimeFormatter outputFormat =
                DateTimeFormatter.ofPattern("dd-MM-uuuu");

        System.out.println("\n----- Birthday Details -----");
        System.out.println("Name: " + name);
        System.out.println("Date of Birth: "
                + dob.format(outputFormat));

        // Calculate age
        Period age = Period.between(dob, today);

        System.out.println("Age: " + age.getYears() + " years, "
                + age.getMonths() + " months, "
                + age.getDays() + " days");

        // Find day of birth
        DayOfWeek birthDay = dob.getDayOfWeek();
        System.out.println("Day of Birth: " + birthDay);

        // Calculate next birthday
        LocalDate nextBirthday = dob.withYear(today.getYear());

        if (nextBirthday.isBefore(today)) {
            nextBirthday = nextBirthday.plusYears(1);
        }

        // Handle February 29 birthdays in non-leap years
        if (dob.getMonthValue() == 2 && dob.getDayOfMonth() == 29
                && !java.time.Year.isLeap(nextBirthday.getYear())) {
            nextBirthday = LocalDate.of(
                    nextBirthday.getYear(), 2, 28);
        }

        long daysRemaining =
                ChronoUnit.DAYS.between(today, nextBirthday);

        System.out.println("Next Birthday: "
                + nextBirthday.format(outputFormat));

        System.out.println("Days Remaining Until Birthday: "
                + daysRemaining);

        // Display birthday greeting
        if (dob.getMonthValue() == today.getMonthValue()
                && dob.getDayOfMonth() == today.getDayOfMonth()) {

            System.out.println("\n🎉 HAPPY BIRTHDAY, "
                    + name.toUpperCase() + "! 🎂");
            System.out.println("Wishing you a wonderful year ahead!");
        } else {
            System.out.println("\nBirthday reminder saved for "
                    + name + ".");
        }

        System.out.println("\nThank you for using the system!");
        sc.close();
    }
}

