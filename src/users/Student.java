package users;

import model.Course;
import model.Feedback;
import services.CourseService;
import services.FeedbackService;
import services.ComplaintService;
import model.Complaint;


import java.util.Scanner;

public class Student extends User {
    
    private String studentId;

    public Student(String email, String password, String studentId) {
        super(email, password);
        this.studentId = studentId;
    }

    public String getStudentId() {
        return studentId;
    }
    private void viewSchedule() {
        CourseService cs = CourseService.getInstance();

        System.out.println("\n--- WEEKLY SCHEDULE ---");

        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};

        boolean foundAny = false;

        for (String day : days) {
            boolean found = false;

            for (Course c : cs.getAllCourses()) {
                if (c.getStudents().contains(studentId) && c.getDay().equalsIgnoreCase(day)) {

                    if (!found) {
                        System.out.println("\n" + day + ":");
                        found = true;
                    }

                    System.out.println("  " + c.getCourseCode() + " - " + c.getTime());
                    foundAny = true;
                }
            }
        }

        if (!foundAny) {
            System.out.println("No courses registered.");
        }
    }
    // VIEW REGISTERED COURSES
    private void viewRegisteredCourses() {
        CourseService cs = CourseService.getInstance();
        boolean found = false;

        for (Course c : cs.getAllCourses()) {
            if (c.getStudents().contains(studentId)) {
                c.displayCourse();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No courses registered.");
        }
    }

    // CALCULATE TOTAL CREDITS
    private int calculateTotalCredits() {
        CourseService cs = CourseService.getInstance();
        int total = 0;

        for (Course c : cs.getAllCourses()) {
            if (c.getStudents().contains(studentId)) {
                total += c.getCredits();
            }
        }

        return total;
    }

    // CALCULATE SGPA
    private double calculateSGPA() {
        CourseService cs = CourseService.getInstance();

        double totalPoints = 0;
        int totalCredits = 0;

        for (Course c : cs.getAllCourses()) {
            if (c.getStudents().contains(studentId)) {

                String grade = c.getGrade(studentId);

                if (grade != null) {
                    int gradePoint = 0;

                    switch (grade) {
                        case "A": gradePoint = 10; break;
                        case "B": gradePoint = 8; break;
                        case "C": gradePoint = 6; break;
                        case "D": gradePoint = 4; break;
                        case "F": gradePoint = 0; break;
                    }

                    totalPoints += gradePoint * c.getCredits();
                    totalCredits += c.getCredits();
                }
            }
        }

        if (totalCredits == 0) {
            System.out.println("\nNo grades available yet.\n");
            return 0;
        }

        return totalPoints / totalCredits;
    }

    @Override
    public void showMenu() {
        Scanner sc = new Scanner(System.in);
        CourseService cs = CourseService.getInstance();
        ComplaintService cs2 = ComplaintService.getInstance();

        while (true) {
            System.out.println("\n1. View All Courses");
            System.out.println("2. Register Course");
            System.out.println("3. View Registered Courses");
            System.out.println("4. Drop Course");
            System.out.println("5. Submit Complaint");
            System.out.println("6. View My Complaints");
            System.out.println("7. View Academic Progress");
            System.out.println("8. View Schedule");
            System.out.println("9. Give Feedback");
            System.out.println("10. Exit");

            int choice = sc.nextInt();

            // VIEW ALL COURSES
            if (choice == 1) {
                cs.viewCourses();
            }

            // REGISTER COURSE
            else if (choice == 2) {
                System.out.print("Enter course code: ");
                String code = sc.next();

                Course c = cs.getCourseByCode(code);

                if (c != null) {

                    if (calculateTotalCredits() + c.getCredits() > 20) {
                        System.out.println("Credit limit exceeded (Max 20)");
                        continue;
                    }

                    boolean added = c.addStudent(studentId);

                    if (added) {
                        System.out.println("Registered successfully!");
                    } else {
                        System.out.println("Course full or already registered!");
                    }

                } else {
                    System.out.println("Course not found!");
                }
            }

            // VIEW REGISTERED COURSES
            else if (choice == 3) {
                viewRegisteredCourses();
            }

            // DROP COURSE
            else if (choice == 4) {
                System.out.print("Enter course code to drop: ");
                String code = sc.next();

                Course c = cs.getCourseByCode(code);

                if (c != null && c.getStudents().contains(studentId)) {

                    int index = c.getStudents().indexOf(studentId);
                    c.getStudents().remove(index);

                    System.out.println("Course dropped successfully!");

                } else {
                    System.out.println("You are not enrolled in this course.");
                }
            }

            // SUBMIT COMPLAINT
            else if (choice == 5) {
                sc.nextLine();
                System.out.print("Enter complaint: ");
                String desc = sc.nextLine();

                Complaint comp = new Complaint(email, desc);
                cs2.addComplaint(comp);

                System.out.println("Complaint submitted!");
            }

            // VIEW MY COMPLAINTS
            else if (choice == 6) {
                for (Complaint c : cs2.getAllComplaints()) {
                    if (c.getStudentEmail().equals(email)) {
                        c.display();
                    }
                }
            }

            // VIEW SGPA
            else if (choice == 7) {
                double sgpa = calculateSGPA();
                System.out.println("\nYour SGPA: " + sgpa + "\n");
            }
            else if (choice == 8) {
                viewSchedule();
            }
            else if (choice == 9) {
                System.out.print("Enter course code: ");
                String code = sc.next();

                sc.nextLine(); // clear buffer

                System.out.print("Enter feedback: ");
                String fb = sc.nextLine();

                Feedback<String> f = new Feedback<>(studentId, code, fb);
                FeedbackService.getInstance().addFeedback(f);

                System.out.println("Feedback submitted!");
            }

            else {
                break;
            }
        }
    }
}