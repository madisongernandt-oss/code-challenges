
package DSA.fundamentals.maps.part0.java;

import java.util.*;

public class Judge {

    public void runTests() {
        runTests(
                new String[][]{
                    {"Doe, John", "Smith, Jane", "Johnson, Jim"},
                    {"Doe, John", "Smith, Jane", "Johnson, Jim", "Williams, Mary", "Brown, Bob"},}
        );
    }

    public void runTests(String[][] testCasesA) {
        int passes = 0;
        for (String[] test : testCasesA) {
            Map<String, String> copyUser = new HashMap<>();
            Map<String, String> copyExpected = new HashMap<>();
            if (test(test, copyUser, testCaseSolutionOutput(test, copyExpected))) {
                passes++;
            }
        }
        System.out.println("Passed " + passes + " of " + testCasesA.length + " tests.");
    }

    private boolean test(String[] n, Map<String, String> userMap, Map<String, String> expected) {
        Solution sol = new Solution();
        sol.storeNames(n, userMap);
        boolean passed = userMap.size() == expected.size() && userMap.values().containsAll(expected.values());

        System.out.println("n: " + Arrays.toString(n));
        System.out.println("Expected Output: " + expected.values());
        System.out.println("Your Output: " + userMap.values());
        System.out.println(passed ? "Test PASSED" : "Test FAILED");
        System.out.println("-----------");
        return passed;
    }

    private Map<String, String> testCaseSolutionOutput(String[] n, Map<String, String> m) {
        int i = 0;
        for (String name : n) {
            String[] parts = name.split(", ");
            m.put(Integer.toString(i), parts[1] + " " + parts[0]);
            i++;
        }
        return m;
    }

}
