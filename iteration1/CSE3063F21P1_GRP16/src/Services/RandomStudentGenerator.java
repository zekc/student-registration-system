package Services;

import Models.Student;

import java.util.ArrayList;

public class RandomStudentGenerator {


    private String[] names = {"ali","veli","mahmut"};
    private String[] lastNames = {"tuncer","pala","kaya"};


    public ArrayList<Student> GenerateRandomStudents(int count){


        ArrayList<Student> students = new ArrayList<Student>();

        for (int i = 0; i < count; i = i + 1) {

            String newName = names[(int) (Math.random()*names.length)];
            String newLastName = lastNames[(int) (Math.random()*lastNames.length)];

            Student tempForStudendt = new Student(newName,newLastName);


            students.add(tempForStudendt);

        }

return students;


    }
}
