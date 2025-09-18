const Solution = require('./solution');

class Judge {
    runTests() {
        const testCasesP = [
            [4, 1, 4, 7, 3, 6],
            [1, 2, 3, 4, 5, 6, 7],
        ];
        const testCasesB = [
            7,
            10,
        ];

        let passes = 0;
        for (let i = 0; i < testCasesP.length; i++) {
            if (this.test(testCasesP[i], testCasesB[i], this.testCaseSolutionOutput(testCasesP[i], testCasesB[i]))) {
                passes++;
            }
        }
        console.log(`Passed ${passes} of ${testCasesP.length} tests.`);
    }

    test(p, b, expected) {
        const solution = new Solution();
        const output = solution.twoItems(p, b);
        const passed = output && output.length === 2 && p[output[0]] + p[output[1]] === b;

        console.log(`p: ${JSON.stringify(p)}`);
        console.log(`b: ${b}`);
        console.log(`Expected Output: Any valid pair like ${JSON.stringify(expected)}`);
        console.log(`Your Output: ${JSON.stringify(output)}`);
        console.log(passed ? "Test PASSED" : "Test FAILED");
        console.log("-----------");
        return passed;
    }

    testCaseSolutionOutput(p, b) {
        const seen = new Map();
        for (let i = 0; i < p.length; i++) {
            const complement = b - p[i];
            if (seen.has(complement)) {
                return [seen.get(complement), i];
            }
            seen.set(p[i], i);
        }
        return [];
    }
}

module.exports = Judge;