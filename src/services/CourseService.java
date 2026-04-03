package services;

import model.Course;
import java.util.ArrayList;

public class CourseService {

    // SINGLE INSTANCE
    private static CourseService instance;

    private ArrayList<Course> courses;

    // PRIVATE CONSTRUCTOR
    private CourseService() {
        courses = new ArrayList<>();

        // Dummy data (only created once now)
        courses.add(new Course("CS101", "DSA", 4, "Prof A", 3));
        courses.add(new Course("CS102", "OOP", 4, "Prof B", 3));
        courses.add(new Course("CS103", "DBMS", 2, "Prof C", 3));
    }

    // GLOBAL ACCESS METHOD
    public static CourseService getInstance() {
        if (instance == null) {
            instance = new CourseService();
        }
        return instance;
    }

    public void viewCourses() {
        for (Course c : courses) {
            c.displayCourse();
        }
    }

    public Course getCourseByCode(String code) {
        for (Course c : courses) {
            if (c.getCourseCode().equalsIgnoreCase(code)) {
                return c;
            }
        }
        return null;
    }
}