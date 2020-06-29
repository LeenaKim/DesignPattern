package ChainOfResponsibility;

import java.util.Scanner;

public class ChainOfResponsibilityPattern {

	private DispenseChain c1;
	
	public ChainOfResponsibilityPattern() {
		this.c1 = new Dollar50Dispenser();
		DispenseChain c2 = new Dollar20Dispenser();
		DispenseChain c3 = new Dollar10Dispenser();
		
		c1.setNextChain(c2);
		c2.setNextChain(c3);
	}
	
	public static void main(String[] args) {
		ChainOfResponsibilityPattern atmDispenser = new ChainOfResponsibilityPattern();
		Scanner input = null;
		
		while(true) {
			int amount = 0;
			System.out.println("Enter amount to dispense");
			input = new Scanner(System.in);
			amount = input.nextInt();
			if(amount % 10 != 0) {
				System.out.println("Amount should be multiple of ten! Input again. ");
				continue;
			}
			
			atmDispenser.c1.dispense(new Currency(amount));
		}
	}
}
