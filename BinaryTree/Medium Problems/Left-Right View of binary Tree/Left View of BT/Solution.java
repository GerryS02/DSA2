import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import binaryTree.Node;

public class Solution {
    public List<Integer> leftView(Node root){
        //if tree is empty, return empty list
        if(root == null) return new ArrayList<>();

        Queue<Node> q = new LinkedList<>(); //use queue for level-order (BFS) traversal
        List<Integer> ans = new Arraylist<>(); //list to store the left view nodes

        q.add(root); //add the root node

        //continue until all levels are processed
        while(!.q.isEmpty()){
            int size = q.size(); //get number of nodes at a current level

            //traverse all nodes of the current level
            for(int i=0; i<size; i++){
                Node curr = q.poll(); //remove the curr (first) node

                //first node of each level is part of left view, add it to ans
                if(i==0){
                    ans.add(curr.data);
                }

                //add left and right child to queue if it exists
                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
            }
        }

        return ans; //return the left view list
    }
}
