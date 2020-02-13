package algorithms_java;

public class SortingUtils {
	/**
	 * print all the elements in the array
	 * 
	 * @param nums
	 */
	public static void printNums(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			if (i != nums.length - 1) {
				System.out.print(nums[i] + ", ");
			} else {
				System.out.print(nums[i]);
			}
		}
		System.out.println();
	}

	/**
	 * swap the two elements in the array
	 * 
	 * @param nums
	 * @param i
	 * @param j
	 */
	public static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	/**
	 * maintain the heap property for element with index and its children make the
	 * parent be the largest one among these three elements worst time complexity is
	 * O(logn)
	 * 
	 * @param nums
	 */
	public static void maxHeapify(int[] nums, int size, int index) {
		// get the indices of left child and right child
		int left = 2 * index + 1;
		int right = 2 * index + 2;

		// get the index of the largest element
		int max = index;
		if (left < size && nums[max] < nums[left]) {
			max = left;
		}
		if (right < size && nums[max] < nums[right]) {
			max = right;
		}

		// update the parent element if it's not the largest one
		if (max != index) {
			swap(nums, max, index);
			maxHeapify(nums, size, max);
		}
	}

	/**
	 * construct a max heap using maxHeapify
	 * time complexity is O(n)
	 * space complexity is O(1)
	 * 
	 * @param nums
	 */
	public static void makeHeap(int[] nums) {
		int size = nums.length;
		for (int i = size / 2 - 1; i >= 0; i--) {
			maxHeapify(nums, size, i);
		}
	}
	
	/**
	 * merge two sorted arrays
	 * @param nums
	 * @param l 
	 * @param m
	 * @param r
	 */
	public static void merge(int[] nums, int l, int m, int r) {
		int len1 = m - l + 1;
		int len2 = r - m;
		
		if (len1 + len2 > nums.length) {
			return;
		}
		
		// create two temp arrays for the two subarrays
		int[] left = new int[len1];
		int[] right = new int[len2];
		
		// copy elements into the two subarrays
		for (int i = 0; i < len1; i++) {
			left[i] = nums[l + i];
		}
		for (int j = 0; j < len2; j++) {
			right[j] = nums[m + j + 1];
		}

		// compare the elements from each array
		// and decide which one to put in the result array
		int i = 0;
		int j = 0;
		while (i < len1 && j < len2) {
			if (left[i] <= right[j]) {
				nums[l + i + j] = left[i++];
			} else {
				nums[l + i + j] = right[j++];
			}
		}

		while (i < len1) {
			nums[l + i + j] = left[i++];
		}

		while (j < len2) {
			nums[l + i + j] = right[j++];
		}
	}
	
	/**
	 * choose a pivot and rearrange the array according to the pivot in-place
	 * the elements less than or equal to pivot are on the left of the pivot
	 * the others will be on the right of the pivot
	 * @param nums
	 * @param l
	 * @param r
	 * @return
	 */
	public static int partition(int[] nums, int l, int r) {
		int pivot = nums[r];
		int i = l - 1;
		for (int j = l; j < r; j++) {
			if (nums[j] <= pivot) {
				i++;
				swap(nums, i, j);
			}
		}
		swap(nums, i + 1, r);
		
		return i + 1;
	}
}
