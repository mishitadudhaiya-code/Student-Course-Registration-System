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
            System.out.println("6. Exit");

            int choice = sc.nextInt();

            if (choice == 1) {
                cs.viewCourses();
            }

            else if (choice == 2) {

            sc.nextLine(); // 🔥 VERY IMPORTANT (clears buffer)

            System.out.print("Enter course code: ");
            String code = sc.nextLine();

            System.out.print("Enter title: ");
            String title = sc.nextLine();

            System.out.print("Enter credits (2 or 4): ");
            int credits = sc.nextInt();

            sc.nextLine(); // 🔥 clear buffer again

            System.out.print("Enter professor name: ");
            String prof = sc.nextLine();

            System.out.print("Enter max students: ");
            int max = sc.nextInt();

            Course c = new Course(code, title, credits, prof, max);
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

            else {
                break;
            }
        }
    }
}