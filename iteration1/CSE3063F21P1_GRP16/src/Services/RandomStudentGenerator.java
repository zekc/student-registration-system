package Services;

import Models.Student;

public class RandomStudentGenerator {


    private String[] names = {"ali","veli","mahmut"};
    private String[] lastNames = {"tuncer","pala","kaya"};


    public void GenerateRandomStudents(int count){


        for (int i = 0; i <= count; i = i + 1) {

            String newName = names[(int) (Math.random()*names.length)];
            String newLastName = names[(int) (Math.random()*lastNames.length)];

            Student tempForStudendt = new Student(newName,newLastName);


        }




    }
}
