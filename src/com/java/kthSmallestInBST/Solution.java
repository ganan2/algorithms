package com.java.kthSmallestInBST;

public class Solution {
	
	private Node root;
	private static int counter;

	private class Node {

		private Node left;
		private Node right;
		private int data;

		public Node(int data) {
			this.data = data;
		}
	}
	
	public Solution() {
		addNode(root, 40);
		addNode(root, 20);
		addNode(root, 60);
		addNode(root, 10);
		addNode(root, 30);
		addNode(root, 50);
		addNode(root, 70);

		printTreeInOrder(root);

		Node kthSmallestNode = findKthSmallestItem(root, 4);

		if (kthSmallestNode != null) {
			System.out.println("\nElement is :" + kthSmallestNode.data);
		} else {
			System.out.println("\nElement not found");
		}
	}

	private Node findKthSmallestItem(Node root, int k) {
		if (root == null) {
			return null;
		}

		Node node = findKthSmallestItem(root.left, k);

		// If counter is not equal to K, then only increment the counter.
		// Once counter is equal to K, it means we have found the desired smallest
		// element and no need to increment further,
		// Take the back up of the current node as it might be the Kth smallest element
		// we are looking for.
		if (counter != k) {
			counter++;
			node = root;
		}

		// This is the place where actual check is going to happen between counter and
		// K,
		// If counter matched K, it means we found the node and no need to find further
		// so simply return the found node.
		if (counter == k) {
			return node;
		} else {
			return findKthSmallestItem(root.right, k);
		}
	}

	private void printTreeInOrder(Node root) {
		if (root == null)
			return;
		printTreeInOrder(root.left);
		System.out.print(root.data + " ");
		printTreeInOrder(root.right);
	}

	private void addNode(Node root, int data) {
		if (root == null) {
			Node temp1 = new Node(data);
			this.root = temp1;
		} else {
			addNodeInProperPlace(root, data);
		}
	}

	private void addNodeInProperPlace(Node root, int data) {
		if (data > root.data) {
			if (root.right != null) {
				addNode(root.right, data);
			} else {
				Node temp1 = new Node(data);
				root.right = temp1;
			}
		} else if (data < root.data) {
			if (root.left != null) {
				addNode(root.left, data);
			} else {
				Node temp1 = new Node(data);
				root.left = temp1;
			}
		}
	}
	
	public static void main(String[] args) {
		new Solution();
	}
}