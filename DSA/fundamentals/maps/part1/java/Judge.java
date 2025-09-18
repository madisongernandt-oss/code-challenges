package DSA.fundamentals.maps.part1.java;

import java.util.*;

public class Judge {

    public void runTests() {
        runTests(
                new int[][]{
                    {4, 1, 4, 7, 3, 6},
                    {1, 2, 3, 4, 5, 6, 7},},
                new int[]{
                    7,
                    10,}
        );
    }

    public void runTests(int[][] testCasesP, int[] testCasesB) {
        int passes = 0;
        for (int i = 0; i < testCasesP.length; i++) {
            if (test(testCasesP[i], testCasesB[i], testCaseSolutionOutput(testCasesP[i], testCasesB[i]))) {
                passes++;
            }
        }
        System.out.println("Passed " + passes + " of " + testCasesP.length + " tests.");
    }

    private boolean test(int[] p, int b, int[] expected) {
        Solution sol = new Solution();
        int[] output = sol.twoItems(p, b);
        boolean passed = output != null && output.length == 2 && p[output[0]] + p[output[1]] == b;

        System.out.println("p: " + Arrays.toString(p));
        System.out.println("b: " + b);
        System.out.println("Expected Output: Any valid pair like " + Arrays.toString(expected));
        System.out.println("Your Output: " + Arrays.toString(output));
        System.out.println(passed ? "Test PASSED" : "Test FAILED");
        System.out.println("-----------");
        return passed;
    }

    private int[] testCaseSolutionOutput(int[] p, int b) {
        Map<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < p.length; i++) {
            int complement = b - p[i];
            if (seen.containsKey(complement)) {
                return new int[]{seen.get(complement), i};
            }
            seen.put(p[i], i);
        }
        return new int[]{};
    }

}
