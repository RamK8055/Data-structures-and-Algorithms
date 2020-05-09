package DataStructures;

import java.util.Scanner;

/*
	1.	Add(index, element) --insert
	2.	addLast(element) --append
	3.	addFirst(element) –head
	4.	set(index, element)
	5.	get(index)
	6.	indexOf(element)
	7.	getNode(index)
	8.	getFirstNode()
	9.	getLastNode()
	10.	removeAt(index)
	11.	remove(element) – remove multiple element if exist
	12.	size()
	13.	isEmpty()
	14.	display() –traverse all nodes
	15. displayReverse() - reverse Traversal
	15.	clear() 
*/



//not using getters and setter for understanding purpose




//Implementation class
public class DoubleLinkedList<T>{	

	private class Node<T>{
		T data;
		Node<T> next;
		Node<T> prev;
	}
	private int size;
	private Node<T> head;
	private Node<T> tail;
	public DoubleLinkedList(){
		this.size = 0;
		this.head = null;
		this.tail = null;
	}

	//Creating first node
	//need separate function because of using head and tail (as null)
	private void firstNode(T data){
		Node<T> node = new Node<T>();
		node.data = data;
		node.next = node.prev = null;
		head = tail = node;
		size ++;
	}
	//Inserting Data in Head
	public void addFirst(T data){
		if(head==null && tail==null)//or if(size == 0)
			firstNode(data);
		else{
			Node<T> node = new Node<T>();
			node.data = data;
			node.next = head;
			node.prev = head.prev;
			head.prev = node;
			head = node;
			size++;
		}
	}
	
	//Inserting or Appending data in Last
	public void addLast(T data){
		if(head==null && tail==null)
			firstNode(data);
		else{
			Node<T> node = new Node<T>();
			node.data = data;
			node.prev = tail;
			node.next = tail.next;
			tail.next = node;
			tail = node;
			size++;
		}
	}
	
	//Inserting with index pointing
	public void add(int index, T data){
		if(index==0)
			addFirst(data);
		else if (index == size)
			addLast(data);
		else if (index >= size)
			System.out.println("cannot add element out of list bound");
		else{
			//using prvious node
			Node<T> preNode = getNode(index-1);
			Node<T> node = new Node<T>();
			node.data = data;
			node.next = preNode.next;
			node.next.prev = node;
			node.prev = preNode;
			node.prev.next = node;
			size++;
			
			//using current node
		/*	Node<T> currentNode = getNode(index);
			Node<T> n = new Node<T>();
			n.data = data;
			n.next = currentNode;
			n.prev = currentNode.prev;
			currentNode.prev = node;
			n.prev.next = node;
			size++;
		*/
			}
	}
	
	//Change value of node
	public void set(int index, T data){
		if(index<size && index>0){
			getNode(index).data = data;
		}
		else{
			System.out.println("Given index in out of list bound");
		}
	}
	
	//Get value of node
	public T get(int i){
		if(i<size && i>=0)
			return getNode(i).data;
		return null;
	}
	
	//Traverse all Node
	public void display(){
		Node<T> travelNode = head;
		StringBuffer result = new StringBuffer();
		result.append("List -> : ");
		while(travelNode != null){
			result.append(travelNode.data+" ");
			travelNode = travelNode.next;
		}
		System.out.println(result);
	}
	
	//Traverse all Node in Reverse direction
	public void displayReverse(){
		Node<T> travelNode = tail;
		StringBuffer result = new StringBuffer();
		result.append("List <- : ");
		while(travelNode != null){
			result.append(travelNode.data+" ");
			travelNode = travelNode.prev;
		}
		System.out.println(result);
	}
	
	//Getting Node positions:
	public Node<T> getFirstNode(){
		return head;
	}
	public Node<T> getLastNode(){
		return tail;
	}
	public Node<T> getNode(int index){
		if(index<size){
			Node<T> requiredNode = head;
			int i = 0;
			while(i<size){
				if(i==index)
					return requiredNode;
				requiredNode = requiredNode.next;
				i++;
			}
		}
		return null;
	}
	
	//Get index of the element
	public int indexOf(T data){
		Node<T> node = head;
		int index =0;
		while(index<size){
			if(node.data==data)	
				return index;
			index++;
			node = node.next;
		}
		return -1;
			
	}
	
	//Delete using index
	public int deleteAt(int index){
		if(index>=0 && index< size){
			Node<T> delNode;
			//Delete first Node
			if(size == 1){
				head = tail = null;
			}
			else if(index == 0){
				delNode = head;
				head = head.next;
				head.prev = null;
			}
			//Delete last Node
			else if(index==size-1){
				delNode = tail;
				tail = tail.prev;
				tail.next = null;
				
			}
			//Delete any Node
			else{
				delNode = getNode(index);
				delNode.prev.next = delNode.next;
				delNode.next.prev = delNode.prev;
			}
			delNode = null;
			size--;
			return 1;
		}
		return -1;
	}
	
