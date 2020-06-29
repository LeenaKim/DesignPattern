package book.part1.uml1_12;

import java.util.ArrayList;


/*
 * < 다대다 연관 관계 >
 * 1_11은 여러개의 course 대 한명의 student 의 단방향 관계였는데,
 * 이는 실제로 성립할 수 없다.
 * 다대다 양방향 연관 관계로 바꿔주자. 
 * 일반적으로 다대다 연관 관계는 양방향 연관 관계로 표현됨.
 */
public class Student {

	private ArrayList<Course> course;
	
	Student(){
		course = new ArrayList<>();
	}
	public void registerCourse(Course course) {
		this.course.add(course);
		course.registerStudent(this);
	}
	
	public void dropCourse(Course course) {
		if(this.course.contains(course)) {
			this.course.remove(course);			
		}
		course.dropStudent(this);
	}
}
