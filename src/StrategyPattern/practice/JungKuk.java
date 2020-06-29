package StrategyPattern.practice;

public class JungKuk extends BTS {

	public JungKuk(String name) {
		super(name);
	}

	@Override
	public void show() {
		System.out.print("안녕, 내 이름은 " + getName());
		System.out.println(", 포지션은 춤추기! ");
	}

}
