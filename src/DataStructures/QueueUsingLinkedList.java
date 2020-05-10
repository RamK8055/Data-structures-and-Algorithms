package DataStructures;

public class QueueUsingLinkedList {
	//Using already implemented LinekedList class
		LinkedList list = new LinkedList();	//String
		
		public void enqueue(String data){
			list.addLast(data);
		}
		public int dequeue(){
			//different from stack
			return list.deleteAt(0);
		}
		public String peek(){
			//different from stack
			return list.get(0);
		}
		public void display(){
			list.display();
		}
		
		
		
		public static void main(String[] args){
			QueueUsingLinkedList queue = new QueueUsingLinkedList();
			queue.dequeue();	//-1
			System.out.println(queue.peek());	//null
			queue.enqueue("a");
			queue.enqueue("e");
			System.out.println(queue.peek());	//a
			queue.enqueue("i");
			queue.enqueue("o");
			queue.enqueue("u");
			queue.display();	//List: a e i o u 
			System.out.println(queue.peek());	//a
			queue.dequeue();
			queue.dequeue();
			queue.dequeue();
			queue.display();	//List: o u
			System.out.println(queue.peek());	//o
			queue.dequeue();
			queue.dequeue();
			queue.dequeue();
			queue.display();	//List: 
		}
}
