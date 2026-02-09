import java.util.LinkedList;
import java.util.Queue;

class pair{
    int i;
    int j;
    int dis;

    pair(int i, int j, int dis){
        this.i = i;
        this.j = j;
        this.dis = dis;
    }
}
public class Solution {
    public int[][] updateMatrix(int[][] mat){
        int n = mat.length;
        int m = mat[0].length;

        Queue<pair> q = new LinkedList<>();

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(mat[i][j] == 0){
                    q.offer(new pair(i,j,0));
                } else{
                    mat[i][j] = -1;
                }
            }
        }

        while(q.size() > 0){
            pair p = q.poll();

            int i = p.i;
            int j = p.j;
            int d = p.dis;

             // up
            if (i - 1 >= 0 && mat[i - 1][j] == -1) {
                mat[i - 1][j] = d + 1;
                q.offer(new pair(i - 1, j, d + 1));
            }

            // right
            if (j + 1 < m && mat[i][j + 1] == -1) {
                mat[i][j + 1] = d + 1;
                q.offer(new pair(i, j + 1, d + 1));
            }

            // down
            if (i + 1 < n && mat[i + 1][j] == -1) {
                mat[i + 1][j] = d + 1;
                q.offer(new pair(i + 1, j, d + 1));
            }

            // left
            if (j - 1 >= 0 && mat[i][j - 1] == -1) {
                mat[i][j - 1] = d + 1;
                q.offer(new pair(i, j - 1, d + 1));
            }
        }

        return mat;
    }
}
