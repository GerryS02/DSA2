// Given an array nums with n objects colored red, white, or blue, sort them in-place so 
// that objects of the same color are adjacent, with the colors in the order red, white, and 
// blue.

// We will use the integers 0, 1, and 2 to represent the color red, white, and blue, 
// respectively.

//using insertion sort

class Solution{
    public void sortColors(int[] nums){
        int n = nums.length;

        for(int i=1; i<n; i++){
            int curr = nums[i];
            int prev = i-1;

            while(prev >= 0 && nums[prev] > curr){
                nums[prev+1] = nums[prev];
                prev--;
            }

            nums[prev+1] = curr;
        }
    }
};