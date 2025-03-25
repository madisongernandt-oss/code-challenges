const Solution = require('./solution');

class Judge {
    runTests() {
        const testCases = [
            "Hh-e-ell-l-lo-o",
            "Goodbye-------",
            "Peek----a-Boo",
        ];

        testCases.forEach(testCase => {
            this.test(testCase, this.testCaseSolutionOutput(testCase));
        });
    }

    test(p, expected) {
        const solution = new Solution();
        const result = solution.decodeMessage(p);
        const passed = result === expected;
        console.log(`Message: ${p}`);
        console.log(`Expected: ${expected}`);
        console.log(`Your Output: ${result}`);
        console.log(passed ? "Test PASSED" : "Test FAILED");
        console.log("-----------");
    }

    testCaseSolutionOutput(p) {
        const stack = [];
        for (const char of p) {
            if (char === '-') {
                stack.pop();
            } else {
                stack.push(char);
            }
        }
        return stack.join('');
    }
}

module.exports = Judge;