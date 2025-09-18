#include <iostream>
#include <vector>
#include "Solution.cpp"
using namespace std;

class Judge {
public:
    void runTests() {
        vector<vector<int>> testCasesP = {
            {1, 2, 4, 5},
            {1, 2, 4, 5}
        };
        vector<vector<int>> testCasesM = {
            {2, 2, 5, 10},
            {2, 1, 5, 0},
        };
        
        runTests(testCasesP, testCasesM);
    }

    void runTests(vector<vector<int>>& testCasesP, vector<vector<int>>& testCasesM) {
        int passes = 0;
        for (int i = 0; i < testCasesP.size(); i++) {
            int expected = testCaseSolutionOutput(testCasesP[i], testCasesM[i]);
            if (test(testCasesP[i], testCasesM[i], expected)) {
                passes++;
            }
        }
        cout << "Passed " << passes << " of " << testCasesP.size() << " tests." << endl;
    }

private:
    bool test(vector<int>& p, vector<int>& m, int expected) {
        Solution sol;
        int output = sol.difference(p, m);
        bool passed = (output == expected);
        
        cout << "p: [";
        for (int i = 0; i < p.size(); i++) {
            cout << p[i];
            if (i < p.size() - 1) cout << ", ";
        }
        cout << "]" << endl;
        cout << "m: [";
        for (int i = 0; i < m.size(); i++) {
            cout << m[i];
            if (i < m.size() - 1) cout << ", ";
        }
        cout << "]" << endl;
        cout << "Expected Output: " << expected << endl;
        cout << "Your Output: " << output << endl;
        
        cout << (passed ? "Test PASSED" : "Test FAILED") << endl;
        cout << "-----------" << endl;
        return passed;
    }

    int testCaseSolutionOutput(vector<int> p, vector<int> m) {
        int sum = 0;
        for (int i = 0; i < p.size(); i++) {
            sum += m[i] - p[i];
        }
        return sum;
    }
};
