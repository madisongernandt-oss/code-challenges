from solution import Solution

class Judge:
    def run_tests(self):
        test_cases_c = [
            ["Plateau", "Haven", "Insomnia", "Grand Trad", "Plateau", "Sunville"],
            ["Plateau", "Haven", "Insomnia", "Grand Trad", "Sunville", "Bronze City", "Sunville"],
        ]

        passes = 0;
        for i in range(len(test_cases_c)):
            if self.test(test_cases_c[i].copy(), self.test_case_solution_output(test_cases_c[i].copy())):
                passes += 1
        print(f"Passed {passes} of {len(test_cases_c)} tests.")

    def test(self, c, expected):
        solution = Solution()
        output = solution.dispatch_to(c)
        passed = output == expected

        print(f"c: {c}")
        print(f"Expected Output: {expected}")
        print(f"Your Output: {output}")
        print("Test " + ("PASSED" if passed else "FAILED"))
        print("-----------")
        return passed

    def test_case_solution_output(self, c):
        seen = []
        for city in c:
            if city in seen:
                return city
            seen.append(city)
        return ""