/*
 * A permutation is an ordered arrangement of objects. For example, 3124 is one
 * possible permutation of the digits 1, 2, 3 and 4. If all of the permutations
 * are listed numerically or alphabetically, we call it lexicographic order.
 * The lexicographic permutations of 0, 1 and 2 are:
 * 
 * 012   021   102   120   201   210
 * 
 * What is the millionth lexicographic permutation of the digits 
 * 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?
 * 
 * Created: 06.26.2014
 * @Author: Azargan
 * 
 * Answer is 2783915460
 * 
 */

package by.azargan.problems.twentytotwentynine;

public class Problem24 {
	private int[] alphabet = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
	
	private void printPermutationN(int number) {
		int[] buf = alphabet.clone();
		
		number--; // Because first value it's value too
		int alphabetLength = alphabet.length;
		int index = 0, currentIndex = 1;
		
		if (getPermutationCount(alphabetLength) < number) {
			System.out.println("Current alphabet is not enougth!");
			return;
		}
		
		while (index < alphabetLength - 1) {
			if (number >= (getPermutationCount(alphabetLength - index - 1))) {
				number -= getPermutationCount(alphabetLength - index - 1);
				switchLetters(index, currentIndex++);
				continue;
			} else {
				index++;
				currentIndex = index + 1;
			}
		}
		
		showAlphabet();
		alphabet = buf.clone();
	}
		
	private int getPermutationCount(int alphabetLength) {
		if (alphabetLength < 1) {
			return 0;
		}
		int permutationCount = 1;
		while (alphabetLength != 1) {
			permutationCount *= alphabetLength--;
		}
		return permutationCount;
	}
	
	private void switchLetters(int first, int second) {
		int buf = alphabet[first];
		alphabet[first] = alphabet[second]; 
		alphabet[second] = buf;
	}
		
	private void showAlphabet() {
		for (int i = 0; i < alphabet.length; i++) {
			System.out.print(alphabet[i]);
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		Problem24 problem = new Problem24();
		problem.printPermutationN(1000000);
	}
}
