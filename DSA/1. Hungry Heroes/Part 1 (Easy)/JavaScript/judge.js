const Solution = require('./solution');

class Judge {
    runTests() {
        const testCases = [
            ["Beef", "Beef", "Beef"],
            ["Beef", "Beef", "Chicken", "Pork", "Vegetable", "Grain", "Vegetable", "Vegetable"],
            ["Fruit", "Grain", "Fruit", "Grain", "Beef"],
            ["Fruit", "Beef", "Vegetable"],
            []
        ];

        testCases.forEach(testCase => {
            this.test(testCase, this.testCaseSolutionOutput(testCase));
        });
    }

    test(stock, expected) {
        const solution = new Solution();
        const actual = solution.splitFood(stock);
        const passed = JSON.stringify(actual) === JSON.stringify(expected);

        console.log(`Input: ${JSON.stringify(stock)}`);
        console.log(`Expected: ${JSON.stringify(expected)}`);
        console.log(`Actual: ${JSON.stringify(actual)}`);
        console.log(passed ? "Test PASSED" : "Test FAILED");
        console.log("-----------");
    }

    testCaseSolutionOutput(stock) {
        const foodCount = stock.reduce((acc, food) => {
            acc[food] = (acc[food] || 0) + 1;
            return acc;
        }, {});

        const result = [];
        for (const [food, count] of Object.entries(foodCount)) {
            result.push(food);
            result.push(count.toString());
        }
        return result;
    }
}

module.exports = Judge;