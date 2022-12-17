package Models;

//import Services.CalculateGpa;

import Types.SemesterName;

import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;


// TODO: create only necessary methods
public class Transcript {
	private final Student student;
	private final Set<StudentCourseScore> scores;
	private double gpa;

	public Transcript(Student student, List<Course> courses) {
		this.student = student;
		this.scores = courses.stream()
				.map(course -> new StudentCourseScore(student, course, ThreadLocalRandom.current().nextDouble(4.0)))
				.collect(Collectors.toSet());
		this.calculateGPA();
	}

	public Student getStudent() {
		return student;
	}

	public Set<StudentCourseScore> getScores() {
		return scores;
	}

	private void calculateGPA() {
		if (scores.isEmpty()) {
			this.gpa = 0.0;
			return;
		}

		double scoresDotCredits = scores.stream()
				.map(score -> score.pointScore() * score.course().getCredits())
				.mapToDouble(Double::doubleValue)
				.sum();

		double credits = scores.stream()
				.map(score -> score.course().getCredits())
				.mapToDouble(Integer::doubleValue)
				.sum();

		this.gpa = credits != 0 ? scoresDotCredits / credits : 0.0;
	}

	public double getGPA() {
		return gpa;
	}

	public List<Course> getPassedCourses() {
		return scores.stream()
				.filter(score -> score.pointScore() >= 1.0)
				.map(StudentCourseScore::course)
				.toList();
	}

	public List<Course> getFailedCourses() {
		return scores.stream()
				.filter(score -> score.pointScore() < 1.0)
				.map(StudentCourseScore::course)
				.toList();
	}

	public int getCompletedCredits() {
		return scores.stream()
				.map(scores -> scores.course().getCredits())
				.mapToInt(Integer::intValue)
				.sum();
	}

	public boolean addCourses(Student student, List<Course> courses) throws Exception {
		if (this.student == student) {
			Set<StudentCourseScore> newScores = courses.stream()
					.map(course -> new StudentCourseScore(student, course, ThreadLocalRandom.current().nextDouble(4.0)))
					.collect(Collectors.toSet());

			this.calculateGPA();

			return scores.addAll(newScores);
		}

		return false;
	}

	public void addSemester(Student student, List<Course> courses, Integer semesterNo, SemesterName semesterName) {
		if (this.student == student) {
			Set<StudentCourseScore> newScores = courses.stream()
					.map(course -> new StudentCourseScore(student, course, ThreadLocalRandom.current().nextDouble(4.0)))
					.collect(Collectors.toSet());

			this.calculateGPA();

			scores.addAll(newScores);
		}
	}
}
