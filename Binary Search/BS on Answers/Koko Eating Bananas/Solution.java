// Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas.
// The guards have gone and will come back in h hours.

// Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of 
// bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all
// of them instead and will not eat any more bananas during this hour.

// Koko likes to eat slowly but still wants to finish eating all the bananas before the guards
// return.

// Return the minimum integer k such that she can eat all the bananas within h hours.

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;

        // Find the maximum number of bananas in a pile
        // This will be the upper limit of Koko's eating speed
        for(int val : piles){
            max = Math.max(val, max);
        }

        int lo = 1;  // Minimum possible speed (can't be 0 or division by zero error)
        int hi = max; // Maximum possible speed
        int ans = Integer.MAX_VALUE; // Store the smallest possible eating speed

        // Binary search for the minimum eating speed
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2; // Middle speed to check

            // If Koko can eat all bananas at this speed within h hours
            if(isPossible(piles, mid, h)){
                ans = mid;    // Save the answer
                hi = mid - 1; // Try to find a smaller speed
            } else {
                lo = mid + 1; // Increase speed to finish in time
            }
        }

        return ans; // Return the minimum speed found
    }

    public boolean isPossible(int[] piles, int mid, int h){
        long time = 0; // Total hours needed

        // Calculate total hours needed to eat all piles at 'mid' speed
        for(int i = 0; i < piles.length; i++){
            // Math.ceil ensures Koko needs a full extra hour if bananas remain
            time += (int) Math.ceil((double) piles[i] / mid);
        }

        // If time is within allowed hours, return true
        return time <= h;
    }
}

