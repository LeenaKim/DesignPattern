package TemplateMethodPattern;

public abstract class AbstGameConnectionHelper {

	// 하위클래스가 재정의를 해야하므로 private은 안되지만 외부에 노출되진 않도록 protected 사용 
	protected abstract String doSecurity(String string); // 보안 
	
	protected abstract boolean authentication(String id, String password);// 인증 
	
	protected abstract int authorization(String userName); //권한 
	
	protected abstract String connection(String info);// 접속 
	
	// 접속을 도와주는 템플릿 메소드 
	public String requestConnection(String encodedInfo) {
		// 보안과정 -> 암호화 된 문자열을 디코드한다. 
		String decodedInfo = doSecurity(encodedInfo);
		
		// 반환된 것을 가지고 아이디, 패스워드를 할당한다. 
		String id = "aaa";
		String password = "bbb";
		
		// 인증과정 -> db에 있는 아이디, 패스워드와 비교해 인증 여부 결정 
		if(!authentication(id, password)) {
			throw new Error("아이디 암호 불일치");
		}
		// 권한 부여 과정 -> 게임 매니저, 유로회원, 무료회원 등으로 나누어 서로 다른 권한을 부여할 수 있다. 
		String userName = "";
		int i = authorization(userName);
		
		switch (i) {
		case -1:
			throw new Error("셧다운");// 나이때문에 10시지나면 셧다운 
		case 0:
			System.out.println("게임 매니저 권한");
			break;
		case 1 :
			System.out.println("유료회원 권한 ");
			break;
		case 2 :
			System.out.println("무료회원 권한 ");
			break;
		case 3 :
			System.out.println("권한 없음 ");
		default:// 기타상황 
			break;
		}
		
		// 접속 과정 
		return connection(decodedInfo);
	}
}
