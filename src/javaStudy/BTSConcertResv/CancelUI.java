package javaStudy.BTSConcertResv;

public class CancelUI extends ReservedSeats {

	@Override
	public void execute() {
		int seatType = scanInt("좌석구분 - S석 : 1번, A석 : 2번, B석 : 3번 ");
		System.out.print(seatsType[seatType - 1] + "석 : ");
		for(int i = 0; i < ReservedSeats.rsvdSeats[seatType - 1].length; i++) {
			System.out.print("[ ");
			System.out.print(ReservedSeats.rsvdSeats[seatType - 1][i] == null ? " " : ReservedSeats.rsvdSeats[seatType - 1][i].getName());
			System.out.print(" ]");
		}
		System.out.println();
		String name = scanStr("이름을 입력하세요 : ");
		int cnt = 0;
		for(int i = 0; i < ReservedSeats.rsvdSeats[seatType - 1].length; i++) {
			if(ReservedSeats.rsvdSeats[seatType - 1][i] != null) {
				if(ReservedSeats.rsvdSeats[seatType - 1][i].getName().equals(name)) {
					cnt++;
					if(cnt == 2) {
						int seat = scanInt("동명이인이 있습니다. 취소할 좌석 번호를 선택하세요. ");
						ReservedSeats.rsvdSeats[seatType - 1][seat - 1] = null;
						break;
					} 
				} else if(i == ReservedSeats.rsvdSeats[seatType - 1].length - 1) {
					ReservedSeats.rsvdSeats[seatType - 1][i] = null;
				}
				
			}
		}
		
	}

}
