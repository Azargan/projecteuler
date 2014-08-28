//<editor-fold defaultstate="collapsed" desc="Problem description">
/*
 The fraction 49/98 is a curious fraction, as an inexperienced mathematician
 in attempting to simplify it may incorrectly believe that 49/98 = 4/8,
 which is correct, is obtained by cancelling the 9s.

 We shall consider fractions like, 30/50 = 3/5, to be trivial examples.
 There are exactly four non-trivial examples of this type of fraction,
 less than one in value, and containing two digits in the numerator and denominator.

 If the product of these four fractions is given in its lowest common terms,
 find the value of the denominator.
 */
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="ANSWER">
//SOLVED: Answer is 100
//</editor-fold>

package by.azargan.problems.problem33;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Aliaksei_Vihuro
 */
public class Main {

    public static void main(String[] args) {
        List<Fraction> listOfFractions = new LinkedList<>();
        Fraction fraction = new Fraction(10, 11, 99);
        while (fraction.hasNext()) {
            fraction = fraction.next();
            if (Utilz.hasEqualsDigit(fraction.getDenominator(), fraction.getNumerator())) {
                Fraction newFraction = Utilz.getCuriousFraction(fraction);
                if (fraction.isEqualsTo(newFraction) && fraction.notMultyOfTen()) {
                    System.out.println(newFraction.toString() + " " + fraction.toString());
                    listOfFractions.add(newFraction);
                }
            }
        }

        int denumerator = listOfFractions.stream().mapToInt(f -> f.getDenominator()).reduce(1, (a, b) -> a * b);
        int numerator = listOfFractions.stream().mapToInt(f -> f.getNumerator()).reduce(1, (a, b) -> a * b);
        int gcd = Utilz.gcd(numerator, denumerator);
        Fraction result = new Fraction(numerator / gcd, denumerator / gcd, denumerator);
        System.out.println(result.toString());
        System.out.println("Answer is " + result.getDenominator());
    }

}
