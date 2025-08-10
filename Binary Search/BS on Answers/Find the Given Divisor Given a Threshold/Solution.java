// Given an array of integers nums and an integer threshold, we will choose a positive integer
// divisor, divide all the array by it, and sum the division's result. Find the smallest 
// divisor such that the result mentioned above is less than or equal to threshold.

// Each result of the division is rounded to the nearest integer greater than or equal to that
// element. (For example: 7/3 = 3 and 10/2 = 5).

class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int max = 0;

        // Find the maximum value in nums (largest possible divisor needed)
        for(int val : nums){
            max = Math.max(max, val);
        }

        int lo = 1;       // smallest possible divisor
        int hi = max;     // largest possible divisor
        int ans = 0;      // stores the smallest valid divisor

        // Binary search to find the smallest divisor
        while(lo <= hi){
            int mid = (lo+hi)/2;  // try middle divisor

            // If it's possible to use 'mid' as divisor without exceeding threshold
            if(isPossible(nums, mid, threshold)){
                ans = mid;       // update answer
                hi = mid-1;      // try a smaller divisor
            } else{
                lo = mid+1;      // need a bigger divisor
            }
        }

        return ans;
    }

    public boolean isPossible(int[] arr, int mid, int val){
        long result = 0; // sum of divisions

        for(int i=0; i<arr.length; i++){
            // Divide and round up (Math.ceil) to simulate integer division ceiling
            result += (int) Math.ceil((double) arr[i] / mid);
        }

        // Valid if total sum is within threshold
        return result <= val;
    }
}

