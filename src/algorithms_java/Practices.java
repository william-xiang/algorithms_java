package algorithms_java;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Collectors;

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
					if (currentDigit != 0 || num == 0) {
						result.add(singleDigits[currentDigit]);
					}
					if (nextDigit >= 2) {
						result.add(multiplesOfTen[nextDigit - 2]);
					}
				}
				k += 2;
				num = num / 100;
			} else {
				if (currentDigit != 0 || num == 0) {
					result.add("Hundred");
					result.add(singleDigits[currentDigit]);
				}
				k++;
				num = num / 10;
			}
		} while (num > 0);
		
		return joinString(result);
	}
	
	/**
	 * join the strings in the list using a single space as delimiter by the reversing order
	 * @param strs
	 * @return
	 */
	public static String joinString(List<String> strs) {
		Collections.reverse(strs);
		StringJoiner sj = new StringJoiner(" ");
		strs.forEach(str -> sj.add(str));
		
		return sj.toString();
	}
	
	/**
	 * The numbers to written out in words are One, Two, Three, Four, Five. 
	 * Given a number, you have to write it in words.
	 * Input is in range [0, 9999]
	 * 
	 * The difference between this one and the previous practice is that there is only one group of three digits,
	 * so we don't need to consider the scenarios like, twenty two thousand. This makes the question much easier.
	 * And also the range of int is good enough for the input.
	 * 
	 * @param num
	 * @return
	 */
	public static String numberToWords2(int num) {
		String[] lessThan20 = { "Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
				"Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen" };
		String[] multiplesOfTen = { "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety", "Hundred" };

		List<String> result = new ArrayList<>(); // this is for building the result string

		if (num == 0) {
			result.add(lessThan20[0]);
		} else {
			// handle the first two digits
			int firstTwoDigits = num % 100;
			if (firstTwoDigits > 0 && firstTwoDigits < 20) {
				result.add(lessThan20[firstTwoDigits]);
			} else {
				int firstDigit = num % 10;
				int secondDigit = num / 10 % 10;
				
				if (firstDigit > 0) {
					result.add(lessThan20[firstDigit]);
				}
				if (secondDigit > 0) {
					result.add(multiplesOfTen[secondDigit - 2]);
				}
			}
			
			// handle the third digit
			int thirdDigit = num / 100 % 10;
			if (thirdDigit > 0) {
				if (thirdDigit > 0) {
					result.add("Hundred");
					result.add(lessThan20[thirdDigit]);
				}
			}
			
			// handle the fourth digit
			int fourthDigit = num / 1000 % 10;
			if (fourthDigit > 0) {
				if (fourthDigit > 0) {
					result.add("Thousand");
					result.add(lessThan20[fourthDigit]);
				}
			}
		}
		
		return joinString(result);
	}
	
	/**
	 * Given an array and a number k where k is smaller than size of array, we need to find the k’th smallest element in the given array. It is given that ll array elements are distinct.
	 * Examples:
	 * Input: arr[] = {7, 10, 4, 3, 20, 15}
	 * k = 3
	 * Output: 7
	 * 
	 * Input: arr[] = {7, 10, 4, 3, 20, 15}
	 * k = 4
	 * Output: 10
	 * 
	 * Method 1
	 * A simple solution is to sort the given array using a O(nlogn) sorting algorithm 
	 * like Merge Sort, Heap Sort, etc and return the element at index k-1 in the sorted array.
	 * Time Complexity of this solution is O(nlogn) since the array indexing is constant time
	 * @param nums
	 * @param k
	 * @return
	 */
	public static int kthSmallest1(int[] nums, int k) {
		// this sort algorithm using dual-pivot quick sort implementation
		// time complexity is O(nlogn) in most cases
		// the default order is ascending
		Arrays.sort(nums);
		return nums[k - 1];
	}
	
	/**
	 * move all the zeros to the center of the array
	 * time complexity: O(n)
	 * space complexity: O(n)
	 * 
	 * @param nums
	 * @return
	 */
	public static List<Integer> moveZeros1(List<Integer> nums) {
		int len = nums.size();
		Long numOfZeros = nums.stream().filter(num -> num == 0).collect(Collectors.counting());
		int numOfNonZeros = (int) (len - numOfZeros);
		int numOfLeft = numOfNonZeros / 2;
		int numOfRight = numOfNonZeros - numOfLeft;
		List<Integer> result = new ArrayList<Integer>();
		
		// initialize the elements of new list to be zeros
		for (int i = 0; i < len; i++) {
			result.add(0);
		}
		
		// find and set all the elements in the left part
		for (int i = 0, leftIndex = 0; leftIndex < numOfLeft && i < len; i++) {
			if (leftIndex < numOfLeft && nums.get(i) != 0) {
				result.set(leftIndex, nums.get(i));
				leftIndex++;
			}
		}
		
		// find and set all the elements in the right part
		for (int j = len - 1, rightIndex = len - 1; j >= 0; j--) {
			if (rightIndex > len - numOfRight - 1 && nums.get(j) != 0) {
				result.set(rightIndex, nums.get(j));
				rightIndex--;
			}
		}
		
		return result;
	}
	
	/**
	 * move all the zeros to the center of the array
	 * in-place method
	 * time complexity: O(n)
	 * space complexity: O(1)
	 * 
	 * @param nums
	 * @return
	 */
	public static void moveZeros2(List<Integer> nums) {
		int len = nums.size();
		int mid = (len - 1) / 2;
		// indices of zero regions
		int leftIndex = mid;
		int rightIndex = mid - 1;
		
		// handle left and right parts independently
		// move the zeros to the center
		for (int i = 0; i <= mid; i++) {
			if (nums.get(i) == 0) {
				if (leftIndex == mid) {
					leftIndex = i;
				}
			} else {
				if (leftIndex != mid) {
					int tmp = nums.get(leftIndex);
					nums.set(leftIndex, nums.get(i));
					nums.set(i, tmp);
					leftIndex++;
				}
			}
		}
		
		for (int i = len - 1; i > mid - 1; i--) {
			if (nums.get(i) == 0) {
				if (rightIndex == mid - 1) {
					rightIndex = i;
				}
			} else {
				if (rightIndex != mid - 1) {
					int tmp = nums.get(rightIndex);
					nums.set(rightIndex, nums.get(i));
					nums.set(i, tmp);
					rightIndex--;
				}
			}
		}
		
		// adjust the position of zero region
		int numOfNoneZeros = len - (rightIndex - leftIndex + 1);
		int actualLeftIndex = numOfNoneZeros / 2;
		int actualRightIndex = len - (numOfNoneZeros - actualLeftIndex) - 1;
		if (actualLeftIndex < leftIndex) {
			// shift zero region to the left
			int diff = leftIndex - actualLeftIndex;
			for (int i = 0; i < diff; i++) {
				int tmp  = nums.get(--leftIndex);
				nums.set(leftIndex, nums.get(rightIndex));
				nums.set(rightIndex--, tmp);
			}
		}
		if (actualRightIndex > rightIndex) {
			// shift zero region to the right
			int diff = actualRightIndex - rightIndex;
			for (int i = 0; i < diff; i++) {
				int tmp = nums.get(++rightIndex);
				nums.set(rightIndex, nums.get(leftIndex));
				nums.set(leftIndex--, tmp);
			}
		}
	}
	
	/**
	 * Given two arrays, write a function to compute their intersection.
	 * Example 1:
	 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
	 * Output: [2]
	 * 
	 * Example 2:
	 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
	 * Output: [9,4]
	 * 
	 * this method using hash map to get all the common elements
	 * time complexity: O(m + n)
	 * space complexity: O(max(m, n))
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public static int[] findIntersection(int[] nums1, int[] nums2) {
		Map<Integer, Integer> nums = new HashMap<>();
		
		// get all the numbers in nums1
		for (int i : nums1) {
			if (!nums.containsKey(i)) {
				nums.put(i, 1);
			}
		}
		
		// get all the numbers in nums2
		for (int i : nums2) {
			if (nums.containsKey(i)) {
				nums.put(i, nums.get(i) + 1);
			}
		}
		
		// get all the common elements
		int numOfCommons = 0;
		for (int value : nums.values()) {
			if (value > 1) {
				numOfCommons++;
			}
		}
		
		int[] result = new int[numOfCommons];
		int index = 0;
		for (int i : nums.keySet()) {
			if (nums.get(i) > 1) {
				result[index] = i;
				index++;
			}
		}
		
		return result;
	}
	/**
	 * In a town, there are N people labeled from 1 to N.  
	 * There is a rumor that one of these people is secretly the town judge.
	 * 
	 * If the town judge exists, then:
	 * 1) The town judge trusts nobody.
	 * 2) Everybody (except for the town judge) trusts the town judge.
	 * There is exactly one person that satisfies properties 1 and 2.
	 * 
	 * You are given trust, an array of pairs trust[i] = [a, b] representing that the person labeled a trusts the person labeled b.
	 * If the town judge exists and can be identified, return the label of the town judge.  Otherwise, return -1.
	 * 
	 * We can think of each person as the vertex of a graph, and the pair of trust as the edge of the graph
	 * Get the in-degree and out-degree of all the vertices, check if there is any in-degree is equal to N - 1
	 * the corresponding out-degree should be 0
	 * 
	 * @param N
	 * @param trust
	 * @return
	 */
	public static int findTownJudge(int N, int[][] trust) {
		Map<Integer, Integer> inDegrees = new HashMap<>();
		Map<Integer, Integer> outDegrees = new HashMap<>();
		int nums = trust.length;
		int maxInDegree = 0;
		int vetexWithMaxInDegree = 1;
		
		for (int i = 0; i < nums; i++) {
			int a = trust[i][0];
			int b = trust[i][1];
			int inDegree = 0;
			int outDegree = 0;
			
			outDegree = outDegrees.containsKey(a) ? outDegrees.get(a) + 1 : 1;
			inDegree = inDegrees.containsKey(b) ? inDegrees.get(b) + 1 : 1;
			outDegrees.put(a, outDegree);
			inDegrees.put(b, inDegree);
			maxInDegree = Math.max(maxInDegree, inDegree);
			vetexWithMaxInDegree = inDegree == maxInDegree ? b : vetexWithMaxInDegree;
		}
		
		if (maxInDegree == N - 1 && !outDegrees.containsKey(vetexWithMaxInDegree)) {
			return vetexWithMaxInDegree;
		} else {
			return -1;
		}
	}
	/**
	 * Problem with previous implementation is that:
	 * even though search, insert and get for hashmap is O(1) in best cases, the worst is still O(n)
	 * We can use array indexing to replace it, the time complexity of which is always O(1)
	 *  
	 * @param N
	 * @param trust
	 * @return
	 */
	public static int findTownJudge2(int N, int[][] trust) {
		int[] degree = new int[N + 1];
		
		for (int[] i : trust) {
			// i[0] represents vertex with out edge
			degree[i[0]]--;
			// i[1] represents vertex with in edge
			degree[i[1]]++;
		}
		
		for (int i = 1; i <= N; i++) {
			if (degree[i] == N - 1) {
				return i;
			}
		}
		
		return -1;
	}
	
	/**
	 * You have N gardens, labeled 1 to N.  In each garden, you want to plant one of 4 types of flowers.
	 * paths[i] = [x, y] describes the existence of a bidirectional path from garden x to garden y.
	 * Also, there is no garden that has more than 3 paths coming into or leaving it.
	 * Your task is to choose a flower type for each garden such that, for any two gardens connected by a path, they have different types of flowers.
	 * Return any such a choice as an array answer, where answer[i] is the type of flower planted in the (i+1)-th garden.  
	 * The flower types are denoted 1, 2, 3, or 4.  It is guaranteed an answer exists.
	 * 
	 * first get the adjacency matrix for the graph
	 * then try to assign type of flowers to each vertex by check if the vertex in the adjacency matrix already been assigned that type
	 * 
	 * time complexity: O(N^2)
	 * space complexity: O(N^2)
	 * 
	 * @param N
	 * @param paths
	 * @return
	 */
	public static int[] gardenNoAdj1(int N, int[][] paths) {
		int[] answer = new int[N];
		
		// get the adjacency matrix
		boolean[][] adjMatrix = new boolean[N][N];
		for (int[] i : paths) {
			int a = i[0];
			int b = i[1];
			adjMatrix[a - 1][b - 1] = true;
			adjMatrix[b - 1][a - 1] = true;
		}
		
		for (int i = 0; i < N; i++) {
			List<Integer> types = new ArrayList<>(Arrays.asList(new Integer[] {1, 2, 3, 4}));
			for (int j = 0; j < N - 1; j++) {
				if (adjMatrix[i][j] && answer[j] != 0) {
					types.remove(new Integer(answer[j]));
				}
			}
			answer[i] = types.get(0);
		}
		
		return answer;
	}
}
