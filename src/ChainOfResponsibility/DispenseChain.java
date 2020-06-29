package ChainOfResponsibility;

public interface DispenseChain {

	void setNextChain(DispenseChain nextChian);
	void dispense(Currency cur);
}
