from solution import Solution

class Judge:
    def run_tests(self):
        test_cases_t = [
            [1, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 0, 0, 1],
            [1, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 0, 0, 1],
        ]

        test_cases_b = [
            5,
            3
        ]
        
        for test_case_t, test_case_b in zip(test_cases_t, test_cases_b):
            self.test(test_case_t, test_case_b, self.test_case_solution_output(test_case_t, test_case_b))

    def test(self, t, b, expected):
        solution = Solution()
        actual = solution.buildBridges(t, b)
        passed = actual == expected
        print(f"Terrain: {t}")
        print(f"Bridges: {b}")
        print(f"Expected: {expected}")
        print(f"Actual: {actual}")
        print("Test " + ("PASSED" if passed else "FAILED"))
        print("-----------")

    def test_case_solution_output(self, t, b):
        n = len(t)
        bridges_used = 0
        for i in range(n):
            if t[i] == 0:
                start = i
                while i < n and t[i] == 0:
                    i += 1
                length = i - start
                if length > 1:
                    if bridges_used + (length - 1) > b:
                        return []
                    for j in range(start, i - 1):
                        t[j] = 2
                        bridges_used += 1
        return t