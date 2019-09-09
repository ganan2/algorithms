package com.java.lexicographic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	
	public static List<String> getLexicographically(String[] words){
		for (int i = 0; i < 3; ++i) {
			for (int j = i + 1; j < 4; ++j) {
				if (words[i].compareTo(words[j]) > 0) {
					String temp = words[i];
					words[i] = words[j];
					words[j] = temp;
				}
			}
		}
		return new ArrayList<String>(Arrays.asList(words));
	}
	public static void main(String[] args) {
		String[] words = { "Ruby", "C", "Python", "Java" };
		System.out.println("In no specific order:" + Arrays.toString(words));
		List<String> list = Solution.getLexicographically(words);
		System.out.println("In lexicographical order:" + list);
	}
}