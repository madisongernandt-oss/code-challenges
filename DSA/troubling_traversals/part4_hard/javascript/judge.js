const Solution = require('./solution');

class Judge {
    runTests() {
        const testCasesF = [
            [
                [1, 1, 1, 1, 1, 1],
                [3, 0, 4, 4, 4, 2],
                [1, 0, 1, 1, 1, 1],
                [1, 0, 0, 0, 0, 2], 
                [0, 1, 0, 1, 1, 1],
                [1, 2, 4, 1, 1, 1]
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
        const rows = f.length;
        const cols = f[0].length;
        let start = null;
        const visited = Array.from({ length: rows }, () => Array(cols).fill(false));
        const directions = [[-1, 0], [1, 0], [0, -1], [0, 1]];

        for (let i = 0; i < rows; i++) {
            for (let j = 0; j < cols; j++) {
                if (f[i][j] === 3) {
                    start = [i, j];
                    break;
                }
            }
        }

        const pq = [[start[0], start[1], 0]];

        while (pq.length > 0) {
            pq.sort((a, b) => a[0] - b[0]);
            const [dist, row, col] = pq.shift();

            if (visited[row][col]) continue;
            visited[row][col] = true;

            if (f[row][col] === 2) {
                return [String(row), String(col)];
            }

            for (const dir of directions) {
                const newRow = row + dir[0];
                const newCol = col + dir[1];

                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && !visited[newRow][newCol] && f[newRow][newCol] !== 1) {
                    let newDist = dist + 1;
                    if (f[newRow][newCol] === 4) {
                        newDist += 1;
                    }
                    pq.push([newDist, newRow, newCol]);
                }
            }
        }
        
        return null;
    }
}

module.exports = Judge;