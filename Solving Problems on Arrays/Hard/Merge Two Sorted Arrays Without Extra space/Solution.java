// Given two integer arrays nums1 and nums2. Both arrays are sorted in non-decreasing order.
// Merge both the arrays into a single array sorted in non-decreasing order.

//  1. The final sorted array should be stored inside the array nums1 and it should be done 
//     in-place.
//  2. nums1 has a length of m + n, where the first m elements denote the elements of nums1 
//     and rest are 0s.
//  3. nums2 has a length of n.

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n){
        int i = m-1;
        int j = n-1;
        int k = m+n-1;

        while(i>=0 && j>=0){
            if(nums1[i] < nums2[j]){
                nums1[k--] = nums2[j--];
            } else{
                nums1[k--] = nums1[i--];
            }
        }

        while(j>=0){
            nums1[k--] = nums2[j--];
        }
    }
}
