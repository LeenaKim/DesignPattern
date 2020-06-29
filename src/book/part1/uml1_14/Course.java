package book.part1.uml1_14;

import java.util.ArrayList;

/*
 * 다대다 양방향 연관관계는 복잡하기때문에 대부분 클래스를 하나 더 두어 일대다 단방향 연관 관계로 변환해 구현한다.
 * 연관클래스 : 연관 관계에 추가할 속성이나 행위가 있을때 사용. 두 클래스의 사이에 위치.
 * ex) student와 course간에 성적이란 항목을 추가하고싶을떄. 
 * 	   성적은 student와 course 두 객체가 모두 존재할때만 가능하기 때문. 
 *     즉, 성적 정보는 클래스의 속성이 아닌 '수강하다'라는 연관 관계의 속성으로 다뤄야함.
 *     
 */
public class Course {

	private String name;
	private String year;
	private ArrayList<Transcript> transcript;
	
	Course(String year, String name) {
		this.year = year;
		this.name = name;
		transcript = new ArrayList<>();
	}
	
	public void setTranscript(Transcript transcript) {
		this.transcript.add(transcript);
	}
}
