package book.part2.code2_4;

public class ArrayStack {

	public int top;
	public int[] itemArray;
	public int stackSize;
	
	public ArrayStack(int stackSize) {
		itemArray = new int[stackSize];
		top = -1;
		this.stackSize = stackSize;
	}
	
	// 스택이 비어있는지 검사 
	public boolean isEmpty() {
		return (top == -1);
	}
	
	// 스택이 꽉 차있는지 검사 
	public boolean isFull() {
		return (top == this.stackSize -1);
	}
	
	// 스택에 아이템 추가 
	public void push(int item) {
		if(isFull()) {
			System.out.println("Inserting fail! Array Stack is full!!");
		} else {
			itemArray[++top] = item;
			System.out.println("Inserted Item : " + item);
		}
	}
	
	// 스택의 top에 있는 아이템 반환 
	public int pop() {
		if(isEmpty()) {
			System.out.println("Deleting fail! Array Stack is empty!");
			return -1;
		} else {
			return itemArray[top--];
		}
	}
	
	public int peek() {
		if(isEmpty()) {
			System.out.println("Peeking fail! Array Stack is empty!");
			return -1;
		} else {
			return itemArray[top];
		}
	}
	
	
	
	
}
