package DSA.troubling_traversals.part5_hard.java;

import java.util.*;

public class Judge {

    public void runTests() {
        int[][][] testCasesPaths = {
            {
                {2, 1},
                {0, 1},
                {1, 3},
                {5, 3},
                {2, 4},
                {3, 6}
            },
            {
                {0,1},
                {1,3},
                {2,3},
                {4,0},
                {4,5}
            }
        };

        int[] testCasesN = {
            7,
            6
        };

        runTests(testCasesPaths, testCasesN);
    }

    public void runTests(int[][][] testCasesPaths, int[] testCasesN) {
        for(int i = 0; i < testCasesPaths.length; i++) {
            test(testCasesPaths[i], testCasesN[i], testCaseSolutionOutput(testCasesPaths[i], testCasesN[i]));
        }
    }

    private boolean test(int[][] paths, int n, int expected) {
        Solution sol = new Solution();
        int output = sol.redirectPaths(paths, n);
        boolean passed = output == expected;
        System.out.println("Nodes: " + n);
        System.out.println("Paths: " + Arrays.deepToString(paths));
        System.out.println("Expected: " + expected);
        System.out.println("Your Output: " + output);
        System.out.println(passed ? "Test PASSED" : "Test FAILED");
        System.out.println("-----------");
        return passed;
    }

    private int testCaseSolutionOutput(int[][] paths, int n) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        Set<String> reversedEdges = new HashSet<>();

        for (int[] path : paths) {
            int to = path[0];
            int from = path[1];
            graph.putIfAbsent(from, new ArrayList<>());
            graph.putIfAbsent(to, new ArrayList<>());

            graph.get(from).add(to);
            graph.get(to).add(from);

            reversedEdges.add(from + "," + to);
        }

        int swaps = 0;
        Set<Integer> visited = new HashSet<>();

        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);

        while (!stack.isEmpty()) {
            int node = stack.pop();
            visited.add(node);

            for (int neighbor : graph.get(node)) {
                if (!visited.contains(neighbor)) {
                    if (reversedEdges.contains(node + "," + neighbor)) {
                        swaps++;
                    }
                    stack.push(neighbor);
                }
            }
        }

        return swaps;
    }

}
