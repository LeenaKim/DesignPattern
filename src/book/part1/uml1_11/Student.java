package book.part1.uml1_11;

import java.util.ArrayList;

/*
 * < 단방향 연관 관계 >
 * 학생은 자신이 수강하는 과목을 알지만 과목은 자신을 수강하는 학생들의 존재를 모른다. 
 * 이렇게 한쪽으로만 방향성이 있는 연관관계를 단방향 연관관계라 한다. 
 */
public class Student {

	private ArrayList<Course> course;
	
	Student(){
		course = new ArrayList<>();
	}
	public void registerCourse(Course course) {
		this.course.add(course);
	}
	
	public void dropCourse(Course course) {
		if(this.course.contains(course)) {
			this.course.remove(course);			
		}
	}
}
