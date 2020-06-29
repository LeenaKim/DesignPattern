package StrategyPattern;

public class Main {

	public static void main(String[] args) {
		Ainterface ainterface = new AinterfaceImpl();
		
		// aInterface를 사용할 수 있는 통로 
		ainterface.funcA();
	}
}
