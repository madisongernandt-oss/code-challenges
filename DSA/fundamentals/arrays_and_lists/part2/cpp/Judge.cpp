#include <iostream>
#include <vector>
#include <string>
#include "Solution.cpp"
using namespace std;

class Judge {
public:
    void runTests() {
        vector<vector<string>> testCasesC = {
            {"Plateau", "Haven", "Insomnia", "Grand Trad", "Plateau", "Sunville"},
            {"Plateau", "Haven", "Insomnia", "Grand Trad", "Sunville", "Bronze City", "Sunville"}
        };
        
        runTests(testCasesC);
    }

    void runTests(vector<vector<string>>& testCasesC) {
        int passes = 0;
        for (int i = 0; i < testCasesC.size(); i++) {
            string expected = testCaseSolutionOutput(testCasesC[i]);
            if (test(testCasesC[i], expected)) {
                passes++;
            }
        }
        cout << "Passed " << passes << " of " << testCasesC.size() << " tests." << endl;
    }

private:
    bool test(vector<string>& c, string expected) {
        Solution sol;
        string output = sol.dispatchTo(c);
        bool passed = (output == expected);
        
        cout << "c: [";
        for (int i = 0; i < c.size(); i++) {
            cout << "\"" << c[i] << "\"";
            if (i < c.size() - 1) cout << ", ";
        }
        cout << "]" << endl;
        cout << "Expected Output: " << expected << endl;
        cout << "Your Output: " << output << endl;
        
        cout << (passed ? "Test PASSED" : "Test FAILED") << endl;
        cout << "-----------" << endl;
        return passed;
    }

    string testCaseSolutionOutput(vector<string> c) {
        vector<string> seen;
        for (const string& city : c) {
            for (const string& seenCity : seen) {
                if (seenCity == city) {
                    return city;
                }
            }
            seen.push_back(city);
        }
        return "";
    }
};