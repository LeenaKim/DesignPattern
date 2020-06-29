package AdapterPattern;
// adapter 
public class WebAdapter implements WebRequester {

	private FancyRequester fancyRequester;
	
	public WebAdapter(FancyRequester fancyRequester) {
		this.fancyRequester = fancyRequester;
	}
	// oldRequestHandler 대신 fancyRequester를 호출 
	@Override
	public void requestHandler() {
		fancyRequester.fancyRequestHandler();
	}

}
