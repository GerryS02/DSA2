//Given an integer array nums, rotate the array to the left by one.
//for eg: [1, 2, 3, 4, 5] -> [2, 3, 4, 5, 1]

public class Solution {
    public void rotateArrayByOne(int[] arr){
        for(int i=1; i<arr.length; i++){
            int temp = arr[i-1];
            arr[i-1] = arr[i];
            arr[i] = temp;
        }
    }
}
