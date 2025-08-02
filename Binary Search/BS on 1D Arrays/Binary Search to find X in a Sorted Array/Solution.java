// Given an array of integers nums which is sorted in ascending order, and an integer target, 
// write a function to search target in nums. If target exists, then return its index. 
// Otherwise, return -1.

// You must write an algorithm with O(log n) runtime complexity.

class Solution {
    public int search(int[] arr, int target){
        int lo = 0;
        int hi = arr.length-1;

        while(lo <= hi){
            int mid = (lo+hi)/2;

            if(arr[mid] == target){
                return mid;
            }
            //target lies in the left part
            else if(target < arr[mid]){
                hi = mid-1;
            }
            //target lies in the right part
            else if(target > arr[mid]){
                lo = mid+1;
            }
        }

        return -1;
    }
}
