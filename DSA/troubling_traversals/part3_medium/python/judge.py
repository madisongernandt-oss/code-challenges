from collections import Counter
from solution import Solution

class Judge:
    def run_tests(self):
        test_cases_f = [
            [
                [1, 1, 1, 1, 1, 1],
                [3, 0, 1, 1, 0, 2],
                [1, 0, 1, 1, 0, 1],
                [1, 0, 0, 0, 0, 2],
                [2, 0, 0, 1, 1, 1],
                [1, 1, 1, 1, 1, 1]
            ],
            [
                [1, 1, 1, 1, 1, 1],
                [3, 0, 0, 0, 0, 2],
                [1, 1, 0, 1, 0, 1],
                [1, 0, 0, 0, 0, 2],
                [2, 0, 1, 1, 1, 1],
                [1, 1, 1, 0, 0, 1]
            ]
        ]
        for test_case_f in test_cases_f:
            self.test(test_case_f, self.test_case_solution_output(test_case_f))

    def test(self, f, expected):
        solution = Solution()
        actual = solution.shortest_path(f)
        passed = actual == expected
        print(f"Input: {f}")
        print(f"Expected: {expected}")
        print(f"Actual: {actual}")
        print("Test " + ("PASSED" if passed else "FAILED"))
        print("-----------")

    def test_case_solution_output(self, f):
        directions = [
            [0, 1],
            [1, 0],
            [0, -1],
            [-1, 0]
        ]
        
        rows = len(f)
        cols = len(f[0])

        visited = [[False] * cols for _ in range(rows)]
        queue = []

        for i in range(rows):
            for j in range(cols):
                if f[i][j] == 3:
                    queue.append((i, j))
                    visited[i][j] = True
                    break

        while queue:
            x, y = queue.pop(0)

            if f[x][y] == 2:
                return f"{x},{y}"
                
            for dx, dy in directions:
                nx, ny = x + dx, y + dy

                if 0 <= nx < rows and 0 <= ny < cols and not visited[nx][ny] and f[nx][ny] != 1:
                    queue.append((nx, ny))
                    visited[nx][ny] = True

        return ""
        
        
        
