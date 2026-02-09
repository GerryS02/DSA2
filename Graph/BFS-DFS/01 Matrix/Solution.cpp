#include <iostream>
#include <vector>
#include <queue>
using namespace std;

class Solution {
public:
    vector<vector<int>> updateMatrix(vector<vector<int>>& mat) {
        int n = mat.size();
        int m = mat[0].size();

        //stores {{row, col}, distance from nearest 0}
        queue<pair<pair<int, int>, int>> q;

        //push all 0-cells into the queue with distance 0
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(mat[i][j] == 0){
                    q.push({{i,j}, 0});
                } else{
                    mat[i][j] = -1; //mark all 1-cells as -1 (unvisited)
                }
            }
        }

        //process the queue until empty
        while(q.size() > 0){
            auto p = q.front();
            q.pop();

            int i = p.first.first;  //current row
            int j = p.first.second; //current col
            int d = p.second;       //current dis

            //up 
            if(i-1 >= 0 && mat[i-1][j] == -1){
                mat[i-1][j] = d+1;          //set distance
                q.push({{i-1, j}, d+1});    //add to queue
            } 

            //right
            if(j+1 < m && mat[i][j+1] == -1){
                mat[i][j+1] = d+1;
                q.push({{i, j+1}, d+1});
            }

            //left
            if(j-1 >= 0 && mat[i][j-1] == -1){
                mat[i][j-1] = d+1;
                q.push({{i, j-1}, d+1});
            } 

            //bottom
            if(i+1 < n && mat[i+1][j] == -1){
                mat[i+1][j] = d+1;
                q.push({{i+1, j}, d+1});
            } 
        }

        return mat;
    }
};