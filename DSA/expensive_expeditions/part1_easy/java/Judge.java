package DSA.expensive_expeditions.part1_easy.java;

import java.util.*;

public class Judge {

    public void runTests() {
        int[][] testCases = {
            {0,1,2,5,2,10,30,4,7,0,0,0,1},  
            {5, 5, 5, 5, 5, 5, 5, 5},       
            {100, 99, 98, 50, 10, 5, 1, 0},  
            {0, 0, 0, 0, 0},                
            {100, 100, 100, 99, 99, 50, 1},  
            {1, 2, 3, 4, 5, 6, 7, 8, 9},     
            {9, 8, 7, 6, 5, 4, 3, 2, 1},     
            {50, 20, 40, 10, 30, 60, 70},    
            {0, 1, 100, 99, 98, 2, 97, 3},   
            {42},                           
        };

        runTests(testCases);
    }

    public void runTests(int[][] testCases) {
        for(int[] testCase : testCases) {
            test(testCase, testCaseSolutionOutput(testCase));
        }
    }

    private boolean test(int[] p, int[] expected) {
        Solution sol = new Solution();
        int[] pCopy = p.clone();
        sol.modifyPlaces(pCopy);
        boolean passed = Arrays.equals(pCopy, expected);
        System.out.println("Places: " + Arrays.toString(p));
        System.out.println("Expected: " + Arrays.toString(expected));
        System.out.println("Your Output: " + Arrays.toString(pCopy));
        System.out.println(passed ? "Test PASSED" : "Test FAILED");
        System.out.println("-----------");
        return passed;
    }

    private int[] testCaseSolutionOutput(int[] p) {
        int[] pCopy = p.clone(); // This is not part of the solution, it is just for the judge.
        int[] count = new int[101];

        for (int num : pCopy) {
            count[num]++;
        }

        int index = 0;
        for(int value = 100; value >= 0; value--) {
            while(count[value] > 0) {
                pCopy[index++] = value;
                count[value]--;
            }
        }

        return pCopy;
    }

}
