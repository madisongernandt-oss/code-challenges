import java.util.*;

public class Judge {

    public void runTests() {

        String[][] testCasesS = {
            {"Beef", "2", "Chicken", "1", "Pork", "1", "Vegetable", "3", "Grain", "1"},
            {"Beef", "5", "Pork", "2", "Vegetable", "1", "Grain", "3"},
            {"Grain", "30"},
            {"Beef", "1", "Chicken", "1", "Pork", "1", "Vegetable", "1", "Grain", "1", "Fruit", "1"}
        };

        String[][][] testCasesP = {
            {
                {"Beef", "2", "Chicken", "1", "Pork", "2", "Vegetable", "0.5", "Grain", "1", "Fruit", "0.5"},
                {"Beef", "0.5", "Chicken", "1", "Pork", "0.5", "Vegetable", "2", "Grain", "1", "Fruit", "2"},
                {"Beef", "2", "Chicken", "2", "Pork", "0.5", "Vegetable", "1", "Grain", "0.5", "Fruit", "1"},
                {"Beef", "1", "Chicken", "2", "Pork", "2", "Vegetable", "0.5", "Grain", "1", "Fruit", "1"}
            },
            {
                {"Beef", "2", "Chicken", "1", "Pork", "2", "Vegetable", "0.5", "Grain", "1", "Fruit", "0.5"},
                {"Beef", "0.5", "Chicken", "1", "Pork", "0.5", "Vegetable", "2", "Grain", "1", "Fruit", "2"},
                {"Beef", "2", "Chicken", "2", "Pork", "0.5", "Vegetable", "1", "Grain", "0.5", "Fruit", "1"},
                {"Beef", "1", "Chicken", "2", "Pork", "2", "Vegetable", "0.5", "Grain", "1", "Fruit", "1"}
            },
            {
                {"Beef", "2", "Chicken", "1", "Pork", "2", "Vegetable", "0.5", "Grain", "1", "Fruit", "0.5"},
                {"Beef", "0.5", "Chicken", "1", "Pork", "0.5", "Vegetable", "2", "Grain", "1", "Fruit", "2"},
                {"Beef", "2", "Chicken", "2", "Pork", "0.5", "Vegetable", "1", "Grain", "0.5", "Fruit", "1"},
                {"Beef", "1", "Chicken", "2", "Pork", "2", "Vegetable", "0.5", "Grain", "1", "Fruit", "1"}
            },
            {
                {"Beef", "2", "Chicken", "1", "Pork", "2", "Vegetable", "0.5", "Grain", "1", "Fruit", "0.5"},
                {"Beef", "0.5", "Chicken", "1", "Pork", "0.5", "Vegetable", "2", "Grain", "1", "Fruit", "2"},
                {"Beef", "2", "Chicken", "2", "Pork", "0.5", "Vegetable", "1", "Grain", "0.5", "Fruit", "1"},
                {"Beef", "1", "Chicken", "2", "Pork", "2", "Vegetable", "0.5", "Grain", "1", "Fruit", "1"}
            }
        };

        int[][] testCasesR = {
            {2, 2, 2, 2},
            {2, 2, 2, 2},
            {10, 10, 10, 10},
            {4, 3, 2, 1}
        };

        runTests(testCasesS, testCasesP, testCasesR);
    }

    public void runTests(String[][] s, String[][][] p, int[][] r) {
        for (int i = 0; i < s.length; i++) {
            test(s[i], p[i], r[i], testCaseSolutionOutput(s[i], p[i], r[i]));
        }
    }

    private boolean test(String[] s, String[][] p, int[] r, boolean expected) {
        Solution sol = new Solution();
        boolean output = sol.distributeFood(s, p, r);
        boolean passed = output == expected;

        System.out.println("Test Case:");
        System.out.println("s: " + Arrays.toString(s));
        System.out.println("p: " + Arrays.deepToString(p));
        System.out.println("r: " + Arrays.toString(r));
        System.out.println("Expected: " + expected);
        System.out.println("Output: " + output);
        System.out.println(passed ? "Test PASSED" : "Test FAILED");
        System.out.println("-----------");

        return passed;
    }

    private boolean testCaseSolutionOutput(String[] s, String[][] p, int[] r) {

    }

    private boolean backtrack() {

    }

}
