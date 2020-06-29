package book.part2.code2_4;

public class StackClient {

	public static void main(String[] args) {
		// 길이 10의 Array Stack 으로 초기화 
		ArrayStack st = new ArrayStack(10);
		
		// 0번지값에 20 할당 
		st.itemArray[++st.top] = 20;
		
		// 가장 최근에 들어간 데이터의 인덱스(st.top)에 위치한 값(st.itemArray) 출력 
		System.out.println(st.itemArray[st.top]);
		
	}
}
