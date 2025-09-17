import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import Linkedlist.Node;

// Given the head of a sorted doubly linked list of positive distinct integers, and a target 
// integer, return a 2D array containing all unique pairs of nodes (a, b) such that 
// a + b == target.

// Each pair should be returned as a 2-element array [a, b] with a < b. The list is sorted in 
// ascending order. If there are no such pairs, return an empty list.

public class Solution {
    public List<List<Integer>> findPairsWithGivenSum(Node head, int target){
        List<List<Integer>> ans = new ArrayList<>();

        //set two pointers, left(start) and right(end)
        Node left = head;
        Node curr = head;

        while(curr.next != null){
            curr = curr.next;
        }

        Node right = curr;

        while(left.data < right.data){
            //calculate the sum of the values at the left and right pointers
            int sum = left.data  + right.data;

            //if the sum matches the target, add the pair to the result list
            if(sum == target){
                ans.add(Arrays.asList(left.data, right.data));

                left = left.next; //move the left pointer to the next node
                right = right.prev; //move the right pointer to the previous node
            } //if the sum is less than the target, move the left pointer forward
            else if(sum < target){
                left = left.next;
            } //if the sum is greater than the target, move the right pointer backward
            else if(sum > target){
                right = right.prev;
            }
        }

        return ans;
    }
}
