/*
 * A unit fraction contains 1 in the numerator. The decimal representation of 
 * the unit fractions with denominators 2 to 10 are given:
 * 
 *  1/2	 = 	0.5
 *  1/3  = 	0.(3)
 *  1/4	 = 	0.25
 *  1/5	 = 	0.2
 *  1/6	 = 	0.1(6)
 *  1/7	 = 	0.(142857)
 *  1/8	 = 	0.125
 *  1/9	 = 	0.(1)
 *  1/10 = 	0.1
 *  
 *  Where 0.1(6) means 0.166666..., and has a 1-digit recurring cycle. It can be
 *  seen that 1/7 has a 6-digit recurring cycle.
 *  
 *  Find the value of d < 1000 for which 1/d contains the longest recurring 
 *  cycle in its decimal fraction part.
 *  
 */

package by.azargan.problems;

public class Problem26 {
    final static int DENOM_LIMIT = 1000;
    final static int RESULT_LENGTH_LIMIT = 1000000;
    static int denominator = 1;
    static int answer = 1;
    static int maxLength = 1;    
    
    private static String findFraction(int denominator) {
        StringBuilder sb = new StringBuilder();
        int numerator = 1;
        while ((numerator != 0) && (sb.length() <= RESULT_LENGTH_LIMIT)) {
            sb.append(numerator / denominator);
            numerator = (numerator % denominator) * 10;
        }
        sb.deleteCharAt(0);
        return sb.toString();
    }
    
    private static int checkRecurringCycleLength(String fraction) {
        if (fraction.length() < RESULT_LENGTH_LIMIT) {
            return 0;
        }
        int length = 0;
        StringBuilder sb = new StringBuilder();
        int curInd = 0, startInd = 0, endInd = 0;
        boolean flag = false;
        for (int i = 0; i < fraction.length(); i++) {
            char ch = fraction.charAt(i);
            int matchInd = sb.indexOf(String.valueOf(ch));
            if (flag) {
                if (sb.charAt(++curInd) != ch) {
                    flag = false;
                    curInd = 0;
                    startInd = 0;
                    endInd = 0;
                } else if (curInd == endInd) {
                    length = endInd - startInd;
                    break;
                }
            }
            if (flag == false && matchInd != -1) {
                curInd = matchInd;
                endInd = i;
                startInd = matchInd;
                flag = true;
            }
            sb.append(ch);
        }
        return length;
    }
    
    public static void main(String[] args) {
        for (int i = 1; i < DENOM_LIMIT; i++) {
            int length = checkRecurringCycleLength(findFraction(denominator++));
            System.out.println((denominator - 1) +
                    " : " +
                   // findFraction(denominator - 1) +
                    " : " +
                    length);
            if (length > maxLength) {
                answer = i;
                maxLength = length;
            }
        }
        System.out.println("Probabli answer is " + answer);
    }
}
