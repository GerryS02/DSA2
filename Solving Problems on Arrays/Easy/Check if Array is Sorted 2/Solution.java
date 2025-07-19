// Given an array nums of n integers, return true if the array nums is sorted in 
// non-decreasing order or else false.

import java.util.ArrayList;

public class Solution {
    public boolean isSorted(ArrayList<Integer> nums){
        
        for(int i=0; i<nums.size()-1; i++){
            if(nums.get(i) > nums.get(i+1)){
                return false;
            }
        }

        return true;
    }
}
