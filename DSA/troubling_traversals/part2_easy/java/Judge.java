package DSA.troubling_traversals.part2_easy.java;

import java.util.*;

public class Judge {

    public void runTests() {
        int[][] testCasesT = {  
            {1, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 0, 0, 1},
            {1, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 0, 0, 1},
        };

        int[] testCasesB = {
            5,
            3
        };

        runTests(testCasesT, testCasesB);
    }

    public void runTests(int[][] testCasesT, int[] testCasesB) {
        for(int i = 0; i < testCasesT.length; i++) {
            test(testCasesT[i], testCasesB[i], testCaseSolutionOutput(testCasesT[i], testCasesB[i]));
        }
    }

    private boolean test(int[] t, int b, int[] expected) {
        Solution sol = new Solution();
        int[] output = sol.buildBridges(t, b);
        boolean passed = Arrays.equals(output, expected);
        System.out.println("Terrain: " + Arrays.toString(t));
        System.out.println("Bridges: " + b);
        System.out.println("Expected: " + Arrays.toString(expected));
        System.out.println("Your Output: " + Arrays.toString(output));
        System.out.println(passed ? "Test PASSED" : "Test FAILED");
        System.out.println("-----------");
        return passed;
    }

    private int[] testCaseSolutionOutput(int[] t, int b) {
        int n = t.length;
        int bridgesUsed = 0;
        for (int i = 0; i < n; i++) {
            if (t[i] == 0) {
                int start = i;
                while (i < n && t[i] == 0) {
                    i++;
                }
                int length = i - start;
                if (length > 1) {
                    if (bridgesUsed + (length - 1) > b) {
                        return new int[0];
                    }
                    for (int j = start; j < i - 1; j++) {
                        t[j] = 2;
                        bridgesUsed++;
                    }
                }
            }
        }
        return t;
    }

}
