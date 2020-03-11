package algorithms_java;
import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;

import junit.framework.TestCase;

public class Tests extends TestCase {
	private int[] nums;
	private int[] expected;
	private int[] empty;

	@Override
	protected void setUp() throws Exception {
		nums = new int[] { 6, 2, 3, 4, 1, 5 };
		expected = new int[] { 1, 2, 3, 4, 5, 6 };
		empty = new int[] {};
	}

	public void testInsertionSorting() {
		// test sorting the empty array
		Sorting.insertionSort(empty);
		assertEquals(0, empty.length);

		// test sorting the non-empty array
		Sorting.insertionSort(nums);
		Assert.assertArrayEquals(expected, nums);
	}

	public void testBubbleSorting() {
		// test sorting the empty array
		Sorting.bubbleSort(empty);
		assertEquals(0, empty.length);

		// test sorting the non-empty array
		Sorting.bubbleSort(nums);
		Assert.assertArrayEquals(expected, nums);
	}

	public void testHeapSorting1() {
		// test sorting the empty array
		Sorting.heapSort1(empty);
		assertEquals(0, empty.length);

		// test sorting the non-empty array
		Sorting.heapSort1(nums);
		Assert.assertArrayEquals(expected, nums);
	}
	
	public void testHeapSorting2() {
		// test sorting the empty array
		Sorting.heapSort2(empty);
		assertEquals(0, empty.length);

		// test sorting the non-empty array
		Sorting.heapSort2(nums);
		Assert.assertArrayEquals(expected, nums);
	}
	
	public void testMerge() {
		// test empty arrays
		int[] nums = {};
		SortingUtils.merge(nums, 1, 2, 3);
		assertArrayEquals(new int[] {}, nums);
		
		// test normal arrays
		nums = new int[] {4, 5, 6, 1, 2, 3};
		SortingUtils.merge(nums, 0, 2, 5);
		assertArrayEquals(expected, nums);
	}
	
	public void testMergeSorting() {
		// test empty arrays
		int[] empty = {};
		Sorting.mergeSort(empty, 1, 2);
		assertArrayEquals(new int[] {}, empty);
		
		// test normal arrays
		Sorting.mergeSort(nums, 0, 5);
		assertArrayEquals(expected, nums);
	}
	
	public void testPartition() {
		int pivotIndex = SortingUtils.partition(nums, 0, 5);
		assertEquals(4, pivotIndex);
	}
	
	public void testQuickSort() {
		// test normal arrays
		Sorting.mergeSort(nums, 0, 5);
		assertArrayEquals(expected, nums);
	}
	
	public void testFibonacciRecursion() {
		int[] expected = { 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144 };
		for (int i = 0; i < expected.length; i++) {
			assertEquals(expected[i], DP.fibonacciRecursion(i));
		}
	}
	
	public void testFibonacciRecursionMemoized() {
		int[] expected = { 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144 };
		for (int i = 0; i < expected.length; i++) {
			assertEquals(expected[i], DP.fibonacciRecursionMemoized(i));
		}
	}
	
	public void testFibonacciIterative() {
		int[] expected = { 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144 };
		for (int i = 0; i < expected.length; i++) {
			assertEquals(expected[i], DP.fibonacciIterative(i));
		}
	}
	
	public void testNumberToWords() {
		long num = 0;
		assertEquals("Zero", Practices.numberToWords(num));
		assertEquals("Zero", Practices.numberToWords2((int) num));
		
		num = 1;
		assertEquals("One", Practices.numberToWords(num));
		assertEquals("One", Practices.numberToWords2((int) num));
		
		num = 10;
		assertEquals("Ten", Practices.numberToWords(num));
		assertEquals("Ten", Practices.numberToWords2((int) num));
		
		num = 11;
		assertEquals("Eleven", Practices.numberToWords(num));
		assertEquals("Eleven", Practices.numberToWords2((int) num));
		
		num = 17;
		assertEquals("Seventeen", Practices.numberToWords(num));
		assertEquals("Seventeen", Practices.numberToWords2((int) num));
		
		num = 20;
		assertEquals("Twenty", Practices.numberToWords(num));
		assertEquals("Twenty", Practices.numberToWords2((int) num));
		
		num = 21;
		assertEquals("Twenty One", Practices.numberToWords(num));
		assertEquals("Twenty One", Practices.numberToWords2((int) num));
		
		num = 30;
		assertEquals("Thirty", Practices.numberToWords(num));
		assertEquals("Thirty", Practices.numberToWords2((int) num));
		
		num = 31;
		assertEquals("Thirty One", Practices.numberToWords(num));
		assertEquals("Thirty One", Practices.numberToWords2((int) num));
		
		num = 100;
		assertEquals("One Hundred", Practices.numberToWords(num));
		assertEquals("One Hundred", Practices.numberToWords2((int) num));
		
		num = 101;
		assertEquals("One Hundred One", Practices.numberToWords(num));
		assertEquals("One Hundred One", Practices.numberToWords2((int) num));
		
		num = 1000;
		assertEquals("One Thousand", Practices.numberToWords(num));
		assertEquals("One Thousand", Practices.numberToWords2((int) num));
		
		num = 1001;
		assertEquals("One Thousand One", Practices.numberToWords(num));
		assertEquals("One Thousand One", Practices.numberToWords2((int) num));
		
		num = 9990;
		assertEquals("Nine Thousand Nine Hundred Ninety", Practices.numberToWords(num));
		assertEquals("Nine Thousand Nine Hundred Ninety", Practices.numberToWords2((int) num));
		
		num = 9999;
		assertEquals("Nine Thousand Nine Hundred Ninety Nine", Practices.numberToWords(num));
		assertEquals("Nine Thousand Nine Hundred Ninety Nine", Practices.numberToWords2((int) num));
		
		num = 101001;
		assertEquals("One Hundred One Thousand One", Practices.numberToWords(num));
		
		num = 10000000010L;
		assertEquals("Ten Billion Ten", Practices.numberToWords(num));
		
		num = 1001888888888L;
		assertEquals("One Trillion One Billion Eight Hundred Eighty Eight Million Eight Hundred Eighty Eight Thousand Eight Hundred Eighty Eight", Practices.numberToWords(num));
	}
	
