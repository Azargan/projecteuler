/*
 * Surprisingly there are only three numbers that can be written as the sum
 * of fourth powers of their digits:
 *
 *  1634 = 1^4 + 6^4 + 3^4 + 4^4
 *  8208 = 8^4 + 2^4 + 0^4 + 8^4
 *  9474 = 9^4 + 4^4 + 7^4 + 4^4
 *
 * As 1 = 1^4 is not a sum it is not included.
 *
 * The sum of these numbers is 1634 + 8208 + 9474 = 19316.
 *
 * Find the sum of all the numbers that can be written as the sum of fifth
 * powers of their digits.
 *
 * SOLVED: Answer is 443839
 *
 */

package by.azargan.problems.thirtytothirtynine;

/**
 * @date   11/7/2014
 * @author Aliaksei_Vihuro
 */
public class Problem30 {

    private final static int POWER = 5;

    private static boolean isEqualsToSumOfPowers(int number) {
        String n = String.valueOf(number);
        int digitCount = n.length();
        int buffer = number;
        boolean answer = false;
        for (int i = 0; i < digitCount; i++) {
            int digit = getDigit(number, i);
            int pow = (int) Math.pow(digit, POWER);
            if (pow > buffer && buffer != 0) {
                break;
            } else {
                buffer -= pow;
            }
        }
        if (buffer == 0) {
            answer = true;
        }
        return answer;
    }

    private static int getDigit(int number, int position) {
        String n = String.valueOf(number);
        return Integer.parseInt(String.valueOf(n.charAt(position)));
    }

    public static void main(String[] args) {
        int sum = 0;
        for (int i = 2; i < 200000; i++) {
            if (isEqualsToSumOfPowers(i)) {
                sum += i;
                System.out.println(i);
            }
        }
        System.out.println("Answer is " + sum);
    }
}
