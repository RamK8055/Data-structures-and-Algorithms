package DataStructures;

public class SimpleLinkedListWithStack {
	class Node{
		int data;
		Node next;
		Node(int data){
			this.data = data;
			this.next = null;
		}
	}
	
	//Head implementations
	Node head = null;
	
	//Inserting Simple Linked List
	public void push(int data){
		Node node = new Node(data);
		if(head==null)
			head = node;
		else{
			Node start = head;
			while(start.next!=null)
				start = start.next;
			start.next = node;
		}
	}
	
	//Deleting Simple Linked List
	public void pop(){
		if(head==null);
		else if (head.next==null)
			head = null;
		else{
			Node start = head;
			while(start.next.next!=null){
				start = start.next;
			}
			start.next = null;
		}
	}
	
	//Display:
	public void display(){
		if(head!=null){
			Node start = head;
			while(start!=null){
				System.out.println(start.data);
				start = start.next;
			}
		}
	}

	
	
	public static void main(String[] args) {
		SimpleLinkedListWithStack sll = new SimpleLinkedListWithStack();
		sll.push(1);
		sll.push(1);
		sll.push(2);
		sll.push(3);
		sll.push(4);
		sll.display();
		sll.pop();
		sll.display();
		sll.pop();
		sll.pop();
		sll.display();
		sll.pop();
		sll.pop();
				
	}
}
