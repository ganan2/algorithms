package com.java.arrayToListAndBack2.palindrome;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

	public static boolean isPaliondrome(String string) {
		List<Character> list = string.chars().mapToObj(e -> (char) e).collect(Collectors.toList());
		Collections.reverse(list);
		String reversedString = list.stream().map(Object::toString).reduce((t, u) -> t + u).orElse("");
		
		if (string.equals(reversedString)) return true;
		
		return false;
	}

	public static void main(String[] args) {
		String string = "1001";
		boolean isPalindrome = isPaliondrome(string);
		System.out.println(string + " is palindrome? " + isPalindrome);
	}

}
