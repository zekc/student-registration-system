package Models;
import Types.CourseType;

import java.util.*;

public class Course {

    private String courseName;
    private String courseCode;
    private int quota;
    private String prerequisiteCourse;
    private int credits;
    private Semester courseSemesterName;
    private CourseType courseType ; //1..8(Semester number),FTE,NTE,UE,TE
    private ArrayList<CourseSession> sessions= new ArrayList<CourseSession>();//includes all sessions,and their informations like day and hour


    public Course(String courseName, String courseCode, int quota, String prerequisiteCourse, int credits,
                  Semester semester, CourseType courseType, ArrayList<CourseSession> sessions) {

        this.courseName = courseName;
        this.courseCode = courseCode;
        this.quota = quota;
        this.prerequisiteCourse = prerequisiteCourse;
        this.credits = credits;
        this.courseSemesterName = courseSemesterName;
        this.courseType = courseType;
        this.sessions = sessions;
        courseSemesterName = semester;
    }

    //getters and setters
    public String getCourseName() {
        return courseName;
    }
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    public String getCourseCode() {
        return courseCode;
    }
    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
    public int getQuota() {
        return quota;
    }
    public void setQuota(int quota) {
        this.quota = quota;
    }
    public String getPrerequisiteCourse() {
        return prerequisiteCourse;
    }
    public void setPrerequisiteCourse(String prerequisiteCourse) {
        this.prerequisiteCourse = prerequisiteCourse;
    }
    public int getCredits() {
        return credits;
    }
    public void setCredits(int credits) {
        this.credits = credits;
    }
    public Semester getCourseSemesterName() {
        return courseSemesterName;
    }

    public ArrayList<CourseSession> getSessions() {
        return sessions;
    }
    public void setSessions(ArrayList<CourseSession> sessions) {
        this.sessions = sessions;
    }



}