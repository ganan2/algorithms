package com.java.bstPreInPostOrders;

public class Solution {

	Node root;

	private static class Node {
		private Node left;
		private Node right;
		private int key;

		private Node(int key) {
			this.key = key;
			this.left = null;
			this.right = null;
		}
	}

	Solution() {
		this.root = null;
	}

	public void printPreOrder(Node node) {

		if (node == null) {
			return;
		}
		
		System.out.println(node.key + " ");

		printPreOrder(node.left);
		printPreOrder(node.right);

	}

	public void printInOrder(Node node) {

		if (node == null) {
			return;
		}
		
		printInOrder(node.left);
		
		System.out.println(node.key + " ");
		
		printInOrder(node.right);
	}

	public void printPostOrder(Node node) {

		if (node == null) {
			return;
		}
		
		printPostOrder(node.left);
		printPostOrder(node.right);
		
		System.out.println(node.key + " ");
	}
	
	public void printPreOrder() {
		printPreOrder(root);
	}
	
	public void printInOrder() {
		printPreOrder(root);
	}
	
	public void printPostOrder() {
		printPreOrder(root);
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		
		solution.root = new Node(1); 
		solution.root.left = new Node(2); 
		solution.root.right = new Node(3); 
		solution.root.left.left = new Node(4); 
		solution.root.left.right = new Node(5); 
  
        System.out.println("Preorder traversal of binary tree is "); 
        solution.printPreOrder(); 
  
        System.out.println("\nInorder traversal of binary tree is "); 
        solution.printInOrder(); 
  
        System.out.println("\nPostorder traversal of binary tree is "); 
        solution.printPostOrder(); 
	}

}
