package book.part1.uml1_12;

import java.util.ArrayList;

public class Course {

	private String courseName;
	private ArrayList<Student> students;
	
	
	Course(String name){
		this.courseName = name;
		this.students = new ArrayList<>();
	}
	
	public void registerStudent(Student student) {
		if(!this.students.contains(student))
			this.students.add(student);
	}
	
	public void dropStudent(Student student) {
		if(this.students.contains(student))
			this.students.remove(student);
	}

}
