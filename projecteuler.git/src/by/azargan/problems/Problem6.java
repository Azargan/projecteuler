package by.azargan.problems;

public class Problem6 {
	public static void main(String[] argv) {
		long sumOfSquares = 0;
		long squaresOfSum = 0;
		
		for (int i = 1; i <= 100; i++) {
			sumOfSquares += Math.pow(i, 2);
		}
		for (int i = 1; i <= 100; i++) {
			squaresOfSum += i;
		}
		squaresOfSum *= squaresOfSum;
		
		System.out.println("Sum of Squares is " + sumOfSquares);
		System.out.println("Square of sum is " + squaresOfSum);
		
		System.out.println("Difference is " + (squaresOfSum - sumOfSquares));
	}
}
