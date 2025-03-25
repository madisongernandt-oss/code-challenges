import java.util.*;

public class Judge {

    public void runTests() {
        runTests(new double[][]{
            new double[]{5, 3, 6, 4, 2, 3},
            new double[]{1, 2, 4, 8, 16, 32},
        });
    }

    public void runTests(double[][] testCases) {
        for(double[] testCase : testCases) {
            test(testCase, testCaseSolutionOutput(testCase));
        }
    }

    private boolean test(double[] h, boolean expected) {
        Solution sol = new Solution();
        boolean output = sol.canCross(h);
        boolean passed = output == expected;
        System.out.println("Heights: " + Arrays.toString(h));
        System.out.println("Expected: " + expected);
        System.out.println("Your Output: " + output);
        System.out.println(passed ? "Test PASSED" : "Test FAILED");
        System.out.println("-----------");
        return passed;
    }

    private boolean testCaseSolutionOutput(double[] h) {
        for (int i = 1; i < h.length; i++) {
            double diff = Math.abs(h[i] - h[i - 1]);
            if (diff > h[i] || diff > h[i - 1]) {
                return false;
            }
        }
        return true;
    }

}
