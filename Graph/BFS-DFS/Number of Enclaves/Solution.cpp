#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    int numEnclaves(vector<vector<int>>& grid) {
        int n = grid.size();
        int m = grid[0].size();
        int count = 0;

        //step 1: remove all land connected to the boundary
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                //if the cell is on the boundary
                if(i == 0 || j == 0 || i == n-1 || j == m-1){
                    //start DFS to remove it, and make it 0
                    if(grid[i][j] == 1){
                        dfs(grid, i, j);
                    }
                }
            }
        }

        //step 2: count remaining land cells
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 1){
                    count++;
                }
            }
        }

        return count;
    }

    void dfs(vector<vector<int>>& grid, int x, int y){
        //stop if out of bounds OR cell is water (0)
        if(x < 0 || y < 0 || x >= grid.size() || y >= grid[0].size() || grid[x][y] == 0){
            return;
        }
        grid[x][y] = 0; //change to 0

        dfs(grid, x+1, y);  //top
        dfs(grid, x-1, y);  //bottom
        dfs(grid, x, y+1);  //right
        dfs(grid, x, y-1);  //left
    }
};