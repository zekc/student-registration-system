package Models;

import Services.CourseRegistrationSystem;

import java.util.ArrayList;
import java.util.Random;


public class StudentUtils {

    private Student student;
    private ArrayList<Course> selectedCourses;

    public StudentUtils(){
        selectedCourses = new ArrayList<>();
    }
    CourseRegistrationSystem courseRegistrationSystem = CourseRegistrationSystem.getRegistrationSystem();

    public String sendToApprove( ArrayList<Course> courses, Student student) {
        //Sends to registration system for adding modified list to transcript
        return student.getAdvisor().courseApproval(student, courses);
    }

    public String enrollTheCourse(Student student) {
        //this method sends student's selected courses to systems control
        selectedCourses= courseRegistrationSystem.checkSelectedCourses(student,selectedCourses);
        return sendToApprove(selectedCourses, student);
    }

    public void AddCourse(Course course) {
        if (!selectedCourses.contains(course)) {
            selectedCourses.add(course);
        }
    }

    public void SelectRandomCourses(ArrayList<Course> avaibleCourses) {
        System.out.println(FirstName + " " + LastName + "is selecting course");
        selectedCourses.clear();
        int randomAmount = (int) Math.min(Math.max(5, avaibleCourses.size() * Math.random()), 1);
        for (int i = 0; i < randomAmount; i = i + 1) {
            int randomClass = (int) (avaibleCourses.size() * Math.random());
            AddCourse(avaibleCourses.get(randomClass));
        }
    }

    public ArrayList<Course> selectTheCourse(ArrayList<Course> courses) {
        Random rand = new Random();
        // generate random 5 courses that the student selected
        for (int i = 0; i < 5; i++) {
            int int_random = rand.nextInt(courses.size());
            selectedCourses.add(courses.get(int_random));
            courses.remove(int_random);
        }
        return selectedCourses;
    }

    public ArrayList<Course> sendToApprovement(Student student, ArrayList<Course> checkedSelectedCourses) {
        //student sends the checked courses by the registration system to his/her advisor and advisor returns modified list
        //checkedSelectedCourses = advisor.courseApprovement(student, checkedSelectedCourses);
        // disabled For now
        return checkedSelectedCourses;
    }

    public ArrayList<Course> getSelectedCourses() {
        return selectedCourses;
    }

    public void setSelectedCourses(ArrayList<Course> selectedCourses) {
        this.selectedCourses = selectedCourses;
    }
}
