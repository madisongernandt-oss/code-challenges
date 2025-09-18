const Solution = require('./solution');

class Judge {

    runTests() {
        const testCasesC = [
            ["Beef", "Beef", "Chicken", "Pork", "Vegetable", "Grain", "Vegetable", "Vegetable"],
            ["Fruit", "Beef", "Vegetable"],
            ["Beef", "Beef", "Beef"],
            ["Fruit", "Beef", "Vegetable"],
        ];

        const testCasesP = [
            ["Beef", "2", "Chicken", "1", "Pork", "2", "Vegetable", "0.5", "Grain", "1", "Fruit", "0.5"],
            ["Beef", "2", "Chicken", "1", "Pork", "2", "Vegetable", "0.5", "Grain", "1", "Fruit", "0.5"],
            ["Beef", "2", "Chicken", "1", "Pork", "2", "Vegetable", "0.5", "Grain", "1", "Fruit", "0.5"],
            ["Beef", "2", "Chicken", "1", "Pork", "2", "Vegetable", "0.5", "Grain", "1", "Fruit", "0.5"],
        ];

        const testCasesQ = [
            [[1, 3], [0, 4], [2, 6]],
            [[0, 2]],
            [[0, 2]],
            [[0, 1]],
        ];

        for (let i = 0; i < testCasesC.length; i++) {
            this.test(testCasesC[i], testCasesP[i], testCasesQ[i], this.testCaseSolutionOutput(testCasesC[i], testCasesP[i], testCasesQ[i]));
        }
    }

    test(c, p, q, expected) {
        const sol = new Solution();
        const output = sol.calculateSatisfaction(c, p, q);
        const passed = this.arrayEquals(output, expected);

        console.log("Test Case:");
        console.log("c:", JSON.stringify(c));
        console.log("p:", JSON.stringify(p));
        console.log("q:", JSON.stringify(q));
        console.log("Expected:", JSON.stringify(expected));
        console.log("Output:", JSON.stringify(output));
        console.log(passed ? "Test PASSED" : "Test FAILED");
        console.log("-----------");

        return passed;
    }

    arrayEquals(a, b) {
        return JSON.stringify(a) === JSON.stringify(b);
    }

    testCaseSolutionOutput(c, p, q) {
        const satisfactionMap = new Map();
        for (let i = 0; i < p.length; i += 2) {
            const food = p[i];
            const satisfaction = parseFloat(p[i + 1]);
            satisfactionMap.set(food, satisfaction);
        }

        const prefixSum = new Array(c.length + 1).fill(0);
        for (let i = 0; i < c.length; i++) {
            const satisfaction = satisfactionMap.get(c[i]) || 0.0;
            prefixSum[i + 1] = prefixSum[i] + satisfaction;
        }

        const result = new Array(q.length);
        for (let i = 0; i < q.length; i++) {
            const [start, end] = q[i];
            result[i] = prefixSum[end + 1] - prefixSum[start];
        }

        return result;
    }
}

module.exports = Judge;