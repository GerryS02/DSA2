// Given an integer array nums. Return all triplets such that:

//  1. i != j, i != k, and j != k
//  2. nums[i] + nums[j] + nums[k] == 0.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> ans = new ArrayList<>();
        int sum = 0;
        int n = nums.length;

        Arrays.sort(nums); //sort the input array to use two-pointer approach efficiently

        for(int i=0; i<n; i++){
            int j = i+1; //pointer j starts right after i
            int k = n-1; //pointer k starts from the end of the array

            //if the current number is the same as the previous one, skip it to avoid duplicates
            if(i>0 && nums[i] == nums[i-1]) continue;

            while(j<k){
                sum = nums[i] + nums[j] + nums[k];

                //if the sum is less than zero, move the left pointer to the right to increase the sum
                if(sum < 0){
                    j++;
                } else if(sum > 0){ //if the sum is greater than zero, move the right pointer to the left to decrease the sum
                    k--;
                } else{ //if the sum is exactly zero, we've found a valid triplet
                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));

                    j++;
                    k--;

                    //skip duplicate elements for j (same value as the previous element)
                    while(j<k && nums[j] == nums[j-1]){
                        j++;
                    }
                }
            }

        }

        return ans;
    }
}
