
// Given an integer array nums sorted in non-decreasing order, remove all duplicates in-place 
// so that each unique element appears only once. Return the number of unique elements in the 
// array.

// If the number of unique elements be k, then,

//  1. Change the array nums such that the first k elements of nums contain the unique values
//     in the order that they were present originally.
//  2. The remaining elements, as well as the size of the array does not matter in terms of 
//     correctness.

public class Solution {
    public int removeDuplicates(int[] nums){
        int k = 1;

        for(int i=0; i<nums.length; i++){
            if(nums[i] != nums[k-1]){
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }
}
