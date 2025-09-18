package DSA.expensive_expeditions.part3_medium.java;

import java.util.*;

public class Judge {

    public void runTests() {
        String[] testCases = {
            "h-H-+e-e-+lll-l-o-o",
            "Goodbye-------+oodmorning!",
            "Foo_----_-B-+a-+r-+",
        };

        runTests(testCases);
    }

    public void runTests(String[] testCases) {
        for(String testCase : testCases) {
            test(testCase, testCaseSolutionOutput(testCase));
        }
    }

    private boolean test(String m, String expected) {
        Solution sol = new Solution();
        String result = sol.decodeMessage(m);
        boolean passed = result.equals(expected);
        System.out.println("Message: " + m);
        System.out.println("Expected: " + expected);
        System.out.println("Your Output: " + result);
        System.out.println(passed ? "Test PASSED" : "Test FAILED");
        System.out.println("-----------");
        return passed;
    }

    private String testCaseSolutionOutput(String m) {
        Stack<Character> stack = new Stack<>();
        Character prev = null;
        for (char c : m.toCharArray()) {
            switch (c) {
                case '-':
                    if (!stack.isEmpty()) {
                        prev = stack.pop();
                    }   
                    break;
                case '+':
                    if (prev != null) {
                        stack.push(prev);
                    }   
                    break;
                default:
                    stack.push(c);
                    break;
            }
        }
        StringBuilder result = new StringBuilder();
        for (char c : stack) {
            result.append(c);
        }
        return result.toString();
    }

}
