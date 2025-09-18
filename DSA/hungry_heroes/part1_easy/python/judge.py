from collections import Counter
from solution import Solution

class Judge:
    def run_tests(self):
        test_cases = [
            ["Beef", "Beef", "Chicken", "Pork", "Vegetable", "Grain", "Vegetable", "Vegetable"],
            ["Beef"],
            ["Chicken", "Beef", "Beef", "Beef", "Beef", "Beef", "Beef", "Beef", "Beef", "Beef", "Beef", "Beef", "Beef", "Beef", "Beef", "Beef", "Beef", "Beef", "Beef", "Beef", "Beef"],
            ["Vegetable", "Beef", "Vegetable", "Grain", "Grain"],
            ["Fruit", "Beef", "Vegetable"],
            ["Fruit", "Beef", "Vegetable", "Grain", "Grain"],
            ["Fruit", "Beef", "Vegetable", "Fruit"],
            ["Grain", "Grain"],
            ["Chicken", "Fruit", "Pork", "Grain", "Vegetable"],
            ["Vegetable", "Vegetable", "Vegetable", "Vegetable"],
            ["Grain", "Fruit", "Grain", "Fruit", "Grain", "Fruit"],
            ["Pork", "Chicken", "Beef", "Fruit"],
            ["Beef", "Grain", "Grain", "Grain", "Fruit"],
            ["Pork", "Pork", "Pork", "Chicken", "Chicken", "Vegetable"],
            ["Grain", "Vegetable", "Fruit", "Grain", "Vegetable", "Fruit"],
            ["Fruit", "Fruit", "Fruit", "Fruit", "Fruit"],
            ["Beef", "Vegetable", "Grain", "Chicken", "Pork", "Fruit"],
            ["Pork"],
            []
        ]

        passes = 0;
        for test_case in test_cases:
            if self.test(test_case, self.test_case_solution_output(test_case)):
                passes += 1
        print(f"Passed {passes} of {len(test_cases)} tests.")

    def test(self, stock, expected):
        solution = Solution()
        actual = solution.split_food(stock)
        passed = actual == expected
        print(f"Input: {stock}")
        print(f"Expected: {expected}")
        print(f"Actual: {actual}")
        print("Test " + ("PASSED" if passed else "FAILED"))
        print("-----------")
        return passed

    def test_case_solution_output(self, stock):
        food_count = Counter(stock)
        result = []
        for food, count in food_count.items():
            result.append(food)
            result.append(str(count))
        return result
