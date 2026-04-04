package model;

public class Feedback<T> {

    private String studentId;
    private String courseCode;
    private T feedback;

    public Feedback(String studentId, String courseCode, T feedback) {
        this.studentId = studentId;
        this.courseCode = courseCode;
        this.feedback = feedback;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public T getFeedback() {
        return feedback;
    }

    public void display() {
        System.out.println("Student: " + studentId +
                " | Course: " + courseCode +
                " | Feedback: " + feedback);
    }
}