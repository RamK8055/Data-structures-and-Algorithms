package DataStructures;

/**
 * 
 * @author Ram Kumar
 *
 * @Description
 *	Queue is base on FIFO
 *	//front = always(-1) and its Head and enqueue() operation done here
 *	//rear = always(end) and its tail and dequeue() operation done here
 *	
 *	1. void enqueue(ele)
 *	2. int dequeue()
 *	3. int peek() -- only show the first (not delete)
 *	4. void display()	-- list all elements in queue
 *	5. int search()
 *	6. boolean isEmpty()
 *	7. boolean isFull()
 */

public class Queue {

	private int[] queueArray;
	private int size;
	private int front;
	private int rear;
	
	public Queue(int size){
		this.size = size;
		this.queueArray = new int[size];
		front = 0;
		rear = -1;
	}

	public void enqueue(int element){
		if(isFull())
			System.out.println("Queue is FULL");
		else{
			rear++;
			queueArray[rear] = element;
			//Only re-arrange happens when the list reach its maximum limit and its starting elements are removed by dequeue()
			if((rear == size -1) && (front!=0))
				rearrangeQueue();
		}
	}
	private void rearrangeQueue() {
		int newFront = 0;
		for(int i = front; i <= rear; i++)
			queueArray[newFront++] = queueArray[i];
		front = 0;
		rear = newFront - 1;
	}
	
	public int dequeue(){
		if(isEmpty()){
			System.out.println("Queue is EMPTY");
		} else {
			int element = queueArray[front];
			front++;
			return element;
		}
		return -1;
	}

	public int peek(){
		if(isEmpty())
			System.out.println("Queue is EMPTY");
		else 
			return queueArray[front];
		return -1;
	}
	
	public void display(){
		StringBuilder result = new StringBuilder();
		for(int i = front; i<= rear; i++)
			result.append(queueArray[i]+" ");
		System.out.println(result);
	}
	
	public int search(int element){
		int pos = 0;
		for(int i=front; i<rear; i++){
			if(queueArray[i]==element)
				return pos;
			pos++;
		}
		return -1;
	}
	
	
	
	public boolean isEmpty(){
		return (rear < front);	//rear + 1 == front
	}
	
	public boolean isFull(){
		return (rear == size -1);
	}

	//** Main Class **//*
	public static void main(String args[]){
		
		Queue queue = new Queue(5);
		
		queue.dequeue();
		
		System.out.println("isEmpty "+ queue.isEmpty());
		System.out.println("isFull "+ queue.isFull());

		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		queue.enqueue(10);
		
		queue.display();
		 
		System.out.println("Position of 4 is "+ queue.search(4));
		
		System.out.println("First element "+ queue.peek());

		System.out.println("dequeue all element");
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		
		queue.display();
		
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		
		
	}


}


/*
	OUTPUT:
	
	Queue is EMPTY
	isEmpty true
	isFull false
	Queue is FULL
	1 2 3 4 5 
	Position of 4 is 3
	First element 1
	dequeue all element
	1
	2
	3 4 5 
	3
	4
	5
	Queue is EMPTY
	-1


*/
