#include <iostream>
#include <vector>
#include <stack>
using namespace std;

class Solution{
public:
    vector<int> topoSort(int V, vector<int> adj[]){
        vector<int> ans;
        vector<bool> vis(V, false);
        stack<int> s;                   //stack to store nodes after DFS finishes

        //loop through all vertices
        for(int i=0; i<V; i++){
            //if the node is not visited, start DFS from it
            if(!vis[i]){
                dfs(i, vis, s, adj);
            }
        }

        //pop elements from stack to get topological order
        while(s.size() > 0){
            ans.push_back(s.top());     //add top element to answer
            s.pop();                    //remove top element
        }

        return ans;
    }

    void dfs(int curr, vector<bool>& vis, stack<int>& s, vector<int> adj[]){
        vis[curr] = true;

        //visit all neighbouring nodes
        for(auto v : adj[curr]){
            //if neighbour node is not visited, do DFS on it
            if(!vis[v]){
                dfs(v, vis, s, adj);
            }
        }

        //after visiting all neighbors, push current node into stack
        //this ensures dependencies come before the node
        s.push(curr);
    }

};