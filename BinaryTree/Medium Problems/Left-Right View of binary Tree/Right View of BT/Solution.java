import BinaryTree.Node;

public class Solution {
    public List<Integer> rightView(Node root){
        //if the tree is empty, return an empty list
        if(root == null) return new ArrayList<>();

        List<Integer> ans = new ArrayList<>();

        //queue for level-order traversal
        Queue<Node> q = new LinkedList<>();
        q.add(root); //add the root to the queue

        //process nodes level by level
        while(!q.isEmpty()){
            int size = q.size(); //get number of nodes at current level

            //traverse all nodes of the current level
            for(int i=0; i<size; i++){
                //remove the front node from the queue
                Node curr = q.poll();

                //add the first node of the level to the ans
                if(i==0){
                    ans.add(curr.data);
                }

                //add right child first so it is processed first
                if(curr.right != null){
                    q.add(curr.right);
                }
                //then add left child
                if(curr.left != null){
                    q.add(curr.left);
                }
            }
        }

        return ans;
    }
}
