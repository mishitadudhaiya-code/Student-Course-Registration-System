package model;

import java.util.ArrayList;

public class Course {

    private String courseCode;
    private String title;
    private int credits;

    // 🔥 UPDATED: store BOTH
    private String professorEmail;
    private String professorName;

    private int maxStudents;

    private ArrayList<String> students;
    private ArrayList<String> grades;

    private String day;
    private String time;
    private String prerequisite;

    // ✅ FINAL CONSTRUCTOR
    public Course(String courseCode, String title, int credits,
                  String professorEmail, String professorName,
                  int maxStudents, String prerequisite,
                  String day, String time) {

        this.courseCode = courseCode;
        this.title = title;
        this.credits = credits;
        this.professorEmail = professorEmail;
        this.professorName = professorName;
        this.maxStudents = maxStudents;
        this.prerequisite = prerequisite;
        this.day = day;
        this.time = time;

        students = new ArrayList<>();
        grades = new ArrayList<>();
    }

    // ✅ ADD STUDENT
    public boolean addStudent(String studentId) {

        if (students.contains(studentId)) return false;

        if (students.size() >= maxStudents) return false;

        students.add(studentId);
        grades.add(null);

        return true;
    }

    // ✅ ASSIGN GRADE
    public boolean assignGrade(String studentId, String grade) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).equals(studentId)) {
                grades.set(i, grade);
                return true;
            }
        }
        return false;
    }

    // ✅ GET GRADE
    public String getGrade(String studentId) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).equals(studentId)) {
                return grades.get(i);
            }
        }
        return null;
    }

    // ✅ GETTERS

    public String getCourseCode() {
        return courseCode;
    }

    public int getCredits() {
        return credits;
    }

    public String getProfessorEmail() {
        return professorEmail;
    }

    public String getProfessorName() {
        return professorName;
    }

    public String getPrerequisite() {
        return prerequisite;
    }

    public String getDay() {
        return day;
    }

    public String getTime() {
        return time;
    }

    public ArrayList<String> getStudents() {
        return students;
    }

    // ✅ SETTERS

    public void setProfessor(String email, String name) {
        this.professorEmail = email;
        this.professorName = name;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public void setTime(String time) {
        this.time = time;
    }

    // ✅ DISPLAY (IMPORTANT FOR OUTPUT)
    public void displayCourse() {
        System.out.println(courseCode + " - " + title +
                " (" + credits + " credits) | Prof: " + professorName +
                " | Day: " + day +
                " | Time: " + time +
                " | Prerequisite: " + (prerequisite == null ? "None" : prerequisite));
    }
}