package com.java.arrayToListAndBack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Solution {

	public static void convertArrayToListAndBack() {
		String[] array = { "1", "2" };
		List<String> list = new ArrayList<String>(Arrays.asList(array));
		String[] arrayFromList = list.toArray(new String[list.size()]);
		System.out.println(Arrays.toString(arrayFromList));
	}

	// optimization
	public static void getResultsAfterMapped() {
		Integer[] intArrayA = { 1, 2, 3 };
		List<Integer> intListA = new ArrayList<Integer>(Arrays.asList(intArrayA));
		System.out.println("List A: " + intListA);
		Integer[] intArrayB = { 11, 2, 33 };
		List<Integer> intListB = new ArrayList<Integer>(Arrays.asList(intArrayB));
		System.out.println("List B: " + intListB);
		Map<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();
		// Using id as key in LinkedHashMap consisting of one list and as index of the
		// other list
		int id = 0;
		for (Integer i : intListA) {
			map.put(id, i);
			id++;
		}

		for (int i = 0; i < intListB.size(); i++) {
			int element = intListB.get(i);
			if (element == map.get(i)) {
				System.out.println("Common element: " + element);
				intListA.remove(new Integer(element)); // removing element by value and not by index
				intListB.remove(i); // removing element by index and not by value
				// When an element is removed from an array list,
				// the removed value will be replaced by the next element instead of null
				System.out.println("Common element removed from list A: " + intListA);
				System.out.println("Common element removed from list B: " + intListB);
			}
		}
	}

	public static void removeCommon() {
		// Convert array to list
		String[] a = { "1", "2", "3" };
		String[] b = { "1", "2", "4" };
		List<String> listA = new ArrayList<String>(Arrays.asList(a));
		List<String> listB = new ArrayList<String>(Arrays.asList(b));
		System.out.println("List A: " + listA);
		System.out.println("List B: " + listB);
		// Remove common elements
		List<String> tempListA = new ArrayList<String>(listA);
		listA.removeAll(listB);
		listB.removeAll(tempListA);
		// Convert list to array
		String[] a1 = new String[listA.size()];
		String[] b1 = new String[listB.size()];
		a1 = listA.toArray(a1);
		b1 = listB.toArray(b1);
		// Display both arrays
		System.out.println("A without B: " + Arrays.toString(a1));
		System.out.println("B without A: " + Arrays.toString(b1));
	}

	public static void mergeLists() {
		// Convert array to list
		String[] a = { "1", "2", "3" };
		String[] b = { "1", "2", "4" };
		List<String> listA = new ArrayList<String>(Arrays.asList(a));
		List<String> listB = new ArrayList<String>(Arrays.asList(b));
		System.out.println("List A: " + listA);
		System.out.println("List B: " + listB);
		// Merge both lists
		listA.addAll(listB);
		Collections.sort(listA);
		System.out.println("Merged and sorted list: " + listA);
		System.out.println("Merged and sorted without duplicates: " + new HashSet<String>(listA));
	}

	public static void main(String[] args) {
		// Remove commons
		Solution.removeCommon();
		// Remove merged
		Solution.mergeLists();
		// Array and list interconversion
		Solution.convertArrayToListAndBack();
		// O(N^2) to O(N)
		Solution.getResultsAfterMapped();
	}
}
