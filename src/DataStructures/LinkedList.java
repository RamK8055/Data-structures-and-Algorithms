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
	15.	clear() 
*/



//node for string
//not using getters and setter for understanding purpose
class Node{
	String data;
	Node next;
}



//Implementation class
public class LinkedList{	

	private int size;
	private Node head;
	public LinkedList(){
		this.size = 0;
		this.head = null;
	}
	
	//Inserting Data in Head
	public void addFirst(String data){
		Node node = new Node();
		node.data = data;
		node.next = head;
		head = node;
		size++;
	}
	
	//Inserting or Appending data in Last
	public void addLast(String data){
		if(head==null)
			addFirst(data);
		else{
			Node node = new Node();
			node.data = data;
			node.next = getLastNode().next;
			getLastNode().next = node;
			size++;
		}
	}
	
	//Inserting with index pointing
	public void add(int index, String data){
		if(index==0)
			addFirst(data);
		else if (index == size)
			addLast(data);
		else if (index >= size)
			System.out.println("cannot add element out of list bound");
		else{
			Node preNode = getNode(index-1);
			Node node = new Node();
			node.data = data;
			node.next = preNode.next;
			preNode.next = node;
			size++;
		}
	}
	
	//Change value of node
	public void set(int index, String data){
		if(index<size && index>0){
			getNode(index).data = data;
		}
		else{
			System.out.println("Given index in out of list bound");
		}
	}
	
	//Get value of node
	public String get(int i){
		if(i<size && i>0)
			return getNode(i).data;
		return null;
	}
	
	//Traverse all Node
	public void display(){
		Node travelNode = head;
		StringBuffer result = new StringBuffer();
		result.append("List: ");
		while(travelNode != null){
			result.append(travelNode.data+" ");
			travelNode = travelNode.next;
		}
		System.out.println(result);
	}
	
