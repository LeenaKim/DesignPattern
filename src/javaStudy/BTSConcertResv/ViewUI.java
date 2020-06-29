package javaStudy.BTSConcertResv;

public class ViewUI extends ReservedSeats {

	@Override
	public void execute() {
		for(int i = 0; i < ReservedSeats.rsvdSeats.length; i++) {
			System.out.print(seatsType[i] + "석 : ");
			for(int j = 0; j < ReservedSeats.rsvdSeats[i].length; j++) {
				System.out.print("[ ");
				System.out.print(ReservedSeats.rsvdSeats[i][j] == null ? " " : ReservedSeats.rsvdSeats[i][j].getName());
				System.out.print(" ]");
			}
			System.out.println();
		}
		System.out.println("<< 조회를 완료하였습니다. >>");
	}

	
}
