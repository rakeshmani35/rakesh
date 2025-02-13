package com.dp;

// https://www.youtube.com/watch?v=rMLEZdtdAO8&list=PLCZJSEiJwWZ7kd4wXxIkFiU6mYXsCwYOC&index=11
// https://www.techiedelight.com/find-total-ways-to-reach-nth-stair/
// https://www.techiedelight.com/find-total-ways-reach-nth-stair-with-atmost-m-steps/
// https://www.geeksforgeeks.org/count-ways-reach-nth-stair/
// https://www.geeksforgeeks.org/count-ways-reach-nth-stair-using-step-1-2-3/
public class NStairsProblem {

	// n= stairs, m = jump
	public static int countWays_recursive(int n, int m) {

		// base case : invalid input
		if (n < 0) {
			return 0;
		}

		// base case : 1 way (with no steps)
		if (n == 0) {
			return 1;
		}

		// else {
		// if m=2
		// return countWays(n - 1, m) + countWays(stair - 1, m);
		// }

		// approach 2
		int count = 0;
		for (int i = 1; i <= m; i++) {
			count += countWays_recursive(n - i, m);
		}
		return count;
	}

	// top down = memoization approach
	public static int countWays_topdown(int n, int m, int[] dp) {

		// base case : invalid input
		if (n < 0) {
			return 0;
		}

		// base case : 1 way (with no steps)
		if (n == 0) {
			return 1;
		}

		// if subproblem not seen before
		if (dp[n] == 0) {
			for (int i = 1; i <= m; i++) {
				dp[n] += countWays_topdown(n - i, m, dp);
			}
		}

		return dp[n];

	}

	// bottom up = tabulation approach
	public static int countWays_bottomup(int n, int m) {

		// create an array n+1 size for storing the solutions to sub-problem
		int[] dp = new int[n + 1];

		// base case : 1 way (with no steps)
		dp[0] = 1;

		// base case : m way to reach mth stair
		for (int i = 1; i < m; i++) {
			dp[i] = i;
		}

		// fill the dp table in bottom-up manner
		for (int i = m; i <= n; i++) {

			for (int j = 1; j <= m && (i - j) >= 0; j++) {
                  dp[i] = dp[i] + dp[i-j];
			}
		}

		return dp[n];

	}

	public static void main(String[] args) {

		int n = 4; // stairs
		int m = 2; // jumps

		int countWays = countWays_recursive(n, m);
		System.out.println("recursive approach = " + countWays);

		int[] dp = new int[n + 1];

		int countWays_topdown = countWays_topdown(n, m, dp);
		System.out.println("countWays_topdown approach = " + countWays_topdown);

		
		int countWays_bottomup = countWays_bottomup(n, m);
		System.out.println("countWays_bottomup approach = " + countWays_bottomup);
	}

}
