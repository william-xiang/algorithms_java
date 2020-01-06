
public class SortingUtils {
	/**
	 * print all the elements in the array
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
	 * maintain the heap property for element with index and its children
	 * make the parent be the largest one among these three elements
	 * 
	 * @param nums
	 */
	public static void maxHeapify(int[] nums, int index) {
		int size = nums.length;
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
		}
	}
	
	/**
	 * construct a max heap using maxHeapify
	 * @param nums
	 */
	public static void makeHeap(int[] nums) {
		int size = nums.length;
		
	}
}
