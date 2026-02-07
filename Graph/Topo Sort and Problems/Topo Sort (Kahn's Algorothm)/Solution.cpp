#include <iostream>
#include <vector>
#include <queue>
using namespace std;

class Solution{
public:
    vector<int> topoSort(int V, vector<int> adj[]){
        vector<int> ans;
        vector<int> indeg(V, 0);    //indeg[i] will store indegree of node i

        //step 1: calc indegree of each node
        //for every edge i -> v, indegree of v increases
        for(int i=0; i<V; i++){
            for(int v : adj[i]){
                indeg[v]++;
            }
        }

        //step 2: push all nodes with indegree 0 into the queue
        queue<int> q;

        for(int i=0; i<V; i++){
            if(indeg[i] == 0){
                q.push(i);
            }
        }

        //step 3: bsf
        while(!q.empty()){
            //take the front node from the queue
            int curr = q.front();
            q.pop();
            //add it to the topological order
            ans.push_back(curr);

            //reduce indegree of all neighbors of curr
            for(int v : adj[curr]){
                indeg[v]--;

                //if indegree becomes 0, push into queue
                if(indeg[v] == 0){
                    q.push(v);
                }
            }
        }

        return ans;     //ans contain the topological sort
    }
};