// A conveyor belt has packages that must be shipped from one port to another within days days

// The ith package on the conveyor belt has a weight of weights[i]. Each day, we load the ship 
// with packages on the conveyor belt (in the order given by weights). We may not load more 
// weight than the maximum weight capacity of the ship.

// Return the least weight capacity of the ship that will result in all the packages on the 
// conveyor belt being shipped within days days.

class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int sum = 0;
        int max = 0;

        for(int val : weights){
            sum += val;
            max = Math.max(val, max);
        }

        if(weights.length == days){
            return max;
        }

        int lo = max;
        int hi = sum;
        int ans = 0;

        while(lo <= hi){
            int mid = lo + (hi-lo)/2;

            if(isPossible(weights, mid, days)){
                ans = mid;
                hi = mid-1;
            } else{
                lo = mid+1;
            }
        }

        return ans;
    }

    public boolean isPossible(int[] weights, int mid, int days){
        int day = 1;
        int sum = 0;

        for(int i=0; i<weights.length; i++){
            sum += weights[i];

            if(sum > mid){
                day++;
                sum = weights[i];
            }
        }

        return day <= days;
    }
}
