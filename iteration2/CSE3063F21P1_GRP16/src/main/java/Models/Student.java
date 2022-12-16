package Models;

import Services.CourseRegistrationSystem;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Student extends Person {

    private StudentID studentID;
    private Advisor advisor;
    private StudentUtils studentUtils;
    private Transcript transcript;
    private Payment paymentAmount;
    private int StudentSemesterNo;
    private static FileWriter file;

    public Student(String newFirstName, String newLastName, ArrayList<Course> allCourses) {

        studentID = new StudentID("CSE", Integer.toString((int) Math.max(18, Math.random() * 20)), Integer.toString(Math.max(10, ((int) (Math.random() * 50)))));
        StudentSemesterNo = (int) (Math.random() * 5 + 2);
        FirstName = newFirstName;
        LastName = newLastName;
        transcript = new Transcript(allCourses);
        studentUtils=new StudentUtils();
    }

    public void saveToJson() {

        JSONObject obj = new JSONObject();
        obj.put("Name", FirstName);
        obj.put("LastName", LastName);

        JSONObject Trans = new JSONObject();
        Trans.put("gpa", transcript.getGPA());
        JSONArray passedCourses = new JSONArray();

        for (int i = 0; i < transcript.getPassedCourses().size(); i = i + 1) {
            passedCourses.put(transcript.getPassedCourses().get(i).getCourseCode());
        }

        JSONArray failedCourses = new JSONArray();
        for (int i = 0; i < transcript.getFailedCourses().size(); i = i + 1) {
            failedCourses.put(transcript.getFailedCourses().get(i).getCourseCode());
        }

        obj.put("PassedCourses", passedCourses);
        obj.put("FailedCourses", failedCourses);

        for (int i = 0; i <= passedCourses.length(); i = i + 1) {
            // passedCourses.put(transcript.passedCourses.get(i).getCourseCode());
        }

        obj.put("TranskriptObj", Trans);
        try {

            file = new FileWriter("src/students/" + studentID.getStudentString() + ".json");
            file.write(obj.toString());
            // System.out.println("json created");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                file.flush();
                file.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

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

    public Transcript getTranscript() {
        return transcript;
    }

    public void setTranscript(Transcript transcript) {
        this.transcript = transcript;
    }

    public Payment getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(Payment paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public StudentUtils getStudentUtils() {
        return studentUtils;
    }

    public void setStudentUtils(StudentUtils studentUtils) {
        this.studentUtils = studentUtils;
    }
}