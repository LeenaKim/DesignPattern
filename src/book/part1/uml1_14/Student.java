package book.part1.uml1_14;

import java.util.ArrayList;

public class Student {

	private String name;
	private ArrayList<Transcript> transcript;
	
	Student(String name){
		this.name = name;
		transcript = new ArrayList<>();
	}
	
	public void setTranscript(Transcript transcript) {
		this.transcript.add(transcript);
	}
}
