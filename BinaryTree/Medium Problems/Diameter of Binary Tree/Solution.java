import BinaryTree.Node;

public class Solution {
    public int diameterOfBinaryTree(Node root){
        if(root == null) return 0;

        int leftDiam = diameterOfBinaryTree(root.left);
        int rightDiam = diameterOfBinaryTree(root.right);

        int currDiam = height(root.left) + height(root.right);

        return Math.max(currDiam, Math.max(leftDiam, rightDiam));
    }

    public int height(Node root){
        if(root == null) return 0;

        int lh = height(root.left);
        int rh = height(root.right);

        return Math.max(lh, rh) +1;
    }
}
