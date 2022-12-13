package Models;

import java.util.ArrayList;

public class Advisor extends Lecturer{
    
    private ArrayList<Course> CourseList;
    
    
    public String courseApprovement (Student student, ArrayList<Course> waitingCourses){
        // Removing disapproved courses from approvement list and adding reminding parts to the transcript through registration system
        ArrayList<Integer> disApprovedCourses = new ArrayList<Integer>();
        for (int i = 0; i < waitingCourses.size(); i++) {
            if(student.getTranscript().getSemester()!=waitingCourses.get(i).getCourseSemesterName()){
            	disApprovedCourses.add(i);	
            	continue;
            	              
            }
            
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
        	waitingCourses.get(i).setQuota(waitingCourses.get(i).getQuotaCounter()+1);
        }
        
        if (student.courseRegistrationSystem.addApprovedCoursesToTranscript(student, waitingCourses)){
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
