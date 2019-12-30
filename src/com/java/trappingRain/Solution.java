package com.java.trappingRain;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public static int trapQuantity(int[] height) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i : height) {
			list.add(i);
		}

		Integer count = 0;
		L1: for (int i = 0; i < list.size(); i++) {
			int startElement = list.get(i);
			List<Integer> sublist = list.subList(i + 1, list.size());
			L2: for (int j = 0; j < sublist.size(); j++) {
				int endElement = sublist.get(j);
				if (endElement < startElement) {
					count = count + startElement - endElement;
					break L2;
				}
			}

		}
		return count;
	}

	public static void main(String[] args) {
		int[] heights = new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		System.out.println("Heights: ");
		for (int i = 0; i < heights.length; i++) {
			System.out.print(heights[i]);
			if (i != heights.length - 1) {
				System.out.print(", ");
			}
		}
		System.out.println("\n");
		int quantity = trapQuantity(heights);
		System.out.println("Trapped quantity: " + quantity);
	}

}
