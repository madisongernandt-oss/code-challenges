import java.util.*;

public class Judge {

    public void runTests() {
        String[] testCases = {
            "Hh-e-ell-l-lo-o",
            "Goodbye-------",
            "Peek----a-Boo",
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
        for (char c : m.toCharArray()) {
            if (c == '-') {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(c);
            }
        }
        StringBuilder result = new StringBuilder();
        for (char c : stack) {
            result.append(c);
        }
        return result.toString();
    }

}
