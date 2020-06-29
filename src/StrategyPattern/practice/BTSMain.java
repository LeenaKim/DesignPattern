package StrategyPattern.practice;

public class BTSMain {

	public static void main(String[] args) {
		
		Fan fan = new Fan();
		
		fan.show();// 아무 멤버도 할당되지 않았을때 Fan 클래스의 show 메서드가 호출된다. 
		
		fan.setBTS(new Vui("뷔"));// 묵시적 형변환 - 자식클래스의 메소드를 호출 
		fan.show();
		
		fan.setBTS(new JungKuk("정국"));
		fan.show();
		
		fan.setBTS(new Jimin("지민"));
		fan.show();
		
	}
}
