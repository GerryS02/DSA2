import java.util.LinkedList;
import java.util.Queue;

//helper class to store position and time
class pair{
    int x;
    int y;
    int time;

    pair(int x, int y, int time){
        this.x = x;
        this.y = y;
        this.time = time;
    }
}

public class Solution {
    public int orangesRotting(int[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;    //maximum time taken

        boolean[][] visited = new boolean[n][m];
        Queue<pair> q = new LinkedList<>();
        
        //add all initially rotten oranges to the queue
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 2){
                    q.offer(new pair(i,j,0));   //time = 0
                    visited[i][j] = true;            //mark visited
                }
            }
        }

        //bfs
        while(!q.isEmpty()){
            pair p = q.poll();
            int i = p.x;
            int j = p.y;
            int time = p.time;

            ans = Math.max(ans, time);  //update maximum time

            // up
            if(i-1 >= 0 && !visited[i-1][j] && grid[i-1][j] == 1){
                q.offer(new pair(i-1, j, time+1));
                visited[i-1][j] = true;
            }

            // right
            if (j + 1 < m && !visited[i][j + 1] && grid[i][j + 1] == 1) {
                q.offer(new pair(i, j + 1, time + 1));
                visited[i][j + 1] = true;
            }

            // down
            if (i + 1 < n && !visited[i + 1][j] && grid[i + 1][j] == 1) {
                q.offer(new pair(i + 1, j, time + 1));
                visited[i + 1][j] = true;
            }

            // left
            if (j - 1 >= 0 && !visited[i][j - 1] && grid[i][j - 1] == 1) {
                q.offer(new pair(i, j - 1, time + 1));
                visited[i][j - 1] = true;
            }
        }

        //check if any fresh orange is left unvisited
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(!visited[i][j] && grid[i][j] == 1){
                    return -1;
                }
            }
        }

        return ans;
    }
}
