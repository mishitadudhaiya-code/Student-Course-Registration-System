package users;

import java.util.Scanner;
import model.Complaint;
import model.Course;
import services.ComplaintService;
import services.CourseService;


public class Administrator extends User {

    public Administrator(String email, String password) {
        super(email, password);
    }

    @Override
    public void showMenu() {
        Scanner sc = new Scanner(System.in);
        CourseService cs = CourseService.getInstance();
        

        while (true) {
            ComplaintService cs2 = ComplaintService.getInstance();
            System.out.println("\n--- ADMIN MENU ---");
            System.out.println("1. View All Courses");
            System.out.println("2. Add Course");
            System.out.println("3. Delete Course");
            System.out.println("4. View Complaints");
            System.out.println("5. Resolve Complaint");
            System.out.println("6. Assign Grade");
            System.out.println("7. Exit");

            int choice = sc.nextInt();

            if (choice == 1) {
                cs.viewCourses();
            }

            else if (choice == 2) {
                System.out.print("Enter course code: ");
                String code = sc.next();

                System.out.print("Enter title: ");
                String title = sc.next();

                System.out.print("Enter credits: ");
                int credits = sc.nextInt();

                System.out.print("Enter professor: ");
                String prof = sc.next();

                System.out.print("Enter max students: ");
                int max = sc.nextInt();

                System.out.print("Enter day (Monday, Tuesday...): ");
                String day = sc.next();

                System.out.print("Enter time (e.g. 10AM): ");
                String time = sc.next();

                Course c = new Course(code, title, credits, prof, max, day, time);

                cs.addCourse(c);
                System.out.println("Course added successfully!");
            }
            else if (choice == 3) {
                System.out.print("Enter course code to delete: ");
                String code = sc.next();

                boolean removed = cs.deleteCourse(code);

                if (removed) {
                    System.out.println("Course deleted successfully!");
                } else {
                    System.out.println("Course not found!");
                }
            }
            else if (choice == 4) {
                for (Complaint c : cs2.getAllComplaints()) {
                c.display();
                }
            }
            else if (choice == 5) {
                sc.nextLine();
                System.out.print("Enter student email: ");
                String email = sc.nextLine();

                for (Complaint c : cs2.getAllComplaints()) {
                    if (c.getStudentEmail().equals(email)) {
                        c.setStatus("Resolved");
                    }
                }

                System.out.println("Complaint resolved!");
            }
            else if (choice == 6) {
                System.out.print("Enter course code: ");
                String code = sc.next();

                Course c = cs.getCourseByCode(code);

                if (c != null) {

                    System.out.print("Enter student ID: ");
                    String sid = sc.next();

                    System.out.print("Enter grade (A/B/C/D/F): ");
                    String grade = sc.next();

                    boolean success = c.assignGrade(sid, grade);

                    if (success) {
                        System.out.println("Grade assigned!");
                    } else {
                        System.out.println("Student not found in this course!");
                    }

                } else {
                    System.out.println("Course not found");
                }
            }

            else {
                break;
            }
        }
    }
}