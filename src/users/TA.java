package users;

import services.CourseService;
import model.Course;

import java.util.Scanner;

public class TA extends User {

    public TA(String email, String password) {
        super(email, password);
    }

    @Override
    public void showMenu() {
        Scanner sc = new Scanner(System.in);
        CourseService cs = CourseService.getInstance();

        while (true) {
            System.out.println("\n--- TA MENU ---");
            System.out.println("1. View All Courses");
            System.out.println("2. View Students in Course");
            System.out.println("3. Exit");

            int choice = sc.nextInt();

            // VIEW COURSES
            if (choice == 1) {
                cs.viewCourses();
            }

            // VIEW STUDENTS IN COURSE
            else if (choice == 2) {
                System.out.print("Enter course code: ");
                String code = sc.next();

                Course c = cs.getCourseByCode(code);

                if (c != null) {
                    if (c.getStudents().isEmpty()) {
                        System.out.println("No students enrolled.");
                    } else {
                        System.out.println("Students: " + c.getStudents());
                    }
                } else {
                    System.out.println("Course not found.");
                }
            }

            else {
                break;
            }
        }
    }
}