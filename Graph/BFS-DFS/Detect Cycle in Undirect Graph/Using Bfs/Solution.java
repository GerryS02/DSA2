import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public boolean isCycle(int V, List<Integer>[] adj){
        boolean[] visited = new boolean[V];

        for(int i=0; i<V; i++){
            if(!visited[i]){
                if(bfs(i, adj, visited)){
                    return true;
                }
            }
        }

        return false;  
    }

    public boolean bfs(int src, List<Integer>[] adj, boolean[] vis){
        Queue<int[]> q = new LinkedList<>();

        //{currentNode, parentNode}
        q.add(new int[]{src, -1});
        vis[src] = true;

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int node = curr[0];
            int parent = curr[1];

            for(int neighbour : adj[node]){
                if(!vis[neighbour]){
                    q.add(new int[]{neighbour, node});
                    vis[neighbour] = true;
                } else if(neighbour != parent){
                    return true;
                }
            }
        }

        return false;
    }
}
