package users;

import java.util.Scanner;
import model.Course;
import model.Complaint;
import services.CourseService;
import services.ComplaintService;

public class Administrator extends User {

    public Administrator(String email, String password) {
        super(email, password);
    }

    @Override
    public void showMenu() {

        Scanner sc = new Scanner(System.in);
        CourseService cs = CourseService.getInstance();
        ComplaintService compService = ComplaintService.getInstance();

        while (true) {

            System.out.println("\n--- ADMIN MENU ---");
            System.out.println("1. View All Courses");
            System.out.println("2. Add Course");
            System.out.println("3. Delete Course");
            System.out.println("4. View Complaints");
            System.out.println("5. Resolve Complaint");
            System.out.println("6. Assign Grade");
            System.out.println("7. Assign Professor");
            System.out.println("8. Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            // 1. VIEW COURSES
            if (choice == 1) {
                cs.viewCourses();
            }

            // 2. ADD COURSE
            else if (choice == 2) {

                System.out.print("Enter course code: ");
                String code = sc.nextLine();

                System.out.print("Enter title: ");
                String title = sc.nextLine();

                System.out.print("Enter credits (2/4): ");
                int credits = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter professor email: ");
                String profEmail = sc.nextLine();

                System.out.print("Enter professor name: ");
                String profName = sc.nextLine();

                System.out.print("Enter max students: ");
                int max = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter prerequisite (or NONE): ");
                String pre = sc.nextLine();
                if (pre.equalsIgnoreCase("NONE")) pre = null;

                System.out.print("Enter day: ");
                String day = sc.nextLine();

                System.out.print("Enter time: ");
                String time = sc.nextLine();

                Course c = new Course(code, title, credits,
                        profEmail, profName,
                        max, pre, day, time);

                cs.addCourse(c);

                System.out.println("Course added successfully!");
            }

            // 3. DELETE COURSE
            else if (choice == 3) {

                System.out.print("Enter course code: ");
                String code = sc.nextLine();

                if (cs.deleteCourse(code)) {
                    System.out.println("Course deleted successfully!");
                } else {
                    System.out.println("Course not found!");
                }
            }

            // 4. VIEW COMPLAINTS
            else if (choice == 4) {

                for (Complaint c : compService.getAllComplaints()) {
                    c.display();
                }
            }

            // 5. RESOLVE COMPLAINT
            else if (choice == 5) {

                System.out.print("Enter student email: ");
                String email = sc.nextLine();

                boolean found = false;

                for (Complaint c : compService.getAllComplaints()) {
                    if (c.getStudentEmail().equalsIgnoreCase(email)) {
                        c.setStatus("Resolved");
                        found = true;
                    }
                }

                System.out.println(found ? "Complaint resolved!" : "Complaint not found!");
            }

            // 6. ASSIGN GRADE
            else if (choice == 6) {

                System.out.print("Enter course code: ");
                String code = sc.nextLine();

                Course c = cs.getCourseByCode(code);

                if (c != null) {

                    System.out.print("Enter student ID: ");
                    String studentId = sc.nextLine();

                    System.out.print("Enter grade (A/B/C/D/F): ");
                    String grade = sc.nextLine();

                    if (c.assignGrade(studentId, grade)) {
                        System.out.println("Grade assigned successfully!");
                    } else {
                        System.out.println("Student not found!");
                    }

                } else {
                    System.out.println("Course not found!");
                }
            }

            // 7. ASSIGN PROFESSOR
            else if (choice == 7) {

                System.out.print("Enter course code: ");
                String code = sc.nextLine();

                Course c = cs.getCourseByCode(code);

                if (c != null) {

                    System.out.print("Enter professor email: ");
                    String email = sc.nextLine();

                    System.out.print("Enter professor name: ");
                    String name = sc.nextLine();

                    c.setProfessor(email, name);

                    System.out.println("Professor assigned successfully!");
                } else {
                    System.out.println("Course not found!");
                }
            }

            // 8. EXIT
            else if (choice == 8) {
                break;
            }
        }
    }
}