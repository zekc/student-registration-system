
package Models;

import java.util.ArrayList;

public class E4NoEnoughCredits  implements CourseEvents {
	
	
private ArrayList<Student> students;


public ArrayList<Student> getStudents() {
	return students;
}

public  E4NoEnoughCredits() {
	students=new ArrayList<>();
	
}

@Override
public String toString() {
		
	String s="Total Number of Student who couldn't take the course because of they don't have enough credits: "+students.size()+"\nList Of Students:\n";
	
	for(int i=0;i<students.size();i++) {
		s+=students.get(i).getFirstName()+" "+students.get(i).getLastName()+"\n";
		
		
	}
	return s;
}

}





