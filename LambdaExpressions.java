/*
This article series focuses on Algorithms, Data Structures, and applying them to problem solving.

[Question/Problem Statement is the Property of Techgig]

Java Advanced — Lambda Expressions [www.techgig.com] 
Write the following methods that return a lambda expression performing a specified action: Perform the operation isodd():
The lambda expression must return if a number is odd or if it is even.... Perform  the  operation  isprime(): The lambda 
expression must return if a number is prime or if it is composite.... Perform  the  operation ispalindrome(): The lambda 
expression must return if a number is a palindrome or if it is not. 

Input Format
Input is as shown in the format below:
Input
3
1 3
2 7
3 7777

Constraints
NA

Output Format
Output is as Show in the format below:
Output
ODD
PRIME
PALINDROME

[Explanation of the Solution]
This is a good question to refresh java 8 lambdas. In  my  solution, I implemented the  functional  interfaces within my 
main() Method and assigned it to local reference variables.
*/

// Techgig Core Java Basics Problem - Knock Off Java Lambdas!   
// Author: Sumith Puri [I Bleed Java!] // GitHub: @sumithpuri   
// Tested On 30-12-2022 - All OK

import java.util.Scanner;

// This is a Functional Interface!
interface LambdaYogi {
	public boolean opYog(int x);
}

public class LambdaExpressions {
	public static void main(String args[]) throws Exception {

        // you may choose to refactor, as this method
        // becomes really long and unmanageable #TODO
		LambdaYogi isOdd = a -> {
			boolean retFlag = false;
			if (a % 2 != 0)
				retFlag = true;
			return retFlag;
		};
		LambdaYogi isPrime = a -> {
			boolean retFlag = true;
			for (int i = 2; i < a - 1; i++) {
				if (a % i == 0) {
					retFlag = false;
					break;
				}
			}
			return retFlag;
		};
		LambdaYogi isPalindrome = a -> {
			boolean retFlag = false;
			String actStr = String.valueOf(a).trim();
			String revStr = new StringBuffer(actStr).reverse().toString();

			// using string basis, not mathematical
			if (actStr.equals(revStr))
				retFlag = true;
			return retFlag;
		};

		Scanner scanner = new Scanner(System.in);
		int val = scanner.nextInt();

		for (int i = 0; i < val; i++) {
			int opr = scanner.nextInt();
			int num = scanner.nextInt();
			switch (opr) {
			case 1: {
				if (isOdd.opYog(num))
					System.out.println("ODD");
				else
					System.out.println("EVEN");
				break;
			}
			case 2: {
				if (isPrime.opYog(num))
					System.out.println("PRIME");
				else
					System.out.println("COMPOSITE");
				break;
			}
			case 3: {
				if (isPalindrome.opYog(num))
					System.out.println("PALINDROME");
				else
					System.out.println("NONPALIN");
			}
			}
		}
	}
}

