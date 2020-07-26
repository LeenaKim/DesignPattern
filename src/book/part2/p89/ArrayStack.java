package book.part2.p89;

import java.util.ArrayList;

public class ArrayStack {

//	private int top;
	private ArrayList<Integer> itemList;
//	private int stackSize;
	
	public ArrayStack() {
		itemList = new ArrayList<>();
		
	}
	
	public boolean isEmpty() {
		return (itemList.size() == 0);
	}
	
	public void push(int item) {
		itemList.add(item);
		System.out.println("Inserted Item : " + item);
	}
	
	public int pop() {
		if(isEmpty()) {
			System.out.println("Deleting fail! ArrayStack is empty!");
			return -1;
		} else {
			return itemList.remove(itemList.size() - 1);			
		}
	}
	
	public int peek() {
		if(isEmpty()) {
			System.out.println("Deleting fail! ArrayStack is empty!");
			return -1;
		} else {
			return itemList.get(itemList.size() - 1);			
		}
	}

	public ArrayList<Integer> getItemList() {
		return itemList;
	}

	public void setItemList(ArrayList<Integer> itemList) {
		this.itemList = itemList;
	}
	
	
	
}
