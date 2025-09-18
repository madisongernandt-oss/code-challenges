from solution import Solution

class Judge:
    def run_tests(self):
        test_cases_p = [
            [1, 2, 4, 5],
            [1, 2, 4, 5],
        ]
        test_cases_m = [
            [2, 2, 5, 10],
            [2, 1, 5, 0],
        ]

        passes = 0;
        for i in range(len(test_cases_p)):
            if self.test(test_cases_p[i].copy(), test_cases_m[i].copy(), self.test_case_solution_output(test_cases_p[i].copy(), test_cases_m[i].copy())):
                passes += 1
        print(f"Passed {passes} of {len(test_cases_p)} tests.")

    def test(self, p, m, expected):
        solution = Solution()
        output = solution.difference(p, m)
        passed = output == expected

        print(f"p: {p}")
        print(f"m: {m}")
        print(f"Expected Output: {expected}")
        print(f"Your Output: {output}")
        print("Test " + ("PASSED" if passed else "FAILED"))
        print("-----------")
        return passed

    def test_case_solution_output(self, p, m):
        sum = 0
        for i in range(len(p)):
            sum += m[i] - p[i]
        return sum