// Given a sorted array nums and an integer x. Find the floor and ceil of x in nums. The floor 
// of x is the largest element in the array which is smaller than or equal to x. The ceiling 
// of x is the smallest element in the array greater than or equal to x. If no floor or ceil 
// exists, output -1.

import java.util.Arrays;

class Solution{
    public static int[] getFloorAndCeil(int[] nums, int x){
        int floor = -1;
        int ceil = -1;

        int lo = 0;
        int hi = nums.length-1;

        //binary search for floor (largest number <= x)
        while(lo <= hi){
            int mid = (lo+hi)/2;

            if(nums[mid] <= x){
                floor = nums[mid]; //possible floor
                lo = mid+1; //try to find a bigger one
            } else{
                hi = mid-1;
            }
        }

        //binary search for ceil (smallest number >= x)
        lo = 0;
        hi = nums.length-1;

        while(lo <= hi){
            int mid = (lo+hi)/2;

            if(nums[mid] >= x){
                ceil = nums[mid]; //possible ceil
                hi = mid-1; //try to find a smaller one
            } else{
                lo = mid+1;
            }
        }

        return new int[]{floor, ceil};
    }

    public static void main(String[] args){
        int[] nums = {3,4,4,7,8,10};

        int[] ans = getFloorAndCeil(nums, 5);

        System.out.println(Arrays.toString(ans));
    }
}