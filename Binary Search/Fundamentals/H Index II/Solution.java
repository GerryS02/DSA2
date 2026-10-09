class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int lo = 0;
        int hi = n-1;

        while(lo <= hi){
            int mid = (lo+hi)/2;
            int papers = n-mid;

            if(citations[mid] >= papers){
                hi = mid-1;
            } else{
                lo = mid+1;
            }
        }

        return n-lo;
    }
}