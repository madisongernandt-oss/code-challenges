from collections import Counter
from solution import Solution

class Judge:
    def run_tests(self):
        test_cases = [
            ["Beef", "Beef", "Beef"],
            ["Beef", "Beef", "Chicken", "Pork", "Vegetable", "Grain", "Vegetable", "Vegetable"],
            ["Fruit", "Grain", "Fruit", "Grain", "Beef"],
            []
        ]
        for test_case, expected in test_cases:
            self.test(test_case, expected)

    def test(self, stock, expected):
        solution = Solution()
        actual = solution.split_food(stock)
        passed = actual == expected
        print(f"Input: {stock}")
        print(f"Expected: {expected}")
        print(f"Actual: {actual}")
        print("Test " + ("PASSED" if passed else "FAILED"))
        print("-----------")

    def test_case_solution_output(self, stock):
        food_count = Counter(stock)
        result = []
        for food, count in food_count.items():
            result.append(food)
            result.append(str(count))
        return result
