package StrategyPattern.practice;

public class Vui extends BTS {

	public Vui(String name) {
		super(name);// new Vui()가 호출되는 순간 BTS 클래스의 생성자를 name 매개변수를 가지고 넘어가 BTS클래스의 멤버변수인 name에 "뷔"를 저장 
	}

	@Override
	public void show() {
		System.out.print("안녕, 내 이름은 " + getName());
		System.out.println(", 포지션은 윙크하기! ");
	}
	

}
