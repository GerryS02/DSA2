#include <iostream>
#include <vector>
#include <stack>
using namespace std;

class Soution{
public:
    bool isCycleDFS(int src, vector<bool>& vis, vector<bool>& recPath, vector<vector<int>>& edges){
        vis[src] = true;
        recPath[src] = true;

        //loop through all edges
        for(int i=0; i<edges.size(); i++){
            int v = edges[i][0];    //from node v
            int u = edges[i][1];    // to node u

            //if there is an edge u -> v and u is current source
            if(src == u){
                if(!vis[v]){
                    if(isCycleDFS(v, vis, recPath, edges)){
                        return true;    //cycle found
                    }
                } else if(recPath[v]){
                    return true;
                }
            }

            recPath[src] = false;

            return false;   //no cycle found
        }
    }

    void topoOrder(int src, vector<bool>& vis, stack<int>& s, vector<vector<int>>& edges){
        vis[src] = true;

        for(int i=0; i<edges.size(); i++){
            int v = edges[i][0];    //from node v
            int u = edges[i][1];    // to node u

            if(src == u){
                if(!vis[v]){
                    topoOrder(v, vis, s, edges);
                } 
            }
        }

        s.push(src);
    }

    vector<int> findOrder(int n, vector<vector<int>>& edges){
        vector<int> ans;

        vector<bool> vis(n, false);
        vector<bool> recPath(n, false);

        //check for cycle in the graph
        for(int i=0; i<n; i++){
            if(!vis[i]){
                if(isCycleDFS(i, vis, recPath, edges)){
                    //if cycle exists, topo sort is not possible ->return empty list
                    return ans;
                }
            }
        }

        //if graph has no cycle, perform topological sort
        stack<int> s;
        vis.assign(n, false);

        for(int i=0; i<n; i++){
            if(!vis[i]){
                topoOrder(i, vis, s, edges);
            }
        }

        //pop elements from stack to get topo order
        while(!s.empty()){
            ans.push_back(s.top());
            s.pop();
        }

        return ans;
    }
};