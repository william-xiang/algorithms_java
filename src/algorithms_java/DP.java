package algorithms_java;

public class DP {
	/**
	 * recursive version fibonacci number generating
	 * since there are duplicates in the recursion tree, this method is not efficient
	 * time complexity is O(2^n)
	 * space complexity is O(n)
	 * @param n
	 * @return
	 */
	public static int fibonacciRecursion(int n) {
		if (n < 0)
			throw new IllegalArgumentException();
		// base case
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		return fibonacciRecursion(n - 1) + fibonacciRecursion(n - 2);
	}
	
	/**
	 * This method utilizes memoization to store the already computed fibonacci numbers
	 * to decrease the duplicate recursion calls
	 * time complexity is O(n)
	 * space complexity is O(n)
	 * @param n
	 * @return
	 */
	public static int fibonacciRecursionMemoized(int n) {
		if (n < 0) 
			throw new IllegalArgumentException();
		if (n == 0) 
			return 0;
		if (n == 1) {
			return 1;
		}
		// create the array to store the computed fibonacci numbers
		int[] fibos = new int[n + 1];
		fibos[0] = 0;
		fibos[1] = 1;
		
		// initialize the array to make the initial value of the rest elements to be -1
		for (int i = 2; i <= n; i++) {
			fibos[i] = -1;
		}
		
		return fibonacciRecursionMemoizedAux(n, fibos);
	}
	private static int fibonacciRecursionMemoizedAux(int n, int[] fibos) {
		int value = fibos[n];
		if (value == -1) {
			return fibonacciRecursionMemoizedAux(n - 1, fibos) + fibonacciRecursionMemoizedAux(n - 2, fibos);
		}
		return value;
	}
	
	/**
	 * Iterative version fibonacci number generating
	 * time complexity is O(n)
	 * space complexity is O(1)
	 * @param n
	 * @return
	 */
	public static int fibonacciIterative(int n) {
		if (n < 0) 
			throw new IllegalArgumentException();
		if (n == 0) 
			return 0;
		if (n == 1) {
			return 1;
		}
		
		int fibo1 = 0;
		int fibo2 = 1;
		for (int i = 2; i <= n; i++) {
			int temp = fibo2;
			fibo2 += fibo1;
			fibo1 = temp;
		}
		
		return fibo2;
	}
}
