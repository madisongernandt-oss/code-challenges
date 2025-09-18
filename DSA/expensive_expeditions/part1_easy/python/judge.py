from collections import Counter
from solution import Solution

class Judge:
    def run_tests(self):
        test_cases = [
            [0,1,2,5,2,10,30,4,7,0,0,0,1],  
            [5, 5, 5, 5, 5, 5, 5, 5],       
            [100, 99, 98, 50, 10, 5, 1, 0],  
            [0, 0, 0, 0, 0],                 
            [100, 100, 100, 99, 99, 50, 1],  
            [1, 2, 3, 4, 5, 6, 7, 8, 9],     
            [9, 8, 7, 6, 5, 4, 3, 2, 1],     
            [50, 20, 40, 10, 30, 60, 70],    
            [0, 1, 100, 99, 98, 2, 97, 3],   
            [42],                           
        ]
        for test_case in test_cases:
            self.test(test_case, self.test_case_solution_output(test_case))

    def test(self, p, expected):
        solution = Solution()
        pCopy = p.copy()
        solution.modify_places(pCopy)
        passed = pCopy == expected
        print(f"Places: {p}")
        print(f"Expected: {expected}")
        print(f"Your Output: {pCopy}")
        print("Test " + ("PASSED" if passed else "FAILED"))
        print("-----------")

    def test_case_solution_output(self, p):
        p_copy = p.copy()
        count = [0] * 101
        for num in p_copy:
            count[num] += 1
        index = 0
        for value in range(100, -1, -1):
            while count[value] > 0:
                p_copy[index] = value
                count[value] -= 1
                index += 1
        return p_copy
