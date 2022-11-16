package Services;

import Models.Course;
import Models.Student;

import java.util.ArrayList;

public class CourseRegistrationSystem {
    public ArrayList<Course> checkSelectedCourses(Student student, ArrayList<Course> courses){
        ArrayList<Course> checkedCourses = courses;
        return checkedCourses;
    }
    public boolean addApprovedCoursesToTranscript(Student student, ArrayList<Course> courses){
        return student.getTranscript().addCourses(student, courses);
    }
}
