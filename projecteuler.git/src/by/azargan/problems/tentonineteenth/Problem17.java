/*
 * If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
 * 
 * If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?
 * 
 * NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) contains 23 letters and 115 (one hundred and fifteen) contains 20 letters.
 * The use of "and" when writing out numbers is in compliance with British usage.
 * 
 * SOLVED: answer is 21124
 * 
 */

package by.azargan.problems.tentonineteenth;

public class Problem17 {
	public static final int ONE = 3;
	public static final int TWO = 3;
	public static final int THREE = 5;
	public static final int FOOR = 4;
	public static final int FIVE = 4;
	public static final int SIX = 3;
	public static final int SEVEN = 5;
	public static final int EIGHT = 5;
	public static final int NINE = 4;
	public static final int TEN = 3;
	public static final int ELEVEN = 6;
	public static final int TWELVE = 6;
	public static final int THIRTEEN = 8;
	public static final int FOURTEEN = 8;
	public static final int FIFTEEN = 7;
	public static final int SIXTEEN = 7;
	public static final int SEVENTEEN = 9;
	public static final int EIGHTEEN = 8;
	public static final int NINETEEN = 8;
	public static final int TWENTY = 6;
	public static final int THIRTY = 6;
	public static final int FORTY = 5;
	public static final int FIFTY = 5;
	public static final int SIXTY = 5;
	public static final int SEVENTY = 7;
	public static final int EIGHTY = 6;
	public static final int NINETY = 6;
	public static final int HUNDRED = 7;
	public static final int THOUSAND = 8;
	public static final int AND = 3;
	
	public static final int[] SIMPLE_NUMBERS = {ONE, TWO, THREE, FOOR, FIVE, SIX, SEVEN, EIGHT, NINE};
	public static final int[] TEEN_NUMBERS = {TEN, ELEVEN, TWELVE, THIRTEEN, FOURTEEN, FIFTEEN, SIXTEEN, SEVENTEEN, EIGHTEEN, NINETEEN};
	public static final int[] DOZEN_NUMBERS = {TWENTY, THIRTY, FORTY, FIFTY, SIXTY, SEVENTY, EIGHTY, NINETY};

	public static int getSumOfArraysItems(int[] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		return sum;
	}
	
	public static void main(String[] argv) {
		int sumOfSimpleNumbers = getSumOfArraysItems(SIMPLE_NUMBERS);
		int sumOfTeenNumbers = getSumOfArraysItems(TEEN_NUMBERS);
		int sumOfDozenNumbers = getSumOfArraysItems(DOZEN_NUMBERS);
		int resultSum = 0;
		
		int sumBeforeHundred =   sumOfSimpleNumbers
							   + sumOfTeenNumbers
							   + sumOfDozenNumbers * (SIMPLE_NUMBERS.length + 1) + sumOfSimpleNumbers * DOZEN_NUMBERS.length;
		
		int sumWithHundreds = 0;
		for (int i = 0; i < SIMPLE_NUMBERS.length; i++) {
			sumWithHundreds += (SIMPLE_NUMBERS[i] + HUNDRED + AND) * 99
							 + SIMPLE_NUMBERS[i] + HUNDRED
							 + sumBeforeHundred;
		}
		
		resultSum = sumBeforeHundred + sumWithHundreds + SIMPLE_NUMBERS[0] + THOUSAND;
		System.out.println(resultSum);
	}
	
}
