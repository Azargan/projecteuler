/*
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 *
 * Find the sum of all the primes below two million.
 */
package by.azargan.problems.tentonineteenth;

import java.util.LinkedList;
import java.util.List;

public class Problem10 {
	public static List<Integer> primeSec;
	
	private static List<Integer> findPrimeSec(Integer limit) {
		List<Integer> primeSec = new LinkedList<Integer>();
		for (int i = 2; i <= limit; i++) {
			boolean flag = false;
			for (Integer j : primeSec) {
				if ((i % j) == 0) {
					flag = true;
					break;
				}
			}
			if (!flag) {
				primeSec.add(i);
			}
		}
		return primeSec;
	}
	
	public static void main(String[] argv) {
		primeSec = findPrimeSec(2000000);
		System.out.println(primeSec.toString());
		Long sum = 0L;
		for (Integer i : primeSec) {
			sum += i;
		}
		System.out.println("Sum is " + sum);
	}
}
