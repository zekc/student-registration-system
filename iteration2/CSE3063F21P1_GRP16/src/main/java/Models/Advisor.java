package Models;

import java.util.ArrayList;
import java.util.Objects;

public class Advisor extends Lecturer{
    
    private ArrayList<Course> CourseList;
    private ArrayList<Student> StudentList;

    public Advisor(String newName, String newLastName) {
        FirstName = newName;
        LastName = newLastName;
    }

    public String courseApproval(Student student, ArrayList<Course> waitingCourses){
        // Removing disapproved courses from approval list and adding reminding parts to the transcript through registration system
        ArrayList<Integer> disApprovedCourses = new ArrayList<Integer>();
        for (int i = 0; i < waitingCourses.size(); i++) {

            if(waitingCourses.get(i).getRequieredCredits()>student.getTranscript().getCompletedCredits()) {

                System.out.println("Advisor: The course: " + waitingCourses.get(i).getCourseCode() + " not added due to credits");
                waitingCourses.get(i).getCourseEvents().get(4).getStudents().add(student);//student doesnt have needed number of credits
                disApprovedCourses.add(i);
            }

        }
        for (int i = 0; i < disApprovedCourses.size(); i++) {
            waitingCourses.remove(disApprovedCourses.get(i));
        }

        for (int i = 0; i < waitingCourses.size(); i++) {
            waitingCourses.get(i).getCourseEvents().get(0).getStudents().add(student);//successfully added student to i'th course
            waitingCourses.get(i).setQuotaCounter(waitingCourses.get(i).getQuotaCounter()+1);

            for(int j=0;j<student.getTranscript().getFailedCourses().size();j++){
                if(Objects.equals(waitingCourses.get(i).getCourseCode(), student.getTranscript().getFailedCourses().get(j).getCourseCode())){
                    System.out.println("Advisor: The course: " + waitingCourses.get(i).getCourseCode() + " was taken again by the student");
                    waitingCourses.get(i).getCourseEvents().get(1).getStudents().add(student);//student retake the course
                    break;
                }
            }

        }

        if (student.getStudentUtils().courseRegistrationSystem.addApprovedCoursesToTranscript(student, waitingCourses)){
            return "Successfully Approved";
        }
        else {
            return "Failed to register";
        }

    }

    public String addingCheckedCourses(Student student , ArrayList<Course> courses){
        // Method sends checked courses to registration system
        if (student.getStudentUtils().courseRegistrationSystem.addApprovedCoursesToTranscript(student, courses)){
            return "Successfully Approved";
        }
        else {
            return "Failed to register";
        }
    }

    public ArrayList<Student> getStudentList() {
        return StudentList;
    }

    public void setStudentList(ArrayList<Student> studentList) {
        StudentList = studentList;
    }
}
