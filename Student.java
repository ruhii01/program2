import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Student {
    private String name;
    private LocalDate dateOfBirth;

    public Student(String name, String dob) {
        this.name = name;
        this.dateOfBirth = parseDate(dob);
    }

    private LocalDate parseDate(String dob) {
        LocalDate date = null;
        try {
            if (dob.contains("-")) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                date = LocalDate.parse(dob, formatter);
            } else if (dob.contains("/")) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                date = LocalDate.parse(dob, formatter);
            } else {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
                date = LocalDate.parse(dob, formatter);
            }
        } catch (Exception e) {
            System.out.println("Invalid date format. Please use DD-MM-YYYY or YYYYMMDD.");
        }
        return date;
    }

    public void displayInfo() {
        if (dateOfBirth != null) {
            int age = Period.between(dateOfBirth, LocalDate.now()).getYears();
            System.out.println("Student Name: " + name);
            System.out.println("Age: " + age + " years");
        } else {
            System.out.println("Date of birth is not set correctly.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter date of birth (DD-MM-YYYY or YYYYMMDD): ");
        String dob = scanner.nextLine();
        Student student = new Student(name, dob);
        student.displayInfo();
        scanner.close();
    }
}