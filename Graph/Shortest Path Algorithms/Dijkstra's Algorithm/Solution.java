import java.util.*;

public class Solution{
    public int[] dijkstra(int V, ArrayList<ArrayList<int[]>> adj, int src){
        int[] dis = new int[V];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[src] = 0;

        //priority queue: (distance, node)
        PriorityQueue<int[]> pq = new PriorityQueue<>( (a,b) -> Integer.compare(a[0], b[0]));
        pq.add(new int[]{0, src});

        while(pq.size() > 0){
            int[] top = pq.poll();
            int u = top[1];
            
            for(int[] edge : adj.get(u)){
                int v = edge[0];    //neighboring vertex
                int wt = edge[1];   //weight of the edge

                //relaxation step
                if(dis[v] > dis[u] + wt){
                    dis[v] = dis[u] + wt;
                    pq.add(new int[]{dis[v], v});
                }
            }
        }
        return dis; 
    }
}