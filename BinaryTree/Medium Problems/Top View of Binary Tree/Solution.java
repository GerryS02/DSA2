import BinaryTree.Node;

import java.util.ArrayList;

public class Solution{
    public ArrayList<Integer> topView(Node root){
        ArrayList<Integer> ans = new ArrayList<>();

        if(root == null) return ans;

        Queue<Node> qNode = new LinkedList<>();
        Queue<Integer> qHd = new LinkedList<>();

        Map<Integer, Integer> m = new TreeMap<>();

        qNode.offer(root);
        qHd.offer(0);

        while(!qNode.isEmpty()){
            Node curr = qNode.poll();
            int currHd = qHd.poll();

            if(!m.containsKey(currHd)){
                m.put(currHd, curr.data);
            }

            if(curr.left != null){
                qNode.offer(curr.left);
                qHd.offer(currHd-1);
            }

            if(curr.right != null){
                qNode.offer(curr.right);
                qHd.offer(currHd+1);
            }
        }

        for(int val : m.values()){
            ans.add(val);
        }

        return ans;
    }
}