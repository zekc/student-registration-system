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
    private ArrayList<CourseEvents> courseEvents;
    private int quotaCounter;////////////////
    private int requiredCredits;/////////////////////////




    public Course(String courseName, String courseCode, int quota, String prerequisiteCourse, int credits,
                  Semester semester, CourseType courseType, ArrayList<CourseSession> sessions,int requiredCredits) {

        this.courseName = courseName;
        this.courseCode = courseCode;
        this.quota = quota;
        this.prerequisiteCourse = prerequisiteCourse;
        this.credits = credits;
        this.courseSemesterName = semester;
        this.courseType = courseType;
        this.sessions = sessions;
        this.quotaCounter=0;////////////////////
        this.requiredCredits=requiredCredits;
        this.courseEvents=new ArrayList<>();

        setEvents();
    }

    private void setEvents() {
        courseEvents.add(new E0Success());
        courseEvents.add(new E1ReTakeCourse());
        courseEvents.add(new E2prerequisite());
        courseEvents.add(new E3HourCollusion());
        courseEvents.add(new E4NoEnoughCredits());
        courseEvents.add(new E5Quota());


    }

    public ArrayList<CourseEvents> getCourseEvents() {
        return courseEvents;
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

}
