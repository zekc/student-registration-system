package Models;

import Types.SemesterName;

import java.util.ArrayList;
import java.util.HashMap;

public class Transcript {
	private Double GPA;
	private int credit;
	private int completedCredits;
	private ArrayList<Course> passedCourses;
	private ArrayList<Course> failedCourses;
	private Semester semester;

	HashMap<Course, Double>
		gpa_Map = new HashMap<Course, Double>();
		
	HashMap<Course, Integer>
	credit_Map = new HashMap<Course, Integer>();

	public Transcript() {

		// if (Math.random() * 2 == 0) {
		// 	semester = new Semester(4, SemesterName.FALL);
		// } 
		// else {
		// 	semester = new Semester(4, SemesterName.SPRING);
		// }

		passedCourses = new ArrayList<Course>();
		failedCourses = new ArrayList<Course>();

		// int PassedAmount = (int) (Math.random() * 15);
		// int RandomFailed = (int) (Math.random() * PassedAmount);
		// for (int i = 0; i < PassedAmount; i = i + 1) {
		// 	if (i == RandomFailed) {
		// 		failedCourses.add(Courses.get(i));
		// 	} 
		// 	else {
		// 		passedCourses.add(Courses.get(i));
		// 		this.completedCredits+=Courses.get(i).getCredits();
		// 	}
		// }
	}

	public boolean addCourses(Student student, ArrayList<Course> courses) {
		return true;
	}

	public double getGPA(Course course) { //get corresponding GPA for the course
		return gpa_Map.get(course);
	}

	public double getGPA() {return 3.0;}

	public void setGPA(Course course, Double gpa) {
        gpa_Map.put(course, gpa);
	}

	public double getCredit(Course course) { //get corresponding Credit for the course
		return credit_Map.get(course);
	}

	public void setCredit(Course course, int credit) {
        credit_Map.put(course, credit);
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

	public void setGPA(Double genGrade) {

	}


	public int getCompletedCredits() {
		return completedCredits;
	}
	// Tis function take list of courses and assign them randomly for passed and failed courses
	public void addSemester(ArrayList<Course> Courses, Integer semesterNo, SemesterName semesterName){
		semester = new Semester(semesterNo, semesterName);
		int PassedAmount = (int) (Math.random() * (Courses.size()));
		int RandomFailed = (int) (Math.random() * PassedAmount);
		for (int i = 0; i < PassedAmount; i = i + 1) {
			if (i == RandomFailed) {
				failedCourses.add(Courses.get(i));
			} 
			else {
				passedCourses.add(Courses.get(i));
				this.completedCredits+=Courses.get(i).getCredits();
			}
		}
	}

}
