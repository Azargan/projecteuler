//<editor-fold defaultstate="collapsed" desc="Problem description">
/*
* The number, 197, is called a circular prime because all rotations of the digits: 197, 971, and 719,
* are themselves prime.
*
* There are thirteen such primes below 100: 2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, and 97.
*
* How many circular primes are there below one million?
*/
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="ANSWER">
//SOLVED: Answer is 55
//</editor-fold>
package by.azargan.problems.problem35;

import java.math.BigInteger;

/**
 *
 * @author Aliaksei_Vihuro
 */
public class Main {
    public static boolean isCirularPrime(BigInteger number) {
        BigInteger originalNumber = number;
        int loopCounter = 0;
        boolean answer = true;
        do {
            if (!number.isProbablePrime(1) || loopCounter++ > 10) {
                answer = false;
                break;
            }
            number = turnAround(number);
        } while (!number.equals(originalNumber));
        return answer;
    }

    public static BigInteger turnAround(BigInteger number) {
        String stringNumber = number.toString();
        if (stringNumber.length() > 1) {
            stringNumber = stringNumber.substring(1) + stringNumber.substring(0, 1);
            number = new BigInteger(stringNumber);
        }
        return number;
    }

    public static void main(String[] args) {
        BigInteger number = new BigInteger("0");
        int circularPrimeCounter = 0;
        while (number.intValue() < 1000000) {
            number = number.nextProbablePrime();
            if (isCirularPrime(number)) {
                circularPrimeCounter++;
                System.out.println(circularPrimeCounter + " : " + number.toString());
            }
        }
        System.out.println("Total count: " + circularPrimeCounter);
    }
}
