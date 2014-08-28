package by.azargan.problems.problem33;

/**
 *
 * @author Aliaksei_Vihuro
 */
public class Fraction {

    final private int denominatorLimit;

    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator, int denominatorLimit) {
        this.numerator = numerator;
        this.denominator = denominator;
        this.denominatorLimit = denominatorLimit;
    }

    public int getDenominatorLimit() {
        return denominatorLimit;
    }

    public boolean isRightFraction() {
        return (numerator < denominator);
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public boolean hasNext() {
        int nextNumerator = numerator + 1;
        return (denominator < denominatorLimit
                || (denominator == denominatorLimit && nextNumerator != denominator));
    }

    public Fraction next() {
        numerator++;
        if (!isRightFraction()) {
            if (denominator == denominatorLimit) {
                return null;
            }
            denominator++;
            numerator = 10;
        }
        return this;
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    public boolean notMultyOfTen() {
        return !String.valueOf(denominator).contains("0");
    }

    public boolean isEqualsTo(Fraction fraction) {
        int oldMultiply = numerator * denominator;
        int newMultyply = fraction.getNumerator() * fraction.getDenominator();

        int lcm = Utilz.lcm(denominator, fraction.getDenominator());

        if (oldMultiply == 0 || newMultyply == 0 || lcm == 0) {
            return false;
        }

        int oldNumerator = numerator * (lcm / denominator);
        int newNumerator = fraction.numerator * (lcm / fraction.getDenominator());

        return (oldNumerator == newNumerator);
    }

}
