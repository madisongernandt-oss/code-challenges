const Solution = require('./solution');

class Judge {
    runTests() {
        const testCasesPaths = [
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

        const testCasesN = [
            7,
            6
        ];

        testCasesPaths.forEach((testCasePaths, index) => {
            this.test(testCasePaths, testCasesN[index], this.testCaseSolutionOutput(testCasePaths, testCasesN[index]));
        });
    }

    test(testCasePaths, testCaseN, expected) {
        const solution = new Solution();
        const actual = solution.redirectPaths(testCasePaths, testCaseN);
        const passed = JSON.stringify(actual) === JSON.stringify(expected);

        console.log(`Nodes: ${testCaseN}`);
        console.log(`Paths: ${JSON.stringify(testCasePaths)}`);
        console.log(`Expected: ${JSON.stringify(expected)}`);
        console.log(`Your Output: ${JSON.stringify(actual)}`);
        console.log(passed ? "Test PASSED" : "Test FAILED");
        console.log("-----------");
    }

    testCaseSolutionOutput(testCasePaths, testCaseN) {
        const graph = new Map();
        const reversedEdges = new Set();

        for(const [from, to] of testCasePaths) {
            if(!graph.has(from)) graph.set(from, []);
            if(!graph.has(to)) graph.set(to, []);
            graph.get(from).push(to);
            graph.get(to).push(from);
            reversedEdges.add(from + "," + to);
        }

        let swaps = 0;
        const visited = new Set();
        const dfs = (node) => {
            visited.add(node);
            for(let neighbor of graph.get(node)) {
                if(!visited.has(neighbor)) {
                    if(reversedEdges.has(node + "," + neighbor)) {
                        swaps++;
                    }
                    dfs(neighbor);
                }
            }
        }
    
        dfs(0);
        return swaps;
    }
}

module.exports = Judge;