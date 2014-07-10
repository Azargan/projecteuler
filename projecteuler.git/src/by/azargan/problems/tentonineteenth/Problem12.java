package by.azargan.problems.tentonineteenth;

public class Problem12 {
	final static int MAX_DIVISORS = 500;

	public static void main(String[] argv) {
		long counter = 2L;

		for (long i = 1L; i < Long.MAX_VALUE; i += counter++) {
			int divisors = 0;
			if (((i % 2) ==0) 
					&& ((i % 3) == 0)
					&& ((i % 5) == 0)
					&& ((i % 7) == 0)
					&& ((i % 9) == 0)) {
				divisors = 10;
				for (long j = 11L; j <= i; j++) {
					if ((i % j) == 0) {
						divisors++;
					}
				}
			}
			if (divisors >= MAX_DIVISORS) {
				System.out.println("Number with 500 divisors is :" + i);
				break;
			}
		}
	}
}
