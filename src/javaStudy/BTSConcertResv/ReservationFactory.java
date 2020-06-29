package javaStudy.BTSConcertResv;

import java.util.Scanner;

public class ReservationFactory {

	private Scanner sc;
	private IResv rsv = null;
	
	ReservationFactory() {
		sc = new Scanner(System.in);
	}
	
	public void getResv() {
		while(true) {
			System.out.println("BTS 콘서트 좌석 예약 시스템입니다. 원하시는 번호를 입력해주세요. ");
			System.out.println("예약<1>, 조회<2>, 취소<3>, 끝내기<4>");
			int serviceType = Integer.parseInt(sc.nextLine());
			switch(serviceType) {
			case 1 : 
				rsv = new ReserveUI();
				break;
			case 2 :
				rsv = new ViewUI();
				break;
			case 3 :
				rsv = new CancelUI();
				break;
			case 4 :
				System.out.println("서비스를 종료합니다. ");
				System.exit(0);
			}
			rsv.execute();
		}
	}
}
