
package Models;

import java.util.ArrayList;

public class E5Quota  implements CourseEvents {
	
	
private ArrayList<Student> students;


public ArrayList<Student> getStudents() {
	return students;
}

public  E5Quota() {
	students=new ArrayList<>();
	
}

@Override
public String toString() {
		
	String s="Total Number of Student who could't take the course becuase the is quota full: "+students.size()+"\nList Of Students:\n";
	
	for(int i=0;i<students.size();i++) {
		s+=students.get(i).getFirstName()+" "+students.get(i).getLastName()+"\n";
		
		
	}
	return s;
}

}




