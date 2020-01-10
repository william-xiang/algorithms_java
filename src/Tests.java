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
		SortingUtils.merge(empty, 1, 2, 3);
		assertArrayEquals(new int[] {}, empty);
		
		// test normal arrays
		Sorting.mergeSort(nums, 0, 5);
		assertArrayEquals(expected, nums);
	}
}