import java.util.List;

public class Solution {
    public boolean isCycle(int V, List<Integer>[] adj){
        boolean[] visited = new boolean[V];

        for(int i=0; i<V; i++){
            if(!visited[i]){
                if(dfs(i, -1, adj, visited)){
                    return true;
                }
            }
        }

        return false;
    }

    public boolean dfs(int src, int par, List<Integer>[] adj, boolean[] vis){
        vis[src] = true;

        for(int neighbour: adj[src]){
            if(!vis[neighbour]){
                if(dfs(neighbour, src, adj, vis)){
                    return true;
                }
            } else if(neighbour != par){
                return true;
            }
        }
        return false;
    }
}
