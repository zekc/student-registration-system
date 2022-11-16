package Models;

public class StudentID {

    private String studentDepartment;
    private String studentEntryYear;
    private String studentEntryOrder;

    public StudentID(String studentID) {
        this.studentDepartment = studentID.substring(0, 4);
        this.studentEntryYear = studentID.substring(4, 6);
        this.studentEntryOrder = studentID.substring(6, 9);
    }

    public String getStudentDepartment() {
        return studentDepartment;
    }

    public void setStudentDepartment(String studentDepartment) {
        this.studentDepartment = studentDepartment;
    }

    public String getStudentEntryYear() {
        return studentEntryYear;
    }

    public void setStudentEntryYear(String studentEntryYear) {
        this.studentEntryYear = studentEntryYear;
    }

    public String getStudentEntryOrder() {
        return studentEntryOrder;
    }

    public void setStudentEntryOrder(String studentEntryOrder) {
        this.studentEntryOrder = studentEntryOrder;
    }

    public void parse(String studentID) {
        this.studentDepartment = studentID.substring(0, 4);
        this.studentEntryYear = studentID.substring(4, 6);
        this.studentEntryOrder = studentID.substring(6, 9);
    }

    public int get() {
        return Integer.parseInt(studentDepartment + studentEntryYear + studentEntryOrder);
    }
}
