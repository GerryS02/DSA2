// Given an integer array nums, return a list of all the leaders in the array.

// A leader in an array is an element whose value is strictly greater than all elements to its
// right in the given array. The rightmost element is always a leader. The elements in the 
// leader array must appear in the order they appear in the nums array.

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static List<Integer> leaders(int[] nums){
        List<Integer> ans = new ArrayList<>();

        int n = nums.length;

        //the rightmost element is always a leader
        int maxFromLast = nums[n-1];
        ans.add(maxFromLast);

        //scan from right to left
        for(int i=n-2; i>=0; i--){
            if(nums[i] > maxFromLast){
                //update the maximum and add to ans
                maxFromLast = nums[i];
                ans.add(maxFromLast);
            }
        }

        //reverse the answer list to maintain correct order
        Collections.reverse(ans);

        return ans;
    }

    public static void main(String[] args){
        int[] arr = {1,2,5,3,1,2};

        List<Integer> ans = leaders(arr);

        for(int i : ans){
            System.out.print(i + " ");
        }


    }
};
