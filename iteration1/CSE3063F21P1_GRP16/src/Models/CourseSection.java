package Models;

import java.util.ArrayList;

public class CourseSection {
    private ArrayList<Student> allstudent = new ArrayList<Student>(); // Array list that includes all the students
                                                                      // registered to a specific course
    // private ArrayList<CoursesError> errors = new ArrayList<CoursesError>();
    // //Array list that includes errors while registering to a course

    // Counstructor
    public CourseSection(ArrayList<Student> allstudent /* ArrayList<CourseError> errors */) {
        this.allstudent = allstudent;
        // this.errors = errors;
    }

    // Setters and Getters
    public ArrayList<Student> getAllstudent() {
        return allstudent;
    }

    public void setAllstudent(ArrayList<Student> allstudent) {
        this.allstudent = allstudent;
    }

    /*
     * public ArrayList<CoursesError> getErrors() {
     * return errors;
     * }
     * 
     * //public void setErrors(ArrayList<CoursesError> errors) {
     * this.errors = errors;
     * }
     */

    ArrayList<Course> selectedCourses = new ArrayList<Course>();

    public ArrayList<Course> getSelectedCourses() {
        return selectedCourses;
    }

    public void setSelectedCourses(ArrayList<Course> selectedCourses) {
        this.selectedCourses = selectedCourses;
    }

}