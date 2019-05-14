/**
 *	@author Kenny Hoang
 *	Class: CS3345 - Data Structures and Introduction to Algorithmic Analysis
 *	Section: 004
 *	Semester: Spring 2017
 *
 *	Assignment: Project 4
 **/
// Description: Project 4 is the implementation of a red-black tree with no deletion and appropriate rotation
// 				that has RBTreeNode as nested class in Java.
// RBTree.java implements the red-black tree with no deletion
public class RBTree {
	private RBTreeNode root;
	
	public RBTree(){
		this.root = null;
	}
	
	private boolean isEmpty(){
		return root == null;
	}
	
	public void insert(int num){
		if(contains(num)){ // if number is duplicate exclude number, and do not insert
			System.out.printf("The red-black tree already contains the element number %d. The element %d will not be added.\n", num, num);
			return;
		}
		RBTreeNode current = root;
		RBTreeNode newNode = new RBTreeNode(num);
		if(isEmpty()){ // If tree is empty, set root to new node
			this.root = newNode;
			return;
		}
		RBTreeNode parent = null;
		newNode.isRed = true; // THIS CAUSES NULL POINTER EXCEPTION
		do // Tree is not empty, find where to insert
		{
			parent = current;
			if(num < current.element){
				current = parent.left; // set current to left child since the search key is smaller than the current key
				if(current == null){ // if left child is null, then insert new element as left child
					parent.left = newNode; // insert new element as left child
					newNode.parent = parent;
					doubleRed(newNode);
					break;
				}
			}
			else{
				current = parent.right; // set current to right child since the search key is larger than the current key
				if(current == null){ // if right child is null, then insert new element as right child
					parent.right = newNode; // insert new element as right child
					newNode.parent = parent;
					doubleRed(newNode);
					break;
				}
			}
		}while(true);
		System.out.println("Element inserted.");
	}
	
	private void doubleRed(RBTreeNode node){
		while (node.parent.isRed) {
            RBTreeNode uncle = null;
            if (node.parent == node.parent.parent.left) {
                uncle = node.parent.parent.right;

                if (uncle != null && uncle.isRed) {
                    node.parent.isRed = false;
                    uncle.isRed = false;
                    node.parent.parent.isRed = true;
                    node = node.parent.parent;
                    if(node.parent != null && node.parent.parent != null && (node.parent.isRed && node.isRed)){
                    	node.parent.parent.isRed = true;
                    	rotateRight(node.parent.parent);
                    }
                    break;
                } 
                if (node == node.parent.right) {
                    //Double rotation
                    node = node.parent;
                    rotateLeft(node);
                } 	 
                node.parent.isRed = false;
                node.parent.parent.isRed = true;
                //if the "else if" code hasn't executed, this
                //is a case where we only need a single rotation 
                rotateRight(node.parent.parent);
            } else {
                uncle = node.parent.parent.left;
                 if (uncle != null && uncle.isRed) {
                    node.parent.isRed = false;
                    uncle.isRed = false;
                    node.parent.parent.isRed = true;
                    node = node.parent.parent;
                    if(node.parent != null && node.parent.parent != null && (node.parent.isRed && node.isRed)){
                    	node.parent.parent.isRed = true;
                    	rotateLeft(node.parent.parent);
                    }
                    break;
                }
                if (node == node.parent.left) {
                    //Double rotation needed
                    node = node.parent;
                    rotateRight(node);
                }
                node.parent.isRed = false;
                node.parent.parent.isRed = true;
                //if the "else if" code hasn't executed, this
                //is a case where we only need a single rotation
                rotateLeft(node.parent.parent);
            }
        }
        root.isRed = false;
	}
	
	private void rotateLeft(RBTreeNode node){
		if (node.parent != null) {
            if (node == node.parent.left) {
                node.parent.left = node.right;
            } else {
                node.parent.right = node.right;
            }
            node.right.parent = node.parent;
            node.parent = node.right;
            if (node.right.left != null) {
                node.right.left.parent = node;
            }
            node.right = node.right.left;
            node.parent.left = node;
        } else {//Need to rotate root
            RBTreeNode right = root.right;
            if(root.right.left != null)
            	root.right = root.right.left;
            else
            	root.right = null;
            root.right = null;
            root.parent = right;
            right.left = root;
            right.parent = null;
            root = right;
        }
	}
	
	private void rotateRight(RBTreeNode node){
		if (node.parent != null) {
            if (node == node.parent.left) {
                node.parent.left = node.left;
            } else {
                node.parent.right = node.left;
            }

            node.left.parent = node.parent;
            node.parent = node.left;
            if (node.left.right != null) {
                node.left.right.parent = node;
            }
            node.left = node.left.right;
            node.parent.right = node;
        } else {//Need to rotate root
            RBTreeNode left = root.left;
            if(root.left.right != null)
            	root.left = root.left.right;
            else
            	root.left = null;
            root.parent = left;
            left.right = root;
            left.parent = null;
            root = left;
        }
	}
	
	public boolean contains(int num){
		RBTreeNode current = root;
		while(current != null){
			if(current.element == num){
				return true;
			}
			else if(current.element > num){
				current = current.left; // set current to left child since the search key is smaller than the current key
			}
			else{
				current = current.right; // set current to right child since the search key is larger than the current key
			}
		}
		return false;
	}
	
	public void printTree(){
		System.out.print("RB Tree: ");
		printTree(root);
		System.out.println("\n");
	}
	
	private void printTree(RBTreeNode node){
		if(node != null){
			printTree(node.left);
			if(node.isRed){
				System.out.print("*" + node.element + " ");
			}
			else{	
				System.out.print(node.element + " ");
			}
			printTree(node.right);
		}
	}
	
	private static class RBTreeNode{
		int element;
		RBTreeNode left;
		RBTreeNode right;
		RBTreeNode parent;
		boolean isRed;
		
		public RBTreeNode(int num){
			this.element = num;
			this.left = null;
			this.right = null;
			this.parent = null;
			this.isRed = false;
		}
	}
}
