// A peak element is an element that is strictly greater than its neighbors.

// Given a 0-indexed integer array nums, find a peak element, and return its index. If the 
// array contains multiple peaks, return the index to any of the peaks.

// You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always 
// considered to be strictly greater than a neighbor that is outside the array.

class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int lo = 0;
        int hi = n - 1;

        // Binary search loop
        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            // Check if the left neighbor is less than mid (or mid is at index 0)
            boolean leftOk = (mid == 0 || nums[mid] > nums[mid - 1]);

            // Check if the right neighbor is less than mid (or mid is at the last index)
            boolean rightOk = (mid == n - 1 || nums[mid] > nums[mid + 1]);

            // If both sides are okay, then nums[mid] is a peak
            if (leftOk && rightOk) {
                return mid; // Return the index of the peak
            } else if (!leftOk) {
                // If the left side is higher, move to the left half
                hi = mid - 1;
            } else {
                // If the right side is higher, move to the right half
                lo = mid + 1;
            }
        }

        // Should never reach here if input is valid
        return -1;
    }
}

