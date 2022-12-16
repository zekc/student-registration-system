package Services;

import Models.Advisor;
import Models.Course;
import Models.CourseSession;
import Models.Semester;
import Types.CourseType;
import Types.SemesterName;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class JsonService {


    public static ArrayList<Course> InitCourses(String fileName) throws IOException {


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
            String courseCode = course.getString("courseCode");


            int credit = course.getInt("credit");
            int requiredCredits = course.getInt("requiredCredits");


            SemesterName sem = SemesterName.SPRING;
            if (course.getInt("courseSemester") % 2 == 0) {

                sem = SemesterName.FALL;
            }

            CourseType courseType = CourseType.NTE;

            Semester courseSemester = new Semester(course.getInt("courseSemester"), sem);

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


            JSONObject JO = (JSONObject) courseSessionsJSONObjects.get(0);
            int quota = JO.getInt("quota");

            String prereq = "non";

            if (preRequisites.size() > 0) {

                prereq = preRequisites.get(0);
            }

            //  Course _course = new Course(courseName, credit, preRequisites, courseSessions, requiredCredits, courseSemester);  // CourseType will be dynamic.
            //Course _course = new Course(courseName,courseCode,quota,prereq,credit,courseSemester,courseType,courseSessions);
            Course _course = new Course(courseName, courseCode, quota, prereq, credit, courseSemester, courseType, courseSessions, requiredCredits);
            courseList.add(_course);
        }


        return courseList;


    }

    public ArrayList<Advisor> InitAdvisors(String s) throws IOException {


        String jsonString = new String(Files.readAllBytes(Paths.get(s)), StandardCharsets.UTF_8);
        JSONObject obj = new JSONObject(jsonString);


        JSONArray AdJsonArray = obj.getJSONArray("advisors");
        ArrayList<JSONObject> advisorJSON = new ArrayList<>();
        for (int i = 0; i < AdJsonArray.length(); i++) {
            advisorJSON.add((JSONObject) (AdJsonArray.get(i)));
        }


        ArrayList<Advisor> advisorList = new ArrayList<>();
        for (JSONObject AD :  advisorJSON) {
            String Name = AD.getString("AdvisorName");
            String LName = AD.getString("AdvisorLastName");


           Advisor _advisor = new Advisor(Name,LName);
           advisorList.add(_advisor);

        }





        return advisorList;
    }

}
