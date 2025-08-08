// Given an integer array nums of size n, sorted in ascending order with distinct values. 
// The array has been right rotated an unknown number of times, between 0 and n-1 (including). 
// Determine the number of rotations performed on the array.

import java.util.ArrayList;
import java.util.Collections;

class Solution{
    public static int findKRotation(ArrayList<Integer> nums){
        int lo = 0;
        int hi = nums.size() - 1;
        int ansIndex = 0; // stores index of smallest element
        int minVal = Integer.MAX_VALUE;

        while (lo <= hi) {
            // If this subarray is already sorted, then nums[lo] is the smallest in it
            if (nums.get(lo) <= nums.get(hi)) {
                if (nums.get(lo) < minVal) {
                    minVal = nums.get(lo);
                    ansIndex = lo;
                }
                break;
            }

            int mid = (lo + hi) / 2;

            // Update smallest element if needed
            if (nums.get(mid) < minVal) {
                minVal = nums.get(mid);
                ansIndex = mid;
            }

            // Decide which side to search
            if (nums.get(mid) >= nums.get(lo)) {
                lo = mid + 1; // left part sorted, go right
            } else {
                hi = mid - 1; // right part sorted, go left
            }
        }

        return ansIndex;
    }

    public static void main(String[] args){
        ArrayList<Integer> nums = new ArrayList<>();
        Collections.addAll(nums, 4, 5, 6, 7, 0, 1, 2, 3);

        System.out.println(findKRotation(nums));

    }
}