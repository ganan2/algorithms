package com.java.pascal;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	private static List<List<Integer>> pascalTriangle = new ArrayList<List<Integer>>();

	private static List<List<Integer>> getPascalTriangle(int totalRows) {
		List<Integer> currentRow = new ArrayList<Integer>();
		List<Integer> previousRow = new ArrayList<Integer>();

		if (totalRows == 0) {
			return null;
		}

		for (int row = 1; row <= totalRows; row++) {
			for (int column = 1; column <= row; column++) {
				if (column == 1 || row == column) {
					currentRow.add(1);
				} else {
					int previousRowIndex = pascalTriangle.size() - 1;
					previousRow = pascalTriangle.get(previousRowIndex);
					int currentElement = previousRow.get(column - 2) + previousRow.get(column - 1);
					currentRow.add(currentElement);
				}
			}
			pascalTriangle.add(currentRow);
			currentRow = new ArrayList<Integer>();
		}

		return pascalTriangle;
	}

	public static int pascal(int height, int row, int column) {
		pascalTriangle = Solution.getPascalTriangle(height);
		List<Integer> currentRow = pascalTriangle.get(row - 1);
		return currentRow.get(column - 1);
	}
	
	public static void displayPascalTriangle(){
		System.out.println("Pascal triangle: ");
		for(int rowIndex = 0; rowIndex < pascalTriangle.size(); rowIndex++) {
			List<Integer> currentRow = pascalTriangle.get(rowIndex);
			
			for(int i = pascalTriangle.size() - currentRow.size(); i > 0; i--) {
				System.out.print(" ");
			}
			
			for(int elementIndex = 0; elementIndex < currentRow.size(); elementIndex++) {
				System.out.print(currentRow.get(elementIndex) + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int height = 10;
		int row = 5, column = 2;
		int result = Solution.pascal(height, row, column);
		System.out.println("Element at (" + row + "," + column + "): " + result);
		System.out.println();
		displayPascalTriangle();
	}
}
