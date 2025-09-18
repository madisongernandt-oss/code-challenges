from solution import Solution

class Judge:

    def run_tests(self):
        test_cases_c = [
            ["Beef", "Beef", "Chicken", "Pork", "Vegetable", "Grain", "Vegetable", "Vegetable"],
            ["Fruit", "Beef", "Vegetable"],
            ["Beef", "Beef", "Beef"],
            ["Fruit", "Beef", "Vegetable"]
        ]

        test_cases_p = [
            ["Beef", "2", "Chicken", "1", "Pork", "2", "Vegetable", "0.5", "Grain", "1", "Fruit", "0.5"],
            ["Beef", "2", "Chicken", "1", "Pork", "2", "Vegetable", "0.5", "Grain", "1", "Fruit", "0.5"],
            ["Beef", "2", "Chicken", "1", "Pork", "2", "Vegetable", "0.5", "Grain", "1", "Fruit", "0.5"],
            ["Beef", "2", "Chicken", "1", "Pork", "2", "Vegetable", "0.5", "Grain", "1", "Fruit", "0.5"]
        ]

        test_cases_q = [
            [[1, 3], [0, 4], [2, 6]],
            [[0, 2]],
            [[0, 2]],
            [[0, 1]]
        ]

        self.run_tests(test_cases_c, test_cases_p, test_cases_q)

    def run_tests(self, c, p, q):
        for i in range(len(c)):
            self.test(c[i], p[i], q[i], self.test_case_solution_output(c[i], p[i], q[i]))

    def test(self, c, p, q, expected):
        sol = Solution()
        output = sol.calculate_satisfaction(c, p, q)
        passed = output == expected

        print("Test Case:")
        print("c:", c)
        print("p:", p)
        print("q:", q)
        print("Expected:", expected)
        print("Output:", output)
        print("Test PASSED" if passed else "Test FAILED")
        print("-----------")

        return passed

    def test_case_solution_output(self, c, p, q):
        satisfaction_map = {}
        for i in range(0, len(p), 2):
            food = p[i]
            satisfaction = float(p[i + 1])
            satisfaction_map[food] = satisfaction

        prefix_sum = [0] * (len(c) + 1)
        for i in range(len(c)):
            satisfaction = satisfaction_map.get(c[i], 0.0)
            prefix_sum[i + 1] = prefix_sum[i] + satisfaction

        result = []
        for start, end in q:
            result.append(prefix_sum[end + 1] - prefix_sum[start])

        return result