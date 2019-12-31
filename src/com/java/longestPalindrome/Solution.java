package com.java.longestPalindrome;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {

	private static String getLongestPalindrome(String string) {
		Set<String> substrings = new HashSet<String>();
		List<String> palindromes = new ArrayList<String>();

		if (string.isEmpty()) {
			return null;
		}

		if (string.length() == 1) {
			return string;
		}

		// find all substrings
		String substring = "";
		for (int i = 0; i < string.length(); i++) {
			for (int j = i + 1; j < string.length(); j++) {
				substring = string.substring(i, j);
				substrings.add(substring);
			}
		}

		System.out.println("All substrings: ");
		System.out.println(substrings);
		System.out.println();

		// check for palindrome
		for (String localString : substrings) {
			List<Character> list = localString.chars().mapToObj(e -> (char) e).collect(Collectors.toList());
			Collections.reverse(list);
			String reversedString = list.stream().map(Object::toString).reduce((t, u) -> t + u).orElse("");

			if (localString.equals(reversedString)) {
				palindromes.add(localString);
			}
		}

		// check for max length element
		int length = 0;
		String longest = "";
		for (String localString : palindromes) {
			if (localString.length() > length) {
				length = localString.length();
				longest = localString;
			}
		}

		return longest;
	}

	public static void main(String[] args) {
		String string = "babad";
		System.out.println("Given string: ");
		System.out.println(string);
		System.out.println();

		String longestPalindrome = Solution.getLongestPalindrome(string);
		System.out.println("Longest Palindrome: ");
		System.out.println(longestPalindrome);

	}
}
