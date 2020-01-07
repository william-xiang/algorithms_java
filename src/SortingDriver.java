
public class SortingDriver {
	public static void main(String[] args) {
		int[] nums = { 4, 5, 3, 1, 6, 2 };
		Sorting.heapSort(nums);
		SortingUtils.printNums(nums);
	}
}
