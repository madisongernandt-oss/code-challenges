#include <iostream>
#include <vector>
#include "Solution.cpp"
using namespace std;

class Judge {
public:
    void runTests() {
        vector<vector<int>> testCasesA = {
            {1, 2, 3, 4, 5},
            {1, 2, 3, 4, 5}
        };
        vector<int> testCasesK = {1, 0};
        
        runTests(testCasesA, testCasesK);
    }

    void runTests(vector<vector<int>>& testCasesA, vector<int>& testCasesK) {
        int passes = 0;
        for (int i = 0; i < testCasesA.size(); i++) {
            vector<int> expected = testCaseSolutionOutput(testCasesA[i], testCasesK[i]);
            if (test(testCasesA[i], testCasesK[i], expected)) {
                passes++;
            }
        }
        cout << "Passed " << passes << " of " << testCasesA.size() << " tests." << endl;
    }

private:
    bool test(vector<int>& a, int k, vector<int>& expected) {
        vector<int> originalA = a;
        Solution sol;
        sol.incrementArray(a, k);
        bool passed = (a == expected);
        
        cout << "a: [";
        for (int i = 0; i < originalA.size(); i++) {
            cout << originalA[i];
            if (i < originalA.size() - 1) cout << ", ";
        }
        cout << "]" << endl;
        
        cout << "k: " << k << endl;
        
        cout << "Expected Output: [";
        for (int i = 0; i < expected.size(); i++) {
            cout << expected[i];
            if (i < expected.size() - 1) cout << ", ";
        }
        cout << "]" << endl;
        
        cout << "Your Output: [";
        for (int i = 0; i < a.size(); i++) {
            cout << a[i];
            if (i < a.size() - 1) cout << ", ";
        }
        cout << "]" << endl;
        
        cout << (passed ? "Test PASSED" : "Test FAILED") << endl;
        cout << "-----------" << endl;
        return passed;
    }

    vector<int> testCaseSolutionOutput(vector<int> a, int k) {
        for (int i = 0; i < a.size(); i++) {
            a[i] += k;
        }
        return a;
    }
};
