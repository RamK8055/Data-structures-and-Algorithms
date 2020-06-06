package DataStructures;

public class SimpleStackWithLinkedList {
	class Node{
		int data;
		Node prev;
	}
	
	//Initialize top (last element)
	Node top = null;
	
	//Inserting Simple Stack
	public void push(int data){
		Node temp = new Node();
		temp.data = data;
		temp.prev = top;	//old top
		
		top = temp;
	}
	
	//Deleting Simple Stack
	public void pop(){
		if(top!=null)
			top = top.prev;
	}
	
	//Peek Simple Stack
	public void peek(){
		if(top!=null)
			System.out.println(top.data);
	}
	
	//Display: (reverse order)
	public void display(){
		if(top!=null){
			Node temp = top; 
            while (temp != null) { 
                System.out.printf("%d->", temp.data); 
                temp = temp.prev; 
            } 
		}
			
	}
	
	
	public static void main(String[] args) {
		SimpleStackWithLinkedList stack = new SimpleStackWithLinkedList();
		stack.push(1);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.display();
		stack.pop();
		stack.peek();
		stack.pop();
		stack.pop();
		stack.display();
		stack.pop();
		stack.pop();
				
	}
}
