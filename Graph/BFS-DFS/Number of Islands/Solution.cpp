#include <iostream>
#include <vector>
using namespace std;

class Solution{
public:
    //DFS to visit all connected '1's (land)
    void dfs(int i, int j, vector<vector<char>>& grid, vector<vector<bool>>& vis, int n, int m){
        // Base cases: 1. Out of grid bounds
        //             2. Already visited
        //             3. Water cell ('0')
        if(i < 0 || j > 0 || i >= n || j >= m || vis[i][j] || grid[i][j] != '1'){
            return;
        }

        vis[i][j] = true;   //mark current cell as visited

        //visit all four neighboring cells
        dfs(i+1, j, grid, vis, n, m);   //top
        dfs(i, j+1, grid, vis, n, m);   //right
        dfs(i, j-1, grid, vis, n, m);   //left
        dfs(i-1, j, grid, vis, n, m);   //bottom

    }

    int numIslands(vector<vector<char>>& grid){
        int islands = 0;    //counter for islands
        int n = grid.size();
        int m = grid[0].size();

        vector<vector<bool>> vis(n, vector<bool>(m, false));

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                //if the cell is land ('1') and not visited
                if(!vis[i][j] && grid[i][j] == '1'){
                    dfs(i, j, grid, vis, n, m); //visit all connected land
                    islands++;                  //increment islands count
                }
            }
        }


        return islands;
    }
};