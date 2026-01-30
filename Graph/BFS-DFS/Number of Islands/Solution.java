
public class Solution {
    public void dfs(int i, int j, char[][] grid, boolean[][] vis, int n, int m){

        if(i<0 || j<0 || i>=n || j>=m || vis[i][j] || grid[i][j] != '1'){
            return;
        }

        vis[i][j] = true;

        dfs(i+1, j, grid, vis, n, m);
        dfs(i-1, j, grid, vis, n, m);
        dfs(i, j+1, grid, vis, n, m);
        dfs(i, j-1, grid, vis, n, m);
    }

    public int numIslands(char[][] grid) {
        int islands = 0;
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(!vis[i][j] && grid[i][j] == '1'){
                    dfs(i, j, grid, vis, n, m);
                    islands++;
                }
            }
        }

        return islands;
    }
}
