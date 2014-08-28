package by.azargan.problems.problem33;

/**
 *
 * @author Aliaksei_Vihuro
 */
public class Utilz {

    public static int gcd(int a, int b) {
        return (b == 0) ? a : gcd(b, a % b);
    }

    public static int lcm(int a, int b) {
        return a / gcd(a, b) * b;
    }

    public static boolean hasEqualsDigit(int a, int b) {
        String first = String.valueOf(a);
        String second = String.valueOf(b);

        for (int i = 0; i < first.length(); i++) {
            if (second.contains(first.subSequence(i, i + 1))) {
                return true;
            }
        }

        return false;
    }

    public static Fraction getCuriousFraction(Fraction fraction) {
        String numerator = String.valueOf(fraction.getNumerator());
        String denominator = String.valueOf(fraction.getDenominator());

        for (int i = 0; i < numerator.length(); i++) {
            if (denominator.contains(numerator.subSequence(i, i + 1))) {
                String digit = String.valueOf(numerator.charAt(i));
                denominator = denominator.replaceFirst(digit, "");
                numerator = numerator.replaceFirst(digit, "");
            }
        }

        int newNumerator = Integer.parseInt(numerator);
        int newDenominator = Integer.parseInt(denominator);

        return new Fraction(newNumerator, newDenominator, fraction.getDenominatorLimit());
    }

}
