class Solution {
public:
    void incrementArray(vector<int>& a, int k) {
        for (int& element : a) {
            element += k;
        }
    }
};
int main() {
    std::vector<int> a = {1, 2, 3, 4, 5};
    int k = 1;

    Solution solution;
    solution.incrementArray(a, k);

    std::cout << "[";
    for (size_t i = 0; i < a.size(); ++i) {
        std::cout << a[i];
        if (i < a.size() -1) {
            std::cout << ", ";
        }
    }
    std::cout << "]" << std::endl;

    return 0;
}
