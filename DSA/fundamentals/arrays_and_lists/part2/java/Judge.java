package DSA.fundamentals.arrays_and_lists.part2.java;

import java.util.*;

public class Judge {

    public void runTests() {
        runTests(
                new String[][]{
                    {"Plateau", "Haven", "Insomnia", "Grand Trad", "Plateau", "Sunville"},
                    {"Plateau", "Haven", "Insomnia", "Grand Trad", "Sunville", "Bronze City", "Sunville"},}
        );
    }

    public void runTests(String[][] testCasesC) {
        int passes = 0;
        for (int i = 0; i < testCasesC.length; i++) {
            if (test(testCasesC[i], testCaseSolutionOutput(testCasesC[i]))) {
                passes++;
            }
        }
        System.out.println("Passed " + passes + " of " + testCasesC.length + " tests.");
    }

    private boolean test(String[] c, String expected) {
        Solution sol = new Solution();
        String output = sol.dispatchTo(c);
        boolean passed = output.equals(expected);

        System.out.println("c: " + Arrays.toString(c));
        System.out.println("Expected Output: " + expected);
        System.out.println("Your Output: " + output);
        System.out.println(passed ? "Test PASSED" : "Test FAILED");
        System.out.println("-----------");
        return passed;
    }

    private String testCaseSolutionOutput(String[] c) {
        ArrayList<String> seen = new ArrayList<>();
        for (String city : c) {
            if (seen.contains(city)) {
                return city;
            }
            seen.add(city);
        }
        return "";
    }

}
