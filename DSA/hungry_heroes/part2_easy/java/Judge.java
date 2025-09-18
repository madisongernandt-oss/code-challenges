package DSA.hungry_heroes.part2_easy.java;

import java.util.*;

public class Judge {

    public void runTests() {

        String[][] testCasesC = {
            {"Beef", "Beef", "Chicken", "Pork", "Vegetable", "Grain", "Vegetable", "Vegetable"},
            {"Fruit", "Beef", "Vegetable"},
            {"Beef", "Beef", "Beef"},
            {"Fruit", "Beef", "Vegetable"}
        };

        String[][] testCasesP = {
            {"Beef", "2", "Chicken", "1", "Pork", "2", "Vegetable", "0.5", "Grain", "1", "Fruit", "0.5"},
            {"Beef", "2", "Chicken", "1", "Pork", "2", "Vegetable", "0.5", "Grain", "1", "Fruit", "0.5"},
            {"Beef", "2", "Chicken", "1", "Pork", "2", "Vegetable", "0.5", "Grain", "1", "Fruit", "0.5"},
            {"Beef", "2", "Chicken", "1", "Pork", "2", "Vegetable", "0.5", "Grain", "1", "Fruit", "0.5"}
        };

        int[][][] testCasesQ = {
            {{1, 3}, {0, 4}, {2, 6}},
            {{0, 2}},
            {{0, 2}},
            {{0, 1}}
        };

        runTests(testCasesC, testCasesP, testCasesQ);
    }

    public void runTests(String[][] c, String[][] p, int[][][] q) {
        for (int i = 0; i < c.length; i++) {
            test(c[i], p[i], q[i], testCaseSolutionOutput(c[i], p[i], q[i]));
        }
    }

    private boolean test(String[] c, String[] p, int[][] q, double[] expected) {
        Solution sol = new Solution();
        double[] output = sol.calculateSatisfaction(c, p, q);
        boolean passed = Arrays.equals(output, expected);

        System.out.println("Test Case:");
        System.out.println("c: " + Arrays.toString(c));
        System.out.println("p: " + Arrays.toString(p));
        System.out.println("q: " + Arrays.deepToString(q));
        System.out.println("Expected: " + Arrays.toString(expected));
        System.out.println("Output: " + Arrays.toString(output));
        System.out.println(passed ? "Test PASSED" : "Test FAILED");
        System.out.println("-----------");

        return passed;
    }

    private double[] testCaseSolutionOutput(String[] c, String[] p, int[][] q) {
        HashMap<String, Double> satisfactionMap = new HashMap<>();
        for (int i = 0; i < p.length; i += 2) {
            String food = p[i];
            double satisfaction = Double.parseDouble(p[i + 1]);
            satisfactionMap.put(food, satisfaction);
        }

        double[] prefixSum = new double[c.length + 1];
        for (int i = 0; i < c.length; i++) {
            double satisfaction = satisfactionMap.getOrDefault(c[i], 0.0); // Invalid foods should not be accepted.
            prefixSum[i + 1] = prefixSum[i] + satisfaction;
        }

        double[] result = new double[q.length];
        for (int i = 0; i < q.length; i++) {
            int start = q[i][0];
            int end = q[i][1];
            result[i] = prefixSum[end + 1] - prefixSum[start];
        }

        return result;
    }

}
