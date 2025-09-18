const Solution = require('./solution');

class Judge {
    runTests() {
        const testCases = [
            [5, 3, 6, 4, 2, 3],
            [1, 2, 4, 8, 16, 32],
        ];

        testCases.forEach(testCase => {
            this.test(testCase, this.testCaseSolutionOutput(testCase));
        });
    }

    test(h, expected) {
        const solution = new Solution();
        const actual = solution.canCross(h);
        const passed = actual === expected;

        console.log(`Heights: ${h}`);
        console.log(`Expected: ${expected}`);
        console.log(`Your Output: ${actual}`);
        console.log(passed ? "Test PASSED" : "Test FAILED");
        console.log("-----------");
    }

    testCaseSolutionOutput(h) {
        for (let i = 1; i < h.length; i++) {
            const diff = Math.abs(h[i] - h[i - 1]);
            if (diff > h[i] || diff > h[i - 1]) {
                return false;
            }
        }
        return true;
    }
}

module.exports = Judge;