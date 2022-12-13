package Models;

import java.util.ArrayList;

public class Advisor extends Lecturer{
    
    private ArrayList<Course> CourseList;
    
    
    public ArrayList<Course> courseApprovement (Student student, ArrayList<Course> waitingCourses){
        // Removing disapproved courses from approvement list and adding reminding parts to the transcript through registration system
        // student wants to take a course from different semester
        ArrayList<Course> disApprovedCourses = new ArrayList<Course>();
        for (int i = 0; i < waitingCourses.size(); i++) {
            if(student.getTranscript().getSemester()!=waitingCourses.get(i).getCourseSemesterName()){
                disApprovedCourses.add(waitingCourses.get(i));
            }
        }
        for (Course disApprovedCourse : disApprovedCourses) {
            System.out.println("Student " + student.getFirstName() + student.getLastName() + " could not take " + disApprovedCourse.getCourseName());
            waitingCourses.remove(disApprovedCourse);
        }
    return waitingCourses;
    }
    public String addingCheckedCourses(Student student , ArrayList<Course> courses){
        // Method sends checked courses to registration system
        if (student.courseRegistrationSystem.addApprovedCoursesToTranscript(student, courses)){
            return "Successfully Approved";
        }
        else {
            return "Failed to register";
        }
    }
    private ArrayList<Student> StudentList;

    public Advisor(String newName, String newLastName) {
        super();
    }

    public ArrayList<Student> getStudentList() {
        return StudentList;
    }

    public void setStudentList(ArrayList<Student> studentList) {
        StudentList = studentList;
    }
    
}
