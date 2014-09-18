package by.azargan.problems.problem37;

import java.math.BigInteger;

/**
 *
 * @author Aliaksei_Vihuro
 */
public class NumberTruncationService {
    public static BigInteger truncLeftDigit(BigInteger number) {
        if (number.toString().length() <= 1) {
            return BigInteger.ZERO;
        }
        String stringNumber = number.toString();
        stringNumber = stringNumber.substring(1, stringNumber.length());
        return new BigInteger(stringNumber);
    }

    public static BigInteger truncRightDigit(BigInteger number) {
        if (number.toString().length() <= 1) {
            return BigInteger.ZERO;
        }
        String stringNumber = number.toString();
        stringNumber = stringNumber.substring(0, stringNumber.length() - 1);
        return new BigInteger(stringNumber);
    }
}
