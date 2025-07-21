// Given an integer array nums of size n, return the majority element of the array.

// The majority element of an array is an element that appears more than n/2 times in the 
// array. The array is guaranteed to have a majority element.

public class Solution {
    
    public int majorityElement(int[] nums){
        int n = nums.length;
        int freq = 0, ans = 0;

        for(int i=0; i<n; i++){
            if(freq == 0){
                ans = nums[i];
            }

            if(ans == nums[i]){
                freq++;
            } else{
                freq--;
            }
        }

        return ans;
    }
}
