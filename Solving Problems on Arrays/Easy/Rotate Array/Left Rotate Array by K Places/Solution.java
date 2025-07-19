//Given an integer array nums and a non-negative integer k, rotate the array to the left
//by k steps.
//Input: nums = [1, 2, 3, 4, 5, 6], k = 2
// Output: nums = [3, 4, 5, 6, 1, 2]

public class Solution {
    public void rotateArray(int[] nums, int k){
        int n = nums.length;

        //if k is larger than array size, take k modulo n to avoid unnecessary rotations
        if(k>n){
            k = k % n;
        }

        //convert left rotation to equivalent right rotation
        //rotating left by k is the same as rotating right by (n - k)
        k = n-k;

        reverse(nums, 0, n-1); //reverse the entire array
        reverse(nums, 0, k-1); //reverse the first 'k' elements
        reverse(nums, 0, n-1); //reverse the remaining 'n - k' elements
    }

    public void reverse(int[] arr, int start, int end){
        while(start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }
}
