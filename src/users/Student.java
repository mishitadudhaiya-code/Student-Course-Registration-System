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

    private int calculateTotalCredits() {
        int total = 0;
        for (Course c : registeredCourses) {
            total += c.getCredits();
        }
        return total;
    }

    private void viewRegisteredCourses() {
        if (registeredCourses.isEmpty()) {
            System.out.println("No courses registered.");
            return;
        }

        for (Course c : registeredCourses) {
            c.displayCourse();
        }
    }

    @Override
    public void showMenu() {
        Scanner sc = new Scanner(System.in);
        CourseService cs = new CourseService();

        while (true) {
            System.out.println("\n1. View All Courses");
            System.out.println("2. Register Course");
            System.out.println("3. View Registered Courses");
            System.out.println("4. Drop Course");
            System.out.println("5. Exit");

            int choice = sc.nextInt();

            if (choice == 1) {
                cs.viewCourses();
            }

            else if (choice == 2) {
                System.out.print("Enter course code: ");
                String code = sc.next();

                Course c = cs.getCourseByCode(code);

                if (c != null) {

                    // CREDIT LIMIT CHECK
                    if (calculateTotalCredits() + c.getCredits() > 20) {
                        System.out.println("Credit limit exceeded (Max 20)");
                        continue;
                    }

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

            else if (choice == 3) {
                viewRegisteredCourses();
            }

            else if (choice == 4) {
                System.out.print("Enter course code to drop: ");
                String code = sc.next();

                Course toRemove = null;

                for (Course c : registeredCourses) {
                    if (c.getCourseCode().equalsIgnoreCase(code)) {
                        toRemove = c;
                        break;
                    }
                }

                if (toRemove != null) {
                    registeredCourses.remove(toRemove);
                    System.out.println("Course dropped successfully!");
                } else {
                    System.out.println("You are not enrolled in this course.");
                }
            }

            else {
                break;
            }
        }
    }
}