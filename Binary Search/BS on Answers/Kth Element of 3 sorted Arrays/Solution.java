// Given two sorted arrays a and b of size m and n respectively. Find the kth element of the 
// final sorted array.

class Solution {
    public static int kthElement(int[] a, int[] b, int k){
        //ensure that a is the smaller array for easier binary search
        if(a.length > b.length){
            int[] temp = a;
            a = b;
            b = temp;
        }

        int lo = 0;
        int hi = a.length-1;
        
        while(lo <= hi){
            //divide array 'a' at a position 'aLeft'
            int aLeft = (lo+hi)/2;
            //calculate the corresponding position 'bLeft' in array 'b'
            int bLeft = k - aLeft;

            int alm1 = (aLeft == 0) ? Integer.MIN_VALUE : a[aLeft-1];
            int al = (aLeft == a.length) ? Integer.MAX_VALUE : a[aLeft];
            int blm1 = (bLeft == 0) ? Integer.MIN_VALUE : b[bLeft-1];
            int bl = (bLeft == b.length) ? Integer.MAX_VALUE : b[bLeft];

            //if we have found the correct partition, return the max of alm1 and bl
            if(alm1 <= bl && blm1 <= al){
                int lMax = Math.max(alm1, blm1);

                return lMax;
            } 
            //if alm1 is greater than bl, we need to move the partition in 'a' to the left
            else if(alm1 > bl){
                hi = aLeft-1;
            } 
            //if b1m1 is greater than al, we need to move the partition in 'a' to the right
            else if(blm1 > al){
                lo = aLeft+1;
            }
        }

        return 0;
    }

    public static void main(String[] args){
        int[] a = {2, 3, 6, 7, 9};
        int[] b = {1, 4, 8, 10};
        
        System.out.println(kthElement(a, b, 5));
    }
}
