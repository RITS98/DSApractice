//1 9 -1 -2 7 3 -1 2

import java.util.Scanner;

public class longestSubArraySumK 
{

	// brute force solution
	// time complexity - O(n*k)
	public static int getMaxSumSubArrayOfSizeKM1(int[] A, int k) {
		int maxSum = Integer.MIN_VALUE;
		for (int i = 0; i <= A.length - k; i++) {
			int windowSum = 0;
			for (int j = i; j < i + k; j++) {
				windowSum += A[j];
			}
			maxSum = Math.max(maxSum, windowSum);
		}
		return maxSum;
	}

	// optimized solution using sliding window technique
	// time complexity - O(n)
	public static int getMaxSumSubArrayOfSizeKM2(int[] A, int k) {
		int windowSum = 0, maxSum = Integer.MIN_VALUE;

		for (int i = 0; i < k; i++) {
			windowSum += A[i];
		}
		maxSum = Math.max(maxSum, windowSum);
		for (int windowEndIndex = k; windowEndIndex < A.length; windowEndIndex++) {
			windowSum += A[windowEndIndex] - A[windowEndIndex - k];
			maxSum = Math.max(maxSum, windowSum);
		}

		return maxSum;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int A[] = new int[n];
		for (int i = 0; i < n; i++) {
			A[i] = sc.nextInt();
		}
		method1(A, k);
		method2(A, k);
		sc.close();
	}

	public static void method1(int[] A, int k) {
		long startTime = 0, endTime = 0, executionTime = 0;
		startTime = System.nanoTime();
		System.out.println("brute for solution O(n*k) result=" + getMaxSumSubArrayOfSizeKM1(A, k));
		endTime = System.nanoTime();
		executionTime = endTime - startTime;
		System.out.println("executionTime for brute for solution :" + executionTime + " ns \n");
	}

	public static void method2(int[] A, int k) {
		long startTime = 0, endTime = 0, executionTime = 0;
		startTime = System.nanoTime();
		System.out.println("sliding window technique O(n) result=" + getMaxSumSubArrayOfSizeKM2(A, k));
		endTime = System.nanoTime();
		executionTime = endTime - startTime;
		System.out.println("executionTime for optimized solution :" + executionTime + " ns \n");
	}

}