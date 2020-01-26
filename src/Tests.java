import static org.junit.Assert.assertArrayEquals;

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
		
		num = 1;
		assertEquals("One", Practices.numberToWords(num));
		
		num = 10;
		assertEquals("Ten", Practices.numberToWords(num));
		
		num = 11;
		assertEquals("Eleven", Practices.numberToWords(num));
		
		num = 17;
		assertEquals("Seventeen", Practices.numberToWords(num));
		
		num = 20;
		assertEquals("Twenty", Practices.numberToWords(num));
		
		num = 21;
		assertEquals("Twenty One", Practices.numberToWords(num));
		
		num = 30;
		assertEquals("Thirty", Practices.numberToWords(num));
		
		num = 31;
		assertEquals("Thirty One", Practices.numberToWords(num));
		
		num = 100;
		assertEquals("One Hundred", Practices.numberToWords(num));
		
		num = 101;
		assertEquals("One Hundred One", Practices.numberToWords(num));
		
		num = 1000;
		assertEquals("One Thousand", Practices.numberToWords(num));
		
		num = 1001;
		assertEquals("One Thousand One", Practices.numberToWords(num));
		
		num = 101001;
		assertEquals("One Hundred One Thousand One", Practices.numberToWords(num));
		
		num = 10000000010L;
		assertEquals("Ten Billion Ten", Practices.numberToWords(num));
		
		num = 1001888888888L;
		assertEquals("One Trillion One Billion Eight Hundred Eighty Eight Million Eight Hundred Eighty Eight Thousand Eight Hundred Eighty Eight", Practices.numberToWords(num));
	}
}
