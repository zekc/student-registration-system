package Services;

import Models.Course;
import Models.Grade;
import Models.Transcript;

import java.util.ArrayList;

public class CalculateGpa {
    private double totalGPA;
    private double totalCredit;
    private Course courseName;
    private double resultGPA;

    public double calculateGpa(Transcript transcript) {

        ArrayList<Course> courses = new ArrayList<Course>();
        //Loop at failed and passed courses to collect them at one arraylist
        courses.addAll(transcript.getFailedCourses());
        courses.addAll(transcript.getPassedCourses());

        for (int i = 0; i < courses.size(); i++) { //Loop at all the courses
            courseName = courses.get(i); //get corresponding course name
            totalGPA = totalGPA + (transcript.getCredit(courseName) * transcript.getGPA(courseName)); //Credit * GPA
            totalCredit = totalCredit + transcript.getCredit(courseName); //Credit
        }
        resultGPA = totalGPA / totalCredit;
        return resultGPA;
    }
}
