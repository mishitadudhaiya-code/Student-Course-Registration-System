package model;

public class Complaint {
    private String studentEmail;
    private String description;
    private String status;

    public Complaint(String studentEmail, String description) {
        this.studentEmail = studentEmail;
        this.description = description;
        this.status = "Pending";
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void display() {
        System.out.println("Student: " + studentEmail);
        System.out.println("Issue: " + description);
        System.out.println("Status: " + status);
        System.out.println("-----------------------");
    }
}