import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph){
        int n = graph.length;

        List<Integer> ans = new ArrayList<>();

        //states[1] = visiting
        ////states[2] = safe
        int[] states = new int[n]; 

        //check for all the nodes of the graph
        for(int i=0; i<n; i++){

            //if the node is safe, add it to the list
            if(!dfs(i, graph, states)){
                ans.add(i);
            }
        }

        return ans; //return the ans list
    }

    public boolean dfs(int node, int[][] graph, int[] states){
        if(states[node] == 1) return true;  //the node is currently visited
        if(states[node] == 2) return false; //the ndoe is already safe

        states[node] = 1;   //set the nide to be visiting

        //check all the neighbours
        for(int n : graph[node]){
            if(dfs(n, graph, states)){
                return true;
            }
        }

        //the node is safe
        states[node] = 2;

        return false;
    }
}
