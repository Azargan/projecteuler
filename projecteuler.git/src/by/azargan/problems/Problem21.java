/*
 *
 * Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
 * If d(a) = b and d(b) = a, where a ≠ b, then a and b are an amicable pair and each of a and b are called amicable numbers.
 * 
 * For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284.
 * The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.
 * 
 * Evaluate the sum of all the amicable numbers under 10000.
 * 
 * SOLVED: answer is 31626
 * 
 */

package by.azargan.problems;

public class Problem21 {
	private boolean isDivisor(int number, int divisor) {
		return (number % divisor) == 0;
	}
	
	private int findSumOfDivisors(int number) {
		int sum = 0;
		for (int i = 1; i <= (number / 2); i++) {
			if (isDivisor(number, i)) {
				sum += i;
			}
		}
		return sum;
	}
	
	private boolean isEquals(int number1, int number2) {
		return (number1 == number2);
	}
	
	private boolean isNotEquals(int number1, int number2) {
		return !(isEquals(number1, number2));
	}
	
	private boolean isAmicable(int number, int sumOfNumberDivisors) {
		return (isNotEquals(number, sumOfNumberDivisors) && isEquals(findSumOfDivisors(sumOfNumberDivisors), number));
	}
	
	private long getSumOfAmicableNumbersBefore(int number) {
		if (number <= 0) {
			return 0;
		}
		
		long sum = 0;
		for (int i = 1; i <= number; i++) {
			int otherNumber = findSumOfDivisors(i);
			if (isAmicable(i, otherNumber)) {
				System.out.println("Amicable: " + i + " and " + otherNumber);
				sum += i + otherNumber;
			}
		}
		
		return sum /= 2;
	}
	
	public static void main(String[] argv) {
		Problem21 problem21 = new Problem21();
		long sum = problem21.getSumOfAmicableNumbersBefore(10000);
		System.out.println(sum);
	}
}
