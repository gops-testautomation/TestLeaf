package javaAssignments.Week1.Day1;

public class Fibonacci {

	/*
	 * Home Assignment 1: Print Fibonacci series for first 11 numbers
	 * 0  1  1  2  3  5  8  13  21  34  55  89  144
	 * 
	 * Goal: To understand the arithmetic operation and loop
	 * a) Create a class by name: Fibonacci
	 * b) Create a main method using shortcut
	 * c) Write a logic to print Fibonacci from 0 to 56
	 * 
	 * Hints: 
	 * Initialize 3 int variables (Tip: firstNum = 0, secNum = 1, sum = 0)
	 * Print first number
	 * Iterate from 1 to the 11
	 * Add first and second number assign to sum
	 * Assign second number to the first number
	 * Assign sum to the second number
	 * Print sum
	 */

	public static void main(String[] args) {
		
		int firstNum = 0, secNum = 1, sum = 0;
		System.out.println(firstNum);
		for(int i=0; i<11; i++) {
			sum = firstNum + secNum;
			firstNum = secNum;
			secNum = sum;
			System.out.println(sum);
		}
	}
}
