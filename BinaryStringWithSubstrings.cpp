// https://leetcode.com/problems/binary-string-with-substrings-representing-1-to-n/description/
#include <vector>
#include <iostream>
#include <bitset>
using namespace std;

class Solution {
public:
    bool queryString(string s, int n) {
        for (int i=1; i<=n; i++) {
            string b = bitset<8>(i).to_string();
            // string b = bitset<32>(i).to_string();
            b = b.substr(b.find_first_not_of('0'));
            if (s.find(b) == string::npos)
                return false;
        }
        return true;
    }
};

int main() {
    Solution solution;

    cout << solution.queryString("0110", 3) << endl; // 1 (true)
    cout << solution.queryString("0110", 4) << endl; // 0 (false)

    return 0;
}
