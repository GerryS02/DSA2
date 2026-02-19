#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

class Solution{
public:
    vector<vector<int>> merge(vector<vector<int>>& i){
        sort(i.begin(), i.end(), [](const vector<int>& a, const vector<int>& b){
            return a[0] < b[0];
        });

        vector<vector<int>> ans;

        for(auto curr : i){
            if(ans.size() == 0){
                ans.push_back(curr);
            } else{
                auto& prev = ans.back();

                if(curr[0] <= prev[1]){
                    prev[1] = max(prev[1], curr[1]);
                } else{
                    ans.push_back(curr);
                }
            }
        }

        return ans;
    }
};