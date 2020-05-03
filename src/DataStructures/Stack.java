package DataStructures;

/**
 * 
 * @author Ram Kumar
 *
 * @Description
 *	Stack is base on LIFO
 *	
 *	1. void push()
 *	2. int pop()
 *	3. int peek() -- only show the last element (not delete)
 *	4. void display()	-- list all elements in stack
 *	5. int search()
 *	6. boolean isEmpty()
 *	7. boolean isFull()
 */

public class Stack {

	private int[] stackArray;
	private int size;
	private int top;
	
	public Stack(int size){
		this.stackArray = new int[size];
		this.size = size;
		this.top = -1;
	}
	
	public void push(int element){
		if(isFull()){
			System.out.println("Stack is FULL");
		} else {
			top++;
			stackArray[top] = element;
		}
	}
	
	public int pop(){
		if(isEmpty()){
			System.out.println("Stack is EMPTY");
		} else {
			int element = stackArray[top];
			top--;
			return element;
		}
		return -1;
	}
	
	public int peek(){
		if(isEmpty())
			System.out.println("Stack is EMPTY");
		else 
			return stackArray[top];
		return -1;
	}
	
	public void display(){
		StringBuilder result = new StringBuilder();
		for(int i =0; i<= top; i++)
			result.append(stackArray[i]+" ");
		System.out.println(result);
	}
	
	public int search(int element){
		for(int i=0; i<top; i++)
			if(stackArray[i]==element)
				return i;
		return -1;
	}
	
	public boolean isEmpty(){
		return (top == -1);
	}
	
	public boolean isFull(){
		return (top == size -1);
	}

	/** Main Class **/
	public static void main(String args[]){
		
		Stack stack = new Stack(5);
		
		stack.pop();
		
		System.out.println("isEmpty "+ stack.isEmpty());
		System.out.println("isFull "+ stack.isFull());
		
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.push(6);
		
		stack.display();
		 
		System.out.println("Position of 4 is "+ stack.search(4));
		
		System.out.println("Top most element "+ stack.peek());

		System.out.println("popping all element");
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		
		
	}

}


/*
	OUTPUT:
	
	Stack is EMPTY
	isEmpty true
	isFull false
	Stack is FULL
	1 2 3 4 5 
	Position of 4 is 3
	Top most element 5
	popping all element
	5
	4
	3
	2
	1
	Stack is EMPTY
	-1

*/