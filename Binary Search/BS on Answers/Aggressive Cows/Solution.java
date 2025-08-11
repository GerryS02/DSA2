import java.util.Arrays;

class Solution {
    public static int aggressiveCows(int[] nums, int k) {
        //sort the stall positions
        Arrays.sort(nums);

        //minimum possible distance between cows = 1
        int lo = 1;
        //maximum possible distance = farthest stall - closest stall
        int hi = nums[nums.length - 1] - nums[0];

        int ans = 0; 

        while (lo <= hi) {
            int mid = (lo + hi) / 2; //try placing cows with this minimum distance

            if (isPossible(nums, mid, k)) {
                //if it's possible to place all cows with at least 'mid' distance
                ans = mid;      //store this as a possible answer
                lo = mid + 1;   //try for a bigger distance
            } else {
                hi = mid - 1;   //try for a smaller distance
            }
        }

        return ans;
    }

    public static boolean isPossible(int[] arr, int mid, int k) {
        //place the first cow in the first stall
        int cows = 1;
        int lastPos = arr[0]; //position of the last placed cow

        //try to place the rest of the cows
        for (int i = 0; i < arr.length; i++) {
            //if the current stall is at least 'mid' distance away from the last placed cow
            if ((arr[i] - lastPos) >= mid) {
                cows++;          //place another cow here
                lastPos = arr[i]; //update last placed position
            }

            //if we've placed all k cows successfully
            if (cows == k) return true;
        }

        //not possible to place all cows with 'mid' distance
        return false;
    }
    
    public static void main(String[] args) {
        int[] nums = {0, 3, 4, 7, 10, 9};

        System.out.println(aggressiveCows(nums, 4)); 
    }
}
