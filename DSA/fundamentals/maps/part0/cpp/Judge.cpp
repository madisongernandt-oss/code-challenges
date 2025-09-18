#include <iostream>
#include <vector>
#include <string>
#include <map>
#include <set>
#include <sstream>
#include "Solution.cpp"
using namespace std;

class Judge {
public:
    void runTests() {
        vector<vector<string>> testCasesN = {
            {"Doe, John", "Smith, Jane", "Johnson, Jim"},
            {"Doe, John", "Smith, Jane", "Johnson, Jim", "Williams, Mary", "Brown, Bob"}
        };
        
        runTests(testCasesN);
    }

    void runTests(vector<vector<string>>& testCasesN) {
        int passes = 0;
        for (int i = 0; i < testCasesN.size(); i++) {
            map<string, string> expectedMap = testCaseSolutionOutput(testCasesN[i]);
            if (test(testCasesN[i], expectedMap)) {
                passes++;
            }
        }
        cout << "Passed " << passes << " of " << testCasesN.size() << " tests." << endl;
    }

private:
    bool test(vector<string>& n, map<string, string>& expected) {
        Solution sol;
        map<string, string> userMap;
        sol.storeNames(n, userMap);
        
        set<string> userValues, expectedValues;
        for (const auto& pair : userMap) {
            userValues.insert(pair.second);
        }
        for (const auto& pair : expected) {
            expectedValues.insert(pair.second);
        }
        
        bool passed = userMap.size() == expected.size() && userValues == expectedValues;
        
        cout << "n: [";
        for (int i = 0; i < n.size(); i++) {
            cout << "\"" << n[i] << "\"";
            if (i < n.size() - 1) cout << ", ";
        }
        cout << "]" << endl;
        
        cout << "Expected Output: [";
        bool first = true;
        for (const auto& value : expectedValues) {
            if (!first) cout << ", ";
            cout << "\"" << value << "\"";
            first = false;
        }
        cout << "]" << endl;
        
        cout << "Your Output: [";
        first = true;
        for (const auto& value : userValues) {
            if (!first) cout << ", ";
            cout << "\"" << value << "\"";
            first = false;
        }
        cout << "]" << endl;
        
        cout << (passed ? "Test PASSED" : "Test FAILED") << endl;
        cout << "-----------" << endl;
        return passed;
    }

    map<string, string> testCaseSolutionOutput(vector<string> n) {
        map<string, string> expectedMap;
        for (int i = 0; i < n.size(); i++) {
            size_t commaPos = n[i].find(", ");
            string lastName = n[i].substr(0, commaPos);
            string firstName = n[i].substr(commaPos + 2);
            expectedMap[to_string(i)] = firstName + " " + lastName;
        }
        return expectedMap;
    }
};