package com.kadane;

public class MaxSumOfContiguousSubArray {

	// This is kadane algorithm
	public static void maxSubArray_Kadane(int[] A) {

		int max = A[0];
		int current = 0;

		int startIndex = 0;
		int endIndex = 0;
		int tempIndex = 0;

		for (int i = 0; i < A.length; i++) {

			current = current + A[i];

			if (max < current) {
				max = current;
				startIndex = tempIndex;
				endIndex = i;
			}

			if (current < 0) {
				current = 0;
				tempIndex = i + 1;
			}
		}
		System.out.println("max sum of contiguous sub-array = " + max);
		printSubArray(A, startIndex, endIndex);
	}

	public static void printSubArray(int[] A, int startIndex, int endIndex) {
		System.out.print("contiguous sub array =  ");
		for (int i = startIndex; i <= endIndex; i++) {
			System.out.print(A[i] + " ");

		}

	}

	public static void main(String[] args) {

		int[] A = { 4, -3, -2, 2, 3, 1, -2, -3, 4, 2, -6, -3, -1, 3, 1, 2 };

		maxSubArray_Kadane(A);
	}

}
// max sum of contiguous sub-array = 7
// contiguous sub array =  2 3 1 -2 -3 4 2
