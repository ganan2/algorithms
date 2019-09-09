package com.java.nthNodeLinkedList;

public class MergedKSortedLists {

	Node head;

	class Node {
		Node previous;
		Node next;
		int data;

		Node(int data) {
			this.data = data;
			next = null;
		}
	}

	public void push(int data) {
		Node newNode = new Node(data);

		newNode.next = head;
		newNode.previous = null;

		if (head != null)
			head.previous = newNode;

		head = newNode;
	}

	public int getNthNodeDataFromFirst(int index) {
		Node current = head;
		int count = 0;
		while (current != null) {
			if (index == count) {
				return current.data;
			}
			count++;
			current = current.next;
		}
		assert (false);
		return 0;
	}

	public int getNthNodeDataFromLast(int index) {
		Node current = head;
		int count = 0;
		while (current != null) {
			if (index == count) {
				return current.data;
			}
			count++;
			current = current.previous;
		}
		assert (false);
		return 0;
	}

	void printList(Node node) {
		Node last = null;
		System.out.println("Traversal in forward Direction:");
		while (node != null) {
			System.out.print(node.data + " ");
			last = node;
			node = node.next;
		}
		System.out.println();
		System.out.println("Traversal in reverse direction:");
		while (last != null) {
			System.out.print(last.data + " ");
			last = last.previous;
		}
		System.out.println();
	}

	// Add a node at the end of the list
	void append(int new_data) {
		Node new_node = new Node(new_data);
		Node last = head;
		new_node.next = null;

		if (head == null) {
			new_node.previous = null;
			head = new_node;
			return;
		}

		while (last.next != null) {
			last = last.next;
		}

		last.next = new_node;
		new_node.previous = last;
	}

	public void InsertAfter(Node prev_Node, int new_data) {

		if (prev_Node == null) {
			System.out.println("The given previous node cannot be NULL ");
			return;
		}

		Node new_node = new Node(new_data);
		new_node.next = prev_Node.next;
		prev_Node.next = new_node;
		new_node.previous = prev_Node;
		if (new_node.next != null) {
			new_node.next.previous = new_node;
		}
	}

	// Split a doubly linked list (DLL) into 2 DLLs of
	// half sizes
	Node split(Node head) {
		Node fast = head, slow = head;
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		Node temp = slow.next;
		slow.next = null;
		return temp;
	}

	public Node mergeSort(Node node) {
		if (node == null || node.next == null) {
			return node;
		}
		Node second = split(node);

		node = mergeSort(node);
		second = mergeSort(second);

		return merge(node, second);
	}

	// Function to merge two linked lists
	public Node merge(Node first, Node second) {
		if (first == null) {
			return second;
		}

		if (second == null) {
			return first;
		}

		if (first.data < second.data) {
			first.next = merge(first.next, second);
			first.next.previous = first;
			first.previous = null;
			return first;
		} else {
			second.next = merge(first, second.next);
			second.next.previous = second;
			second.previous = null;
			return second;
		}
	}

	public Node removeDuplicateNode(Node head) {
		// Node current will point to head
		Node current, index, temp;

		// Checks whether list is empty
		if (head == null) {
			return head;
		} else {
			// Initially, current will point to head node
			for (current = head; current != null; current = current.next) {
				// index will point to node next to current
				for (index = current.next; index != null; index = index.next) {
					if (current.data == index.data) {
						// Store the duplicate node in temp
						temp = index;
						// index's previous node will point to node next to index thus, removes the
						// duplicate node
						index.previous.next = index.next;
						if (index.next != null)
							index.next.previous = index.previous;
						// Delete duplicate node by making temp to null
						temp = null;
					}
				}
			}
		}
		
		return head;
	}

	public static void main(String[] args) {
		MergedKSortedLists list1 = new MergedKSortedLists();
		list1.push(0);
		list1.push(7);
		list1.push(9);
		list1.push(3);
		list1.push(1);
		list1.printList(list1.head);
		MergedKSortedLists list2 = new MergedKSortedLists();
		list2.push(0);
		list2.push(8);
		list2.push(9);
		list2.push(2);
		list2.push(1);
		list2.printList(list2.head);
//		list2.printList(list2.merge(list1.head, list2.head));
		
		
		list1.printList(list1.removeDuplicateNode(list2.merge(list1.head, list2.head)));
	}
}
