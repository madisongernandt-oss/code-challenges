const Solution = require('./solution');

class Judge {
    runTests() {
        const testCasesA = [
            [1, 2, 3, 4, 5],
            [1, 2, 3, 4, 5],
        ];
        const testCasesK = [
            1,
            0,
        ];

        let passes = 0;
        for (let i = 0; i < testCasesA.length; i++) {
            if (this.test(Array.from(testCasesA[i]), testCasesK[i], this.testCaseSolutionOutput(Array.from(testCasesA[i]), testCasesK[i]))) {
                passes++;
            }
        }
        console.log(`Passed ${passes} of ${testCasesA.length} tests.`);
    }

    test(a, k, expected) {
        const solution = new Solution();
        solution.incrementArray(a, k);
        const passed = JSON.stringify(a) === JSON.stringify(expected);

        console.log(`a: ${JSON.stringify(a)}`);
        console.log(`k: ${k}`);
        console.log(`Expected Output: ${JSON.stringify(expected)}`);
        console.log(`Your Output: ${JSON.stringify(a)}`);
        console.log(passed ? "Test PASSED" : "Test FAILED");
        console.log("-----------");
        return passed;
    }

    testCaseSolutionOutput(a, k) {
        for (let i = 0; i < a.length; i++) {
            a[i] += k;
        }
        return a;
    }
}

module.exports = Judge;