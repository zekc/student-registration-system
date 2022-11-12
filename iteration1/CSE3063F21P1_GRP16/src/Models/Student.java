package Models;

public class Student extends Person {

    private Advisor advisor;
    public Student(String newName, String newLastName) {

        name = newName;
        lastname = newLastName;


    }


    public void setAdvisor(Advisor advisor) {
        this.advisor = advisor;
    }
}

