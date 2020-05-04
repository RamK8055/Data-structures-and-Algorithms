package DataStructures;

/**
 * 
 * @author Ram Kumar
 *
 * Array : Similar of "Arrays" class in Java
 * 
 * size will auto increase. default size is 10
 * 1. add(element)
 * 2. set(index, element)
 * 3. get(index)
 * 4. indexOf(element)
 * 5. remove(index)
 * 6. removeElement(element)- delete
 * 7. isFull()
 * 8. Display()
 * 9. clearArray()
 * 10. Insert(index, element)
 * @param <T>
 */

public class Array<T> {

	//Implementing in Generic Methods
	private T[] array;
	private int size;
	private int index;
	
	public Array(){
		size = 10;
		index = -1;
		array = (T[]) new Object[size];
	}

	public void add(T element){
		if(isFull()){
			//create a new array
			size += (size/2);
			T[] newArray = (T[]) new Object[size];
			for(int i=0;i<=index;i++)
				newArray[i] = array[i];
		}
		index++;
		array[index] = element;
	}
	
	public void set(int indexx, T element){
		array[indexx] = element;
	}
	
	public T get(int indexx){
		return array[indexx];
	}
	
	public int indexOf(T element){
		for(int i = 0; i<= index; i++)
			if(array[i] == element)
				return i;
		return -1;
	}
	
	public void remove(int indexx){
		if(indexx <= index && indexx >= 0){
			for(int i = indexx; i < index; i++)
				array[i] = array[i+1];
			array[index]=null;
			index--;
		}
	}
	
	public void removeElement(T element){
		remove(indexOf(element));
	}
	
	
	private boolean isFull() {
		return index == size - 1;
	}
	
	public void display(){
		StringBuilder result = new StringBuilder();
		for(int i =0; i<=index; i++)
			result.append(array[i]+" ");
		System.out.println(result);
	}

	public void clear(){
		array = (T[]) new Object[10];
		index = -1;
	}
	
	public void insert(int indexx, T element){
		if(isFull()){
			//create a new array
			size += (size/2);
			T[] newArray = (T[]) new Object[size];
			for(int i=0;i<=index;i++)
				newArray[i] = array[i];
		}
		index++;
		for(int i = index; i>indexx ; i--)
			array[i] = array[i-1];
		array[indexx] = element;
	}
	
	/**		Main Method		**/
	public static void main(String[] args) {
		
		Array<Integer> a = new Array<>();
		a.display();
		
		a.add(1);
		a.display();
		
		a.add(2);
		a.display();

		a.add(3);
		a.add(4);
		a.add(5);
		a.add(6);
		a.display();
		
		a.set(5,60);
		a.display();
		
		System.out.println(a.get(5));	//60
		System.out.println(a.indexOf(60));	//5

		a.remove(10);
		a.removeElement(100);
		a.display();
		
		a.remove(0);
		a.display();
		a.removeElement(4);
		a.display();
		
		a.clear();
		a.add(10);
		a.insert(0, 5);
		a.display();
	}
	
}



/*
	OUTPUT:
	
	1 
	1 2 
	1 2 3 4 5 6 
	1 2 3 4 5 60 
	60
	5
	1 2 3 4 5 60 
	2 3 4 5 60 
	2 3 5 60 
	5 10 

*/