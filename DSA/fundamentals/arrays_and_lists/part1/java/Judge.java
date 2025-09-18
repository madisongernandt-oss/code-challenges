package DSA.fundamentals.arrays_and_lists.part1.java;

import java.util.*;

public class Judge {

    public void runTests() {
        runTests(
                new int[][]{
                    {1, 2, 4, 5},
                    {1, 2, 4, 5},},
                new int[][]{
                    {2, 2, 5, 10},
                    {2, 1, 5, 0},}
        );
    }

    public void runTests(int[][] testCasesP, int[][] testCasesM) {
        int passes = 0;
        for (int i = 0; i < testCasesP.length; i++) {
            if (test(testCasesP[i], testCasesM[i], testCaseSolutionOutput(testCasesP[i], testCasesM[i]))) {
                passes++;
            }
        }
        System.out.println("Passed " + passes + " of " + testCasesP.length + " tests.");
    }

    private boolean test(int[] p, int[] m, int expected) {
        Solution sol = new Solution();
        int output = sol.difference(p, m);
        boolean passed = output == expected;

        System.out.println("p: " + Arrays.toString(p));
        System.out.println("m: " + Arrays.toString(m));
        System.out.println("Expected Output: " + expected);
        System.out.println("Your Output: " + output);
        System.out.println(passed ? "Test PASSED" : "Test FAILED");
        System.out.println("-----------");
        return passed;
    }

    private int testCaseSolutionOutput(int[] p, int[] m) {
        int sum = 0;
        for (int i = 0; i < p.length; i++) {
            sum += m[i] - p[i];
        }
        return sum;
    }

}