	public void testKthSmallest1() {
		assertEquals(3, Practices.kthSmallest1(nums, 3));
		assertEquals(6, Practices.kthSmallest1(nums, 6));
	}
	
	public void testMoveZeros1() {
		List<Integer> nums = Arrays.asList(0);
		Assert.assertEquals(Arrays.asList(0), Practices.moveZeros1(nums));
		
		nums = Arrays.asList(1, 0);
		Assert.assertEquals(Arrays.asList(0, 1), Practices.moveZeros1(nums));
		
		nums = Arrays.asList(1, 2, 3, 0, 0);
		Assert.assertEquals(Arrays.asList(1, 0, 0, 2, 3), Practices.moveZeros1(nums));
		
		nums = Arrays.asList(1, 2, 0, 3, 0, 4, 0, 5);
		Assert.assertEquals(Arrays.asList(1, 2, 0, 0, 0, 3, 4, 5), Practices.moveZeros1(nums));
	}
	
	public void testMoveZeros2() {
		List<Integer> nums = Arrays.asList(0);
		Practices.moveZeros2(nums);
		Assert.assertEquals(Arrays.asList(0), nums);
		
		nums = Arrays.asList(1, 0);
		Practices.moveZeros2(nums);
		Assert.assertEquals(Arrays.asList(0, 1), nums);
		
		nums = Arrays.asList(1, 2, 3, 0, 0);
		Practices.moveZeros2(nums);
		Assert.assertEquals(Arrays.asList(1, 0, 0, 2, 3), nums);
		
		nums = Arrays.asList(1, 2, 0, 3, 0, 4, 0, 5);
		Practices.moveZeros2(nums);
		Assert.assertEquals(Arrays.asList(1, 2, 0, 0, 0, 3, 4, 5), nums);
		
		nums = Arrays.asList(0, 0, 0, 0);
		Practices.moveZeros2(nums);
		Assert.assertEquals(Arrays.asList(0, 0, 0, 0), nums);
		
		nums = Arrays.asList(0, 1, 0, 2, 0, 3);
		Practices.moveZeros2(nums);
		Assert.assertEquals(Arrays.asList(1, 0, 0, 0, 2, 3), nums);
	}
	
	public void testFindTownJudge() {
		int N = 2;
		int[][] trust = { { 1, 2 } };
		assertEquals(2, Practices.findTownJudge(N, trust));
		assertEquals(2, Practices.findTownJudge2(N, trust));
		
		N = 1;
		trust = new int[][]{};
		assertEquals(1, Practices.findTownJudge(N, trust));
		assertEquals(1, Practices.findTownJudge2(N, trust));
		
		N = 3;
		trust = new int[][]{ { 1, 3 }, {2, 3} };
		assertEquals(3, Practices.findTownJudge(N, trust));
		assertEquals(3, Practices.findTownJudge2(N, trust));
		
		N = 3;
		trust = new int[][]{ { 1, 2 }, {2, 3} };
		assertEquals(-1, Practices.findTownJudge(N, trust));
		assertEquals(-1, Practices.findTownJudge2(N, trust));
		
		N = 3;
		trust = new int[][]{ { 1, 3 }, {2, 3}, {3, 1} };
		assertEquals(-1, Practices.findTownJudge(N, trust));
		assertEquals(-1, Practices.findTownJudge2(N, trust));
		
		N = 4;
		trust = new int[][]{ { 1, 3 }, {2, 4}, {2, 3}, {2, 4}, {4, 3} };
		assertEquals(3, Practices.findTownJudge(N, trust));
		assertEquals(3, Practices.findTownJudge2(N, trust));
	}
	
	public void testGardenNoAdj() {
		int N = 1;
		int[][] path = {};
		assertArrayEquals(new int[] {1}, Practices.gardenNoAdj1(N, path));
		
		N = 3;
		path = new int[][]{ { 1, 2 }, {2, 3}, {3, 1} };
		assertArrayEquals(new int[] {1, 2, 3}, Practices.gardenNoAdj1(N, path));
		
		N = 4;
		path = new int[][]{ { 1, 2 }, {3, 4} };
		assertArrayEquals(new int[] {1, 2, 1, 2}, Practices.gardenNoAdj1(N, path));

		N = 4;
		path = new int[][]{ { 1, 2 }, {2, 3}, {3, 4}, {4, 1}, {1, 3}, {2, 4} };
		assertArrayEquals(new int[] {1, 2, 3, 4}, Practices.gardenNoAdj1(N, path));
	}
}
