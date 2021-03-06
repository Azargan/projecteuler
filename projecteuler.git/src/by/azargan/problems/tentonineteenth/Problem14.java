/*
 *
 * The following iterative sequence is defined for the set of positive integers:
 * n → n/2 (n is even)
 * n → 3n + 1 (n is odd)
 * 
 * Using the rule above and starting with 13, we generate the following sequence:
 * 13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
 *
 * It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms.
 * Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.
 * 
 * Which starting number, under one million, produces the longest chain?
 * NOTE: Once the chain starts the terms are allowed to go above one million.
 * 
 */


//NOT SOLVED BY BRUTFORSE IN 1 HOUR!
package by.azargan.problems.tentonineteenth;

import java.util.HashMap;
import java.util.Map;

public class Problem14 {
	public static int LIMIT = 1000000; // One million
	
	public static void main(String[] args) {
		int maxChain = 0;
		int number = 0;
		Map<Integer, Integer> cache = new HashMap<Integer, Integer>();
		for (int i = 2; i < LIMIT; i++) {
			int currentNumber = i;
			int currentChain = 1;
			while (currentNumber != 1) {
				if (cache.containsKey(currentNumber)) {
					currentChain += cache.get(currentNumber);
					break;
				}
				if ((currentNumber % 2) == 0) {
					currentNumber /= 2;
				} else {
					currentNumber = (currentNumber * 3) + 1;
				}
			currentChain++;
			}
			cache.put(i, currentChain);
			if (currentChain > maxChain) {
				maxChain = currentChain;
				number = i;
			}
		}
		System.out.println("Max chain is :" + maxChain);
		System.out.println("Number with max chain is :" + number);
	}

}
