#include <iostream>
#include <climits>
#include <vector>
using namespace std;

class Solution {
public:
	vector<int> bellman_ford(int V, vector<vector<int>>& edges, int src) {
        vector<int> dis(V, INT_MAX);
        dis[src] = 0;   //distance of source vertex from itself is 0

        //relax all edges V-1 times
        for(int i=0; i<V-1; i++){
            //traverse each edge in the graph
            for(auto &e : edges){
                //edges[i] = {u, v, wt}
                int u = e[0];
                int v = e[1];
                int wt = e[2];

                //if u is reachable and we can find a shorter path to v through u
                if(dis[u] != INT_MAX && dis[v] > dis[u] + wt){
                    dis[v] = dis[u] + wt;   //update distance of v
                }
            }
        }

        return dis;
	}
};
