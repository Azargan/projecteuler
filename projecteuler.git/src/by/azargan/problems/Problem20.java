/*
 * n! means n × (n − 1) × ... × 3 × 2 × 1
 * 
 * For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
 * and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
 * 
 * Find the sum of the digits in the number 100!
 * 
 * SOLVED: answer is 648
 * 
 */

package by.azargan.problems;

import java.math.BigInteger;

public class Problem20 {
	public static BigInteger getFactorial(BigInteger number) {
		BigInteger factorial = BigInteger.valueOf(1);
		while (!number.equals(BigInteger.ONE)) {
			factorial = factorial.multiply(number);
			number = number.subtract(BigInteger.ONE);
		}
		return factorial;
	}
	
	public static long getSumOfDigit(BigInteger number) {
		long sum = 0L;
		char[] chars = number.toString().toCharArray();
		for (int i = 0; i < chars.length; i++) {
			sum += Long.valueOf(chars[i]) - 48L;
		}
		return sum;
	}
	
	public static void main(String[] argv) {
		System.out.println(getSumOfDigit(getFactorial(BigInteger.valueOf(100))));
	}
}
