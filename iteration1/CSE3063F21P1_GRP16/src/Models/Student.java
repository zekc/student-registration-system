package Models;
public class Student extends Person {
    
    private StudentID studentID;
    private Advisor advisor;
    //private Transcript transcript;
    //private ArrayList<Course> selectedCourses;
    //private Payment paymentAmount;

    public StudentID getStudentID() {
        return studentID;
    }

    public void setStudentID(StudentID studentID) {
        this.studentID = studentID;
    }

    public Advisor getAdvisor() {
        return advisor;
    }

    public void setAdvisor(Advisor advisor) {
        this.advisor = advisor;
    }
}


