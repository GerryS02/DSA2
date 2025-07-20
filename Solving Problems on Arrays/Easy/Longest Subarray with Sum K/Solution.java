// Given an array nums of size n and an integer k, find the length of the longest sub-array 
// that sums to k. If no such sub-array exists, return 0.

import java.util.HashMap;

public class Solution {
    public int longestSubarray(int[] nums, int k){
        int sum = 0;
        int len = 0;

        // Initialize map with sum 0 at index -1 to handle edge case
        HashMap<Integer, Integer> m = new HashMap<>();
        m.put(0, -1);  // sum 0 occurs at index -1, helps when subarray starts from index 0

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];  // Update running sum

            // Check if there's a previous prefix sum that, if removed, would give sum = k
            if (m.containsKey(sum - k)) {
                // Calculate the length of the subarray and update max length
                len = Math.max(len, i - m.get(sum - k));
            }

            // Store the first occurrence of the current sum
            // Only store the first occurrence, because we want the longest subarray
            if (!m.containsKey(sum)) {
                m.put(sum, i);
            }
        }

        return len;  // Return the length of the longest subarray
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {10, 5, 2, 7, 1, 9};
        int k = 15;
        System.out.println(sol.longestSubarray(nums, k));  // Output: 4
    }
}
