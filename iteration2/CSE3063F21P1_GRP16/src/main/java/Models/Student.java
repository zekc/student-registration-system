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

    private Transcript transcript;
    private ArrayList<Course> selectedCourses;
    private Payment paymentAmount;

    private int StudentSemesterNo;



    private static FileWriter file;

    public Student(String newFirstName, String newLastName,ArrayList<Course> allCourses) {

        studentID = new StudentID("CSE", Integer.toString((int)Math.max(18,Math.random()*20)),Integer.toString(Math.max(10,((int)(Math.random()*50) ))));
        StudentSemesterNo = (int)(Math.random()*5 + 2);
        FirstName = newFirstName;
        LastName = newLastName;
        transcript = new Transcript(allCourses);
        selectedCourses = new ArrayList<>();

    }



    CourseRegistrationSystem courseRegistrationSystem = new CourseRegistrationSystem();


    public ArrayList<Course> enrollTheCourse(Student student ) {
        //this method sends student's selected courses to systems control
        ArrayList<Course> checkedSelectedCourses = courseRegistrationSystem.checkSelectedCourses(student,selectedCourses);
        return checkedSelectedCourses;
    }
    public String sendToApprove (Student student, ArrayList<Course> checkedSelectedCourses){
        //student sends the checked courses by the registration system to his/her advisor
        String message = advisor.courseApprovement(student,checkedSelectedCourses);
        return message;
    }
    public ArrayList<Course> selectTheCourse (ArrayList<Course> courses){
        Random rand = new Random();
        // generate random 5 courses that the student selected
        for (int i = 0; i < 5; i++) {
            int int_random = rand.nextInt(courses.size());
            selectedCourses.add(courses.get(int_random));
            courses.remove(int_random);
        }
        return selectedCourses;
    }

    public void saveToJson(){

            JSONObject obj = new JSONObject();
            obj.put("Name", FirstName);
            obj.put("LastName", LastName);

            JSONObject Trans  = new JSONObject();
            Trans.put("gpa",transcript.getGPA());
            JSONArray passedCourses = new JSONArray();

        for (int i = 0; i < transcript.getPassedCourses().size() ; i = i +1) {
        passedCourses.put(transcript.getPassedCourses().get(i).getCourseCode());
        }

        JSONArray failedCourses = new JSONArray();
        for (int i = 0; i < transcript.getFailedCourses().size() ; i = i +1) {
           failedCourses.put(transcript.getFailedCourses().get(i).getCourseCode());
        }

        obj.put("PassedCourses",passedCourses);
        obj.put("FailedCourses",failedCourses);

        for (int i = 0; i <= passedCourses.length(); i = i + 1) {
          // passedCourses.put(transcript.passedCourses.get(i).getCourseCode());
        }

            obj.put("TranskriptObj",Trans);
            try {

                file = new FileWriter("src/students/" + studentID.getStudentString() +".json");
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

    public void SelectRandomCourses(ArrayList<Course> avaibleCourses)
    {
        selectedCourses.clear();
       int randomAmount = (int) Math.min(Math.max(5,avaibleCourses.size()*Math.random()),1);
        for (int i = 0; i < randomAmount; i = i + 1) {

            int randomClass = (int)(avaibleCourses.size()*Math.random());
            AddCourse(avaibleCourses.get(randomClass));


        }


    }

    public void AddCourse(Course course){


        if(!selectedCourses.contains(course)){

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


