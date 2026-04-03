package users;

import java.util.ArrayList;
import java.util.Scanner;
import model.Course;
import services.CourseService;

public class Professor extends User {

    public Professor(String email, String password) {
        super(email, password);
    }

    @Override
    public void showMenu() {
        Scanner sc = new Scanner(System.in);
        CourseService cs = CourseService.getInstance();

        System.out.print("Enter your name: ");
        String profName = sc.nextLine();

        while (true) {
            System.out.println("\n1. View My Courses");
            System.out.println("2. Update Course Credits");
            System.out.println("3. View Enrolled Students");
            System.out.println("4. Exit");

            int choice = sc.nextInt();

            if (choice == 1) {
                ArrayList<Course> myCourses = cs.getCoursesByProfessor(profName);

                for (Course c : myCourses) {
                    c.displayCourse();
                }
            }

            else if (choice == 2) {
                System.out.print("Enter course code: ");
                String code = sc.next();

                Course c = cs.getCourseByCode(code);

                if (c != null && c.getProfessor().equalsIgnoreCase(profName)) {
                    System.out.print("Enter new credits (2 or 4): ");
                    int newCredits = sc.nextInt();
                    c.setCredits(newCredits);
                    System.out.println("Updated successfully!");
                } else {
                    System.out.println("Invalid course or not assigned to you.");
                }
            }

            else if (choice == 3) {
                System.out.print("Enter course code: ");
                String code = sc.next();

                Course c = cs.getCourseByCode(code);

                if (c != null && c.getProfessor().equalsIgnoreCase(profName)) {
                    System.out.println("Enrolled Students:");
                    for (String s : c.getStudents()) {
                        System.out.println(s);
                    }
                } else {
                    System.out.println("Invalid course.");
                }
            }

            else {
                break;
                
            }
        }
    }
}