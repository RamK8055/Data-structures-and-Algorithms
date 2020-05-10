package DataStructures;

/*
	Extends the class to LinkedList
	Except bleow function everything coming from LinkedList
	1.	Add(index, element) --insert
	2.	addLast(element) --append
	3.	addFirst(element) –head
	4.	set(index, element)
*/
public class SetWithLinkedList extends LinkedList{
	
	//Using private this class is only using inside other pubilc methods
	private boolean contains(String data){
		Node node = head;
		while(head!=null){
			if(head.data.contains(data))
				return true;
			head = head.next;
		}
		return false;
	}

	@Override
	public void add(int index, String data){
		if(contains(data));
		else
			super.add(index,data);
			
	}
	
	@Override
	public void addLast(String data){
		if(!contains(data));
			super.addLast(data);
			
	}
	
	@Override
	public void addFirst(String data){
		if(contains(data))
			super.addFirst(data);
			
	}
}
