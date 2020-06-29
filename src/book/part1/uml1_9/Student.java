package book.part1.uml1_9;

public class Student {
	
	private Professor prof;
	
	public void setAdvisor(Professor prof) {
		this.prof = prof;
	}
	
	public void advise(String msg) {
		System.out.println(msg);
	}
}
