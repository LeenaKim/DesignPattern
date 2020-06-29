package book.part1.uml1_9;

public class main {

	public static void main(String[] args) {
		Professor hongGilDong = new Professor("홍길동", "사회학과");
		Student KimLeeNa = new Student();
		hongGilDong.setStudents(KimLeeNa);
		hongGilDong.advise("오늘의 상담은...");
	}

}
