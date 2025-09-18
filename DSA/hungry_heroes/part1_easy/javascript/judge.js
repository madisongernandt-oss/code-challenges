const Solution = require('./solution');

class Judge {
    runTests() {
        const testCases = [
            ["Beef", "Beef", "Chicken", "Pork", "Vegetable", "Grain", "Vegetable", "Vegetable"],
            ["Beef"],
            ["Chicken", "Beef", "Beef", "Beef", "Beef", "Beef", "Beef", "Beef", "Beef", "Beef", "Beef", "Beef", "Beef", "Beef", "Beef", "Beef", "Beef", "Beef", "Beef", "Beef", "Beef"],
            ["Vegetable", "Beef", "Vegetable", "Grain", "Grain"],
            ["Fruit", "Beef", "Vegetable"],
            ["Fruit", "Beef", "Vegetable", "Grain", "Grain"],
            ["Fruit", "Beef", "Vegetable", "Fruit"],
            ["Grain", "Grain"],
            ["Chicken", "Fruit", "Pork", "Grain", "Vegetable"],
            ["Vegetable", "Vegetable", "Vegetable", "Vegetable"],
            ["Grain", "Fruit", "Grain", "Fruit", "Grain", "Fruit"],
            ["Pork", "Chicken", "Beef", "Fruit"],
            ["Beef", "Grain", "Grain", "Grain", "Fruit"],
            ["Pork", "Pork", "Pork", "Chicken", "Chicken", "Vegetable"],
            ["Grain", "Vegetable", "Fruit", "Grain", "Vegetable", "Fruit"],
            ["Fruit", "Fruit", "Fruit", "Fruit", "Fruit"],
            ["Beef", "Vegetable", "Grain", "Chicken", "Pork", "Fruit"],
            ["Pork"],
            []
        ];

        let passes = 0;
        testCases.forEach(testCase => {
            if (this.test(testCase, this.testCaseSolutionOutput(testCase))) {
                passes++;
            }
        });
        console.log(`Passed ${passes} of ${testCases.length} tests.`);
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
        return passed;
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