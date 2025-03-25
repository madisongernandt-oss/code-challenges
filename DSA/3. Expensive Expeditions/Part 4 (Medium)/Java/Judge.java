import java.util.*;

public class Judge {

    public void runTests() {

        int[][][] testCasesM = {
            {
                {1, -1, 1, 1, 1, 1},
                {3, 0, -4, 4, 4, 2},
                {1, 0, 1, 1, 1, 1},
                {1, 0, 0, 0, 0, -2},
                {0, 1, 0, 1, -1, 1},
                {1, 2, -4, 1, 1, 1}
            },
            {
                {1, -1, 1, 1, 1, 1},
                {3, 0, -4, 4, 4, 2},
                {1, 0, 1, 1, 1, 1},
                {1, 0, 0, 0, 0, -2},
                {0, 1, 0, 1, -1, 1},
                {1, 2, -4, 1, 1, 1}
            }
        };

        int[] testCasesN = {
            5,
            3
        };

        runTests(testCasesM, testCasesN);
    }

    public void runTests(int[][][] testCasesM, int[] testCasesN) {
        for(int i = 0; i < testCasesM.length; i++) {
            test(testCasesM[i], testCasesN[i], testCaseSolutionOutput(testCasesM[i], testCasesN[i]));
        }
    }

    private boolean test(int[][] m, int n, int[][] expected) {
        Solution sol = new Solution();
        int[][] result = sol.findMostValuableArea(n, m);
        boolean passed = Arrays.deepEquals(result, expected);
        System.out.println("Matrix: " + Arrays.deepToString(m));
        System.out.println("n: " + n);
        System.out.println("Expected: " + Arrays.deepToString(expected));
        System.out.println("Your Output: " + Arrays.deepToString(result));
        System.out.println(passed ? "Test PASSED" : "Test FAILED");
        System.out.println("-----------");
        return passed;
    }

    private int[][] testCaseSolutionOutput(int[][] m, int n) {
        int rows = m.length;

        if (rows == 0 || n > rows || n > m[0].length) return new int[][] {{-1, -1}, {-1, -1}}; // Test cases should always be valid, so we return [-1, -1] if not
        int cols = m[0].length;

        int[][] prefixSum = new int[rows + 1][cols + 1];
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                prefixSum[i][j] = m[i - 1][j - 1] + prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1];
            }
        }
        
        int maxSum = Integer.MIN_VALUE;
        int[] topLeft = new int[2];
        int[] bottomRight = new int[2];

        for (int i = n; i <= rows; i++) {
            for (int j = n; j <= cols; j++) {
                int currentSum = prefixSum[i][j] - prefixSum[i - n][j] - prefixSum[i][j - n] + prefixSum[i - n][j - n];
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    topLeft[0] = i - n;
                    topLeft[1] = j - n;
                    bottomRight[0] = i - 1;
                    bottomRight[1] = j - 1;
                }
            }
        }
        
        return new int[][] {topLeft, bottomRight};
    }
}