package by.azargan.problems.onetonine;

public class Problem4 {
	public static boolean isPalindrom(Integer number) {
		String strNumber = number.toString();

		for (int i = 0; i <= (strNumber.length() / 2); i++) {
			if (strNumber.charAt(i) != strNumber.charAt(strNumber.length() - i - 1)) {
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String main[]) {
		int maxPolindrom = 0;
		for (int i = 999; i > 99; i--) {
			for (int j = 999; j > 99; j--) {
				Integer number = i * j;
				if (isPalindrom(number) && (maxPolindrom < number)) {
					maxPolindrom = number;
				}
			}
		}
		System.out.println("Max Polindrom is " + maxPolindrom);
	}
}
