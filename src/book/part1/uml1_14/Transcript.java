package book.part1.uml1_14;

public class Transcript {

	private Student student;
	private Course course;
	private String score;
	
	// 성적표가 생성됨과 동시에 학생과 수강과목에도 성적표 정보를 세팅해줌. 
	Transcript(Student student, Course course, String score) {
		this.student = student;
		this.student.setTranscript(this);
		this.course = course;
		this.course.setTranscript(this);
		this.score = score;
	}
}
