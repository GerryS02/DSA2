import java.util.List;

class Solution{
    public boolean iscycle(int V, List<List<Integer>> adj){
        boolean[] vis = new boolean[V];
        boolean[] recPath = new boolean[V];

        for(int i=0; i<V; i++){
            if(!vis[i]){
                if(dfs(i, vis, recPath, adj)){
                    return true;
                }
            }
        }

        return false;
    }

    boolean dfs(int curr, boolean[] vis, boolean[] recPath, List<List<Integer>> adj){
        vis[curr] = true;
        recPath[curr] = true;

        for(int v : adj.get(curr)){
            if(!vis[v]){
                if(dfs(v, vis, recPath, adj)){
                    return true;
                }
            } else if(recPath[v]){
                return true;
            }
        }

        recPath[curr] = false;

        return false;
    }
}