package AdapterPattern;

public class OldWebRequester implements WebRequester {

	@Override
	public void requestHandler() {
		System.out.println("OldWebRequester is working");
	}

}
