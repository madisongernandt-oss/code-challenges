import java.util.*;

public class Judge {

    public void runTests() {
        runTests(new String[][]{
            new String[]{ "Beef", "Beef", "Beef" },
            new String[]{ "Beef", "Beef", "Chicken", "Pork", "Vegetable", "Grain", "Vegetable", "Vegetable" },
            new String[]{ "Fruit", "Beef", "Vegetable" },
            new String[]{ "Fruit", "Beef", "Vegetable" },
            new String[]{  }
        });
    }

    public void runTests(String[][] testCases) {
        for(String[] testCase : testCases) {
            test(testCase, testCaseSolutionOutput(testCase));
        }
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
        for(String s : stock) {
            foods.put(s, foods.getOrDefault(s, 0) + 1);
        }
        List<String> result = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : foods.entrySet()) {
            result.add(entry.getKey());
            result.add(entry.getValue().toString());
        }
        return result.toArray(new String[0]);
    }

}
