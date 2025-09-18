package DSA.troubling_traversals.part4_hard.java;

import java.util.*;

public class Judge {

    public void runTests() {
        int[][][] testCasesF = {
            {
                {1, 1, 1, 1, 1, 1},
                {3, 0, 4, 4, 4, 2},
                {1, 0, 1, 1, 1, 1},
                {1, 0, 0, 0, 0, 2}, 
                {0, 1, 0, 1, 1, 1},
                {1, 2, 4, 1, 1, 1}
            }
        };

        runTests(testCasesF);
    }

    public void runTests(int[][][] testCasesF) {
        for(int[][] testCase : testCasesF) {
            test(testCase, testCaseSolutionOutput(testCase));
        }
    }

    private boolean test(int[][] f, String[] expected) {
        Solution sol = new Solution();
        String[] output = sol.shortestPath(f);
        boolean passed = Arrays.equals(output, expected);
        System.out.println("Forest: " + Arrays.deepToString(f));
        System.out.println("Expected: " + Arrays.toString(expected));
        System.out.println("Your Output: " + Arrays.toString(output));
        System.out.println(passed ? "Test PASSED" : "Test FAILED");
        System.out.println("-----------");
        return passed;
    }

    private String[] testCaseSolutionOutput(int[][] f) {
        int rows = f.length;
        int cols = f[0].length;
        int[] start = null;
        boolean[][] visited = new boolean[rows][cols];
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (f[i][j] == 3) {
                    start = new int[]{i, j};
                    break;
                }
            }
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.offer(new int[]{start[0], start[1], 0});
        
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int row = current[0];
            int col = current[1];
            int dist = current[2];
            
            if (visited[row][col]) continue;
            visited[row][col] = true;
            
            if (f[row][col] == 2) {
                return new String[]{String.valueOf(row), String.valueOf(col)};
            }
            
            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                
                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols 
                    && !visited[newRow][newCol] && f[newRow][newCol] != 1) {
                    
                    int newDist = dist;
                    if (f[newRow][newCol] == 4) {
                        newDist += 2;
                    } else {
                        newDist += 1;
                    }
                    
                    pq.offer(new int[]{newRow, newCol, newDist});
                }
            }
        }
        
        return new String[]{};
    }

}
