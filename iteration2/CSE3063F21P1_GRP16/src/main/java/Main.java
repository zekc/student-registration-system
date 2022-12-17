import Models.*;
import Services.CourseRegistrationSystem;
import Services.JsonService;
import Services.RandomAdvisorCreator;
import Services.RandomStudentGenerator;
import Types.SemesterName;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Main {

    static CourseRegistrationSystem registrationSystem;

    public static void main(String[] args) throws IOException {

        File StudentsFile = new File("src/students");



        JsonService jsonService = new JsonService(StudentsFile);

        ArrayList<Advisor> advisors = jsonService.InitAdvisors("src/advisors.json");

        ArrayList<Course> fullCourseList = JsonService.InitCourses("src/lectures.json");

        RandomStudentGenerator generator = new RandomStudentGenerator();

        registrationSystem = CourseRegistrationSystem.getRegistrationSystem();

        ArrayList<Student> students = generator.GenerateRandomStudents( fullCourseList);
        ArrayList<Course> ThisSemesterCourses = registrationSystem.GetAvailableCourses(SemesterName.SPRING, fullCourseList);

        for (int i = 0; i < students.size(); i = i + 1) {

            students.get(i).setAdvisor(advisors.get((int) (Math.random() * advisors.size())));

            students.get(i).saveToJson();
        }

        System.out.println("Available Classes This Semester: \n");

        for (int i = 0; i < ThisSemesterCourses.size(); i = i + 1) {
            System.out.println(ThisSemesterCourses.get(i).getCourseCode());
        }

        for (int i = 0; i < students.size(); i = i + 1) {
            students.get(i).getStudentUtils().SelectRandomCourses(ThisSemesterCourses,students.get(i));
        }

        jsonService.outputFileCreator(ThisSemesterCourses);


    }




}
