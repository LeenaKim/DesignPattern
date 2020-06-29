package book.part1.p48;

import java.util.ArrayList;

public class School {
	
	private String name;
	private String region;
	private ArrayList<Student> students;
	
	School(String name, String region){
		this.name = name;
		this.region = region;
	}
	
	public void registerNewStudent(Student student) {
		this.students.add(student);
	}
	
	
}
