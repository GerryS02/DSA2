//anti-clockwise (left to right) boundry traversal

import BinaryTree.Node;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> boundary(Node root){
        List<Integer> ans = new ArrayList<>();

        if(root == null) return ans;    //if tree is empty, return empty list

        //add root only if it is not a leaf node
        if(isLeaf(root) == false) ans.add(root.data);

        addLeafBoundry(root, ans);      //add left boundary (excluding leaf nodes)
        addLeaves(root, ans);           //add all leaf nodes from left to right
        addRightBoundry(root, ans);     //add right boundary in reverse order (excluding leaf nodes)

        return ans;
    }

    //adds the left boundary of the tree (top to bottom)
    public void addLeafBoundry(Node root, List<Intger> res){
        Node curr = root.left;

        while(curr != null){
            //add current node if it is not a leaf
            if(isLeaf(curr) == false) res.add(curr.data);

            //move to the left child first
            if(curr.left != null){
                curr = curr.left;
            } else{
                curr = curr.right;
            }
        }
    }

    //adds all leaf nodes of the tree (left to right)
    public addLeaves(Node root, List<Integer> res){
        //if current node is a leaf, add it and return
        if(isLeaf(root)){
            res.add(root.data);
            return;
        }

        //recursively visit left subtree
        if(root.left != null) addLeaves(root,left, res);
        //recursively visit right subtree
        if(root.right != null) addLeaves(root.right, res);
    }

    //adds the right boundary of the tree (bottom to top)
    public void addRightBoundry(Node root, List<Integer> res){
        List<Integer> temp = new ArrayList<>();

        Node curr = root.right;

        while(curr != null){
            //add current node if it is not a leaf
            if(isLeaf(curr) == false) temp.add(curr.data);

            //move to the right child first
            if(curr.right != null){
                curr = curr.right;
            } else{
                curr = curr.left;
            }
        }

        //add right boundary in reverse order
        for(int i=temp.size()-1; i>=0; i--){
            ans.add(temp.get(i));
        }
    }

    //check whether a node is a leaf node
    public boolean isLeaf(Node root){
        if(root.left == null && root.right == null){
            return true;
        }

        return false;
    }
}
