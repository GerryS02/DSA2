// Given an array of integers nums, return the second-largest element in the array. 
// If the second-largest element does not exist, return -1.

public class Solution {
    public int secondLargestElement(int[] nums){
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for(int val : nums){
            if(val > first){
                second = first; //update second to the old largest
                first = val; //update first to the new largest

            } else if(val > second && val < first){
                second = val; //update second if val is between first and second
            }
        }

        //if no valid second largest element exists
        return (second == Integer.MIN_VALUE) ? -1 : second;
    }
}
