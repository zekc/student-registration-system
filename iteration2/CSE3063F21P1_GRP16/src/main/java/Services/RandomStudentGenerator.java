package Services;

import Models.Course;
import Models.Semester;
import Models.Student;
import Types.SemesterName;

import java.util.ArrayList;

public class RandomStudentGenerator {


    private static final String[] firstNames = { "Charmane",
            "Guillema", "Ruthann", "Welsh", "Garold", "Mitchael", "Noellyn", "Antony", "Rafaellle", "Russ", "Noami",
            "Adler", "Michelle", "Farleigh", "Hertha", "Lucias", "Benedetta", "Fawnia", "Rebe", "Linda", "Mathian",
            "Consuela", "Cal", "Kalle", "Natale", "Athena", "Hervey", "Tilly", "Veronike", "Karl", "Joann", "Raddy",
            "Darren", "Lynnet", "Kaycee", "Brendin", "Oliy", "Magnum", "Tedra", "Marlin", "Velvet", "Helaine",
            "Rebecca", "Natty", "Micky", "Perla", "Kelli", "Garik", "Lucie", "Hollis" };

    private static final String[] lastNames = { "Gallety", "Scurman", "Gulliman", "Domini", "De Caroli", "Durrance",
            "Wozencroft", "Jaqueme", "Campsall", "Chicchelli", "Twydell", "Nowak", "McMillam", "Frood", "Treharne",
            "Dennant", "Clewes", "Moring", "Rankcom", "O'Hanley", "Snodin", "Grigoriev", "Benterman", "Waber",
            "Skouling", "Renihan", "Wilks", "Musson", "Letham", "Mcettrick", "Vieyra", "Tatnell", "Cymper", "Muckeen",
            "Cuxon", "Itzik", "Late", "Sugden", "Wodeland", "MacGahy", "Garric", "Bockman", "Denisovich", "Basnett",
            "Welham", "Luchelli", "Boome", "Gannaway", "Saice", "Greenhough" };


    // This function generate students and assign courses to them for each semester
    public ArrayList<Student> GenerateRandomStudents(ArrayList<Course> courses){
        CourseRegistrationSystem registrationSystem = CourseRegistrationSystem.getRegistrationSystem();


        ArrayList<Student> students = new ArrayList<Student>();

        for (int i = 0; i < 8; i++) {
            ArrayList<Course> ThisSemesterCourses;
            Semester semester;
            for(int j = 0; j < 50; j++){
                String newFirstName = firstNames[(int) (Math.random() * firstNames.length)];
                String newLastName = lastNames[(int) (Math.random() * lastNames.length)];
                students.add(new Student(newFirstName,newLastName,courses));
            }
            if (Math.random() * 2 == 0) {
                ThisSemesterCourses = registrationSystem.GetAvailableCourses(SemesterName.FALL, courses);
                semester = new Semester(i+1, SemesterName.FALL);
            }
            else {
                ThisSemesterCourses = registrationSystem.GetAvailableCourses(SemesterName.SPRING, courses);
                semester = new Semester(i+1, SemesterName.SPRING);
            }
            for(int j = 0; j < students.size(); j++){
                students.get(j).addSemester(ThisSemesterCourses, semester.getSemesterNo(), semester.getSemesterName());
            }



        }

        return students;


    }


}