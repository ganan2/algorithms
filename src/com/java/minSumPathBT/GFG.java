package com.java.minSumPathBT;

//Java program to find minimum path sum 
//between two leaves of a binary tree 
class GFG {

//A binary tree node 
	static class Node {
		int data;
		Node left;
		Node right;
	};

//Utility function to allocate memory 
//for a new node 
	static Node newNode(int data) {
		Node node = new Node();
		node.data = data;
		node.left = node.right = null;

		return (node);
	}

	static int result;

//A utility function to find the minimum sum between 
//any two leaves. This function calculates two values: 
//1. Minimum path sum between two leaves which is stored 
//in result and, 
//2. The minimum root to leaf path sum which is returned. 
//If one side of root is empty, then it returns INT_MIN 
	static int minPathSumUtil(Node root) {
		// Base cases
		if (root == null)
			return 0;

		if (root.left == null && root.right == null)
			return root.data;

		// Find minimum sum in left and right sub tree. Also
		// find minimum root to leaf sums in left and right
		// sub trees and store them in ls and rs
		int ls = minPathSumUtil(root.left);
		int rs = minPathSumUtil(root.right);

		// If both left and right children exist
		if (root.left != null && root.right != null) {
			// Update result if needed
			result = Math.min(result, ls + rs + root.data);

			// Return minimum possible value for root being
			// on one side
			return Math.min(ls + root.data, rs + root.data);
		}

		// If any of the two children is empty, return
		// root sum for root being on one side
		if (root.left == null)
			return rs + root.data;
		else
			return ls + root.data;
	}

//Function to return the minimum 
//sum path between two leaves 
	static int minPathSum(Node root) {
		result = Integer.MAX_VALUE;
		minPathSumUtil(root);
		return result;
	}

//Driver code 
	public static void main(String args[]) {
		Node root = newNode(4);
		root.left = newNode(5);
		root.right = newNode(-6);
		root.left.left = newNode(2);
		root.left.right = newNode(-3);
		root.right.left = newNode(1);
		root.right.right = newNode(8);

		System.out.print(minPathSum(root));
	}
}

//This code is contributed by Arnab Kundu 
