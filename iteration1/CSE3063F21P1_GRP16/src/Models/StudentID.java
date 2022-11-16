package Models;

public class StudentID {

    private String studentEntryYear;

    private String studentEntryOrder;
    private String studentDepartment;


    public StudentID(String studentDepartment, String getStudentEntryYear, String studentEntryOrder) {

        this.studentDepartment = studentDepartment;
        this.studentEntryYear = getStudentEntryYear;
        this.studentEntryOrder = studentEntryOrder;
    }
    
    //public int getStudentID() {return 150118000;}

    public String getStudentString(){

       return  1501+studentEntryYear+studentEntryOrder;

    }


}
