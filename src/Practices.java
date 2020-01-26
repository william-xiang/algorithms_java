import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;

/**
 * This class includes all the practices in Leetcode, Hackerrank, and other sources.
 * 
 * @author WILLIAMXiang
 *
 */
public class Practices {
	/**
	 * The numbers to written out in words are One, Two, Three, Four, Five. 
	 * First character of each word will be capital letter for example: 
	 * 104.382.426.112 is
	 * One Hundred Four Billion Three Hundred Eighty Two Million Four Hundred Twenty
	 * Six Thousand One Hundred Twelve 
	 * 
	 * Given a number, you have to write it in words.
	 * Input is in range [0, 10^12]
	 * 
	 * @param num
	 * @return
	 */
	public static String numberToWords(long num) {
		// since the range of the input is beyond the range of int, have to use long here
		String[] singleDigits = { "Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten" };
		String[] twoDigits = { "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen",
				"Nineteen", "Twenty" };
		String[] multiplesOfTen = { "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety", "Hundred" };
		String[] powersOfTen = { "Thousand", "Million", "Billion", "Trillion" };

		int i = 0; // this is for each group which contains at most three digits
		int j = 0; // this is each digit in each three digit group
		int k = 0; // this is the current digit in the whole number
		List<String> result = new ArrayList<>(); // this is for building the result string

		do {
			i = k / 3;
			j = k % 3;
			int currentDigit = (int) (num % 10);

			// this is for powers of 10
			if (j == 0 && i != 0) {
				int thirdDigit = (int) (num % 1000);
				if (thirdDigit != 0) {
					result.add(powersOfTen[i - 1]);
				}
			}

			// this is first and second digits in each unit
			if (j == 0) {
				// look ahead one
				int nextDigit = (int) (num / 10 % 10);
				if (nextDigit == 1) {
					result.add(twoDigits[currentDigit]);
				} else {
					if (isAdded(currentDigit, num)) {
						result.add(singleDigits[currentDigit]);
					}
					if (nextDigit != 0) {
						result.add(multiplesOfTen[nextDigit - 2]);
					}
				}
				k += 2;
				num = num / 100;
			} else {
				if (isAdded(currentDigit, num)) {
					result.add("Hundred");
					result.add(singleDigits[currentDigit]);
				}
				k++;
				num = num / 10;
			}
		} while (num > 0);
		
		return joinString(result);
	}
	
	public static boolean isAdded(int currentDigit, double num) {
		return currentDigit != 0 || num == 0;
	}
	
	public static String joinString(List<String> strs) {
		Collections.reverse(strs);
		StringJoiner sj = new StringJoiner(" ");
		strs.forEach(str -> sj.add(str));
		
		return sj.toString();
	}
}
