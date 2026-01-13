import java.util.ArrayList;

import BinaryTree.Node;

class pair{
    Node node;
    int row, col;
    
    pair(Node node, int row, int col){
        this.node = node;
        this.row = row;
        this.col = col;
    }

}

public class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root){
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;

        //col -> row -> node value
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> m = new TreeMap<>();

        Queue<pair> q = new LinkedList<>();
        q.offer(new pair(root, 0, 0));

        while(!q.isEmpty()){
            pair p = q.poll();
            Node node = p.node;
            int x = p.row;
            int y = p.col;

            m.putIfAbsent(y, new TreeMap<>());
            m.get(y).putIfAbsent(x, new PriorityQueue<>());
            m.get(y).get(.x).offer(node.data);

            if(node.left != null){
                q.offer(new pair(node.left, x+1, y-1));
            }

            if(node.right != null){
                q.offer(new pair(node.right, x+1, y1));
            }
        }

        for(TreeMap<Integer, PriorityQueue<Integer>> rows : m.values()){
            ans.add(new ArrayList<>());
            for(PriorityQueue<Integer> pq : rows.values()){
                while(!pq.isEmpty()){
                    ans.get(ans.size()-1).add(pq.poll());
                }
            }
        }

        return ans;
    }
}
