package com.java.numbersToWords;

public class Solution {
	private static String[] underTen = new String[] { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine" };
	private static String[] underTwenty = new String[] { "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen",
			"Seventeen", "Eighteen", "Nineteen" };
	private static String[] underHundred = new String[] { "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy",
			"Eighty", "Ninety" };

	public static String numberToWords(int num) {
		if (num == 0)
			return "Zero";
		else
			return helper(num);
	}

	public static String helper(int num) {
		String res = "";
		if (num < 10)
			res += underTen[num];
		else if (num < 20)
			res += underTwenty[num - 10];
		else if (num < 100)
			res += underHundred[num / 10] + " " + helper(num % 10);
		else if (num < 1000)
			res += helper(num / 100) + " Hundred " + helper(num % 100);
		else if (num < 1000000)
			res += helper(num / 1000) + " Thousand " + helper(num % 1000);
		else if (num < 1000000000)
			res += helper(num / 1000000) + " Million " + helper(num % 1000000);
		else
			res += helper(num / 1000000000) + " Billion " + helper(num % 1000000000);
		return res.trim();
	}
	
	public static void main(String[] args) {
		int number = 1000110001;
		System.out.println("Number before formatting: ");
		System.out.println(number);
		System.out.println();
		String formattedNumber = numberToWords(number);
		System.out.println("Number after formatting: ");
		System.out.println(formattedNumber);
		
	}
}