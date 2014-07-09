/*
 * Euler discovered the remarkable quadratic formula:
 * 
 * n² + n + 41
 * 
 * It turns out that the formula will produce 40 primes for the consecutive 
 * values n = 0 to 39. However, when n = 40, 40² + 40 + 41 = 40(40 + 1) + 41 
 * is divisible by 41, and certainly when n = 41, 41² + 41 + 41 is clearly 
 * divisible by 41.
 *
 * The incredible formula  n² − 79n + 1601 was discovered, which produces 80 
 * primes for the consecutive values n = 0 to 79. The product of the 
 * coefficients, −79 and 1601, is −126479.
 * 
 * Considering quadratics of the form:
 *
 * n² + an + b, where |a| < 1000 and |b| < 1000
 *
 * where |n| is the modulus/absolute value of n
 * e.g. |11| = 11 and |−4| = 4
 *
 * Find the product of the coefficients, a and b, for the quadratic expression 
 * that produces the maximum number of primes for consecutive values of n,
 * starting with n = 0.
 *
 */

package by.azargan.problems;

/**
 * @date   7/9/2014
 * @author Aliaksei_Vihuro
 */
public class Problem27 {
    private static boolean isPrimes(long number) {
        number = Math.abs(number);
        for (int i = 2; i < (number / 2); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        int a = 0, b = 0, maxConsLength = 0;
        for (int i = -999; i < 1000; i++) {
            for (int j = -999; j < 1000; j++) {
                int consecutiveLength = 0;
                int n = 0;
                while (isPrimes(n * n + n * i + j)) {
                    n++;
                    consecutiveLength++;
                }
                if (consecutiveLength > maxConsLength) {
                    a = i;
                    b = j;
                    maxConsLength = consecutiveLength;
                    System.out.println(a + " : " + b + " : " + maxConsLength);
                }
            }
        }
        System.out.println("Ansver probably is " + (a * b));
    }
}
