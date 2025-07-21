// Given an integer array nums, find the subarray with the largest sum and return the sum of 
// the elements present in that subarray.

public class Solution {
    public int maxSubArray(int[] nums){
        //initialize current sum and max sum with the first element of the array
        int currSum = nums[0];
        int maxSum = nums[0];


        for(int i=1; i<nums.length; i++){
            //if the current sum is positive, we add the current element to it
            if(currSum >= 0){
                currSum += nums[i];
            } else{ //otherwise, we start a new subarray from the current element
                currSum = nums[i];
            }

            //update maxSum if the current sum is greater than the max sum seen so far
            if(currSum > maxSum){
                maxSum = currSum;
            }
        }

        return maxSum;
    }
}
