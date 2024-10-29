import java.util.ArrayList;
import java.util.List;

public class CourseService {
    private List<Student> students;
    private List<Course> courses;

    public CourseService() {
        students = new ArrayList<>();
        courses = new ArrayList<>();
        
        students.add(new Student("Sanket", "120120"));
        courses.add(new Course("Mathematics", "math_01", 3));
    }

    
    private Student findStudentById(String studentId) {
        for (Student student : students) {
            if (student.getId().equals(studentId)) {
                return student; 
            }
        }
        return null; 
    }

    private Course findCourseById(String courseId) {
        for (Course course : courses) {
            if (course.id.equals(courseId)) {
                return course; 
            }
        }
        return null;
    }

    public void enrollStudent(String studentId, String courseId) {
        Student student = findStudentById(studentId);
        Course course = findCourseById(courseId);

        if (student != null && course != null) {
            student.enroll(course); 
            System.out.println(student.getName() + " has been enrolled in " + course.name);
        } else {
            System.out.println("Student or Course not found.");
        }
    }
    public void unEnrollStudent(String studentId, String courseId) {
        Student student = findStudentById(studentId);
        Course course = findCourseById(courseId);

        if (student != null && course != null) {
            student.unEnroll(course); 
            System.out.println(student.getName() + " has been unenrolled from " + course.name);
        } else {
            System.out.println("Student or Course not found.");
        }
    }
    public void displayCourseInformation(String courseId) {
        Course course = findCourseById(courseId);

        if (course != null) {
            System.out.println("Course ID: " + course.id);
            System.out.println("Course Name: " + course.name);
            System.out.println("Credits: " + course.credits);
        } else {
            System.out.println("Course not found.");
        }
    }
    public void displayStudentInformation(String studentId) {
        Student student = findStudentById(studentId);

        if (student != null) {
            System.out.println("Student ID: " + student.getId());
            System.out.println("Student Name: " + student.getName());
            System.out.println("Enrolled Courses:");
            
            for (Course course : student.getEnrolledCourses()) {
                System.out.println("- " + course.name);
            }
        } else {
            System.out.println("Student not found.");
        }
    }

    public int calculateTotalCredits(String studentId) {
        Student student = findStudentById(studentId);

        if (student != null) {
            int totalCredits = 0;
            for (Course course : student.getEnrolledCourses()) {
                totalCredits += course.credits;
            }
            return totalCredits;
        }
        return 0; 
    }
}