public class Sorting {
	/**
	 * insertion sort
	 * time complexity: O(n^2)
	 * space complexity: O(1)
	 * If the array is almost sorted, then best time complexity can be O(n)
	 * @param nums
	 */
	public static void insertion(int[] nums) {
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
	public static void bubble(int[] nums) {
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
}
