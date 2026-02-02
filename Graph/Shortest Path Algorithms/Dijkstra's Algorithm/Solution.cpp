#include <iostream>
#include <vector>
#include <climits>
#include <queue>
using namespace std;

class Solution{
public:
    //return the vector with the final shortest distances from src to every vertex.
    vector<int> dijkstra(int V, vector<vector<int>> adj[], int src){
        //distance array: dis[i] will store shortest distance from src to i
        //initialize all distances as infinity (INT_MAX)
        vector<int> dis(V, INT_MAX);
        dis[src] = 0;

        //dis[u], u
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq; //min head
        pq.push({0, src});

        while(pq.size() > 0){
            int u = pq.top().second;    //get the node with the smallest distance
            pq.pop();

            //traverse all adjacent edges of node u
            for(auto &edge : adj[u]){
                //edge[0] -> neighboring vertex
                //edge[1] -> weight of the edge
                int v = edge[0];
                int wt = edge[1];

                //relaxation step:
                //if going through u gives a shorter path to v
                if(dis[v] > dis[u] + wt){
                    dis[v] = dis[u] + wt;   //update the distance of v
                    pq.push({dis[v], v});   //push the updated distance into the priority queue
                }
            }
        }

        return dis; //return the final shortest distances from src
    }
};