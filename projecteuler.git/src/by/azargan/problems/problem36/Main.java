//<editor-fold defaultstate="collapsed" desc="Problem description">
/*
 * The decimal number, 585 = 1001001001 (binary), is palindromic in both bases.
 *
 * Find the sum of all numbers, less than one million, which are palindromic in base 10 and base 2.
 *
 * (Please note that the palindromic number, in either base, may not include leading zeros.)
 */
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="ANSWER">
//SOLVED: Answer is 872187
//</editor-fold>
package by.azargan.problems.problem36;

/**
 *
 * @author Aliaksei_Vihuro
 */
public class Main {
    public static boolean isPalindromic(String string) {
        int length = string.length();
        for (int i = 0; i < (length / 2); i++) {
            if (string.charAt(i) != string.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int sum = 0;
        for (int i = 0; i < 1000000; i++) {
            if (isPalindromic(String.valueOf(i))
                    && isPalindromic(Integer.toBinaryString(i))) {
                System.out.println(i + " : " + Integer.toBinaryString(i));
                sum += i;
            }
        }
        System.out.println("Sum of palindromic is " + sum);
    }
}
