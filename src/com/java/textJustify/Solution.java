package com.java.textJustify;

public class Solution {

	public static String justify(String string, int width) {
		int quotient = string.length() / width;
		int remainder = string.length() % width;

		String justifiedString = "";
		for (int i = 0; i < quotient; i++) {
			int start = (i * width);
			int end = (i * width) + width;
			justifiedString = justifiedString + string.substring(start, end) + "\n";
		}

		return justifiedString + string.substring(string.length() - remainder, string.length());
	}

	public static void main(String[] args) {
		String string = "xnmklncljascmknjhbygftdsewdxcfgvbhjnmkl,oweufbcoweinbb";
		System.out.println("String length: " + string.length());
		System.out.println();
		String justifiedString = justify(string, 10);
		System.out.println("Input: ");
		System.out.println("------");
		System.out.println(string);

		System.out.println();
		System.out.println("Justified output: ");
		System.out.println("-----------------");
		System.out.println(justifiedString);

	}

}
