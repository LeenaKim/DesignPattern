package book.part1.p48;

public class Student {

	private String name;
	private School school;
	
	Student(String name, School school) {
		this.name = name;
		this.school = school;
		this.school.registerNewStudent(this);
	}
	
	
	
}
