/*
 *
 *2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
 *
 *What is the sum of the digits of the number 2^1000?
 *
 */
package by.azargan.problems.tentonineteenth;

import java.util.ArrayList;
import java.util.List;

public class Problem16 {
	final static int POWER = 1000;
	
	public static List<Byte> number = new ArrayList<Byte>();
	
	public static void main(String[] args) {		
		number.add((byte) 2);
		for (int i = 1; i < POWER; i++) {
			boolean transfer = false;
			for (int j = 0; j < number.size(); j++) {
				byte buf = (byte) (number.get(j) * 2);
				if (transfer) {
					buf++;
					transfer = false;
				}
				if (buf > 9) {
					transfer = true;
					buf -= 10;
				}
				number.set(j, buf);
			}
			if (transfer) {
				number.add((byte) 1);
			}
		}
		
		int sum = 0;
		for (int i = number.size() - 1; i >= 0; i--) {
			System.out.print(number.get(i));
			sum += number.get(i);
		}
		System.out.println("\nsum " + sum);
	}

}
