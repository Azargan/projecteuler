//<editor-fold defaultstate="collapsed" desc="Problem description">
/*
 We shall say that an n-digit number is pandigital if it makes use of all
 the digits 1 to n exactly once; for example, the 5-digit number, 15234,
 is 1 through 5 pandigital.

 The product 7254 is unusual, as the identity, 39 × 186 = 7254,
 containing multiplicand, multiplier, and product is 1 through 9 pandigital.

 Find the sum of all products whose multiplicand/multiplier/product identity
 can be written as a 1 through 9 pandigital.
 HINT: Some products can be obtained in more than one way so be sure to only
 include it once in your sum.
 */
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="ANSWER">
//SOLVED: Answer is 45228
//</editor-fold>
package by.azargan.problems.problem32;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @date 25/7/2014
 * @author Aliaksei_Vihuro
 */
public class Problem {

    private static final int MAX_LIMIT = 999999;//999999999L;

    private static boolean isAcceptableLength(Integer a, Integer b) {
        final int MAX_LENGTH = 9;
        return ((a.toString().length() + b.toString().length()
                + (a.toString().length() + b.toString().length() - 1))
                    <= MAX_LENGTH);
    }

    private static boolean isHasDiffDigit(Integer a, Integer b) {
        Set<Character> set = new HashSet<>();
        boolean afterAdding = addElementsAndCheckSize(set, digitAsCharacter(a))
                && addElementsAndCheckSize(set, digitAsCharacter(b))
                && addElementsAndCheckSize(set, digitAsCharacter(a * b));
        return (afterAdding
                && set.size() == 9
                && !set.contains('0'));
    }

    private static <T> boolean addElementsAndCheckSize(Set<T> set,
            Collection<? extends T> collection) {
        int sizeBefore = set.size();
        set.addAll(collection);
        return ((sizeBefore + collection.size()) == set.size());
    }

    private static List<Character> digitAsCharacter(Integer a) {
        char[] arrOfChars = a.toString().toCharArray();
        List<Character> resultList = new LinkedList<>();
        for (int i = 0; i < arrOfChars.length; i++) {
            resultList.add(arrOfChars[i]);
        }
        return resultList;
    }

    private static boolean isAcceptable(int a, int b) {
        return (isAcceptableLength(a, b) && isHasDiffDigit(a, b));
    }

    public static void main(String[] args) {
        int sum = 0;
        Set<Integer> set = new HashSet<>();
        for (int a = 0; a < 50; a++) {
            for (int b = MAX_LIMIT; b > a; b--) {
                if (isAcceptable(a, b)) {
                    int setSize = set.size();
                    set.add(a * b);
                    if (setSize != set.size()) {
                        sum += a * b;
                        System.out.println(a + " * " + b + " = " + (a * b));
                    }
                }
            }
        }
        System.out.println("Sum is " + sum);
    }
}
