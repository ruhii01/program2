import java.util.*;

public class StudentCourses {
    private Map<String, Map<String, Integer>> semesterCourses;

    public StudentCourses() {
        semesterCourses = new LinkedHashMap<>();
    }

    public void addSemester(String semesterName, Map<String, Integer> courses) {
        semesterCourses.put(semesterName, courses);
    }

    public void displayCourses() {
        for (Map.Entry<String, Map<String, Integer>> semesterEntry : semesterCourses.entrySet()) {
            String semester = semesterEntry.getKey();
            Map<String, Integer> courses = semesterEntry.getValue();
            System.out.println("\nSemester: " + semester);
            for (Map.Entry<String, Integer> courseEntry : courses.entrySet()) {
                System.out.println("  Course: " + courseEntry.getKey() + " | Marks: " + courseEntry.getValue());
            }
        }
    }

    public static void main(String[] args) {
        StudentCourses sc = new StudentCourses();

        Map<String, Integer> sem1Courses = new LinkedHashMap<>();
        sem1Courses.put("Mathematics", 85);
        sem1Courses.put("Physics", 78);
        sem1Courses.put("Chemistry", 90);
        sc.addSemester("Semester 1", sem1Courses);

        Map<String, Integer> sem2Courses = new LinkedHashMap<>();
        sem2Courses.put("Biology", 88);
        sem2Courses.put("English", 92);
        sem2Courses.put("History", 80);
        sc.addSemester("Semester 2", sem2Courses);

        sc.displayCourses();
    }
}