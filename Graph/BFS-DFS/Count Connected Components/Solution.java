import java.util.ArrayList;
import java.util.List;

class Solution {
    public int findNumberOfComponent(int V, List<List<Integer>> edges) {
        int count = 0;
        boolean[] vis = new boolean[V];

        //create adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<V; i++){
            adj.add(new ArrayList<>());
        }

        for(List<Integer> e : edges){
            int u = e.get(0);
            int v = e.get(1);

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        for(int i=0; i<V; i++){
            if(!vis[i]){
                count++;
                dfs(i, adj, vis);
            }
        }
        
        return count;
    }

    private void dfs(int src, List<List<Integer>> adj, boolean[] vis){
        vis[src] = true;

        for(int n : adj.get(src)){
            if(!vis[n]){
                dfs(n, adj, vis);
            }
        }
    }
}
