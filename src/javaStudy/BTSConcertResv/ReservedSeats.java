package javaStudy.BTSConcertResv;

import java.util.Scanner;

public abstract class ReservedSeats implements IResv{

	protected static Reserver[][] rsvdSeats = new Reserver [3][10];
	protected final String[] seatsType = {"S", "A", "B"};
	protected Scanner sc = new Scanner(System.in);
	
	public String scanStr(String msg) {
		System.out.println(msg);
		return sc.nextLine();
	}
	public int scanInt(String msg) {
		System.out.println(msg);
		return Integer.parseInt(sc.nextLine());
	}
}
