const Solution = require('./solution');

class Judge {
    runTests() {
        const testCasesF = [
            [
                [1, 1, 1, 1, 1, 1],
                [3, 0, 1, 1, 0, 2],
                [1, 0, 1, 1, 0, 1],
                [1, 0, 0, 0, 0, 2],
                [2, 0, 0, 1, 1, 1],
                [1, 1, 1, 1, 1, 1]
            ],
            [
                [1, 1, 1, 1, 1, 1],
                [3, 0, 0, 0, 0, 2],
                [1, 1, 0, 1, 0, 1],
                [1, 0, 0, 0, 0, 2],
                [2, 0, 1, 1, 1, 1],
                [1, 1, 1, 0, 0, 1]
            ]
        ];

        testCasesF.forEach(testCase => {
            this.test(testCase, this.testCaseSolutionOutput(testCase));
        });
    }

    test(f, expected) {
        const solution = new Solution();
        const actual = solution.shortestPath(f);
        const passed = JSON.stringify(actual) === JSON.stringify(expected);

        console.log(`Input: ${JSON.stringify(f)}`);
        console.log(`Expected: ${JSON.stringify(expected)}`);
        console.log(`Actual: ${JSON.stringify(actual)}`);
        console.log(passed ? "Test PASSED" : "Test FAILED");
        console.log("-----------");
    }

    testCaseSolutionOutput(f) {
        const directions = [
            [0, 1],
            [1, 0],
            [0, -1],
            [-1, 0]
        ];

        const rows = f.length;
        const cols = f[0].length;

        const visited = Array.from({ length: rows }, () => Array(cols).fill(false));
        const queue = [];

        for (let i = 0; i < rows; i++) {
            for (let j = 0; j < cols; j++) {
                if (f[i][j] === 3) {
                    queue.push([i, j]);
                    visited[i][j] = true;
                    break;
                }
            }
        }

        while (queue.length > 0) {
            const [x, y] = queue.shift();

            if (f[x][y] === 2) {
                return `${x},${y}`;
            }

            for (let i = 0; i < 4; i++) {
                const nx = x + directions[i][0];
                const ny = y + directions[i][1];    
                
                if (nx >= 0 && nx < rows && ny >= 0 && ny < cols && !visited[nx][ny] && f[nx][ny] !== 1) {
                    queue.push([nx, ny]);
                    visited[nx][ny] = true;
                }
            }
        }

        return "";
    }
}

module.exports = Judge;