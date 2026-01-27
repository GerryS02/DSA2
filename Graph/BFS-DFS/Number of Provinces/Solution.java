package Graph;

public class Solution {
    public int findCircleNum(int[][] isConnected){
        int n = isConnected.length;             //number of cities
        boolean[] visited = new boolean[n];     //track if cities are visited
        int provinces = 0;

        //loop for all the cities
        for(int i=0; i<n; i++){
            //if ith city is not viisted, it starts a new provience
            if(!visited[i]){
                dfs(isConnected, visited, i);   //visite all connected cities
                provinces++;                    //record provience found
            }
        }

        return provinces;
    }

    public void dfs(int[][] isConnected, boolean[] visited, int city){
        visited[city] = true;   //mark the current city visited

        //check for nixt cities
        for(int next=0; next<isConnected.length; next++){
            //if next city is directly connected and not visited 
            if(isConnected[city][next] == 1 && !visited[next]){
                dfs(isConnected, visited, next);    //visit that city
            }
        }
    }
}
