package Services;

import Models.Course;
import Models.Student;
import Types.SemesterName;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CourseRegistrationSystem {
    private static CourseRegistrationSystem instance;
    public ArrayList<Course> checkSelectedCourses(Student student, ArrayList<Course> courses) {
        // Get course codes of passed courses
        List<String> passedCourses = student.getTranscript().getPassedCourses()
                .stream().map(Course::getCourseCode)
                .collect(Collectors.toList());

        ArrayList<Course> checkedCourses = new ArrayList<>();

        for (Course course : courses) {
            if(checkPrerequisite( passedCourses,course.getPrerequisiteCourse())) {
                if (course.getQuota() > course.getQuotaCounter()) {
                    checkedCourses.add(course);
                    // Check if the course has any prerequisite

                } else {

                    course.getCourseEvents().get(5).getStudents().add(student);//add student to course Event2
                    System.out.println("Services.CourseRegistrationSystem: The course: " + course.getCourseCode() + " not added due to quota");
                }
            }
            else{
                course.getCourseEvents().get(2).getStudents().add(student);//add student to course Event2
                System.out.println("Services.CourseRegistrationSystem: The course: " + course.getCourseCode() + " not added due to prerequisite");

            }
        }


        return checkedCourses;
    }

    private boolean checkPrerequisite(List<String> arr, String prerequisiteCourse) {
        if(!prerequisiteCourse.equals("non")) {
            for (String s : arr) {
                if (s.equals(prerequisiteCourse)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean addApprovedCoursesToTranscript(Student student, ArrayList<Course> courses){
        try {
            return student.getTranscript().addCourses(student, courses);
        } catch (Exception e) {
            return false;
        }
    }


    public  ArrayList<Course> GetAvailableCourses(SemesterName semester, ArrayList<Course> allCourses) {
        ArrayList<Course> ACourses = new ArrayList<Course>();

        for (int i = 0; i < allCourses.size(); i = i + 1) {

            if(semester == allCourses.get(i).getCourseSemesterName().getSemesterName()){

                ACourses.add(allCourses.get(i));
            }
        }


        return ACourses;
    }

    public static CourseRegistrationSystem getRegistrationSystem(){
        if(instance==null){
            instance=new CourseRegistrationSystem();
        }
        return instance;
    }
}