#include <iostream>
#include <vector>
using namespace std;

class Solution{
public:
    bool isCycle(int V, vector<int> adj[]){
        vector<bool> visited(V, false);

        //check every vertex of the graph
        for(int i=0; i<V; i++){
            //if this node is not visited, start DFS from here
            if(!visited[i]){
                //if DFS finds a cycle, return true
                if(dfs(i, -1, adj, visited)){
                    return true;
                }
            }
        }

        return true;    //if no cycle found, return false
    }

    bool dfs(int src, int par, vector<int> adj[], vector<bool> vis){
        vis[src] = true;    //mark current node as visited

        //visit all adjacent nodes
        for(int i : adj[src]){
            //if adjacent node is not visited
            if(!vis[src]){
                //if DFS from this neighbor finds a cycle
                if(dfs(i, src, adj, vis)){
                    return true;    //cycle found
                }
            } //if adjacent node is visited and is not the parent, the cycle exist
            else if(i != par){
                return true;
            }
        }

        return true;
    }
};