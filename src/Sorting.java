public class Sorting {
	/**
	 * insertion sort
	 * time complexity: O(n^2)
	 * space complexity: O(1)
	 * If the array is almost sorted, then best time complexity can be O(n)
	 * @param nums
	 */
	public static void insertionSort(int[] nums) {
		int len = nums.length;
		for (int i = 0; i < len; i++) {
			int x = nums[i];
			int j = i - 1;
			while (j >= 0 && nums[j] > x) {
				nums[j + 1] = nums[j];
				j = j - 1;
			}
			nums[j + 1] = x;
		}
	}

	/**
	 * bubble sort
	 * time complexity: O(n^2)
	 * space complexity: O(1)
	 * @param nums
	 */
	public static void bubbleSort(int[] nums) {
		int len = nums.length;
		for (int i = len - 1; i >= 0; i--) {
			for (int j = 0; j < i; j++) {
				int x = nums[j];
				int y = nums[j + 1];
				if (x > y) {
					nums[j] = y;
					nums[j + 1] = x;
				}
			}
		}
	}
	
	public static void heapSort(int[] nums) {
		int size = nums.length;
		
		// first build the max heap using the given array
		SortingUtils.makeHeap(nums);
		SortingUtils.printNums(nums);
		
		// swap the first and last element
		// then heapify to maintain the heap property
		for (int i = size - 1; i >= 0; i--) {
			SortingUtils.swap(nums, i, 0);
			SortingUtils.printNums(nums);

			size--;
			SortingUtils.maxHeapify(nums, size, 0);
			SortingUtils.printNums(nums);

		}
	}
}
