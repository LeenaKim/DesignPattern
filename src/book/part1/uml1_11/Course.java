package book.part1.uml1_11;
// student -> course의 단방향 관계이기때문에 course에서 student 객체를 속성으로 가질 필요가 없다. 
public class Course {
	
	private String courseName;
	
	Course(String name){
		this.courseName = name;
	}
}