	//Getting Node positions:
	public Node getFirstNode(){
		return head;
	}
	public Node getLastNode(){
		Node lastNode = head;
		while(lastNode.next!=null)
			lastNode = lastNode.next;
		return lastNode;
	}
	public Node getNode(int index){
		if(index<size){
			Node requiredNode = head;
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
	public int indexOf(String data){
		Node node = head;
		int index =0;
		while(index<size){
			if(node.data.equals(data))	//used equals for string
				return index;
			index++;
			node = node.next;
		}
		return -1;
			
	}
	
	//Delete using index
	public int deleteAt(int index){
		if(index>=0 && index< size){
			//Delete first node
			if(index == 0){
				Node delNode = head;
				head = head.next;
				delNode = null;
			}
			//Delete any node
			else{
				Node preNode = getNode(index -1);
				Node delNode = preNode.next;
				preNode.next = delNode.next;
				delNode = null;
			}
			size--;
			return 1;
		}
		return -1;
	}
	
	//Delete using data (can delete multiple elements also)
	public int delete(String data){
		Node node = head;
		//set while loop to get multiple element(getNode)
		int index = 0;
		int count = 0;
		//		node!=null && node.next!=null  -->  size>0 && index<size
		while(index<size && size>0){
			if(node.data.equals(data))
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
		Node travelNode = new Node();
		while(travelNode != null){
			Node next = travelNode.next;
			travelNode = null;
			travelNode = next;
		}
		head = travelNode = null;
		size = 0;
	}
	

	
	
	
	
	
	//	main method
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		
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
			String data;
			int index;

			switch(i){
			case 1:
				System.out.println("Enter Index and Data");
				index = scan.nextInt();
				data = scan.next();
				list.add(index, data);
				break;
			case 2:
				System.out.println("Enter Data");
				data = scan.next();
				list.addLast(data);
				break;
			case 3:
				System.out.println("Enter Data");
				data = scan.next();
				list.addFirst(data);
				break;
			case 4:
				System.out.println("Enter Index and Data");
				index = scan.nextInt();
				data = scan.next();
				list.set(index, data);
				break;
			case 5:
				System.out.println("Enter index");
				index = scan.nextInt();
				System.out.println(list.get(index));
				break;
			case 6:
				System.out.println("Enter Data");
				data = scan.next();
				System.out.println(list.indexOf(data));
				break;
			case 10:
				System.out.println("Enter index");
				index = scan.nextInt();
				System.out.println(list.deleteAt(index));
				break;
			case 11:
				System.out.println("Enter data");
				data = scan.next();
				System.out.println(list.delete(data));
				break;
			case 15:
				list.clear();
				break;
			default:
				System.exit(0);
				
			}
			list.display();
		}
			
	}
}


/*

	OUTPUT:
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
		List: 0 
		Enter the choice: 1
		Enter Index and Data
		10 10
		cannot add element out of list bound
		List: 0 
		Enter the choice: 1
		Enter Index and Data
		1 1
		List: 0 1 
		Enter the choice: 1
		Enter Index and Data
		1 2
		List: 0 2 1 
		Enter the choice: 1
		Enter Index and Data
		2 10
		List: 0 2 10 1 
		Enter the choice: 1
		Enter Index and Data
		3 2
		List: 0 2 10 2 1 
		Enter the choice: 1
		Enter Index and Data
		5 0
		List: 0 2 10 2 1 0 
		Enter the choice: 1
		Enter Index and Data
		0 1
		List: 1 0 2 10 2 1 0 
		
		
		Enter the choice: 2
		Enter Data
		10
		List: 1 0 2 10 2 1 0 10 
		Enter the choice: 2
		Enter Data
		20
		List: 1 0 2 10 2 1 0 10 20 
		Enter the choice: 2
		Enter Data
		30
		List: 1 0 2 10 2 1 0 10 20 30 
		
		
		Enter the choice: 3
		Enter Data
		20
		List: 20 1 0 2 10 2 1 0 10 20 30 
		Enter the choice: 3
		Enter Data
		30
		List: 30 20 1 0 2 10 2 1 0 10 20 30 
		
		
		Enter the choice: 4
		Enter Index and Data
		3 3
		List: 30 20 1 3 2 10 2 1 0 10 20 30 
		Enter the choice: 4
		Enter Data
		0 40
		List: 40 20 1 3 2 10 2 1 0 10 20 30
		
		
		Enter the choice: 5
		Enter index
		40
		null
		List: 40 20 1 3 2 10 2 1 0 10 20 30 
		Enter the choice: 5
		Enter index
		-40
		null
		List: 40 20 1 3 2 10 2 1 0 10 20 30 
		 
		 
		Enter the choice: 6
		Enter Data
		40
		0
		List: 40 20 1 3 2 10 2 1 0 10 20 30 
		Enter the choice: 6
		Enter Data
		10
		5
		List: 40 20 1 3 2 10 2 1 0 10 20 30 
		Enter the choice: 6
		Enter Data
		30
		11
		List: 40 20 1 3 2 10 2 1 0 10 20 30 
		Enter the choice: 6
		Enter Data
		111
		-1
		List: 40 20 1 3 2 10 2 1 0 10 20 30 
		
		
		Enter the choice: 10
		Enter index
		100
		-1
		List: 40 20 1 3 2 10 2 1 0 10 20 30 
		Enter the choice: 10
		Enter index
		-100
		-1
		List: 40 20 1 3 2 10 2 1 0 10 20 30 
		Enter the choice: 10
		Enter index
		1
		1
		List: 40 1 3 2 10 2 1 0 10 20 30 
		Enter the choice: 10
		Enter index
		0
		1
		List: 1 3 2 10 2 1 0 10 20 30 
		Enter the choice: 10
		Enter index
		8
		1
		List: 1 3 2 10 2 1 0 10 30 
		Enter the choice: 10
		Enter index
		8
		1
		List: 1 3 2 10 2 1 0 10 
		
		
		Enter the choice: 11
		Enter data
		10
		2
		List: 1 3 2 2 1 0 
		Enter the choice: 11
		Enter data
		1
		2
		List: 3 2 2 0 
		Enter the choice: 11
		Enter data
		0
		1
		List: 3 2 2 
		Enter the choice: 11
		Enter data
		3
		1
		List: 2 2 
		Enter the choice: 11
		Enter data
		2
		2
		List: 
		Enter the choice: 11
		Enter data
		1
		0
		List: 
		 
		Enter the choice: 15
		List: 

*/