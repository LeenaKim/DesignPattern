package AdapterPattern;

public class WebClient {

	private WebRequester webRequester;
	
	public WebClient(WebRequester webRequester) {
		this.webRequester = webRequester;
	}
	
	// WebRequester 인터페이스를 구현한 클래스의 requestHandler() 메소드를 호출하여 동작 
	// 새로운 handler를 구현하기 전에는 oldRequester에서 해당 메소드를 재정의하였으므로 oldRequester의 requestHandler()가 호출된다. 
	public void doWork() {
		webRequester.requestHandler();
	}
	
}
