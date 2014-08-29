//<editor-fold defaultstate="collapsed" desc="Problem description">
/*
 * 145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.
 *
 * Find the sum of all numbers which are equal to the sum of the factorial of their digits.
 *
 * Note: as 1! = 1 and 2! = 2 are not sums they are not included.
 */
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="ANSWER">
//SOLVED: Answer is 40730
//</editor-fold>
package by.azargan.problems.problem34;

/**
 *
 * @author Aliaksei_Vihuro
 */
public class Main {

    private static final Integer LIMIT = 9999999; // Because 9! = 362880

    public static void main(String[] args) {
        int sum = 0;
        FactorialMap factorials = new FactorialMap();
        for (int i = 3; i < LIMIT; i++) {
            int factorialsSum = NumberDecomposition.getDigitList(i)
                    .stream()
                    .reduce(0, (acc, digit) -> acc += factorials.getFactorial(digit));
            if (factorialsSum == i) {
                sum += i;
            }
        }
        System.out.println("Answer is " + sum);
    }
}
