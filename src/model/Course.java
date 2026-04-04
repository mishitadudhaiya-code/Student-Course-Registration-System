package model;

import java.util.ArrayList;

public class Course {

    private String courseCode;
    private String title;
    private int credits;
    private String professor;
    private int maxStudents;

    private ArrayList<String> students;
    private ArrayList<String> grades;
    private String day;
    private String time;
    

    public Course(String courseCode, String title, int credits, String professor, int maxStudents, String day, String time) {
        this.courseCode = courseCode;
        this.title = title;
        this.credits = credits;
        this.professor = professor;
        this.maxStudents = maxStudents;
        this.day = day;
        this.time = time;

        students = new ArrayList<>();
        grades = new ArrayList<>();
    }

    // Add student
    public boolean addStudent(String studentId) {

    if (students.contains(studentId)) {
        System.out.println("Student already registered!");
        return false;
    }

    if (students.size() >= maxStudents) {
        return false;
    }

    students.add(studentId);
    grades.add(null);
    return true;
}

    // Assign grade
    public boolean assignGrade(String studentId, String grade) {
    for (int i = 0; i < students.size(); i++) {
        if (students.get(i).equals(studentId)) {
            grades.set(i, grade);
            return true;
        }
    }
    return false;
}

    // Get grade
    public String getGrade(String studentId) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).equals(studentId)) {
                return grades.get(i);
            }
        }
        return null;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public int getCredits() {
        return credits;
    }

    public String getProfessor() {
        return professor;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public ArrayList<String> getStudents() {
        return students;
    }

    public void displayCourse() {
        System.out.println(courseCode + " - " + title + " (" + credits + " credits) | Prof: " + professor);
    }
    public String getDay() {
        return day;
    }

    public String getTime() {
        return time;
    }
}