	//Delete using data (can delete multiple elements also)
	public int delete(T data){
		Node<T> node = head;
		//set while loop to get multiple element(getNode)
		int index = 0;
		int count = 0;
		//		Node!=null && Node.next!=null  -->  size>0 && index<size
		while(index<size && size>0){
			if(node.data==data)
				count += deleteAt(index);
			else
				index++;
			node = node.next;
		}
		return count;
	}
	
	
	
	public int size(){
		return size;
	}
	public boolean isEmpty(){
		return size() == 0;
	}
	
	//Clean the list
	public void clear(){
		Node<T> travelNode = new Node();
		while(travelNode != null){
			Node<T> next = travelNode.next;
			travelNode = null;
			travelNode = next;
		}
		head = tail = travelNode = null;
		size = 0;
	}
	

	
	
	
	
	
	//	main method
	public static void main(String[] args) {
		DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
		
		list.addLast(2);
		list.addLast(2);
		
		System.out.println(""
				+ "1.Add(index, element) --insert\n"
				+ "2.addLast(element) --append\n"
				+ "3.addFirst(element) –head\n"
				+ "4.set(index, element)\n"
				+ "5.get(index)\n"
				+ "6.indexOf(element)\n"
				+ "7.~getNode(index)\n"
				+ "8.~getFirstNode()\n"
				+ "9.~getLastNode()\n"
				+ "10.removeAt(index)\n"
				+ "11.remove(element) – remove multiple element if exist\n"
				+ "12.~size()\n"
				+ "13.~isEmpty()\n"
				+ "14.~display() –traverse all nodes\n"
				+ "15.clear()\n"		);
		
		while(true){
			System.out.print("Enter the choice: ");
			Scanner scan = new Scanner(System.in);
			int i =scan.nextInt();
			int data;
			int index;

			switch(i){
			case 1:
				System.out.println("Enter Index and Data");
				index = scan.nextInt();
				data = scan.nextInt();
				list.add(index, data);
				break;
			case 2:
				System.out.println("Enter Data");
				data = scan.nextInt();
				list.addLast(data);
				break;
			case 3:
				System.out.println("Enter Data");
				data = scan.nextInt();
				list.addFirst(data);
				break;
			case 4:
				System.out.println("Enter Index and Data");
				index = scan.nextInt();
				data = scan.nextInt();
				list.set(index, data);
				break;
			case 5:
				System.out.println("Enter index");
				index = scan.nextInt();
				System.out.println(list.get(index));
				break;
			case 6:
				System.out.println("Enter Data");
				data = scan.nextInt();
				System.out.println(list.indexOf(data));
				break;
			case 10:
				System.out.println("Enter index");
				index = scan.nextInt();
				System.out.println(list.deleteAt(index));
				break;
			case 11:
				System.out.println("Enter data");
				data = scan.nextInt();
				System.out.println(list.delete(data));
				break;
			case 15:
				list.clear();
				break;
			default:
				System.exit(0);
				
			}
			list.display();
			list.displayReverse();
		}
			
	}
}


