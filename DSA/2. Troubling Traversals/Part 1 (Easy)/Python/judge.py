from collections import Counter
from solution import Solution

class Judge:
    def run_tests(self):
        test_cases = [
            [5, 3, 6, 4, 2, 3],
            [1, 2, 4, 8, 16, 32],
        ]
        for test_case in test_cases:
            self.test(test_case, self.test_case_solution_output(test_case))

    def test(self, h, expected):
        solution = Solution()
        actual = solution.can_cross(h)
        passed = actual == expected
        print(f"Heights: {h}")
        print(f"Expected: {expected}")
        print(f"Your Output: {actual}")
        print("Test " + ("PASSED" if passed else "FAILED"))
        print("-----------")

    def test_case_solution_output(self, h):
        for i in range(1, len(h)):
            diff = abs(h[i] - h[i - 1])
            if diff > h[i] or diff > h[i - 1]:
                return False
        return True
