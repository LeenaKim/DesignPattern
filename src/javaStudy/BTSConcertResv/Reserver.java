package javaStudy.BTSConcertResv;

public class Reserver {

	private String name;
	private int seat;
	
	public Reserver(String name, int seat) {
		super();
		this.name = name;
		this.seat = seat;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSeat() {
		return seat;
	}
	public void setSeat(int seat) {
		this.seat = seat;
	}
	
	
}
