const Solution = require('./solution');

class Judge {
    runTests() {
        const testCasesM = [
            [
                [1, -1, 1, 1, 1, 1],
                [3, 0, -4, 4, 4, 2],
                [1, 0, 1, 1, 1, 1],
                [1, 0, 0, 0, 0, -2],
                [0, 1, 0, 1, -1, 1],
                [1, 2, -4, 1, 1, 1]
            ],
            [
                [1, -1, 1, 1, 1, 1],
                [3, 0, -4, 4, 4, 2],
                [1, 0, 1, 1, 1, 1],
                [1, 0, 0, 0, 0, -2],
                [0, 1, 0, 1, -1, 1],
                [1, 2, -4, 1, 1, 1]
            ]
        ];

        const testCasesN = [
            5,
            3
        ];

        for(let i = 0; i < testCasesM.length; i++) {
            this.test(testCasesM[i], testCasesN[i], this.testCaseSolutionOutput(testCasesM[i], testCasesN[i]));
        }
    }

    test(m, n, expected) {
        const solution = new Solution();
        const result = solution.findMostValuableArea(m, n);
        const passed = result === expected;
        console.log(`Matrix: ${m}`);
        console.log(`n: ${n}`);
        console.log(`Expected: ${expected}`);
        console.log(`Your Output: ${result}`);
        console.log(passed ? "Test PASSED" : "Test FAILED");
        console.log("-----------");
    }

    testCaseSolutionOutput(m, n) {
        const rows = m.length;
        
        if (rows === 0 || n > rows || n > m[0].length) return [[-1, -1], [-1, -1]]; // Test cases should always be valid, so we return [-1, -1] if not
        const cols = m[0].length;

        const prefixSum = new Array(rows + 1).fill(0).map(() => new Array(cols + 1).fill(0));
        for(let i = 1; i <= rows; i++) {
            for(let j = 1; j <= cols; j++) {
                prefixSum[i][j] = m[i - 1][j - 1] + prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1];
            }
        }

        let maxSum = -Infinity;
        let topLeft = [0, 0];
        let bottomRight = [0, 0];

        for(let i = n; i <= rows; i++) {
            for(let j = n; j <= cols; j++) {
                const currentSum = prefixSum[i][j] - prefixSum[i - n][j] - prefixSum[i][j - n] + prefixSum[i - n][j - n];
                if(currentSum > maxSum) {
                    maxSum = currentSum;
                    topLeft = [i - n, j - n];
                    bottomRight = [i - 1, j - 1];
                }
            }
        }

        return [topLeft, bottomRight];
    }
}

module.exports = Judge;