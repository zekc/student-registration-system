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

        DeleteDirectory(StudentsFile);

        JsonService jsonService = new JsonService();

        ArrayList<Advisor> advisors = new ArrayList<Advisor>();

        ArrayList<Course> fullCourseList = JsonService.InitCourses("src/lectures.json");
        advisors = jsonService.InitAdvisors("src/advisors.json");

        RandomStudentGenerator generator = new RandomStudentGenerator();
        RandomAdvisorCreator advisorCreator = new RandomAdvisorCreator();
        registrationSystem = CourseRegistrationSystem.getRegistrationSystem();

        ArrayList<Student> students = new ArrayList<Student>();
        ArrayList<Course> ThisSemesterCourses = registrationSystem.GetAvailableCourses(SemesterName.SPRING, fullCourseList);

        students = generator.GenerateRandomStudents( fullCourseList);

        for (int i = 0; i < students.size(); i = i + 1) {

            students.get(i).setAdvisor(advisors.get((int) (Math.random() * advisors.size())));

            students.get(i).saveToJson();
        }

        System.out.println(" ");
        System.out.println("Available Classes This Semester: \n");

        for (int i = 0; i < ThisSemesterCourses.size(); i = i + 1) {
            System.out.println(ThisSemesterCourses.get(i).getCourseCode());
        }

        for (int i = 0; i < students.size(); i = i + 1) {

            System.out.println(students.get(i).FirstName + " " + students.get(i).LastName + "is selecting course");

            students.get(i).getStudentUtils().SelectRandomCourses(ThisSemesterCourses);

            System.out.println(students.get(i).getStudentUtils().enrollTheCourse(students.get(i)));

        }
        outputFileCreator(ThisSemesterCourses);

        outputFileCreator(ThisSemesterCourses);

    }

    public static void DeleteDirectory(File dir) {

        for (File file : dir.listFiles()) {
            if (file.isDirectory())
                DeleteDirectory(file);
            file.delete();
        }

    }

    private static void outputFileCreator(ArrayList<Course> thisSemesterCourses) {
        PrintWriter output = null;
        try {

            File outputFile = new File("output.txt");
            output = new PrintWriter(outputFile);

            for (int i = 0; i < thisSemesterCourses.size(); i++) {
                output.println("<<" + thisSemesterCourses.get(i).getCourseName() + ">>");
                for (int j = 0; j < thisSemesterCourses.get(i).getCourseEvents().size(); j++) {

                    output.print(thisSemesterCourses.get(i).getCourseEvents().get(j).toString());

                }
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (output != null) output.close();
        }

    }

}
