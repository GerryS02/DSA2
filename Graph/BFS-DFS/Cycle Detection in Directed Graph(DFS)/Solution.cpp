#include <iostream>
#include <vector>
using namespace std;

class Solution{
public:
    bool isCycle(int V, vector<int> adj[]){
        vector<bool> vis(V, false);
        vector<bool> recPath(V, false); //keeps track of nodes in the current DFS path (used to detect cycles)

        for(int i=0; i<V; i++){
            if(!vis[i]){
                if(dfs(i, adj, vis, recPath)){
                    return true;
                }
            }
        }

        return false;
    }

    bool dfs(int curr, vector<int> adj[], vector<bool>& vis, vector<bool>& recPath){
        vis[curr] = true;       //mark current node as visited
        recPath[curr] = true;   //mark current node as part of recursion path

        //visit all neighbours of curr
        for(auto v : adj[curr]){
            //if the neighbour node is not visited, do DFS on it
            if(!vis[v]){
                if(dfs(v, adj, vis, recPath)){
                    return true;    //cycle found
                }
            } //if the adjacent node is already in recursion path, then a back edge exists → cycle detected
            else if(recPath[v]){
                return true;
            }
        }

        // if no cycle found, remove current node from recursion path
        // (backtracking step)
        recPath[curr] = false;

        return false;
    }
};