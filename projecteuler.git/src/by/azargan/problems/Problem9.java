/*
 * 
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
 * a^2 + b^2 = c^2
 * For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 * 
 */
package by.azargan.problems;

public class Problem9 {
	public static void main(String[] argv) {
		long number = 0;
		for (int i = 1; i < 1000; i++) {
			for (int j = 1; j < 1000; j++) {
				for (int k = 1; k < 1000; k++) {
					if ((i + j + k == 1000) && (Math.pow(i, 2) + Math.pow(j, 2) == Math.pow(k, 2))) {
						number = i * j * k;
					}
				}
			}
		}
		System.out.println("Product is " + number);
	}
}
