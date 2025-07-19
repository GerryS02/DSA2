//Given an integer array nums, move all 0's to the end of it while maintaining the relative
//order of the non-zero elements.

class Solution {
    public void moveZeroes(int[] nums) {
        int insertPos = 0; // Position to insert the next non-zero element

        // Step 1: Move all non-zero elements to the front
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[insertPos] = nums[i];
                insertPos++;
            }
        }

        // Step 2: Fill the rest of the array with zeros
        while (insertPos < nums.length) {
            nums[insertPos] = 0;
            insertPos++;
        }
    }
};
