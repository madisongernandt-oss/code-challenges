from solution import Solution

class Judge:
    def run_tests(self):
        test_cases_n = [
            ["Doe, John", "Smith, Jane", "Johnson, Jim"],
            ["Doe, John", "Smith, Jane", "Johnson, Jim", "Williams, Mary", "Brown, Bob"],
        ]

        passes = 0;
        for i in range(len(test_cases_n)):
            if self.test(test_cases_n[i].copy(), self.test_case_solution_output(test_cases_n[i].copy())):
                passes += 1
        print(f"Passed {passes} of {len(test_cases_n)} tests.")

    def test(self, n, expected):
        solution = Solution()
        user_map = {}
        solution.store_names(n, user_map)
        passed = len(user_map) == len(expected) and set(user_map.values()) == set(expected.values())

        print(f"n: {n}")
        print(f"Expected Output: {list(expected.values())}")
        print(f"Your Output: {list(user_map.values())}")
        print("Test " + ("PASSED" if passed else "FAILED"))
        print("-----------")
        return passed

    def test_case_solution_output(self, n):
        expected_map = {}
        for i, name in enumerate(n):
            parts = name.split(", ")
            expected_map[str(i)] = parts[1] + " " + parts[0]
        return expected_map