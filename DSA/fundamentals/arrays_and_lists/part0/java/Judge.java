package DSA.fundamentals.arrays_and_lists.part0.java;

import java.util.*;

public class Judge {

    public void runTests() {
        runTests(
                new int[][]{
                    {1, 2, 3, 4, 5},
                    {1, 2, 3, 4, 5},},
                new int[]{
                    1,
                    0,}
        );
    }

    public void runTests(int[][] testCasesA, int[] testCasesK) {
        int passes = 0;
        for (int i = 0; i < testCasesA.length; i++) {
            int[] copyUser = Arrays.copyOf(testCasesA[i], testCasesA[i].length);
            int[] copyExpected = Arrays.copyOf(testCasesA[i], testCasesA[i].length);
            if (test(copyUser, testCasesK[i], testCaseSolutionOutput(copyExpected, testCasesK[i]))) {
                passes++;
            }
        }
        System.out.println("Passed " + passes + " of " + testCasesA.length + " tests.");
    }

    private boolean test(int[] a, int k, int[] expected) {
        int[] originalA = Arrays.copyOf(a, a.length);
        Solution sol = new Solution();
        sol.incrementArray(a, k);
        boolean passed = Arrays.equals(a, expected);

        System.out.println("a: " + Arrays.toString(originalA));
        System.out.println("k: " + k);
        System.out.println("Expected Output: " + Arrays.toString(expected));
        System.out.println("Your Output: " + Arrays.toString(a));
        System.out.println(passed ? "Test PASSED" : "Test FAILED");
        System.out.println("-----------");
        return passed;
    }

    private int[] testCaseSolutionOutput(int[] a, int k) {
        for (int i = 0; i < a.length; i++) {
            a[i] += k;
        }
        return a;
    }

}
