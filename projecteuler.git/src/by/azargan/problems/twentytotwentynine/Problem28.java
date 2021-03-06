/*
 * Starting with the number 1 and moving to the right in a clockwise direction a
 * 5 by 5 spiral is formed as follows:
 *
 * (21)  22  23  24  (25)
 *  20  (7)   8  (9)  10
 *  19   6   (1)  2   11
 *  18  (5)   4  (3)  12
 * (17)  16  15  14  (13)
 *
 * It can be verified that the sum of the numbers on the diagonals is 101.
 *
 * What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral
 * formed in the same way?
 *
 * SOLVED: Answer is 669171001
 *
 */

package by.azargan.problems.twentytotwentynine;

/**
 * @date   7/9/2014
 * @author Aliaksei_Vihuro
 */
public class Problem28 {
    public static void main(String[] args) {
        final int LIMIT = 1001 * 1001;
        long sum = 1;
        int number = 1;
        int diff = 2;
        while (number < LIMIT) {
            for (int i = 0; i < 4; i++) {
                number += diff;
                sum += number;
            }
            diff += 2;
        }
        System.out.println("Answer probably is " + sum);
    }
}
