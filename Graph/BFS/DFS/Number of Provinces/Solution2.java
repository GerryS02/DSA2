package Graph;

public class Solution2 {
    public int numProvinces(ArrayList<ArrayList<Integer>> adj, int V){
        boolean[] visited = new boolean[V];
        int provience = 0;

        for(int i=0; i<V; i++){
            if(!visited[i]){
                dfs(adj, visited, i, V);
                provience++;
            }
        }

        return provience;
    }

    public void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int city, int V){
        visited[city] = true;

        for(int next=0; next<V; next++){
            if(!visited[next] && adj.get(city).get(next) == 1){
                dfs(adj, visited, next, V);
            }
        }
    }
}
