package DataStructures;


// Using Integer BST for easy understanding
public class BinarySearchTree {

	class Node{
		int key;
		Node left;
		Node right;
	}
	
	//Root of BST
	Node root;
	
	public BinarySearchTree() {
		root = null;
	}
	
	
	
	// Inserting a value
	public void insert(int key){
		root = insertNode(root, key);
	}
	private  Node insertNode(Node root, int key){
		
		// Creating a first node
		if(root == null){
			root = new Node();
			root.key = key;
			//By default left and right are null
		}
		
		// Inserting in left
		else if(key < root.key)
			root.left = insertNode(root.left, key);
		
		// Inserting in right
		else if(key > root.key)
			root.right = insertNode(root.right, key);
		
		return root;
	}
	
	//Delete a value
	public void delete(int key){
		root = deleteNode(root, key);
		
	}
	private  Node deleteNode(Node root, int key){
		if(root == null)
			return root;
		else if( key < root.key )
			root.left = deleteNode(root.left, key);
		else if ( key > root.key )
			root.right = deleteNode(root.right, key);
		else{
			
			//Node with 0 child
			if(root.left == null && root.right == null)
				return null;
			//Node with 1 child (Right child)
			else if (root.left == null )
				return root.right;
			//Node with 1 child (Left child)
			else if (root.right == null )
				return root.left;
			//Node with 2 children
			else{
				//search minimum value of right tree
				root.key = findMin(root.right);
				root.right = deleteNode(root.right, root.key);
			}
		}
		return root;
	}
		
	// Find node
	public boolean find(int key){
		Node node = find(root, key);
		return (node!=null);
	}
	public Node find(Node root, int key){
		if(root == null)
			return null;
		if(key < root.key)
			return find(root.left, key);
		if(key > root.key)
			return find(root.right, key);
		// if(key == root.key)
		return root;	
	}
	
	// Find minimum
	public int findMin(){
		return findMin(root);
	}
	public int findMin(Node root){
		if(root==null)
			return -1;
		while(root.left!=null)
			root = root.left;
		return root.key;
		
	}
	
	// Find maximum
	public int findMax(){
		return findMax(root);
	}
	public int findMax(Node root){
		if(root==null)
			return -1;
		while(root.right!=null)
			root = root.right;
		return root.key;
		
	}
	
	// Tree height
	public int getHeight(){
		return getHeight(root);
	}
	public int getHeight(Node node){
		if(node == null)
			return 0;
		else
			return 1 + Math.max(getHeight(node.left), getHeight(node.right));
	}
	
	// Tree traversal

	// Breath first search
	public void breathFirstSearch(){
		int height = getHeight();
		for(int i =0; i< height; i++)
			printLevelElement(root,i);
	}
	public void printLevelElement(Node root, int level){
		if (root == null)
			return;
		if (level == 0)
			System.out.print(root.key+ " ");
		else if ( level > 0 ){
			printLevelElement(root.left, level - 1);
			printLevelElement(root.right, level - 1);
		}
	}
	
	// Depth first search
	public void inOrder(){ inOrder(root); }
	public void preOrder(){ preOrder(root); }
	public void postOrder(){ postOrder(root); }
	
	void preOrder(Node root){
		if (root != null){
			System.out.print(root.key + " ");
			preOrder(root.left);
			preOrder(root.right);
		}
	}
	
    void inOrder(Node root) { 
        if (root != null){ 
            inOrder(root.left); 
            System.out.print(root.key + " "); 
            inOrder(root.right); 
        } 
    } 
    
    void postOrder(Node root){
    	if (root != null){
    		postOrder(root.left);
    		postOrder(root.right);
    		System.out.print(root.key + " ");
    	}
    }
  
    
    
    
    
    /* --     Main Method     -- */ 
	public static void main(String[] args) {
		
		BinarySearchTree bst = new BinarySearchTree();
		/* 
             5
            / \
            2  7
            \   /\ 
             3 6  8
		*/

		//Search
		System.out.println(bst.find(10));
		
		//Insert
		System.out.println(bst);
		bst.insert(5);
		System.out.println(bst);
		bst.insert(2);
		System.out.println(bst);
		bst.insert(7);
		System.out.println(bst);
		bst.insert(6);
		System.out.println(bst);
		bst.insert(8);
		System.out.println(bst);
		bst.insert(3);
		System.out.println(bst);
		
		System.out.println(bst.find(5));
		
		//Traversal
		System.out.println("\nBreath First Search:");
		bst.breathFirstSearch();
		System.out.println("\nDepth First Search (Pre):");
		bst.preOrder();
		System.out.println("\nDepth First Search (In):");
		bst.inOrder();
		System.out.println("\nDepth First Search (Post):");
		bst.postOrder();
		
		//Delete
		bst.insert(1);
		bst.breathFirstSearch();
		bst.delete(1);	// has 0 child
		bst.breathFirstSearch();
		bst.delete(2);	// has 1 child
		bst.breathFirstSearch();
		bst.insert(1);
		bst.delete(5);	// has 2 child
		bst.breathFirstSearch();
		bst.delete(7);
		bst.breathFirstSearch();
		
		
	}
	
	@Override
	public String toString(){
		return "Min="+findMin()+", Max="+findMax()+", height="+getHeight()+".";
	}
}

/*
	OUTPUT:
		false
		Min=-1, Max=-1, height=0.
		Min=5, Max=5, height=1.
		Min=2, Max=5, height=2.
		Min=2, Max=7, height=2.
		Min=2, Max=7, height=3.
		Min=2, Max=8, height=3.
		Min=2, Max=8, height=3.
		true
		
		Breath First Search:
		5 2 7 3 6 8 
		Depth First Search (Pre):
		5 2 3 7 6 8 
		Depth First Search (In):
		2 3 5 6 7 8 
		Depth First Search (Post):
		3 2 6 8 7 5 
		
		5 2 7 1 3 6 8 
		5 2 7 3 6 8 
		5 3 7 6 8 
		6 3 7 1 8 
		6 3 8 1 
*/
