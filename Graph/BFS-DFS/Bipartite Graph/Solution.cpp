#include <iostream>
#include <vector>
using namespace std;

class Solution{
public:
    bool bipartite = true;  //flag to check whether the graph is bipartite

    bool isBipartite(vector<vector<int>>& graph){
        int V = graph.size();
        vector<bool> vis(V, false);
        //color of node i (0 or 1), -1 means uncolored
        vector<int> color(V, -1);

        for(int i=0; i<V; i++){
            if(!vis[i]){
                dfsColor(i, 0, graph, color, vis);  //start coloring with color 0
            }
        }

        if(bipartite) return true;

        return false;
    }

    //DFS function to color the graph and check bipartiteness
    void dfsColor(int u, int currColor, vector<vector<int>>& graph, vector<int>& color, vector<bool>& vis){
        //if the node already has a different color, graph is not bipartite
        if(color[u] != -1 && color[u] != currColor){
            bipartite = false;
            return;
        }

        color[u] = currColor;   //color that node
        vis[u] = true;

        //visit all neighbours
        for(auto v : graph[u]){
            //if the neighbour is not visited, assign opposite color
            if(!vis[v]){
                dfsColor(v, currColor xor 1, graph, color, vis);
            } //if neighbour has the same color, bipartite condition fails
            else if(color[v] == currColor){
                bipartite = false;
            }
        }
    }

};