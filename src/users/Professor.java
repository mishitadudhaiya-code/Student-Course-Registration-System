package users;

import java.util.Scanner;
import model.Course;
import model.Feedback;
import services.CourseService;
import services.FeedbackService;

public class Professor extends User {

    public Professor(String email, String password) {
        super(email, password);
    }

    @Override
    public void showMenu() {

        Scanner sc = new Scanner(System.in);
        CourseService cs = CourseService.getInstance();

        while (true) {

            System.out.println("\n--- PROFESSOR MENU ---");
            System.out.println("1. View My Courses");
            System.out.println("2. Update Course Details");
            System.out.println("3. View Enrolled Students");
            System.out.println("4. View Feedback");
            System.out.println("5. Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            // 1. VIEW MY COURSES
            if (choice == 1) {

                for (Course c : cs.getAllCourses()) {
                    if (c.getProfessorEmail().equalsIgnoreCase(getEmail())) {
                        c.displayCourse();
                    }
                }
            }

            // 2. UPDATE COURSE DETAILS
            else if (choice == 2) {

                System.out.print("Enter course code: ");
                String code = sc.nextLine();

                Course c = cs.getCourseByCode(code);

                if (c != null && c.getProfessorEmail().equalsIgnoreCase(getEmail())) {

                    System.out.println("1. Update Credits");
                    System.out.println("2. Update Time");

                    int opt = sc.nextInt();
                    sc.nextLine();

                    if (opt == 1) {
                        System.out.print("Enter new credits: ");
                        int cr = sc.nextInt();
                        c.setCredits(cr);
                        System.out.println("Updated!");
                    }

                    else if (opt == 2) {
                        System.out.print("Enter new time: ");
                        String t = sc.nextLine();
                        c.setTime(t);
                        System.out.println("Updated!");
                    }

                } else {
                    System.out.println("Not authorized!");
                }
            }

            // 3. VIEW ENROLLED STUDENTS
            else if (choice == 3) {

                System.out.print("Enter course code: ");
                String code = sc.nextLine();

                Course c = cs.getCourseByCode(code);

                if (c != null && c.getProfessorEmail().equalsIgnoreCase(getEmail())) {

                    for (String s : c.getStudents()) {
                        System.out.println("Student ID: " + s);
                    }

                } else {
                    System.out.println("Not authorized!");
                }
            }

            // 4. VIEW FEEDBACK
            else if (choice == 4) {

                boolean found = false;

                for (Course c : cs.getAllCourses()) {

                    if (c.getProfessorEmail().equalsIgnoreCase(getEmail())) {

                        System.out.println("\nCourse: " + c.getCourseCode());

                        for (Feedback f : FeedbackService.getInstance().getAllFeedback()) {

                            if (f.getCourseCode().equalsIgnoreCase(c.getCourseCode())) {

                                System.out.println("Student: " + f.getStudentId());
                                System.out.println("Feedback: " + f.getFeedback());
                                System.out.println("-------------------");

                                found = true;
                            }
                        }
                    }
                }

                if (!found) {
                    System.out.println("No feedback available.");
                }
            }

            // EXIT
            else if (choice == 5) {
                break;
            }
        }
    }
}