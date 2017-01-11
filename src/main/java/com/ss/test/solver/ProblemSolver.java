package com.ss.test.solver;

/**
 * Based on provided set of data this class is solving the KnapSack problem using dynamic programming approach
 * @author saurav
 *
 */
public final class ProblemSolver {

	// 
	/**
	 * Fins the maximum satisfaction with-in given time range
	 * @param maxTime maximum time
	 * @param time array of all time
	 * @param sts array of all satisfaction index
	 * @param size size of array
	 * @return
	 */
	public static int findMaxStatisfaction(int maxTime, Integer time[], Integer[] sts, int size) {
		int K[][] = new int[size + 1][maxTime + 1];

		// Build table K[][] in bottom up manner
		for (int i = 0; i <= size; i++) {
			for (int w = 0; w <= maxTime; w++) {
				if (i == 0 || w == 0)
					K[i][w] = 0;
				else if (time[i - 1] <= w)
					K[i][w] = max(sts[i - 1] + K[i - 1][w - time[i - 1]], K[i - 1][w]);
				else
					K[i][w] = K[i - 1][w];
			}
		}

		return K[size][maxTime];
	}

	/**
	 * Find maximum number between two provided
	 * @param a first number
	 * @param b second number
	 * @return
	 */
	public static int max(int a, int b) {
		return (a > b) ? a : b;
	}
}
