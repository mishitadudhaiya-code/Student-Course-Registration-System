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
        courses.add(new Course("CS101", "DSA", 4
        , "Prof A", 3, "Monday", "10AM"));
        courses.add(new Course("CS102", "OOP", 4
        , "Prof B", 3, "Tuesday", "2PM"));
        courses.add(new Course("CS103", "DBMS", 2, "Prof C"
        , 3, "Wednesday", "11AM"));
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
    // Get courses by professor
public ArrayList<Course> getCoursesByProfessor(String profName) {
    ArrayList<Course> result = new ArrayList<>();

    for (Course c : courses) {
        if (c.getProfessor().equalsIgnoreCase(profName)) {
            result.add(c);
        }
    }

    return result;
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
        public ArrayList<Course> getAllCourses() {
            return courses;
        }
}