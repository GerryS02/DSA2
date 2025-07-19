// Given an array of integers nums, return the value of the largest element in the array

class Solution {
    public int LargestElement(int[] nums){
        int max = 0;

        for(int val : nums){
            max = Math.max(max, val);
        }

        return max;
    }
}
