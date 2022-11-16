package Services;

import Models.Course;
import Models.Student;

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



    public ArrayList<Student> GenerateRandomStudents(int count, ArrayList<Course> courses){


        ArrayList<Student> students = new ArrayList<Student>();

        for (int i = 0; i < count; i = i + 1) {

            String newFirstName = firstNames[(int) (Math.random() * firstNames.length)];
            String newLastName = lastNames[(int) (Math.random() * lastNames.length)];

            Student tempForStudendt = new Student(newFirstName,newLastName,courses);


            students.add(tempForStudendt);


        }

return students;


    }


}
