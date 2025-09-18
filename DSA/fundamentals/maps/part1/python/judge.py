from solution import Solution

class Judge:
    def run_tests(self):
        test_cases_p = [
            [4, 1, 4, 7, 3, 6],
            [1, 2, 3, 4, 5, 6, 7],
        ]
        test_cases_b = [
            7,
            10,
        ]

        passes = 0;
        for i in range(len(test_cases_p)):
            if self.test(test_cases_p[i].copy(), test_cases_b[i], self.test_case_solution_output(test_cases_p[i].copy(), test_cases_b[i])):
                passes += 1
        print(f"Passed {passes} of {len(test_cases_p)} tests.")

    def test(self, p, b, expected):
        solution = Solution()
        output = solution.two_items(p, b)
        passed = output is not None and len(output) == 2 and p[output[0]] + p[output[1]] == b

        print(f"p: {p}")
        print(f"b: {b}")
        print(f"Expected Output: Any valid pair like {expected}")
        print(f"Your Output: {output}")
        print("Test " + ("PASSED" if passed else "FAILED"))
        print("-----------")
        return passed

    def test_case_solution_output(self, p, b):
        seen = {}
        for i, num in enumerate(p):
            complement = b - num
            if complement in seen:
                return [seen[complement], i]
            seen[num] = i
        return []