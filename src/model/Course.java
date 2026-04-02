package model;

import java.util.ArrayList;

public class Course{
    private String courseCode;
    private String title;
    private int credits;
    private String professor;
    private ArrayList<String> students;
    private int maxStudents;

    public Course(String courseCode, String title, int credits, String professor, int maxStudents) {
        this.courseCode = courseCode;
        this.title = title;
        this.credits = credits;
        this.professor = professor;
        this.maxStudents = maxStudents;
        this.students = new ArrayList<>();
    }

    public boolean addStudent(String studentEmail) {
        if (students.size() >= maxStudents) {
            return false;
        }
        students.add(studentEmail);
        return true;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void displayCourse() {
        System.out.println(courseCode + " - " + title + " (" + credits + " credits) | Prof: " + professor);
    }

    public int getCredits() {
    return credits;
    }
}