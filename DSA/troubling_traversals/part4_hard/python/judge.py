from solution import Solution
import heapq


class Judge:
    def run_tests(self):
        test_cases_f = [
            [
                [1, 1, 1, 1, 1, 1],
                [3, 0, 4, 4, 4, 2],
                [1, 0, 1, 1, 1, 1],
                [1, 0, 0, 0, 0, 2],
                [0, 1, 0, 1, 1, 1],
                [1, 2, 4, 1, 1, 1]
            ]
        ]

        for test_case in test_cases_f:
            self.test(test_case, self.test_case_solution_output(test_case))

    def test(self, f, expected):
        solution = Solution()
        actual = solution.shortestPath(f)
        passed = actual == expected
        print(f"Input: {f}")
        print(f"Expected: {expected}")
        print(f"Actual: {actual}")
        print("Test " + ("PASSED" if passed else "FAILED"))
        print("-----------")

    def test_case_solution_output(self, f):
        rows = len(f)
        cols = len(f[0])
        start = None
        visited = [[False] * cols for _ in range(rows)]
        directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]

        for i in range(rows):
            for j in range(cols):
                if f[i][j] == 3:
                    start = (i, j)
                    break
            if start:
                break

        pq = []
        heapq.heappush(pq, (0, start[0], start[1]))

        while pq:
            dist, row, col = heapq.heappop(pq)

            if visited[row][col]:
                continue
            visited[row][col] = True

            if f[row][col] == 2:
                return [str(row), str(col)]

            for dir in directions:
                newRow, newCol = row + dir[0], col + dir[1]

                if 0 <= newRow < rows and 0 <= newCol < cols and not visited[newRow][newCol] and f[newRow][newCol] != 1:
                    newDist = dist + 1
                    if f[newRow][newCol] == 4:
                        newDist += 1
                heapq.heappush(pq, (newDist, newRow, newCol))
                
        return []
