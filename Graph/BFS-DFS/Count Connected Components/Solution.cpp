#include <iostream>
#include <vector>
using namespace std;

class Solution{
public:
    void dfs(int src, vector<bool>& vis, vector<vector<int>>& adj){
        vis[src] = true;

        for(int v : adj[src]){
            if(!vis[v]){
                dfs(v, vis, adj);
            }
        }
    }

    int findNumberOfComponent(int V, vector<vector<int>> &edges){
        int count = 0;
        vector<bool> vis(V, false);
        vector<vector<int>> adj(V);

        //build adjacency list
        for(auto &e : edges){
            adj[e[0]].push_back(e[1]);
            adj[e[1]].push_back(e[0]);
        }
        
        for(int i=0; i<V; i++){
            if(!vis[i]){
                count++;
                dfs(i, vis, adj);
            }
        }

        return count;
    }    
};