import Models.*;
import Services.CourseRegistrationSystem;
import Services.RandomAdvisorCreator;
import Services.RandomStudentGenerator;
import Types.SemesterName;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Main {


    static CourseRegistrationSystem registrationSystem;

    public static void main(String[] args) throws IOException {
        System.out.println("Hello world!");


        ArrayList<Course> fullCourseList = InitCourses("src/lectures.json");
        RandomStudentGenerator generator = new RandomStudentGenerator();
        RandomAdvisorCreator advisorCreator = new RandomAdvisorCreator();
        registrationSystem = new CourseRegistrationSystem();

        ArrayList<Advisor> advisors = new ArrayList<Advisor>();
        ArrayList<Student> students = new ArrayList<Student>();


       advisors = advisorCreator.GenerateRandomAdv(5);
       students = generator.GenerateRandomStudents(10);


        for (int i = 0; i < students.size(); i = i + 1) {

        students.get(i).setAdvisor(advisors.get((int) (Math.random()*advisors.size())));

        }



        for (int i = 0; i < fullCourseList.size(); i = i + 1) {


           System.out.println(fullCourseList.get(i).coursename);

        }













    }

    private static ArrayList<Course> InitCourses(String fileName) throws IOException {





        String jsonString = new String(Files.readAllBytes(Paths.get(fileName)), StandardCharsets.UTF_8);
        JSONObject obj = new JSONObject(jsonString);





        JSONArray courseJsonArray = obj.getJSONArray("courses");
        ArrayList<JSONObject> courseJSON = new ArrayList<>();
        for (int i = 0; i < courseJsonArray.length(); i++) {
            courseJSON.add((JSONObject) (courseJsonArray.get(i)));
        }

        ArrayList<Course> courseList = new ArrayList<>();
        for (JSONObject course : courseJSON) {
            String courseName = course.getString("courseName");

            int credit = course.getInt("credit");
            int requiredCredits = course.getInt("requiredCredits");
            Semester courseSemester = new Semester(course.getInt("courseSemester"), SemesterName.FALL);

            JSONArray preRequisiteJSON = new JSONArray(course.getJSONArray("preRequisiteCourse"));
            ArrayList<String> preRequisites = new ArrayList<String>();

            for (int i = 0; i < preRequisiteJSON.length(); i++) {
                preRequisites.add(((preRequisiteJSON.get(i).toString())));
            }

            JSONArray courseSessionsJSONObjects = new JSONArray(course.getJSONArray("courseSessions"));
            ArrayList<CourseSession> courseSessions = new ArrayList<>();

            for (int i = 0; i < courseSessionsJSONObjects.length(); i++) {
                courseSessions.add(new CourseSession((JSONObject) courseSessionsJSONObjects.get(i)));
            }
            Course _course = new Course(courseName, credit, preRequisites, courseSessions, requiredCredits, courseSemester);  // CourseType will be dynamic.
            courseList.add(_course);
        }
        return courseList;
    }

    public static JSONObject parseJSONFile(String filename) throws JSONException, IOException {
        Path pathOf = Paths.get(filename).toAbsolutePath();
        String content = new String(Files.readAllBytes(pathOf));
        System.out.println(pathOf);
        return new JSONObject(content);
    }








    private static void FileCreator(){






    }




}