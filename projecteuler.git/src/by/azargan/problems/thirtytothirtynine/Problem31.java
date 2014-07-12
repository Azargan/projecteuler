/*
 *
 * In England the currency is made up of pound, £, and pence, p, and there are
 * eight coins in general circulation:
 *
 * 1p, 2p, 5p, 10p, 20p, 50p, £1 (100p) and £2 (200p).
 *
 * It is possible to make £2 in the following way:
 *
 * 1×£1 + 1×50p + 2×20p + 1×5p + 1×2p + 3×1p
 *
 * How many different ways can £2 be made using any number of coins?
 *
 */

package by.azargan.problems.thirtytothirtynine;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @date   7/12/2014
 * @author Aliaksei_Vihuro
 */
public class Problem31 {
    private static final int FINAL_SUM = 200;

    private static final int ONE_PENCE = 1;
    private static final int TWO_PENCE = 2;
    private static final int FIVE_PENCE = 5;
    private static final int TEN_PENCE = 10;
    private static final int TWENTY_PENCE = 20;
    private static final int FIFTY_PENCE = 50;
    private static final int ONE_POUND = 100;
    private static final int TWO_POUND = 200;

    private static final int[] availableCoins = {
        ONE_PENCE,
        TWO_PENCE,
        FIVE_PENCE,
        TEN_PENCE,
        TWENTY_PENCE,
        FIFTY_PENCE,
        ONE_POUND,
        TWO_POUND
    };

    private static HashMap<Integer, LinkedList<Integer>> rules = new HashMap<>();

    private static void createRule(int coin) {
        int sum = coin;
        List<Integer> replaceCoins = new LinkedList<>();
        for (int i = availableCoins.length - 1; i >= 0; i--) {
            int currentCoin = availableCoins[i];
            if ((sum - currentCoin) > 0) {
                sum -= currentCoin;
                replaceCoins.add(currentCoin);
            }
        }
    }

    public static void main(String[] args) {

    }
}
