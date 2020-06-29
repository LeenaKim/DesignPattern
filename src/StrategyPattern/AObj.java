package StrategyPattern;

public class AObj {

	
	Ainterface ainterface;
	
	public AObj() {
		ainterface = new AinterfaceImpl();
	}
	
	private void funcAA() {
		
		// 출력하는 함수와 같은 기능을 구현할 수 있게된다.
		// 즉, 어떤 기능을 구현할때 다른 객체의 힘을 빌려 구현하는것을 "위임한다"라고 말한다. 
		ainterface.funcA();
		ainterface.funcA();
		
		
//		System.out.println("AAA");
//		System.out.println("AAA");
		
		// 어떤어떤 기능이 필요합니다. 개발해주세요. 라고 하고 다른 기능을 개발한다. 
	}
}
