package Models;

import Services.CourseRegistrationSystem;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Student extends Person {

    private StudentID studentID;
    private Advisor advisor;

    private Transcript transcript;
    private ArrayList<Course> selectedCourses;
    private Payment paymentAmount;
    private int StudentSemesterNo;
    private static FileWriter file;

    public Student(String newFirstName, String newLastName, ArrayList<Course> allCourses) {

        studentID = new StudentID("CSE", Integer.toString((int) Math.max(18, Math.random() * 20)), Integer.toString(Math.max(10, ((int) (Math.random() * 50)))));
        StudentSemesterNo = (int) (Math.random() * 5 + 2);
        FirstName = newFirstName;
        LastName = newLastName;
        transcript = new Transcript(this, allCourses);
        selectedCourses = new ArrayList<>();
    }

    CourseRegistrationSystem courseRegistrationSystem = CourseRegistrationSystem.getRegistrationSystem();

    public ArrayList<Course> enrollTheCourse(Student student) {
        //this method sends student's selected courses to systems control
        ArrayList<Course> checkedSelectedCourses = courseRegistrationSystem.checkSelectedCourses(student, selectedCourses);
        return checkedSelectedCourses;
    }


    public String enrollTheCourse() {
        //this method sends student's selected courses to systems control
        selectedCourses= courseRegistrationSystem.checkSelectedCourses(this,selectedCourses);
        return sendToApprove(this,selectedCourses);
    }

    public ArrayList<Course> sendToApprovement(Student student, ArrayList<Course> checkedSelectedCourses) {
        //student sends the checked courses by the registration system to his/her advisor and advisor returns modified list
      //  checkedSelectedCourses = advisor.courseApprovement(student, checkedSelectedCourses);

        // disabled For now
        return checkedSelectedCourses;
    }



    public String sendToApprove(Student student, ArrayList<Course> courses) {
        //Sends to registration system for adding modified list to transcript
        return advisor.addingCheckedCourses(student, courses);
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

    public void saveToJson() {
        JSONObject obj = new JSONObject();
        obj.put("Name", FirstName);
        obj.put("LastName", LastName);

        JSONObject Trans = new JSONObject();
        Trans.put("gpa", transcript.getGPA());
        JSONArray passedCourses = new JSONArray(transcript.getPassedCourses().stream()
                .map(Course::getCourseCode)
                .collect(Collectors.toSet())
        );

        JSONArray failedCourses = new JSONArray(transcript.getFailedCourses().stream()
                .map(Course::getCourseCode)
                .collect(Collectors.toSet())
        );

        obj.put("PassedCourses", passedCourses);
        obj.put("FailedCourses", failedCourses);

        obj.put("TranskriptObj", Trans);
        try {

            file = new FileWriter("src/students/" + studentID.getStudentString() + ".json");
            file.write(obj.toString(4));
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

    public void SelectRandomCourses(ArrayList<Course> avaibleCourses) {
        selectedCourses.clear();
        int randomAmount = (int) Math.min(Math.max(5, avaibleCourses.size() * Math.random()), 1);
        for (int i = 0; i < randomAmount; i = i + 1) {
            int randomClass = (int) (avaibleCourses.size() * Math.random());
            AddCourse(avaibleCourses.get(randomClass));
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

    public void AddCourse(Course course) {
        if (!selectedCourses.contains(course)) {
            selectedCourses.add(course);
        }
    }

    public Transcript getTranscript() {
        return transcript;
    }

    public void setTranscript(Transcript transcript) {
        this.transcript = transcript;
    }

    public ArrayList<Course> getSelectedCourses() {
        return selectedCourses;
    }

    public void setSelectedCourses(ArrayList<Course> selectedCourses) {
        this.selectedCourses = selectedCourses;
    }

    public Payment getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(Payment paymentAmount) {
        this.paymentAmount = paymentAmount;
    }
}


