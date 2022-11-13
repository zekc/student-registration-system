package Models;

import Types.CourseType;

import java.util.ArrayList;

public class Course {


public String coursename;
private CourseType courseType;



    public Course(String courseName, int credit, ArrayList<String> preRequisites, ArrayList<CourseSession> courseSessions, int requiredCredits, Semester courseSemester) {


       coursename = courseName;


    }
}
