/*
 * A perfect number is a number for which the sum of its proper divisors is exactly equal to the number.
 * For example, the sum of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.
 * 
 * A number n is called deficient if the sum of its proper divisors is less than n and it is called abundant if this sum exceeds n.
 * 
 * As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest number that can be written as the sum of two abundant
 * numbers is 24. By mathematical analysis, it can be shown that all integers greater than 28123 can be written as 
 * the sum of two abundant numbers. However, this upper limit cannot be reduced any further by analysis even though it is known that
 * the greatest number that cannot be expressed as the sum of two abundant numbers is less than this limit.
 * 
 * Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.
 * 
 * SOLVED: Sum of abundant numbers is 4179871
 * 
 * Created: 06.23.2014
 * @Author: Azargan
 * 
 */

package by.azargan.problems;

import java.util.ArrayList;
import java.util.List;

public class Problem23 {
	final static int MAX_LIMIT = 28123;
	final static int MIN_ABUNDANT = 12;
	
	// List of all abundant numbers before 28123
	private List<Integer> abundantNumbers = new ArrayList<Integer>();
	
	private boolean isDivisor(int number, int divisor) {
		return ((number % divisor) == 0) ? true : false;
	}
	
	private int getDivisorsSum(int number) {
		int sum = 1;
		for (int i = 2; i <= (number / 2); i++) {
			if (isDivisor(number, i)) {
				sum += i;
			}
		}
		return sum;
	}
	
	private boolean isAbundant(int number) {
		return (getDivisorsSum(number) > number) ? true : false;
	}
	
	private void fillAbundantNumbersList() {
		for (int i = MIN_ABUNDANT; i <= MAX_LIMIT - MIN_ABUNDANT; i++) {
			if (isAbundant(i)) {
				abundantNumbers.add(i);
			}
		}
	}
	
	private boolean isNotCanBeWrittenAsSumOfAbundant(int number) {
		boolean answer = true;
		for (int i : abundantNumbers) {
			if (number < i) {
				break;
			}
			if (abundantNumbers.contains(number - i)) {
				answer = false;
				break;
			}
		}
		return answer;
	}
	
	private long calcSum() {
		long sum = 0L;
		for (int i = 1; i <= MAX_LIMIT; i++) {
			if (isNotCanBeWrittenAsSumOfAbundant(i)) {
				sum += i;
			}
		}
		return sum;
	}
	
	public static void main(String[] args) {
		Problem23 problem = new Problem23();
		problem.fillAbundantNumbersList();
		System.out.println("All count of abundant numbers is " + problem.abundantNumbers.size());
		System.out.println("Answer probably is " + problem.calcSum());
	}
	
}
