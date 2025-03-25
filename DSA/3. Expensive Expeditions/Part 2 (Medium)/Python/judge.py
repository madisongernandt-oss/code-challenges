from collections import Counter
from solution import Solution

class Judge:
    def run_tests(self):
        test_cases = [
            "Hh-e-ell-l-lo-o",
            "Goodbye-------",
            "Peek----a-Boo",
        ]
        for test_case in test_cases:
            self.test(test_case, self.test_case_solution_output(test_case))

    def test(self, p, expected):
        solution = Solution()
        result = solution.decode_message(p)
        passed = result == expected
        print(f"Message: {p}")
        print(f"Expected: {expected}")
        print(f"Your Output: {result}")
        print("Test " + ("PASSED" if passed else "FAILED"))
        print("-----------")

    def test_case_solution_output(self, m):
        stack = []
        for char in m:
            if char == '-':
                stack.pop()
            else:
                stack.append(char)
        return ''.join(stack)
