/*
 * The Fibonacci sequence is defined by the recurrence relation:
 *
 * F(n) = F(n−1) + F(n−2), where F1 = 1 and F2 = 1.
 *
 * Hence the first 12 terms will be:
 *
 *  F1 = 1
 *  F2 = 1
 *  F3 = 2
 *  F4 = 3
 *  F5 = 5
 *  F6 = 8
 *  F7 = 13
 *  F8 = 21
 *  F9 = 34
 *  F10 = 55
 *  F11 = 89
 *  F12 = 144
 *
 *  The 12th term, F12, is the first term to contain three digits.
 *
 *  What is the first term in the Fibonacci sequence to contain 1000 digits?
 *
 *  Created: 07.07.2014
 *  @Author: Azargan
 *
 *  Answer is 4782
 *
 */

package by.azargan.problems.twentytotwentynine;

import java.math.BigInteger;

public class Problem25 {

	public static BigInteger findNextFib(BigInteger prev, BigInteger current) {
		return current.add(prev);
	}

	public static boolean isHave1000Dig(BigInteger number) {
		return (number.toString().length() >= 1000);
	}

	public static void main(String[] args) {
		BigInteger prev = new BigInteger("1");
		BigInteger current = new BigInteger("1");
		int count = 2;
		while (!isHave1000Dig(current)) {
			BigInteger buf = new BigInteger(current.toString());
			current = findNextFib(prev, current);
			prev = buf;
			count ++;
		}
		System.out.println("Probably " + count);
	}

}
