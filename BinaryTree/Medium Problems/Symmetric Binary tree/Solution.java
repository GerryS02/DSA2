import BinaryTree.Node;

public class Solution {
    public boolean isSymmetric(Node root){
        if(root == null) return false; //if there's only one one -> tree is symmetric

        return isMirror(root.left, root.right); //call a helper function to check left and right root
    }

    public boolean isMirror(Node left, Node right){
        if(left == null && right == null) return true;
        if(left == null || right == null) return false;

        return (left.data == right.data) && isMirror(left.left, right.right) 
                && isMirror(left.right, right.left);
    }
}
