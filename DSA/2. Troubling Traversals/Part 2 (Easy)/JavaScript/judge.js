const Solution = require('./solution');

class Judge {
    runTests() {
        const testCasesT = [
            [1, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 0, 0, 1],
            [1, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 0, 0, 1],
        ];

        const testCasesB = [
            5,
            3
        ];

        for (let i = 0; i < testCasesT.length; i++) {
            test(testCasesT[i], testCasesB[i], testCaseSolutionOutput(testCasesT[i], testCasesB[i]));
        }
    }

    test(t, b, expected) {
        const solution = new Solution();
        const actual = solution.buildBridges(t, b);
        const passed = JSON.stringify(actual) === JSON.stringify(expected);

        console.log(`Terrain: ${JSON.stringify(t)}`);
        console.log(`Bridges: ${b}`);
        console.log(`Expected: ${JSON.stringify(expected)}`);
        console.log(`Actual: ${JSON.stringify(actual)}`);
        console.log(passed ? "Test PASSED" : "Test FAILED");
        console.log("-----------");
    }

    testCaseSolutionOutput(t, b) {
        const n = t.length;
        let bridgesUsed = 0;
        for (let i = 0; i < n; i++) {
            if (t[i] == 0) {
                let start = i;
                while (i < n && t[i] == 0) {
                    i++;
                }
                const length = i - start;
                if (length > 1) {
                    if (bridgesUsed + (length - 1) > b) {
                        return [];
                    }
                    for (let j = start; j < i - 1; j++) {
                        t[j] = 2;
                        bridgesUsed++;
                    }
                }
            }
        }
        return t;
    }
}

module.exports = Judge;