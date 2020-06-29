package book.part1.uml1_14;

public class main {

	public static void main(String[] args) {
		Student student1 = new Student("김리나");
		Student student2 = new Student("김강열");
		
		Course course1 = new Course("2019", "사회학원론");
		Course course2 = new Course("2019", "사회학강독");
		
		// 만든 Student, Course객체를 매개변수로 Transcript 객체 생성 
		Transcript transcript1 = new Transcript(student1, course1, "A+");
		Transcript transcript2 = new Transcript(student1, course2, "A+");
		// 성적표가 등록되는 순간 transcript 생성자 내의 student.setTranscript, course.setTranscript가 발동되어 두 클래스에도 transcript가 등록된다.
		
		
	}
}
