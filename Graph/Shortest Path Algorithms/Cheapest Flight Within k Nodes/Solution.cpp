#include <iostream>
#include <vector>
#include <queue>
#include <climits>
using namespace std;

class Solution {
public:
    int findCheapestPrice(int n, vector<vector<int>>& flights, int src, int dst, int k){
        //create a graph
        vector<pair<int, int>> adj[n];
        for(auto it : flights){
            adj[it[0]].push_back({it[1], it[2]});
        }

        queue<pair<int, pair<int, int>>> q;
        q.push({0, {src, 0}});  //{stops, {node, dist}}

        //distance array to store minimum cost to reach each node
        vector<int> dis(n, INT_MAX);
        dis[src] = 0;

        while(q.size() > 0){
            auto p = q.front();
            q.pop();

            int stops = p.first;
            int node = p.second.first;
            int cost = p.second.second;

            //if stops exceed k, skip
            if(stops > k) continue;

            //check all neighbours
            for(auto v : adj[node]){
                int adjNode = v.first;  //neighbour node
                int edW = v.second;     //edge weight (flight cost)

                //if new cost is smaller and within stop limit
                if(cost + edW < dis[adjNode] && stops <= k){
                    //update the distance
                    dis[adjNode] = cost + edW;
                    //push into queue with one extra stop
                    q.push({stops+1, {adjNode, cost + edW}});
                }
            }
        }

        //if destination not reachable, return -1
        if(dis[dst] == INT_MAX) return -1;

        return dis[dst];
    }
};