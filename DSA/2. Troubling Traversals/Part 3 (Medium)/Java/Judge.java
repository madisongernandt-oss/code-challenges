import java.util.*;

public class Judge {

    public void runTests() {
        int[][][] testCasesF = {
            {
                {1, 1, 1, 1, 1, 1},
                {3, 0, 1, 1, 0, 2},
                {1, 0, 1, 1, 0, 1},
                {1, 0, 0, 0, 0, 2},
                {2, 0, 0, 1, 1, 1},
                {1, 1, 1, 1, 1, 1}
            },
            {
                {1, 1, 1, 1, 1, 1},
                {3, 0, 0, 0, 0, 2},
                {1, 1, 0, 1, 0, 1},
                {1, 0, 0, 0, 0, 2},
                {2, 0, 1, 1, 1, 1},
                {1, 1, 1, 0, 0, 1}
            }
        };

        runTests(testCasesF);
    }

    public void runTests(int[][][] testCasesF) {
        for(int[][] testCase : testCasesF) {
            test(testCase, testCaseSolutionOutput(testCase));
        }
    }

    private boolean test(int[][] f, String expected) {
        Solution sol = new Solution();
        String output = sol.shortestPath(f);
        boolean passed = output.equals(expected);
        System.out.println("Forest: " + Arrays.deepToString(f));
        System.out.println("Expected: " + expected);
        System.out.println("Output: " + output);
        System.out.println(passed ? "Test PASSED" : "Test FAILED");
        System.out.println("-----------");
        return passed;
    }

    private String testCaseSolutionOutput(int[][] f) {
        int[] directions = {0, 1, 0, -1, 1, 0, -1, 0};
        int rows = f.length;
        int cols = f[0].length;

        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> queue = new LinkedList<>();
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (f[i][j] == 3) {
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                    break;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            if (f[x][y] == 2) {
                return x + "," + y;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + directions[i];
                int ny = y + directions[i + 1];

                if (nx >= 0 && nx < rows && ny >= 0 && ny < cols && !visited[nx][ny] && f[nx][ny] != 1) {
                    queue.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }

        return "";
    }

}
