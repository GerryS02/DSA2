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

        for(int val : piles){
            max = Math.max(val, max);
        }

        int lo = 0;
        int hi = max;

        int ans = Integer.MAX_VALUE;

        while(lo <= hi){
            int mid = lo + (hi-lo)/2;

            if(isPossible(piles, mid, h)){
                ans = mid;
                hi = mid-1;
            } else{
                lo = mid+1;
            }
        }

        return ans;
    }

    public boolean isPossible(int[] piles, int mid, int h){
        long time = 0;

        for(int i=0;  i<piles.length; i++){
            time += (int) Math.ceil((double) piles[i]/mid);
        }

        return time <= h;
    }
}
