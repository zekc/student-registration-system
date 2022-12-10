package Models;

public abstract class Person{
    public String FirstName;
    public String LastName;
    private String PersonMail;
    private int ssn;

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }
    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getPersonMail() {
        return PersonMail;
    }

    public void setPersonMail(String personMail) {
        PersonMail = personMail;
    }

    public int getSsn() {
        return ssn;
    }

    public void setSsn(int ssn) {
        this.ssn = ssn;
    }

}
