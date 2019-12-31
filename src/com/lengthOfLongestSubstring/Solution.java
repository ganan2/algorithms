package com.lengthOfLongestSubstring;

public class Solution {

	public int lengthOfLongestSubstring(String s) {
		int result = 0;
		int[] index = new int[128]; // current index of character
		// try to extend the range [i, j]
		for (int j = 0, i = 0; j < s.length(); j++) {
			i = Math.max(index[s.charAt(j)], i); 
			result = Math.max(result, j - i + 1); 
			index[s.charAt(j)] = j + 1; 
		}
		return result;
	}

	public static void main(String[] args) {
		String string = "cslkdcslkdclds";
//		String string = "dxfkkkd";
		Solution main = new Solution();
		System.out.println("Longest substring: " + main.lengthOfLongestSubstring(string));
	}
}
