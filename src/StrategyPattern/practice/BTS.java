package StrategyPattern.practice;

public abstract class BTS implements BroadCast {

	private String name;

	public BTS(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
