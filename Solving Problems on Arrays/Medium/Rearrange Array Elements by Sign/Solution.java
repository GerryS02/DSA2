// Given an integer array nums of even length consisting of an equal number of positive and 
// negative integers.Return the answer array in such a way that the given conditions are 
// met:

//  1. Every consecutive pair of integers have opposite signs.
//  2. For all integers with the same sign, the order in which they were present in nums is 
//     preserved.
//  3. The rearranged array begins with a positive integer.

public class Solution {
    public int[] rearrangeArray(int[] nums){
        int i = 0; //pointer for placing +ve numbers at even indices
        int j = 1; //pointer for placing -ve numbers at odd indices

        int[] ans = new int[nums.length]; //array to store the rearranged result

        for(int val : nums){
            //if the number is positive, place it at the current even index
            if(val >= 0){
                ans[i] = val;
                i += 2; //move to the next even index
            } else{ //if the number is negative, place it at the current odd index
                ans[j] = val;
                j += 2; //move to the next odd index
            }
        }

        return ans; //return the rearranged array
    }
}
