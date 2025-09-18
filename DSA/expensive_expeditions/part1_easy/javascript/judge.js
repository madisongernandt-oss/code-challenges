const Solution = require('./solution');

class Judge {
    runTests() {
        const testCases = [
            [0,1,2,5,2,10,30,4,7,0,0,0,1],  
            [5, 5, 5, 5, 5, 5, 5, 5],       
            [100, 99, 98, 50, 10, 5, 1, 0],  
            [0, 0, 0, 0, 0],                
            [100, 100, 100, 99, 99, 50, 1],  
            [1, 2, 3, 4, 5, 6, 7, 8, 9],     
            [9, 8, 7, 6, 5, 4, 3, 2, 1],     
            [50, 20, 40, 10, 30, 60, 70],    
            [0, 1, 100, 99, 98, 2, 97, 3],   
            [42],                           
        ];

        testCases.forEach(testCase => {
            this.test(testCase, this.testCaseSolutionOutput(testCase));
        });
    }

    test(p, expected) {
        const solution = new Solution();
        const pCopy = p.slice();
        solution.modifyPlaces(pCopy);
        const passed = Arrays.equals(pCopy, expected);

        console.log(`Places: ${p}`);
        console.log(`Expected: ${expected}`);
        console.log(`Your Output: ${pCopy}`);
        console.log(passed ? "Test PASSED" : "Test FAILED");
        console.log("-----------");
    }

    testCaseSolutionOutput(p) {
        const pCopy = p.slice();
        const count = new Array(101).fill(0);

        for (const num of pCopy) {  
            count[num]++;
        }

        let index = 0;
        for (let value = 100; value >= 0; value--) {
            while (count[value] > 0) {
                pCopy[index++] = value;
                count[value]--;
            }
        }
        
        return pCopy;
    }
}

module.exports = Judge;