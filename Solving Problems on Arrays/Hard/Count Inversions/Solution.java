// Given an integer array nums. Return the number of inversions in the array.

// Two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.

//  1. It indicates how close an array is to being sorted.
//  2. A sorted array has an inversion count of 0.
//  3. An array sorted in descending order has maximum inversion.

class Solution {
    public long numberOfInversions(int[] nums){

        return mergeSort(nums, 0, nums.length-1);
    }

    public long mergeSort(int[] nums, int st, int ed){
        long count = 0;

        if(st >= ed) return count;

        int mid = (st+ed)/2;

        count += mergeSort(nums, st, mid);
        count += mergeSort(nums, mid+1, ed);

        count += mergeArray(nums, st, mid, ed);

        return count;
    }

    public long mergeArray(int[] arr, int st, int mid, int ed){
        int[] temp = new int[ed-st+1];
        long count = 0;

        int i = st;
        int j = ed;
        int k = 0;

        while(i<=mid && j<=ed){
            if(arr[i] <= arr[j]){
                temp[k++] = arr[i++];
            } //right element is smaller --arr[i] > arr[j]
            else{
                count += (mid-i+1);
                temp[k++] = arr[j++];
            }
        }

        while(i<=mid){
            temp[k++] = arr[i++];
        }

        while(j<=ed){
            temp[k++] = arr[j++];
        }

        for(int p=0, q=st; p<temp.length; p++, q++){
            arr[q] = temp[p];
        }

        return count;
    }
}
