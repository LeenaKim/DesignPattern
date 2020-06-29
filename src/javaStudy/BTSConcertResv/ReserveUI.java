package javaStudy.BTSConcertResv;

public class ReserveUI extends ReservedSeats {

	@Override
	public void execute() {
		
		while(true) {
			
			int seatType = scanInt("좌석구분 - S석 : 1번, A석 : 2번, B석 : 3번 ");
			System.out.print(seatsType[seatType - 1] + "석 : ");
			for(int i = 0; i < ReservedSeats.rsvdSeats[seatType - 1].length; i++) {
				System.out.print("[ ");
				System.out.print(ReservedSeats.rsvdSeats[seatType - 1][i] == null ? " " : ReservedSeats.rsvdSeats[seatType - 1][i].getName());
				System.out.print(" ]");
			}
			System.out.println();
			String name = scanStr("이름을 입력하세요 : ");
			int seat = scanInt("좌석 번호를 입력하세요 : ");
			if(ReservedSeats.rsvdSeats[seatType - 1][seat - 1] == null) {
				ReservedSeats.rsvdSeats[seatType - 1][seat - 1] = new Reserver(name, seat);		
				break;
			} else {
				System.out.println("이미 예약된 좌석입니다. 다시 선택하세요.");
			}
		}	
	}

	
}
