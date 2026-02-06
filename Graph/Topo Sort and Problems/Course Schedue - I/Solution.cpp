#include <iostream>
#include <vector>
using namespace std;

class Solution{
public:
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites){
        vector<bool> vis(numCourses, false);
        vector<bool> recPath(numCourses, false);

        //check every course (graph may be disconnected)
        for(int i=0; i<numCourses; i++){
            //if course i is not visited, start DFS from it
            if(!vis[i]){
                //if a cycle is found, courses cannot be finished
                if(isCycleDFS(i, vis, recPath, prerequisites)){
                    return false;
                }
            }
        }

        return true;    //no cycle found → all courses can be finished
    }

    bool isCycleDFS(int src, vector<bool>& vis, vector<bool>& recPath, vector<vector<int>>& edges){
        vis[src] = true;        //mark current course as visited
        recPath[src] = true;    //mark current course as part of recursion path

        //traverse all prerequisite pairs
        for(int i=0; i<edges.size(); i++){
            int v = edges[i][0];    //course to be taken
            int u = edges[i][1];    //prerequisite course

            //if current course (src) is a prerequisite of v
            if(u == src){
                //if v is not visited, continue DFS
                if(!vis[v]){
                    if(isCycleDFS(v, vis, recPath, edges)){
                        return true;    //cycle detected
                    }
                } //if v is already in recursion path, cycle exists
                else if(recPath[v]){
                    return true;
                }
            }
        }

        recPath[src] = false;   //remove current course from recursion path before returning

        return false;   //no cycle found from this path
    }
};