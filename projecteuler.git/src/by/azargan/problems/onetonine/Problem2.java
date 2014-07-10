package by.azargan.problems.onetonine;

public class Problem2 {
	public static void main(String[] argv) {
		long last = 1l, current = 1l;
		long sum = 0;
		final long LIMIT = 4000000;
		
		while (current < LIMIT) {
			if ((current % 2) == 0) {
				sum += current;
			}
			long buf = current;
			current = current + last;
			last = buf;
		}
		
		System.out.println("Sum is " + sum);
	}
}
