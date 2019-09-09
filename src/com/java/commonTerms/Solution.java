package com.java.commonTerms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		Integer[] array = { 2, 3, 5, 67, 876, 4, 3, 3 };
		List<Integer> list = new ArrayList<Integer>(Arrays.asList(array));
		List<Integer> uniques = new ArrayList<Integer>();
		List<Integer> commons = new ArrayList<Integer>();

		for (Integer i : list) {
			if (!uniques.contains(i)) {
				uniques.add(i);
			} else {
				commons.add(i);
			}
		}

		System.out.println("Given: " + list);
		System.out.println("Uniques: " + uniques);
		System.out.println("Commons: " + commons);
		System.out.println("No. of given elements: " + list.size());
		System.out.println("No. of common elements: " + commons.size());
		System.out.println("No. of unique elements: " + uniques.size());

		// Find elements between first repeated element
		List<Integer> subset = new ArrayList<Integer>();
		boolean flag = false;
		for (Integer i : list) {
			if (commons.contains(i)) {
				if (!flag) {
					flag = true;
					continue;
				} else {
					flag = false;
				}
			} 
			
			if (flag) {
				subset.add(i);
			}

		}

		System.out.println("Subset: " + subset);
	}
}
