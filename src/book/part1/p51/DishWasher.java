package book.part1.p51;

public class DishWasher extends HomeAppliancies {

	@Override
	public void turnOn() {
		System.out.println("식기세척기 키기...");
	}

	@Override
	public void turnOff() {
		System.out.println("식기세척기 끄기...");
		
	}

}
