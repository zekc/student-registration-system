package Services;

import Models.Course;
import Models.Grade;
import Models.Transcript;

import java.util.ArrayList;
import java.util.UUID;

public class GenerateTranscript {
    private String ID;
    public double GPA;

    public String generateID() {
        this.ID = UUID.randomUUID().toString();
        return ID;
    };

    public void generateCourseStatus(ArrayList<Course> coursesArrayList) {
        Grade grade = new Grade();
        Transcript transcript = new Transcript(coursesArrayList);
        ArrayList<Course> passed = new ArrayList<>();
        ArrayList<Course> failed = new ArrayList<>();

        for (Course course : coursesArrayList) {
            Double genGrade = grade.generateGrade();
            if (genGrade >= 1.00) {
                passed.add(course);
            }
            else {
                failed.add(course);
            }
            transcript.setPassedCourses(passed);
            transcript.setFailedCourses(failed);
            transcript.setGPA(genGrade);
        }
    };
}
