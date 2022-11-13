package Models;

import java.util.ArrayList;

public class Advisor extends Lecturer{
    
    //private ArrayList<Course> CourseList;
    
    private ArrayList<Student> StudentList;

    public ArrayList<Student> getStudentList() {
        return StudentList;
    }

    public void setStudentList(ArrayList<Student> studentList) {
        StudentList = studentList;
    }
    
}
