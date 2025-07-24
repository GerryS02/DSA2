// Given an integer array nums of size n. Return all elements which appear more than n/3 
// times in the array. The output can be returned in any order.

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> majorityElementTwo(int[] nums){
        List<Integer> ans = new ArrayList<>();

        int n = nums.length;
        int freq;

        for(int i=0; i<n; i++){
            freq = nums[i]; //set the current element as the "frequency" element
            int count = 1; //start counting the occurrences of freq, initialized to 1 (since we already counted nums[i])

            //loop through the remaining elements to count how many times 'freq' appears
            for(int j=i+1; j<n; j++){
                if(nums[j] == freq){
                    count++;
                }
            }

            //if the count is greater than n/3 and 'freq' is not already in the result list
            if(count > n/3 && !ans.contains(freq)){
                ans.add(freq); //add the freq to the ans
            }
        }

        return ans;
    }
}
