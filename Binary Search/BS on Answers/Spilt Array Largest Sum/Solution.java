// Given an integer array nums and an integer k, split nums into k non-empty subarrays such 
// that the largest sum of any subarray is minimized.

// Return the minimized largest sum of the split.

class Solution {
    public int splitArray(int[] nums, int k) {
        int sum = 0;   // Total sum of all elements
        int max = 0;   // Maximum value in the array

        // Find total sum and maximum value in nums
        for(int val : nums){
            sum += val;
            max = Math.max(val, max);
        }

        // If we split into exactly k parts (one element in each part)
        // the answer is just the largest element
        if(k == nums.length) return max;

        int lo = max;  // Lower bound (can't be smaller than max element)
        int hi = sum;  // Upper bound (all elements in one subarray)
        int ans = 0;   // Store the final answer

        // Binary search to find the smallest possible largest subarray sum
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2; // Possible largest subarray sum

            // Check if we can split into <= k subarrays with this limit
            if(isPossible(nums, mid, k)){
                ans = mid;     // This limit works, try smaller
                hi = mid - 1;
            } else{
                lo = mid + 1;  // This limit is too small, try bigger
            }
        }

        return ans;
    }

    public boolean isPossible(int[] arr, int mid, int k){
        int subArray = 1; // Start with one subarray
        int sum = 0;      // Current subarray sum

        for(int i = 0; i < arr.length; i++){
            sum += arr[i];

            // If adding the current number exceeds mid,
            // start a new subarray
            if(sum > mid){
                subArray++;
                sum = arr[i];
            }
        }

        // Return true if we can split into k or fewer subarrays
        return subArray <= k;
    }
}

