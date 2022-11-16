package Services;

import Models.Course;
import Models.Student;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class CourseRegistrationSystem {
    public ArrayList<Course> checkSelectedCourses(Student student, ArrayList<Course> courses) {
        // Get course codes of passed courses
        List<String> passedCourses = student.getTranscript().getPassedCourses()
                .stream().map(c -> c.getCourseCode())
                .collect(Collectors.toList());

        ArrayList<Course> checkedCourses = new ArrayList<>();

        for (Course course : courses) {
            // Check if the course has any prerequisite
            if (course.getPrerequisiteCourse() != null) {
                // Check if the student passed the prerequisite
                if (passedCourses != null &&
                        passedCourses.indexOf(course.getPrerequisiteCourse()) != -1) {
                    checkedCourses.add(course);
                } else {
                    System.out.println("Services.CourseRegisterationSystem: The course: " + course.getCourseCode() + " not added due to unmet prerequisities.");
                }
            } else {
                checkedCourses.add(course);
            }
        }

        return checkedCourses;
    }
}
