package exceptions;


public class CourseFullException extends Exception {
    
    private String courseCode;
    private int maxCapacity;
    
    public CourseFullException(String message) {
        super(message);
    }
    
    public CourseFullException(String courseCode, int maxCapacity) {
        super("Course " + courseCode + " is full (Capacity: " + maxCapacity + ")");
        this.courseCode = courseCode;
        this.maxCapacity = maxCapacity;
    }
    
    public String getCourseCode() {
        return courseCode;
    }
    
    public int getMaxCapacity() {
        return maxCapacity;
    }
}