package StrategyPattern.practice;

public class Fan {

	private BTS bts;
	
	// 필요에 따라 전략을 바꿔준다. 여기서의 전략 : 뷔, 정국, 지민 
	public void setBTS(BTS bts) {
		this.bts = bts;
		// BTS bts = new Vui() 이런 형식으로 묵시적 형변환을 발생시키는 메소드 
	}
	
	public void show() {
		if(bts == null) {
			System.out.println("아무 멤버도 활동중이 아닙니다. ");
		}else {
			bts.show();
		}
	}
}
