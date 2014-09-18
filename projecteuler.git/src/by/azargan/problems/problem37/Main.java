//<editor-fold defaultstate="collapsed" desc="Problem description">
/*
* The number 3797 has an interesting property. Being prime itself, it is possible to continuously remove digits
* from left to right, and remain prime at each stage: 3797, 797, 97, and 7. Similarly we can work from right
* to left: 3797, 379, 37, and 3.
*
* Find the sum of the only eleven primes that are both truncatable from left to right and right to left.
*
* NOTE: 2, 3, 5, and 7 are not considered to be truncatable primes.
*/
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="ANSWER">
//SOLVED: Answer is 748317
//</editor-fold>
package by.azargan.problems.problem37;

import java.math.BigInteger;

/**
 *
 * @author Aliaksei_Vihuro
 */
public class Main {
    public static void main(String[] args) {
        int primesCounter = 0;
        int sum = 0;
        Integer currentNumber = 9;
        while (primesCounter != 11) {
            currentNumber++;
            BigInteger number = new BigInteger(currentNumber.toString());
            if (checkLeftTruncate(number) && checkRightTruncate(number)) {
                System.out.println("Find required number: " + number.toString());
                sum += number.intValue();
                primesCounter++;
            }
        }
        System.out.println("Answer is " + sum);
    }

    private static boolean checkLeftTruncate(final BigInteger number) {
        BigInteger current = new BigInteger(number.toString());
        while (!current.equals(BigInteger.ZERO)) {
            if (!current.isProbablePrime(1)) {
                return false;
            }
            current = NumberTruncationService.truncLeftDigit(current);
        }
        return true;
    }

    private static boolean checkRightTruncate(final BigInteger number) {
        BigInteger current = new BigInteger(number.toString());
        while (!current.equals(BigInteger.ZERO)) {
            if (!current.isProbablePrime(1)) {
                return false;
            }
            current = NumberTruncationService.truncRightDigit(current);
        }
        return true;
    }
}
