/*
 * Starting in the top left corner of a 2×2 grid, and only being able to move to the right and down,
 * there are exactly 6 routes to the bottom right corner.
 * 
 * How many such routes are there through a 20×20 grid?
 * 
 */

package by.azargan.problems;

public class Problem15 {
	final static int HEIGHT = 21;
	final static int WIDTH = 21;
	static int count = 0;
	
	public static void main(String[] args) {
		long[][] arr = new long[HEIGHT][WIDTH];
		arr[0][0] = 0;
		for (int i = 0; i < HEIGHT; i++) {
			arr[i][0] = 1;
		}
		for (int j = 0; j < WIDTH; j++) {
			arr[0][j] = 1;
		}
		for (int i = 1; i < HEIGHT; i++) {
			for (int j = 1; j < WIDTH; j++) {
				arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
			}
		}
		System.out.println(arr[HEIGHT - 1][WIDTH - 1]);
	}

}
