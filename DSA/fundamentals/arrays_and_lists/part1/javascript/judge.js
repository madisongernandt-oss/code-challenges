const Solution = require('./solution');

class Judge {
    runTests() {
        const testCasesP = [
            [1, 2, 4, 5],
            [1, 2, 4, 5],
        ];
        const testCasesM = [
            [2, 2, 5, 10],
            [2, 1, 5, 0],
        ];

        let passes = 0;
        for (let i = 0; i < testCasesP.length; i++) {
            if (this.test(testCasesP[i], testCasesM[i], this.testCaseSolutionOutput(testCasesP[i], testCasesM[i]))) {
                passes++;
            }
        }
        console.log(`Passed ${passes} of ${testCasesP.length} tests.`);
    }

    test(p, m, expected) {
        const solution = new Solution();
        const output = solution.difference(p, m);
        const passed = output === expected;

        console.log(`p: ${JSON.stringify(p)}`);
        console.log(`m: ${JSON.stringify(m)}`);
        console.log(`Expected Output: ${expected}`);
        console.log(`Your Output: ${output}`);
        console.log(passed ? "Test PASSED" : "Test FAILED");
        console.log("-----------");
        return passed;
    }

    testCaseSolutionOutput(p, m) {
        let sum = 0;
        for (let i = 0; i < p.length; i++) {
            sum += m[i] - p[i];
        }
        return sum;
    }
}

module.exports = Judge;