/**
 *	@author Kenny Hoang
 *	Class: CS3345 - Data Structures and Introduction to Algorithmic Analysis
 *	Section: 004
 *	Semester: Spring 2017
 *
 *	Assignment: Project 3
 **/
// Description: Project 3 is the implementation of binary search tree class with lazy deletion 
// 				that has TreeNode as nested class in Java.
// BinarySearchTree.java implements the binary search tree class with lazy deletion

public class BinarySearchTree {
	
	private TreeNode root;
	private int numNodes;
	private int numDeleted;
	
	public BinarySearchTree(){
		this.root = null;
	}
	
	public void insert(int num){
		TreeNode current = root;
		if(contains(num)){
			while(current != null){
				if(current.key == num){
					if(current.deleted){
						current.deleted = false;
					}
					else{
						return;
					}
				}
				else if(current.key > num){
					current = current.leftChild;
				}
				else{
					current = current.rightChild;
				}
			}
		}
		TreeNode newNode = new TreeNode(num);
		if(root == null){
			this.root = newNode;
			return;
		}
		TreeNode parent = null;
		do
		{
			parent = current;
			if(num < current.key){
				current = current.leftChild; // set current to left child since the search key is smaller than the current key
				if(current== null){
					parent.leftChild = newNode; 
					return;
				}
			}
			else{
				current = current.rightChild; // set current to right child since the search key is larger than the current key
				if(current == null){
					parent.rightChild = newNode;
					return;
				}
			}
		}while(true);
	}
	
	public void delete(int num){
		TreeNode current = root;
		while(current != null){
			if(current.key == num){
				current.deleted = true;
				return;
			}
			else if(current.key > num){
				current = current.leftChild;
			}
			else{
				current = current.rightChild;
			}
		}
	}
	
	public int findMin(int num){
		return findMin(root);
	}
	
	private int findMin(TreeNode node){
		if(node.leftChild == null)
			return node.key;
		return findMin(node.leftChild);
	}
	
	public int findMax(int num){
		return findMax(root);
	}
	
	private int findMax(TreeNode node){
		if(node.rightChild == null)
			return node.key;
		return findMax(node.rightChild);
	}
	
	public boolean contains(int num){
		TreeNode current = root;
		while(current != null){
			if(current.key == num && !current.deleted){
				return true;
			}
			else if(current.key > num){
				current = current.leftChild; // set current to left child since the search key is smaller than the current key
			}
			else{
				current = current.rightChild; // set current to right child since the search key is larger than the current key
			}
		}
		return false;
	}
	
	public void inOrderTraversal(){
		inOrderTraversal(root);
		System.out.println();
	}
	
	private void inOrderTraversal(TreeNode node){
		if(node != null){
			inOrderTraversal(node.leftChild);
			if(node.deleted){
				System.out.print("*" + node.key + " ");
			}
			else{	
				System.out.print(node.key + " ");
			}
			inOrderTraversal(node.rightChild);
		}
	}
	
	public int height(){
		return height(root);
	}
	
	private int height(TreeNode node){
		if(node == null){
			return -1;
		}
		return 1 + Math.max(height(node.leftChild), height(node.rightChild));
	}
	
	public void numNodes(){
		numNodes(root);
		System.out.printf("Number of Nodes = %d\n", this.numNodes);
		System.out.printf("Number of Deleted Nodes = %d\n", this.numDeleted);
	}
	
	private void numNodes(TreeNode node){
		if(node != null){
			this.numNodes++;
			numNodes(node.leftChild);
			if(node.deleted)
				this.numDeleted++;
			numNodes(node.rightChild);
		}
	}
	
	
	
	private class TreeNode{
		private int key; // All keys are in the range of 1 to 99
		private TreeNode leftChild;
		private TreeNode rightChild;
		private boolean deleted;
		
		public TreeNode(int key){
			this.key = key;
			this.leftChild = null;
			this.rightChild = null;
			this.deleted = false;			
		}
	}
}
