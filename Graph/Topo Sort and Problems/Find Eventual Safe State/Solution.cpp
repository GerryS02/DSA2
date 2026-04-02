#include <iostream>
#include <vector>
using namespace std;

class Solution{
public:
    vector<int> eventualSafeNodes(vector<vector<int>>& graph){
        int n = graph.size();

        vector<int> states(n, 0);
        vector<int> ans;

        for(int i=0; i<n; i++){
            if(!dfs(i, graph, states)){
                ans.push_back(i);
            }
        }

        return ans;
    }

    bool dfs(int node, vector<vector<int>>& graph, vector<int>& states){
        if(states[node] == 1) return true;
        if(states[node] == 2) return false;

        states[node] = 1;

        for(auto n : graph[node]){
            if(dfs(n, graph, states)){
                return true;
            }
        }

        states[node] = 2;

        return false;
    }
};