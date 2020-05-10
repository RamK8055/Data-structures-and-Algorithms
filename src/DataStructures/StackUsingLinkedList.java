package DataStructures;

public class StackUsingLinkedList {
	
	//Using already implemented LinekedList class
	LinkedList list = new LinkedList();	//String
	
	public void push(String data){
		list.addLast(data);
	}
	public int pop(){
		return list.deleteAt(list.size()-1);
	}
	public String peek(){
		return list.get(list.size()-1);
	}
	public void display(){
		list.display();
	}
	
	
	
	public static void main(String[] args){
		StackUsingLinkedList stack = new StackUsingLinkedList();
		stack.pop();	//-1
		System.out.println(stack.peek());	//null
		stack.push("a");
		stack.push("e");
		System.out.println(stack.peek());	//e
		stack.push("i");
		stack.push("o");
		stack.push("u");
		stack.display();	//List: a e i o u 
		System.out.println(stack.peek());	//u
		stack.pop();
		stack.pop();
		stack.pop();
		stack.display();	//List: a e
		stack.pop();
		stack.pop();
		stack.pop();
		stack.display();	//List: 
	}
}
