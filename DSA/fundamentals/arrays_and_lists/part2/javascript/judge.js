const Solution = require('./solution');

class Judge {
    runTests() {
        const testCasesC = [
            ["Plateau", "Haven", "Insomnia", "Grand Trad", "Plateau", "Sunville"],
            ["Plateau", "Haven", "Insomnia", "Grand Trad", "Sunville", "Bronze City", "Sunville"],
        ];

        let passes = 0;
        for (let i = 0; i < testCasesC.length; i++) {
            if (this.test(testCasesC[i], this.testCaseSolutionOutput(testCasesC[i]))) {
                passes++;
            }
        }
        console.log(`Passed ${passes} of ${testCasesC.length} tests.`);
    }

    test(c, expected) {
        const solution = new Solution();
        const output = solution.dispatchTo(c);
        const passed = output === expected;

        console.log(`c: ${JSON.stringify(c)}`);
        console.log(`Expected Output: ${expected}`);
        console.log(`Your Output: ${output}`);
        console.log(passed ? "Test PASSED" : "Test FAILED");
        console.log("-----------");
        return passed;
    }

    testCaseSolutionOutput(c) {
        const seen = [];
        for (const city of c) {
            if (seen.includes(city)) {
                return city;
            }
            seen.push(city);
        }
        return "";
    }
}

module.exports = Judge;