package by.azargan.problems.onetonine;

import java.util.ArrayList;

public class Problem3 {
	final static long NUMBER = 600851475143L;
	public static ArrayList<Integer> primeSec;
	
	private static ArrayList<Integer> findPrimeSec(Integer limit) {
		ArrayList<Integer> sec = new ArrayList<>();
		for (int i = 2; i <= limit; i ++) {
			sec.add(i);
		}
		for (int i = 2; i <= limit; i++) {
			for (int j = 0; j < sec.size(); j++) {
				if ((sec.get(j) % i) == 0) {
					sec.remove(j);
				}
			}
		}
		return sec;
	}
	
	private static ArrayList<Integer> findPrimeFactors(long number) {
		ArrayList<Integer> primeFactors = new ArrayList<Integer>();
		while (number != 1) {
			for (int i = 2; i <= number; i++) {
				if ((number % i) == 0) {
					number /= i;
					if (!primeFactors.contains(i)) {
						primeFactors.add(i);
					}
					break;
				}
			}
		}
		return primeFactors;
	}
	
	private static Integer getMaxPrimeFactor() {
		/*for (int i = primeSec.size(); i > 2; i--) {
			if ((NUMBER % primeSec.get(i)) == 0) {
				return primeSec.get(i);
			}
		}
		return 0;*/
		return primeSec.get(primeSec.size()-1);
	}
	
	public static void main(String[] argv) {
		primeSec = findPrimeSec(1000);
		primeSec = findPrimeFactors(NUMBER);
		System.out.println("Max prime factor is " + getMaxPrimeFactor());
	}
}
