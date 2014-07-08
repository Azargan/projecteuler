/*
 * Work out the first ten digits of the sum of the following one-hundred 50-digit numbers.
 * in file: d:\src\eclipse_workspace\ProjectEuler\src\by\azargan\problems\forProblem13.txt
 */

package by.azargan.problems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Problem13 {
	public static List<String> numbers;
	final static String FILE_PATH = "D:\\src\\eclipse_workspace\\ProjectEuler\\src\\by\\azargan\\problems\\forProblem13.txt";

	public static List<String> readNumbersFromFile() {
		BufferedReader br = null;
		List<String> list = new LinkedList<String>();
		try {
			br = new BufferedReader(new FileReader(FILE_PATH));
			String line = br.readLine();

			while (line != null) {
				list.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			br.close();
		} catch(Exception e) {
			
		}
		return list;
	}

	public static void main(String[] args) {
		BufferedReader br = null;
		Double sum = 0.0;
		try {
			br = new BufferedReader(new FileReader(FILE_PATH));
			String line = br.readLine();

			while (line != null) {
				sum += Double.valueOf(line);
				line = br.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			br.close();
		} catch(Exception e) {
			
		}
		System.out.println(sum.toString());
	}
}
