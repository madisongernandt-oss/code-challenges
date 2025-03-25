from collections import Counter
from solution import Solution

class Judge:
    def run_tests(self):
        testCasesM = [
            [
                [1, -1, 1, 1, 1, 1],
                [3, 0, -4, 4, 4, 2],
                [1, 0, 1, 1, 1, 1],
                [1, 0, 0, 0, 0, -2],
                [0, 1, 0, 1, -1, 1],
                [1, 2, -4, 1, 1, 1]
            ],
            [
                [1, -1, 1, 1, 1, 1],
                [3, 0, -4, 4, 4, 2],
                [1, 0, 1, 1, 1, 1],
                [1, 0, 0, 0, 0, -2],
                [0, 1, 0, 1, -1, 1],
                [1, 2, -4, 1, 1, 1]
            ]
        ];

        testCasesN = [
            5,
            3
        ];

        for i in range(len(testCasesM)):
            self.test(testCasesM[i], testCasesN[i], self.test_case_solution_output(testCasesM[i], testCasesN[i]))

    def test(self, m, n, expected):
        solution = Solution()
        result = solution.find_most_valuable_area(m, n)
        passed = result == expected
        print(f"Matrix: {m}")
        print(f"n: {n}")
        print(f"Expected: {expected}")
        print(f"Your Output: {result}")
        print("Test " + ("PASSED" if passed else "FAILED"))
        print("-----------")

    def test_case_solution_output(self, m, n):
        rows = len(m)
        if rows == 0 or n > rows or n > len(m[0]):
            return [[-1, -1], [-1, -1]] # Test cases should always be valid, so we return [-1, -1] if not

        cols = len(m[0])
        prefixSum = [[0] * (cols + 1) for _ in range(rows + 1)]
        
        for i in range(1, rows + 1):
            for j in range(1, cols + 1):
                prefixSum[i][j] = m[i - 1][j - 1] + prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1]

        maxSum = float('-inf')
        topLeft = [0, 0]
        bottomRight = [0, 0]

        for i in range(n, rows + 1):
            for j in range(n, cols + 1):
                currentSum = prefixSum[i][j] - prefixSum[i - n][j] - prefixSum[i][j - n] + prefixSum[i - n][j - n]
                if currentSum > maxSum:
                    maxSum = currentSum
                    topLeft = [i - n, j - n]
                    bottomRight = [i - 1, j - 1]

        return [topLeft, bottomRight]
                
                
        