/*

	OUTPUT: (same user input used for SLL)
	
		1.Add(index, element) --insert
		2.addLast(element) --append
		3.addFirst(element) –head
		4.set(index, element)
		5.get(index)
		6.indexOf(element)
		7.~getNode(index)
		8.~getFirstNode()
		9.~getLastNode()
		10.removeAt(index)
		11.remove(element) – remove multiple element if exist
		12.~size()
		13.~isEmpty()
		14.~display() –traverse all nodes
		15.clear()
		
		Enter the choice: 1
		Enter Index and Data
		0 0
		List -> : 0 
		List <- : 0 
		Enter the choice: 1
		Enter Index and Data
		10 10
		cannot add element out of list bound
		List -> : 0 
		List <- : 0 
		Enter the choice: 1
		Enter Index and Data
		1 1
		List -> : 0 1 
		List <- : 1 0 
		Enter the choice: 1
		Enter Index and Data
		1 2
		List -> : 0 2 1 
		List <- : 1 2 0 
		Enter the choice: 1
		Enter Index and Data
		2 10
		List -> : 0 2 10 1 
		List <- : 1 10 2 0 
		Enter the choice: 1
		Enter Index and Data
		3 2
		List -> : 0 2 10 2 1 
		List <- : 1 2 10 2 0 
		Enter the choice: 1
		Enter Index and Data
		5 0
		List -> : 0 2 10 2 1 0 
		List <- : 0 1 2 10 2 0 
		Enter the choice: 1
		Enter Index and Data
		0 1
		List -> : 1 0 2 10 2 1 0 
		List <- : 0 1 2 10 2 0 1 
		Enter the choice: 2
		Enter Data
		10
		List -> : 1 0 2 10 2 1 0 10 
		List <- : 10 0 1 2 10 2 0 1 
		Enter the choice: 2
		Enter Data
		20
		List -> : 1 0 2 10 2 1 0 10 20 
		List <- : 20 10 0 1 2 10 2 0 1 
		Enter the choice: 2
		Enter Data
		30
		List -> : 1 0 2 10 2 1 0 10 20 30 
		List <- : 30 20 10 0 1 2 10 2 0 1 
		Enter the choice: 3
		Enter Data
		20
		List -> : 20 1 0 2 10 2 1 0 10 20 30 
		List <- : 30 20 10 0 1 2 10 2 0 1 20 
		Enter the choice: 3
		Enter Data
		30
		List -> : 30 20 1 0 2 10 2 1 0 10 20 30 
		List <- : 30 20 10 0 1 2 10 2 0 1 20 30 
		Enter the choice: 4
		Enter Index and Data
		3 3
		List -> : 30 20 1 3 2 10 2 1 0 10 20 30 
		List <- : 30 20 10 0 1 2 10 2 3 1 20 30 
		Enter the choice: 4
		Enter Index and Data
		0 40
		Given index in out of list bound
		List -> : 40 20 1 3 2 10 2 1 0 10 20 30 
		List <- : 30 20 10 0 1 2 10 2 3 1 20 40 
		Enter the choice: 5
		Enter index
		40
		null
		List -> : 40 20 1 3 2 10 2 1 0 10 20 30 
		List <- : 30 20 10 0 1 2 10 2 3 1 20 40 
		Enter the choice: 5
		Enter index
		-40
		null
		List -> : 40 20 1 3 2 10 2 1 0 10 20 30 
		List <- : 30 20 10 0 1 2 10 2 3 1 20 40 
		Enter the choice: 5
		Enter index
		2
		1
		List -> : 40 20 1 3 2 10 2 1 0 10 20 30 
		List <- : 30 20 10 0 1 2 10 2 3 1 20 40 
		Enter the choice: 5
		Enter index
		0
		40
		List -> : 40 20 1 3 2 10 2 1 0 10 20 30 
		List <- : 30 20 10 0 1 2 10 2 3 1 20 40 
		Enter the choice: 6
		Enter Data
		40
		0
		List -> : 40 20 1 3 2 10 2 1 0 10 20 30 
		List <- : 30 20 10 0 1 2 10 2 3 1 20 40 
		Enter the choice: 6
		Enter Data
		10
		5
		List -> : 40 20 1 3 2 10 2 1 0 10 20 30 
		List <- : 30 20 10 0 1 2 10 2 3 1 20 40 
		Enter the choice: 6
		Enter Data
		30
		11
		List -> : 40 20 1 3 2 10 2 1 0 10 20 30 
		List <- : 30 20 10 0 1 2 10 2 3 1 20 40 
		Enter the choice: 6
		Enter Data
		111
		-1
		List -> : 40 20 1 3 2 10 2 1 0 10 20 30 
		List <- : 30 20 10 0 1 2 10 2 3 1 20 40 
		Enter the choice: 10
		Enter index
		100
		-1
		List -> : 40 20 1 3 2 10 2 1 0 10 20 30 
		List <- : 30 20 10 0 1 2 10 2 3 1 20 40 
		Enter the choice: 10
		Enter index
		-100
		-1
		List -> : 40 20 1 3 2 10 2 1 0 10 20 30 
		List <- : 30 20 10 0 1 2 10 2 3 1 20 40 
		Enter the choice: 10
		Enter index
		1
		1
		List -> : 40 1 3 2 10 2 1 0 10 20 30 
		List <- : 30 20 10 0 1 2 10 2 3 1 40 
		Enter the choice: 10
		Enter index
		0
		1
		List -> : 1 3 2 10 2 1 0 10 20 30 
		List <- : 30 20 10 0 1 2 10 2 3 1 
		Enter the choice: 10
		Enter index
		8
		1
		List -> : 1 3 2 10 2 1 0 10 30 
		List <- : 30 10 0 1 2 10 2 3 1 
		Enter the choice: 10
		Enter index
		8
		1
		List -> : 1 3 2 10 2 1 0 10 
		List <- : 10 0 1 2 10 2 3 1 
		Enter the choice: 10
		Enter index
		8
		-1
		List -> : 1 3 2 10 2 1 0 10 
		List <- : 10 0 1 2 10 2 3 1 
		Enter the choice: 11
		Enter data
		10
		2
		List -> : 1 3 2 2 1 0 
		List <- : 0 1 2 2 3 1 
		Enter the choice: 11
		Enter data
		1
		2
		List -> : 3 2 2 0 
		List <- : 0 2 2 3 
		Enter the choice: 11
		Enter data
		0
		1
		List -> : 3 2 2 
		List <- : 2 2 3 
		Enter the choice: 11
		Enter data
		3
		1
		List -> : 2 2 
		List <- : 2 2
		Enter the choice: 11
		Enter data
		2
		2
		List -> : 
		List <- : 
		Enter the choice: 2
		Enter Data
		2
		List -> : 2 
		List <- : 2 
		Enter the choice: 15
		List -> : 
		List <- : 
		Enter the choice: 

*/