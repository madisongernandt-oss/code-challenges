const Solution = require('./solution');

class Judge {
    runTests() {
        const testCases = [
            "h-H-+e-e-+lll-l-o-o",
            "Goodbye-------+oodmorning!",
            "Foo_----_-B-+a-+r-+",
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
        let prev = null;
        for (const char of p) {
            if (char === '-') {
                if (stack.length > 0) {
                    prev = stack.pop();
                }
            } else if (char === '+') {
                if (prev !== null) {
                    stack.push(prev);
                }
            } else {
                stack.push(char);
            }
        }
        return stack.join('');
    }
}

module.exports = Judge;