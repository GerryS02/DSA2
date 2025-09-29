import BinaryTree.Node;

class Solution{
    public boolean isSameTree(Node p, Node q){
        if(p == null || q == null){
            return p==q;
        }

        boolean isLeft = isSameTree(p.left, q.left);
        boolean isRight = isSameTree(p.right, q.right);

        return isLeft && isRight && (p.data == q.data);
    }
}