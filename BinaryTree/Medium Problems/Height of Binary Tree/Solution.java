import BinaryTree.Node;

public class Solution {
    public int height(Node root){
        if(root == null) return 0;

        int lh = height(root.left);
        int rh = height(root.right);

        return (Math.max(lh, rh) +1);
    }
}
