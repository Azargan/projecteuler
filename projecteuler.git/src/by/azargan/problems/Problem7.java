package by.azargan.problems;

import java.util.ArrayList;
import java.util.List;

public class Problem7 {
	private static Integer findPrimeNumber(Integer index) {
		List<Integer> primeSec = new ArrayList<Integer>();
		int count = 0;
		for (int i = 2; i < Integer.MAX_VALUE; i++) {
			boolean flag = false;
			for (Integer j : primeSec) {
				if ((i % j) == 0) {
					flag = true;
				}
			}
			if (!flag) {
				primeSec.add(i);
				count++;
				if (count == index) {
					return i;
				}
			}
		}
		return 0;
	}
	
	public static void main(String[] argv) {
		System.out.println("10001 is " + findPrimeNumber(10001));
	}
}
