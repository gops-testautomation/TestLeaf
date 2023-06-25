package javaAssignments.Week1.Day1;

public class IsPrime {
	
	/*
	 * Home Assignment 2: Print if the given number is prime
	 * 
	 * Goal: To understand the problem solving, looping and conditional statement
	 * a) Create a class by name: IsPrime
	 * b) Create a main method using shortcut
	 * c) Write a logic to find if the given number is prime or not
	 * d) Print if it is prime or not
	 * 
	 * Hint: Iterate through all numbers from 2 to n-1 (input) and for every number check if it divides n (input). 
	 * If we find any number that divides, print prime.
	 * If nothing divides, then print non-prime
	 */

	public static void main(String[] args) {
		
		int number = 11;
		boolean isPrime = true;
		
		if (number == 0 || number == 1) {
			System.out.println(number + " is not a Prime number");
		}
		else {
			for(int i =2; i<=number/2; i++) {
				if(number%i == 0) {
					System.out.println(number + " is not a Prime number");		
					isPrime = false;
					break;
				}				
			}	
		}
		if (isPrime == true) {
			System.out.println(number + " is a Prime number");				
		}
	}
}
