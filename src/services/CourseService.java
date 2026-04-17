package services;

import java.util.ArrayList;
import model.Course;

public class CourseService {

    private static CourseService instance;
    private ArrayList<Course> courses;

    private CourseService() {

        courses = new ArrayList<>();

        // ✅ UPDATED (email + name)
        courses.add(new Course("CS101", "DSA", 4,
                "profa@university.com", "Prof A",
                3, null, "Monday", "10AM"));

        courses.add(new Course("CS102", "OOP", 4,
                "profb@university.com", "Prof B",
                3, "CS101", "Tuesday", "2PM"));

        courses.add(new Course("CS103", "DBMS", 2,
                "profc@university.com", "Prof C",
                3, "CS102", "Wednesday", "11AM"));
    }

    public static CourseService getInstance() {
        if (instance == null) {
            instance = new CourseService();
        }
        return instance;
    }

    // VIEW COURSES
    public void viewCourses() {
        for (Course c : courses) {
            c.displayCourse();
        }
    }

    // GET COURSE BY CODE
    public Course getCourseByCode(String code) {
        for (Course c : courses) {
            if (c.getCourseCode().equalsIgnoreCase(code)) {
                return c;
            }
        }
        return null;
    }

    // GET ALL COURSES
    public ArrayList<Course> getAllCourses() {
        return courses;
    }

    // ADD COURSE
    public void addCourse(Course c) {
        courses.add(c);
    }

    // DELETE COURSE
    public boolean deleteCourse(String code) {
        Course toRemove = null;

        for (Course c : courses) {
            if (c.getCourseCode().equalsIgnoreCase(code)) {
                toRemove = c;
                break;
            }
        }

        if (toRemove != null) {
            courses.remove(toRemove);
            return true;
        }

        return false;
    }
}