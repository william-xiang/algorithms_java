import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

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
					SortingUtils.swap(nums, j, j + 1);
				}
			}
		}
	}
	
	/**
	 * heap sort using user defined methods
	 * time complexity is O(nlogn)
	 * space complexity is O(1)
	 * not stable
	 * @param nums
	 */
	public static void heapSort1(int[] nums) {
		int size = nums.length;
		
		// first build the max heap using the given array
		SortingUtils.makeHeap(nums);
		SortingUtils.printNums(nums);
		
		// swap the first and last element
		// then heapify to maintain the heap property
		for (int i = size - 1; i > 0; i--) {
			SortingUtils.swap(nums, i, 0);
			SortingUtils.maxHeapify(nums, i, 0);
		}
	}
	
	public static void heapSort2(int[] nums) {
		List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
		// construct a priority queue which is implemented by heap
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(list);
		
		for (int i = 0; i < nums.length; i++) {
			nums[i] = maxHeap.remove();
		}
	}
}
