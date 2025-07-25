// Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], 
// nums[b], nums[c], nums[d]] such that:

//  1. 0 <= a, b, c, d < n
//  2. a, b, c, and d are distinct.
//  3. nums[a] + nums[b] + nums[c] + nums[d] == target

// You may return the answer in any order.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target){
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;

        Arrays.sort(nums); //sort the array to use two-pointer technique and handle duplicates

        //first pointer
        for(int i=0; i<n; i++){
            if(i>0 && nums[i] == nums[i-1]) continue; //skip duplicate values for i

            //second pointer
            for(int j=i+1; j<n; j++){
                if(j>i+1 && nums[j] == nums[j-1]) continue; //skip duplicate values for j

                int p = j+1; //third pointer (left)
                int q = n-1; //fourth pointer (right)

                while(p<q){
                    //used long to prevent integer overflow
                    long sum = (long) nums[i] + nums[j] + nums[p] + nums[q];

                    if(sum < target){
                        p++;
                    } else if(sum > target){
                        q--;
                    } else{
                        ans.add(Arrays.asList(nums[i], nums[j], nums[p], nums[q]));

                        p++;
                        q--;

                        while(p<q && nums[p] == nums[p-1]) p++; //skip duplicate values for p
                    }
                }
            }
        }

        return ans;
    }
}
