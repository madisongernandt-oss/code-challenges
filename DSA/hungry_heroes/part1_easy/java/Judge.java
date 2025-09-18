package DSA.hungry_heroes.part1_easy.java;

import java.util.*;

public class Judge {

    public void runTests() {
        runTests(new String[][]{
            new String[]{"Beef", "Beef", "Chicken", "Pork", "Vegetable", "Grain", "Vegetable", "Vegetable"},
            new String[]{"Beef"},
            new String[]{"Chicken", "Beef", "Beef", "Beef", "Beef", "Beef", "Beef", "Beef", "Beef", "Beef", "Beef", "Beef", "Beef", "Beef", "Beef", "Beef", "Beef", "Beef", "Beef", "Beef", "Beef"},
            new String[]{"Vegetable", "Beef", "Vegetable", "Grain", "Grain"},
            new String[]{"Fruit", "Beef", "Vegetable"},
            new String[]{"Fruit", "Beef", "Vegetable", "Grain", "Grain"},
            new String[]{"Fruit", "Beef", "Vegetable", "Fruit"},
            new String[]{"Grain", "Grain"},
            new String[]{"Chicken", "Fruit", "Pork", "Grain", "Vegetable"},
            new String[]{"Vegetable", "Vegetable", "Vegetable", "Vegetable"},
            new String[]{"Grain", "Fruit", "Grain", "Fruit", "Grain", "Fruit"},
            new String[]{"Pork", "Chicken", "Beef", "Fruit"},
            new String[]{"Beef", "Grain", "Grain", "Grain", "Fruit"},
            new String[]{"Pork", "Pork", "Pork", "Chicken", "Chicken", "Vegetable"},
            new String[]{"Grain", "Vegetable", "Fruit", "Grain", "Vegetable", "Fruit"},
            new String[]{"Fruit", "Fruit", "Fruit", "Fruit", "Fruit"},
            new String[]{"Beef", "Vegetable", "Grain", "Chicken", "Pork", "Fruit"},
            new String[]{"Pork"},
            new String[]{},
        });
    }

    public void runTests(String[][] testCases) {
        int passes = 0;
        for (String[] testCase : testCases) {
            if (test(testCase, testCaseSolutionOutput(testCase))) {
                passes++;
            }
        }
        System.out.println("Passed " + passes + " of " + testCases.length + " tests.");
    }

    private boolean test(String[] stock, String[] expected) {
        Solution sol = new Solution();
        String[] output = sol.splitFood(stock);
        boolean passed = Arrays.equals(output, expected);
        System.out.println("Stock: " + Arrays.toString(stock));
        System.out.println("Expected: " + Arrays.toString(expected));
        System.out.println("Output: " + Arrays.toString(output));
        System.out.println(passed ? "Test PASSED" : "Test FAILED");
        System.out.println("-----------");
        return passed;
    }

    private String[] testCaseSolutionOutput(String[] stock) {
        HashMap<String, Integer> foods = new HashMap<>();
        for (String s : stock) {
            foods.put(s, foods.getOrDefault(s, 0) + 1);
        }
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : foods.entrySet()) {
            result.add(entry.getKey());
            result.add(entry.getValue().toString());
        }
        return result.toArray(new String[0]);
    }

}
