package book.part1.uml1_9;
/**
 * < 양방향 연관관계 >
 * Professor 클래스 객체에서 Student 클래스 객체를 참조할 수 있는 속성이 있고
 * Student 클래스 객체에서 Professor 클래스 객체를 참조할 수 있는 속성이 있다.
 * @author linakim
 *
 */
public class Professor {

	private String name;
	private String major;
	private Student student;
	
	Professor(String name, String major) {
		this.name = name;
		this.major = major;
	}
	// 교수가 맡은 학생을 멤버변수로 설정하고, student의 advisor로도 등록한다. 
	public void setStudents(Student student) {
		this.student = student;
		student.setAdvisor(this);
	}
	
	public void advise(String msg) {
		student.advise(msg);
	}
	
	
}
