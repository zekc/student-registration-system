package Models;

import java.util.ArrayList;


public class Transcript {
    public double GPA;
    public ArrayList<Course> passedCourses;
    public ArrayList<Course> failedCourses;


	public Transcript(){



		passedCourses = new ArrayList<Course>();
	}


	public double getGPA() {
		return GPA;
	}
	public void setGPA(Double gpa) {
		this.GPA = gpa;
	}
	public ArrayList<Course> getPassedCourses() {
		return passedCourses;
	}
	public void setPassedCourses(ArrayList<Course> passedCourses) {
		this.passedCourses = passedCourses;
	}
	public ArrayList<Course> getFailedCourses() {
		return failedCourses;
	}
	public void setFailedCourses(ArrayList<Course> failedCourses) {
		this.failedCourses = failedCourses;
	}



}