package com.java.sumOfAllLevelsBT;

//Java implementation of the approach 
class Sol {

//A Binary Tree Node 
	static class Node {
		int data;
		Node left, right;
	};

//Utility function to create a new tree node 
	static Node newNode(int data) {
		Node temp = new Node();
		temp.data = data;
		temp.left = temp.right = null;
		return temp;
	}

//Utility function to print 
//the contenets of an array 
	static void printArr(int arr[], int n) {
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
	}

//Function to return the height 
//of the binary tree 
	static int getHeight(Node root) {
		if (root.left == null && root.right == null)
			return 0;

		int left = 0;
		if (root.left != null)
			left = getHeight(root.left);

		int right = 0;
		if (root.right != null)
			right = getHeight(root.right);
		// increment from 0 in steps of 1
		return (Math.max(left, right) + 1);
	}

//Recursive function to update sum[] array 
//such that sum[i] stores the sum 
//of all the elements at ith level 
	static void calculateLevelSum(Node node, int level, int sum[]) {
		if (node == null)
			return;

		// Add current node data to the sum
		// of the current node's level
		sum[level] += node.data;

		// Recursive call for left and right sub-tree
		calculateLevelSum(node.left, level + 1, sum);
		calculateLevelSum(node.right, level + 1, sum);
	}

//Driver code 
	public static void main(String args[]) {
		// Create the binary tree
		Node root = newNode(6);
		root.left = newNode(4);
		root.right = newNode(8);
		root.left.left = newNode(3);
		root.left.right = newNode(5);
		root.right.left = newNode(7);
		root.right.right = newNode(9);

		// Count of levels in the
		// given binary tree
		int levels = getHeight(root) + 1;

		// To store the sum at every level
		int sum[] = new int[levels];
		calculateLevelSum(root, 0, sum);

		// Print the required sums
		printArr(sum, levels);
	}
}

//This code is contributed by andrew1234 
