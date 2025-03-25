from collections import defaultdict, deque
from solution import Solution

class Judge:
    def run_tests(self):
        test_cases_paths = [
            [
                [2, 1],
                [0, 1],
                [1, 3],
                [5, 3],
                [2, 4],
                [3, 6]
            ],
            [
                [0,1],
                [1,3],
                [2,3],
                [4,0],
                [4,5]
            ]
        ];

        test_cases_n = [
            7,
            6
        ];

        for test_case_paths, test_case_n in zip(test_cases_paths, test_cases_n):
            self.test(test_case_paths, test_case_n)

    def test(self, test_case_paths, test_case_n):
        solution = Solution()
        actual = solution.redirect_paths(test_case_paths, test_case_n)
        expected = self.test_case_solution_output(test_case_paths, test_case_n)
        passed = actual == expected
        print(f"Nodes: {test_case_n}")
        print(f"Paths: {test_case_paths}")
        print(f"Expected: {expected}")
        print(f"Actual: {actual}")
        print("Test " + ("PASSED" if passed else "FAILED"))
        print("-----------")

    def test_case_solution_output(self, paths, n):
        graph = defaultdict(list)
        reversed_edges = set()

        for from_node, to_node in paths:
            graph[from_node].append(to_node)
            graph[to_node].append(from_node)
            reversed_edges.add((from_node, to_node))

        swaps = 0
        visited = set()
        stack = deque([0])

        while stack:
            node = stack.pop()
            visited.add(node)

            for neighbor in graph[node]:
                if neighbor not in visited:
                    if (node, neighbor) in reversed_edges:
                        swaps += 1
                    stack.append(neighbor)

        return swaps
        
