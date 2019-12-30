package com.java.checkForPrime;

public class Solution {
	
	public static boolean isPrime(int number) {
		Double squareRoot = Math.sqrt(Double.valueOf(number));
		for(int i =  2; i <= squareRoot; i++) {
			if(number % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int number = 173;
		boolean isPrime = Solution.isPrime(number);
		System.out.println(number + " is prime? " + isPrime);
	}

}
