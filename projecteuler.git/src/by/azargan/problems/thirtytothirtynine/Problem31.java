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

import java.util.LinkedList;
import java.util.List;

/**
 * @date   7/12/2014
 * @author Aliaksei_Vihuro
 */
public class Problem31 {
    private static void printCoins(List<Coin> coins) {
        coins.stream().forEach((coin) -> {
            System.out.print(coin.toString() + ";");
        });
        System.out.println();
    }

    public static void main(String[] args) {
        List<Coin> coins = new LinkedList<>();
        coins.add(Coin.TEN_PENCE);
        int count = 0;
        int countOfCoinsBefore = 0;
        int countOfCoinsNow = 1;
        while (countOfCoinsBefore != countOfCoinsNow) {
            count++;
            coins.addAll(Coin.getBiggestCoin(coins).exchangeCoin());
            coins.remove(Coin.getBiggestCoin(coins));
            countOfCoinsBefore = countOfCoinsNow;
            countOfCoinsNow = coins.size();
            printCoins(coins);
        }
        System.out.println("Answer is " + count);
    }
}

enum Coin {
    ONE_PENCE(1),
    TWO_PENCE (2),
    FIVE_PENCE (5),
    TEN_PENCE (10),
    TWENTY_PENCE (20),
    FIFTY_PENCE (50),
    ONE_POUND (100),
    TWO_POUND (200);

    Coin(int weight) {
        this.weight = weight;
    }

    private final int weight;

    /**
     * Get the value of weight
     *
     * @return the value of weight
     */
    public int getWeight() {
        return weight;
    }

    public List<Coin> exchangeCoin() {
        return exchangeCoin(this);
    }

    public List<Coin> exchangeCoin(Coin coin) {
        List<Coin> exchange = new LinkedList<>();
        int needToExchange = coin.getWeight();
        Coin currentCoin = coin;
        while (needToExchange > 0) {
            List<Coin> lessCoins = getCoinsLessThan(currentCoin);
            Coin excangeCoin;
            if (lessCoins.isEmpty()) {
                excangeCoin = currentCoin;
            } else {
                excangeCoin = getBiggestCoin(lessCoins);
            }
            needToExchange -= excangeCoin.getWeight();
            exchange.add(excangeCoin);
            if (needToExchange < excangeCoin.getWeight()) {
                currentCoin = excangeCoin;
            }
        }
        return exchange;
    }

    public static Coin getBiggestCoin(List<Coin> coins) {
        if (coins.isEmpty()) {
            throw new RuntimeException("Can't find biggest coin in empty list");
        }

        Coin coin = null;
        int maxWeight = -1;
        for (Coin currentCoin : coins) {
            if (currentCoin.getWeight() > maxWeight) {
                maxWeight = currentCoin.getWeight();
                coin = currentCoin;
            }
        }

        if (coin == null) {
            throw new RuntimeException("Can't find biggest coin. It's null :(");
        }

        return coin;
    }

    public static List<Coin> getCoinsLessThan(Coin coin) {
        if (coin == null) {
            throw new RuntimeException("They can't be less than null");
        }

        Coin[] availableCoins = values();
        List<Coin> coins = new LinkedList<>();
        for (Coin currentCoin : availableCoins) {
            if (coin.getWeight() > currentCoin.getWeight()) {
                coins.add(currentCoin);
            }
        }

        return coins;
    }

    @Override
    public String toString() {
        return ((this.getWeight() / 100) == 0)
                ? this.getWeight() + "p"
                : (this.getWeight() / 100) + "£";
    }

}