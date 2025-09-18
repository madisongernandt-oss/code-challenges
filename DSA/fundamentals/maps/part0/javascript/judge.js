const Solution = require('./solution');

class Judge {
    runTests() {
        const testCasesN = [
            ["Doe, John", "Smith, Jane", "Johnson, Jim"],
            ["Doe, John", "Smith, Jane", "Johnson, Jim", "Williams, Mary", "Brown, Bob"],
        ];

        let passes = 0;
        for (let i = 0; i < testCasesN.length; i++) {
            if (this.test(testCasesN[i], this.testCaseSolutionOutput(testCasesN[i]))) {
                passes++;
            }
        }
        console.log(`Passed ${passes} of ${testCasesN.length} tests.`);
    }

    test(n, expected) {
        const solution = new Solution();
        const userMap = new Map();
        solution.storeNames(n, userMap);
        
        const userValues = Array.from(userMap.values()).sort();
        const expectedValues = Array.from(expected.values()).sort();
        const passed = userMap.size === expected.size && 
                      JSON.stringify(userValues) === JSON.stringify(expectedValues);

        console.log(`n: ${JSON.stringify(n)}`);
        console.log(`Expected Output: ${JSON.stringify(Array.from(expected.values()))}`);
        console.log(`Your Output: ${JSON.stringify(Array.from(userMap.values()))}`);
        console.log(passed ? "Test PASSED" : "Test FAILED");
        console.log("-----------");
        return passed;
    }

    testCaseSolutionOutput(n) {
        const expectedMap = new Map();
        for (let i = 0; i < n.length; i++) {
            const parts = n[i].split(", ");
            expectedMap.set(i.toString(), parts[1] + " " + parts[0]);
        }
        return expectedMap;
    }
}

module.exports = Judge;