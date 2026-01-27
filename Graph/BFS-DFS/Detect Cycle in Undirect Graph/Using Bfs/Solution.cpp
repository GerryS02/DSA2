#include <iostream>
#include <vector>
#include <queue>
using namespace std;

class Solution{ 
public:
    bool isCycle(int V, vector<int> adj[]){
        vector<bool> visited(V, false);
        
        for(int i=0; i<V; i++){
            if(!visited[i]){
                if(bfs(i, adj, visited)){
                    return true;
                }
            }
        }

        return false;
    }

    bool bfs(int src, vector<int> adj[], vector<bool>& vis){
        queue<pair<int, int>> q;

        q.push({src, -1});
        vis[src] = true;

        while(!q.empty()){
            int u = q.front().first;
            int uPar = q.front().second;
            q.pop();

            for(int i : adj[u]){
                if(!vis[i]){
                    q.push({i, u});
                    vis[i] = true;
                } else if(i != uPar){
                    return true;    //cycle detected
                }
            }
        }

        return false;
    }
};