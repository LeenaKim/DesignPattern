package book.part2.p85;

public class main {

	public static void main(String[] args) {
		A a1 = new A1();
		A1 a2 = new A1();
		
		// A method가 호출됨. static이기떄문. 오버라이딩은 주로 객체와 연관되어 같은 부모를 참조하지만 선언된 객체의 자식 클래스에 따라 서로 다른 메소드를 호출한다.
		// static은 자식객체가 아니라 참조하고있는 값과 연관되있기 때문에 참조하고있는 부모가 가진 메소드를 출력. 
		a1.doIt();
		
		// A1 method가 호출됨. non-static
		a1.doThat();
		
		// A1 method가 호출됨. 애초에 A1의 객체였기 때문. 
		a2.doIt();
	}
}
