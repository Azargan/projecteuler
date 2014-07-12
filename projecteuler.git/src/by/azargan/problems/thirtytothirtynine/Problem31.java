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
    private static Map<Integer, Integer> coins = new HashMap<>();

    private static int calcCurrentSum() {
        int sum = 0;
        for (Map.Entry<Integer, Integer> coin : coins.entrySet()) {
            sum += coin.getKey() * coin.getValue();
        }
        return sum;
    }

    private static int changeCoins() {
        int biggestCoin = findBiggestCoin();
        int possibleWays = 1;
        while (biggestCoin != ONE_PENCE) {
            if (replaceCoins(biggestCoin) &&
                    calcCurrentSum() == FINAL_SUM) {
                possibleWays++;
            }
            biggestCoin = findBiggestCoin();
        }
        return possibleWays;
    }

    private static boolean replaceCoins(int coin) {
        int coinIndex = getCoinIndex(coin);
        if (coinIndex < 1) {        // if it's pence or not found at all
            return false;
        }
        int smallCoin = availableCoins[coinIndex - 1];
        if ((coin % smallCoin) == 0) {
            coins.put(coin, coins.get(coin) - 1);
            coins.put(smallCoin, coins.get(smallCoin) + coin / smallCoin);
            return true;
        }
        if (getCoinIndex(smallCoin) < 1) {
            return false;
        }
        int verySmallCoin = availableCoins[getCoinIndex(smallCoin) - 1];
        coins.put(coin, coins.get(coin) - 1);
        coins.put(smallCoin, coins.get(smallCoin) + coin / smallCoin);
        coins.put(verySmallCoin, coins.get(verySmallCoin) + coin % smallCoin);
        return true;
    }

    private static int getCoinIndex(int coin) {
        int coinIndex = -1;
        for (int i = 0; i < availableCoins.length; i++) {
            if (coin == availableCoins[i]) {
                coinIndex = i;
            }
        }
        return coinIndex;
    }

    private static int findBiggestCoin() {
        for (int i = availableCoins.length - 1; i >= 0; i--) {
            if (coins.get(availableCoins[i]) > 0) {
                return availableCoins[i];
            }
        }
        return -1;
    }

    private static void fillStartCoins() {
        for (int i = 0; i < availableCoins.length; i++) {
            coins.put(availableCoins[i], 0);
        }
    }

    public static void main(String[] args) {
        fillStartCoins();
        coins.put(TWO_POUND, 1);
        System.out.println("Answer is : " + changeCoins());
    }
}
