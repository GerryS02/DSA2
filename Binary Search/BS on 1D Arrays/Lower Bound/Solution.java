// Given a sorted array of nums and an integer x, write a program to find the lower bound of x

// The lower bound algorithm finds the first and smallest index in a sorted array where the 
// value at that index is greater than or equal to a given key i.e. x.

// If no such index is found, return the size of the array.

class Solution {
    public int lowerBound(int[] nums, int x){
        int lo = 0;
        int hi = nums.length-1;

        int ans = nums.length; //default answer if no element >= x is found

        while(lo <= hi){
            int mid = (lo+hi)/2;

            //if the mid value is greater than or equal to x,
            //it could be a possible answer, but we try to find a smaller index
            if(nums[mid] >= x){
                ans = mid;
                hi = mid-1;
            } else{
                //if mid value is less than x, discard the left half
                lo = mid+1;
            }
        }

        return ans;
    }
}
