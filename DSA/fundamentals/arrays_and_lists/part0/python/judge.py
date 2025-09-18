from solution import Solution

class Judge:
    def run_tests(self):
        test_cases_a = [
            [1, 2, 3, 4, 5],
            [1, 2, 3, 4, 5],
        ]
        test_cases_k = [
            1,
            0,
        ]

        passes = 0;
        for i in range(len(test_cases_a)):
            if self.test(test_cases_a[i].copy(), test_cases_k[i], self.test_case_solution_output(test_cases_a[i].copy(), test_cases_k[i])):
                passes += 1
        print(f"Passed {passes} of {len(test_cases_a)} tests.")

    def test(self, a, k, expected):
        solution = Solution()
        solution.increment_array(a, k)
        passed = a == expected

        print(f"a: {a}")
        print(f"k: {k}")
        print(f"Expected Output: {expected}")
        print(f"Your Output: {a}")
        print("Test " + ("PASSED" if passed else "FAILED"))
        print("-----------")
        return passed

    def test_case_solution_output(self, a, k):
        for i in range(len(a)):
            a[i] += k
        return a