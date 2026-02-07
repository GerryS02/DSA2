import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution{
    public int[] topoSort(int V, List<List<Integer>> adj) {
        int[] ans = new int[V];
        int[] indeg = new int[V];

        //calc indegree
        for(int i=0; i<V; i++){
            for(int v : adj.get(i)){
                indeg[v]++;
            }
        }

        //if indeg = 0 -> add to queue
        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<V; i++){
            if(indeg[i] == 0){
                q.offer(i);
            }
        }

        //bfs
        int idx = 0;

        while(!q.isEmpty()){
            int curr = q.poll();
            ans[idx++] = curr;

            for(int v : adj.get(curr)){
                indeg[v]--;

                if(indeg[v] == 0){
                    q.offer(v);
                }
            }
        }

        return ans;
    }
}