// Given an integer array nums, find a subarray that has the largest product, and return the 
// product.

class Solution{
    public int maxProduct(int[] nums){
        int maxProd = Integer.MIN_VALUE;
        int currProd = 1;

        //traverse the array from left to right
        for(int i=0; i<nums.length; i++){
            currProd *= nums[i];
            maxProd = Math.max(currProd, maxProd);

            //if current product becomes 0, reset currProd to 1
            //a product of 0 would break the subarray, so we need to start a next subarray
            if(currProd == 0){
                currProd = 1;
            }
        }

        currProd = 1; //reset currProd to 1 for the second traversal (right to left)

        //traverse the array from right to left
        for(int i=nums.length-1; i>=0; i--){
            currProd *= nums[i];
            maxProd = Math.max(currProd, maxProd);

            if(currProd == 0){
                currProd = 1;
            }
        }

        return maxProd;
    }
}