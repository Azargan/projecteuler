package by.azargan.problems;

public class Problem5 {
	public static void main(String[] argv) {
		long number = 20 * 19;
		long current = number;
		int count = 1;
		boolean flag = true;
		while (number < Long.MAX_VALUE && flag) {
			flag = false;
			current = number * count++;
			for (int i = 18; i > 1; i--) {
				if ((current % i) != 0) {
					flag = true;
					break;
				}
			}
		}
		System.out.println("Smallest multiple is " + current);
	}
}
