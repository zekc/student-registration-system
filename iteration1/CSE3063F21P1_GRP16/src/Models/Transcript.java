package Models;

import java.util.ArrayList;


public class Transcript {
    public double GPA;
    public ArrayList<Course> passedCourses;
    public ArrayList<Course> failedCourses;


	public Transcript(ArrayList<Course> Courses){



		passedCourses = new ArrayList<Course>();
		failedCourses = new ArrayList<Course>();


	int	PassedAmount = (int) (Math.random()*15);
	int RandomFailed = (int) (Math.random()*PassedAmount);
		for (int i = 0; i < PassedAmount ; i = i +1) {
			if(i == RandomFailed){


				failedCourses.add(Courses.get(i));
			}else{

				passedCourses.add(Courses.get(i));
			}

		}



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