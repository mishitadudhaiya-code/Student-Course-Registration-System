package users;

import java.util.ArrayList;
import java.util.Scanner;
import model.Course;
import services.CourseService;

public class Student extends User {

    private ArrayList<Course> registeredCourses = new ArrayList<>();

    public Student(String email, String password) {
        super(email, password);
    }

    @Override
    public void showMenu() {
        Scanner sc = new Scanner(System.in);
        CourseService cs = new CourseService();

        while (true) {
            System.out.println("\n1. View Courses");
            System.out.println("2. Register Course");
            System.out.println("3. Exit");

            int choice = sc.nextInt();

            if(choice == 1){
                cs.viewCourses();
            }
            else if (choice == 2) {
                System.out.print("Enter course code: ");
                String code = sc.next();

                Course c = cs.getCourseByCode(code);

                if (c != null) {
                    boolean added = c.addStudent(email);
                    if (added) {
                        registeredCourses.add(c);
                        System.out.println("Registered successfully!");
                    } else {
                        System.out.println("Course is full!");
                    }
                } else {
                    System.out.println("Course not found!");
                }
            }
            else {
                break;
            }
        }
    }
}