import BinaryTree.Node;
import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

public class Solution{
    public List<List<Integer>> zigzagLevelOrder(Node root){
        List<List<Integer>> ans = new ArrayList<>();

        if(root == null) return ans;

        Stack<Node> currLevel = new Stack<>();
        currLevel.push(root);
        Stack<Node> nextLevel = new Stack<>();

        boolean leftToRight = true;
        List<Integer> level = new ArrayList<>();

        while(!currLevel.isEmpty()){
            Node temp = currLevel.pop();
            level.add(temp.data);

            if(leftToRight){

                if(temp.left != null) nextLevel.push(temp.left);
                if(temp.right != null) nextLevel.push(temp.right);
            } //for right to left direction
            else{

                if(temp.right != null) nextLevel.push(temp.right);
                if(temp.left != null) nextLevel.push(temp.left);
            }

            if(currLevel.isEmpty()){
                ans.add(level);
                level = new ArrayList<>();

                leftToRight = !leftToRight;

                //move to the next level by swapping stacks
                Stack<Node> swap = currLevel;
                currLevel = nextLevel;
                nextLevel = swap;
            }
        }

        return ans;
    }
}