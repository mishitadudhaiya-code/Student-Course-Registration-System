package services;

import model.Course;
import java.util.ArrayList;

public class CourseService {

    private ArrayList<Course> courses = new ArrayList<>();

    public CourseService() {
        // Dummy data
        courses.add(new Course("AI101", "DSA", 4, "Prof A", 3));
        courses.add(new Course("AI102", "OOP", 4, "Prof B", 3));
        courses.add(new Course("AI103", "DBMS", 2, "Prof C", 3));
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