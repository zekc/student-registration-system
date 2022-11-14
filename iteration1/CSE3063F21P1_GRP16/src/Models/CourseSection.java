package Models;

import java.util.ArrayList;

public class CourseSection extends Course {
    private ArrayList<Student> allstudent = new ArrayList<Student>();
    private ArrayList<CoursesError> errors = new ArrayList<CoursesError>();

    public ArrayList<Student> getAllstudent() {
        return allstudent;
    }

    public void setAllstudent(ArrayList<Student> allstudent) {
        this.allstudent = allstudent;
    }

    public ArrayList<CoursesError> getErrors() {
        return errors;
    }

    public void setErrors(ArrayList<CoursesError> errors) {
        this.errors = errors;
    }

    ArrayList<Course> selectedCourses = new ArrayList<Course>();

    public ArrayList<Course> getSelectedCourses() {
        return selectedCourses;
    }

    public void setSelectedCourses(ArrayList<Course> selectedCourses) {
        this.selectedCourses = selectedCourses;
    }

    public CourseSection() {
    }

}