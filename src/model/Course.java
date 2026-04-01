package src.model;
import java.util.ArrayList;
public class Course {
    private String courseCode;
    private String title;
    private int credits;
    private String professor;
    private ArrayList<String> students;

    public Course(String courseCode, String title, int credits, String professor) {
        this.courseCode = courseCode;
        this.title = title;
        this.credits = credits;
        this.professor = professor;
        this.students = new ArrayList<>();
    }

    public void addStudent(String studentEmail) {
        students.add(studentEmail);
    }

    public void displayCourse() {
        System.out.println(courseCode + " - " + title + " (" + credits + " credits)");
    }
}
