#include <iostream>
#include <vector>
#include <unordered_map>
#include "Solution.cpp"
using namespace std;

class Judge {
public:
    void runTests() {
        vector<vector<int>> testCasesP = {
            {4, 1, 4, 7, 3, 6},
            {1, 2, 3, 4, 5, 6, 7}
        };
        vector<int> testCasesB = {
            7,
            10
        };
        
        runTests(testCasesP, testCasesB);
    }

    void runTests(vector<vector<int>>& testCasesP, vector<int>& testCasesB) {
        int passes = 0;
        for (int i = 0; i < testCasesP.size(); i++) {
            vector<int> expected = testCaseSolutionOutput(testCasesP[i], testCasesB[i]);
            if (test(testCasesP[i], testCasesB[i], expected)) {
                passes++;
            }
        }
        cout << "Passed " << passes << " of " << testCasesP.size() << " tests." << endl;
    }

private:
    bool test(vector<int>& p, int b, vector<int>& expected) {
        Solution sol;
        vector<int> output = sol.twoItems(p, b);
        bool passed = output.size() == 2 && p[output[0]] + p[output[1]] == b;
        
        cout << "p: [";
        for (int i = 0; i < p.size(); i++) {
            cout << p[i];
            if (i < p.size() - 1) cout << ", ";
        }
        cout << "]" << endl;
        cout << "b: " << b << endl;
        cout << "Expected Output: Any valid pair like [";
        for (int i = 0; i < expected.size(); i++) {
            cout << expected[i];
            if (i < expected.size() - 1) cout << ", ";
        }
        cout << "]" << endl;
        cout << "Your Output: [";
        for (int i = 0; i < output.size(); i++) {
            cout << output[i];
            if (i < output.size() - 1) cout << ", ";
        }
        cout << "]" << endl;
        
        cout << (passed ? "Test PASSED" : "Test FAILED") << endl;
        cout << "-----------" << endl;
        return passed;
    }

    vector<int> testCaseSolutionOutput(vector<int> p, int b) {
        unordered_map<int, int> seen;
        for (int i = 0; i < p.size(); i++) {
            int complement = b - p[i];
            if (seen.find(complement) != seen.end()) {
                return {seen[complement], i};
            }
            seen[p[i]] = i;
        }
        return {};
    }
};