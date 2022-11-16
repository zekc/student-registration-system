package Models;

import Types.SemesterName;

import java.util.ArrayList;


public class Transcript {
    public double GPA;
    public ArrayList<Course> passedCourses;
    public ArrayList<Course> failedCourses;
	private Semester semester;

	public Transcript(ArrayList<Course> Courses){


	if( Math.random()*2 == 0){
		semester = new Semester(4, SemesterName.FALL);

	}else {

		semester =  new Semester(4, SemesterName.SPRING);
	}



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
	public boolean addCourses(Student student, ArrayList<Course> courses){
		return true;
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


	public Semester getSemester() {
		return semester;
	}

	public void setSemester(Semester semester) {
		this.semester = semester;
	}
}